package com.minister.visitorsapp.services;



import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.minister.visitorsapp.entities.Visitors;
import com.minister.visitorsapp.repos.VisitorsRepository;

@Service
public class VisitorsServiceImpl implements VisitorsService {

	@Autowired
	VisitorsRepository visitorsRepository;
	
	@Override
	public Visitors CreateVisitors(Visitors visitors) {
		// TODO Auto-generated method stub
		return visitorsRepository.save(visitors);
	}
	
	@Override
    public Page<Visitors> getAllVisitors(Pageable pageable) {
        return visitorsRepository.findAll(pageable);
    }

	public Visitors updateVisitorById(String id, Visitors visitors) {
	    // Check if the visitor exists
	    Optional<Visitors> existingVisitorOptional = visitorsRepository.findById(id);
	    
	    if (existingVisitorOptional.isPresent()) {
	        // If the visitor exists, update the existing visitor's information
	        Visitors existingVisitor = existingVisitorOptional.get();
	        
	        // Update fields of the existing visitor with new data
	        existingVisitor.setFullName(visitors.getFullName());
	        existingVisitor.setAge(visitors.getAge());
	        existingVisitor.setGender(visitors.getGender());
	        existingVisitor.setContactNumber(visitors.getContactNumber());
	        existingVisitor.setEmailAddress(visitors.getEmailAddress());
	        existingVisitor.setPurposeOfVisit(visitors.getPurposeOfVisit());
	        existingVisitor.setAppointmentDateTime(visitors.getAppointmentDateTime());
	        existingVisitor.setDepartmentName(visitors.getDepartmentName());
	        existingVisitor.setOrganizationName(visitors.getOrganizationName());
	        existingVisitor.setDesignation(visitors.getDesignation());
	        existingVisitor.setOfficialAddress(visitors.getOfficialAddress());
	        existingVisitor.setGrievanceDetails(visitors.getGrievanceDetails());
	        existingVisitor.setStatus(visitors.getStatus());

	        // Automatically update the updatedAt timestamp
	        existingVisitor.setUpdatedAt(LocalDateTime.now());

	        // Save the updated visitor back to the repository
	        return visitorsRepository.save(existingVisitor);
	    } else {
	        // If the visitor doesn't exist, save the new visitor
	        visitors.setCreatedAt(LocalDateTime.now()); // Set createdAt for new visitor
	        visitors.setUpdatedAt(LocalDateTime.now()); // Set updatedAt for new visitor
	        return visitorsRepository.save(visitors);
	    }
	}


}
