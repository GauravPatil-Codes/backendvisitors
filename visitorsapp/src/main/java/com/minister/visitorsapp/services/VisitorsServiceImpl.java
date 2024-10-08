package com.minister.visitorsapp.services;



import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.minister.visitorsapp.entities.Visitors;
import com.minister.visitorsapp.repos.VisitorsRepository;
// import org.springframework.mail.SimpleMailMessage;
// import org.springframework.mail.javamail.JavaMailSender;

@Service
public class VisitorsServiceImpl implements VisitorsService {

	@Autowired
	VisitorsRepository visitorsRepository;
// 	@Autowired
// private JavaMailSender mailSender;
	
	@Override
	public Visitors CreateVisitors(Visitors visitors) {
		// TODO Auto-generated method stub
		return visitorsRepository.save(visitors);
	}
	
	@Override
    public Page<Visitors> getAllVisitors(Pageable pageable) {
        return visitorsRepository.findAll(pageable);
    }

	@Override
	public Visitors updateVisitorById(String id, Visitors visitors) {
		LocalDateTime newStartTime = visitors.getAppointmentstartDateTime();
	    LocalDateTime newEndTime = newStartTime.plusMinutes(visitors.getMeetingDuration());

	    if (!isTimeSlotAvailable(newStartTime, newEndTime, id)) {
	        throw new IllegalStateException("The selected time slot is already booked.");
	    }
		
	    Optional<Visitors> existingVisitorOptional = visitorsRepository.findById(id);
	    
	    if (existingVisitorOptional.isPresent()) {
	        Visitors existingVisitor = existingVisitorOptional.get();
	        
	        // Update fields of the existing visitor
	        existingVisitor.setFullName(visitors.getFullName());
	        existingVisitor.setAge(visitors.getAge());
	        existingVisitor.setGender(visitors.getGender());
	        existingVisitor.setContactNumber(visitors.getContactNumber());
	        existingVisitor.setEmailAddress(visitors.getEmailAddress());
	        existingVisitor.setPurposeOfVisit(visitors.getPurposeOfVisit());
	        existingVisitor.setAppointmentstartDateTime(visitors.getAppointmentstartDateTime());
			existingVisitor.setQuerysolvingdepartmentName(visitors.getQuerysolvingdepartmentName());
	        
	        // Calculate and set appointment end time
	        if (visitors.getMeetingDuration() > 0) {
	            LocalDateTime endDateTime = visitors.getAppointmentstartDateTime().plusMinutes(visitors.getMeetingDuration());
	            existingVisitor.setAppointmentendDateTime(endDateTime);
	        }

	        existingVisitor.setDepartmentName(visitors.getDepartmentName());
			existingVisitor.setQuerySolvingDepartment(visitors.getQuerySolvingDepartment());
	        existingVisitor.setOrganizationName(visitors.getOrganizationName());
	        existingVisitor.setDesignation(visitors.getDesignation());
	        existingVisitor.setOfficialAddress(visitors.getOfficialAddress());
	        existingVisitor.setGrievanceDetails(visitors.getGrievanceDetails());
	        existingVisitor.setStatus(visitors.getStatus());
			existingVisitor.setMeetingStatus(visitors.getMeetingStatus());
	        existingVisitor.setRole(visitors.getRole());
	        existingVisitor.setUpdatedAt(LocalDateTime.now());
	        existingVisitor.setPassword(visitors.getPassword());
	        existingVisitor.setDocument(visitors.getDocument());
	        existingVisitor.setMeetingDuration(visitors.getMeetingDuration());
			existingVisitor.setAdminRemark(visitors.getAdminRemark());	
	        existingVisitor.setRemark(visitors.getRemark());


	        return visitorsRepository.save(existingVisitor);
	    } else {
	        visitors.setCreatedAt(LocalDateTime.now());
	        visitors.setUpdatedAt(LocalDateTime.now());
	        if (visitors.getMeetingDuration() > 0) {
	            LocalDateTime endDateTime = visitors.getAppointmentstartDateTime().plusMinutes(visitors.getMeetingDuration());
	            visitors.setAppointmentendDateTime(endDateTime);
	        }
	        return visitorsRepository.save(visitors);
	    }
	}

	@Override 
	public Optional<Visitors> getVisitorsById(String id) {
		// TODO Auto-generated method stub
		return visitorsRepository.findById(id);
	}
	
	@Override
	public boolean isTimeSlotAvailable(LocalDateTime start, LocalDateTime end, String excludeVisitorId) {
	    List<Visitors> conflictingAppointments = visitorsRepository.findByAppointmentstartDateTimeBetweenOrAppointmentendDateTimeBetween(start, end, start, end);

	    if (excludeVisitorId != null) {
	        conflictingAppointments = conflictingAppointments.stream()
	            .filter(visitor -> !visitor.getId().equals(excludeVisitorId))
	            .collect(Collectors.toList());
	    }

	    return conflictingAppointments.isEmpty();
	}
	
	 
		@Override
	    public Page<Visitors> getAllPendingVisitors(Pageable pageable) {
	        return visitorsRepository.findByStatus("Pending", pageable);
	    }
		@Override
	    public Page<Visitors> getAllApprovedVisitors(Pageable pageable) {
	        return visitorsRepository.findByStatus("Approved", pageable);
	    }
		@Override
	    public Page<Visitors> getAllRejectedVisitors(Pageable pageable) {
	        return visitorsRepository.findByStatus("Rejected", pageable);
	    }
		@Override
	    public Page<Visitors> getPastVisitors(LocalDateTime from, LocalDateTime to, Pageable pageable) {
	        return visitorsRepository.findByAppointmentstartDateTimeBetween(from, to, pageable);
	    }

		

		@Override
		public boolean isTimeSlotAvailable(LocalDateTime start, int meetingDuration) {
				LocalDateTime end = start.plusMinutes(meetingDuration);
	
				List<Visitors> overlappingVisitors = visitorsRepository
				.findByAppointmentstartDateTimeLessThanEqualAndAppointmentendDateTimeGreaterThanEqual(end, start);
			return overlappingVisitors.isEmpty();
		}

		
	
}
