package com.minister.visitorsapp.controllers;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import com.minister.visitorsapp.entities.Visitors;
import com.minister.visitorsapp.helpers.PaginatedResponse;
import com.minister.visitorsapp.services.EmailService;
import com.minister.visitorsapp.services.VisitorsServiceImpl;


@RestController
public class VisitorsController {
	
	@Autowired
	VisitorsServiceImpl visitorsServiceImpl;
	
	@Autowired
	PaginatedResponse paginatedResponse;

  @Autowired
    private EmailService emailService;
	
	@PostMapping("/sendQueryEmail")
	public ResponseEntity<String> sendQueryEmail(@RequestBody Visitors visitor) {
		if (visitor.getQuerySolvingDepartment() == null || visitor.getQuerySolvingDepartment().isEmpty()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error: Department email is required.");
		}
	
		// Prepare email subject and body
		String subject = "Query Redirect: " + visitor.getFullName() + " - " + visitor.getPurposeOfVisit();
	
		String body = String.format(
			"%s,\n\nWe have received a query from a user on our website that pertains to your department.\n\n"
			+ "Below are the details of the user and their query:\n\n"
			+ "User's Name: %s\nQuery: %s\n\n"
			+ "Kindly address the user's concern at your earliest convenience. Should you need any additional information, feel free to reach out.\n\n"
			+ "Thank you for your prompt attention to this matter.\n\n"
			+ "Best regards,\n%s",
			visitor.getQuerysolvingdepartmentName(),  // 1st %s
			visitor.getFullName(),                    // 2nd %s
			visitor.getPurposeOfVisit(),              // 3rd %s
			visitor.getOrganizationName()             // 4th %s
		);
	
		// Send the email
		try {
			emailService.sendEmail(visitor.getQuerySolvingDepartment(), subject, body);
			return ResponseEntity.status(HttpStatus.OK).body("Email sent successfully to " + visitor.getQuerySolvingDepartment());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error sending email: " + e.getMessage());
		}
	}
	
// @PostMapping("/sendQueryEmail")
// public ResponseEntity<String> sendQueryEmail(@RequestBody Visitors visitor) {
//     if (visitor.getQuerySolvingDepartment() == null || visitor.getQuerySolvingDepartment().isEmpty()) {
//         return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error: Department email is required.");
//     }

//     // Prepare email subject and body
//     String subject = "Query Redirect: " + visitor.getFullName() + " - " + visitor.getPurposeOfVisit();

//     String body = String.format(
//         "%s,\n\nWe have received a query from a user on our website that pertains to your department.\n\n"
//         + "Below are the details of the user and their query:\n\n"
//         + "User's Name: %s\nQuery: %s\n\n"
//         + "Kindly address the user's concern at your earliest convenience. Should you need any additional information, feel free to reach out.\n\n"
//         + "Thank you for your prompt attention to this matter.\n\n"
//         + "Best regards,\n%s\n%s",
//         visitor.getQuerysolvingdepartmentName(),  // 1st %s
//         visitor.getFullName(),                    // 2nd %s
//         visitor.getPurposeOfVisit(),              // 3rd %s
//         visitor.getOrganizationName()           // 4th %s
      
//     );

//     // Send the email
//     try {
//         emailService.sendEmail(visitor.getQuerySolvingDepartment(), subject, body);
//         return ResponseEntity.status(HttpStatus.OK).body("Email sent successfully to " + visitor.getQuerySolvingDepartment());
//     } catch (Exception e) {
//         return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error sending email: " + e.getMessage());
//     }
// }

		
	@PostMapping("/addvisitor")
	public ResponseEntity<Visitors> CreateVisitors (@RequestBody Visitors visitors){
		
		return ResponseEntity.ok(visitorsServiceImpl.CreateVisitors(visitors));
	}
	
	@GetMapping("/getallvisitors")
	@ResponseBody
	public ResponseEntity<PaginatedResponse<Visitors>> getAllVisitors(
	        @RequestParam(defaultValue = "0") int page,
	        @RequestParam(defaultValue = "10") int size) {

	    Page<Visitors> visitorPage = visitorsServiceImpl.getAllVisitors(PageRequest.of(page, size));
	    PaginatedResponse<Visitors> response = new PaginatedResponse<>(
	            visitorPage.getContent(),
	            visitorPage.getNumber(),
	            visitorPage.getTotalPages(),
	            visitorPage.getTotalElements()
	    );

	    return ResponseEntity.ok(response);
	}
	
	@PostMapping("/updatevisitor/{_id}")
	public Object CreateVisitors (@PathVariable("_id") String id, @RequestBody Visitors visitors){
		
		return visitorsServiceImpl.updateVisitorById(id, visitors);
	
	}
	
	@GetMapping("/getvisitorbyid/{_id}")
	public Optional<Visitors> GetVisitorsById (@PathVariable("_id") String id) {
		
		return visitorsServiceImpl.getVisitorsById(id);
	}
	
	@GetMapping("/pending")
    public Page<Visitors> getAllPendingVisitors(Pageable pageable) {
        return visitorsServiceImpl.getAllPendingVisitors(pageable);
    }

	@GetMapping("/approved")
    public Page<Visitors> getAllApprovedVisitors(Pageable pageable) {
        return visitorsServiceImpl.getAllApprovedVisitors(pageable);
    }

    @GetMapping("/rejected")
    public Page<Visitors> getAllRejectedVisitors(Pageable pageable) {
        return visitorsServiceImpl.getAllRejectedVisitors(pageable);
    }

    @GetMapping("/past")
    public Page<Visitors> getPastVisitors(
        @RequestParam("from") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime from,
        @RequestParam("to") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime to,
        Pageable pageable) {
        return visitorsServiceImpl.getPastVisitors(from, to, pageable);
    }
	
	
	@GetMapping("/check-availability")
    public ResponseEntity<Map<String, Object>> checkTimeSlotAvailability(
        @RequestParam("start") LocalDateTime start,
        @RequestParam("duration") int meetingDuration) {

        Map<String, Object> response = new HashMap<>();

        boolean isAvailable = visitorsServiceImpl.isTimeSlotAvailable(start, meetingDuration);

        if (isAvailable) {
            response.put("data", Collections.singletonMap("message", "Time slot is available"));
            response.put("status", "200");
            return ResponseEntity.ok(response);
        } else {
            response.put("data", Collections.singletonMap("message", "Time slot is not available"));
            response.put("status", "409"); // 409 Conflict status
            return ResponseEntity.status(409).body(response);
        }
    }
}
