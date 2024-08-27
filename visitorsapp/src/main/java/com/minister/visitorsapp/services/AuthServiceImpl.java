package com.minister.visitorsapp.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.minister.visitorsapp.entities.Visitors;
import com.minister.visitorsapp.repos.VisitorsRepository;

@Service
public class AuthServiceImpl implements AuthService {
	
	@Autowired
    private VisitorsRepository visitorsRepository;

    @Override 
    public Visitors register(Visitors visitor) {
        // Save password as plain text
        return visitorsRepository.save(visitor);
    }

    @Override
    public Optional<Visitors> login(String contactNumber, String password) {
        Optional<Visitors> visitorOpt = visitorsRepository.findByContactNumber(contactNumber);
        if (visitorOpt.isPresent()) {
            Visitors visitor = visitorOpt.get();
            // Check password directly without encoding
            if (password.equals(visitor.getPassword())) {
                return Optional.of(visitor);
            }
        }
        return Optional.empty();
    }
}
