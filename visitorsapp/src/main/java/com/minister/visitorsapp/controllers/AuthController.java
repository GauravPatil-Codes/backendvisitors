package com.minister.visitorsapp.controllers;

import com.minister.visitorsapp.entities.Visitors;
import com.minister.visitorsapp.services.AuthServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthServiceImpl authServiceImpl;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody Visitors visitor) {
        // Ensure role is either "admin" or "visitor"
        if (!visitor.getRole().equalsIgnoreCase("admin") && !visitor.getRole().equalsIgnoreCase("visitor")) {
            return ResponseEntity.badRequest().body("Invalid role");
        }

        Visitors registeredVisitor = authServiceImpl.register(visitor);
        return ResponseEntity.ok(registeredVisitor);
    }

//     @PostMapping("/login")
//     public ResponseEntity<?> login(@RequestParam String contactNumber, @RequestParam String password) {
//         Optional<Visitors> visitorOpt = authServiceImpl.login(contactNumber, password);

//         if (visitorOpt.isPresent()) {
//             Visitors visitor = visitorOpt.get();
//             return ResponseEntity.ok("Login successful for role: " + visitor.getRole());
//         } else {
//             return ResponseEntity.status(401).body("Invalid credentials");
//         }
//     }
// }
@PostMapping("/login")
public ResponseEntity<Map<String, Object>> login(@RequestParam String contactNumber, @RequestParam String password) {
    Optional<Visitors> visitorOpt = authServiceImpl.login(contactNumber, password);

    Map<String, Object> response = new HashMap<>();
    if (visitorOpt.isPresent()) {
        Visitors visitor = visitorOpt.get();
        response.put("data", Collections.singletonMap("message", "Login successfully done"));
        response.put("status", "200");
        return ResponseEntity.ok(response);
    } else {
        response.put("data", Collections.singletonMap("message", "Invalid credentials"));
        response.put("status", "401");
        return ResponseEntity.status(401).body(response);
    }
}

}