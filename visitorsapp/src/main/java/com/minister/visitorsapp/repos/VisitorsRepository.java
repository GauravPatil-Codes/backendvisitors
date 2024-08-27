package com.minister.visitorsapp.repos;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.minister.visitorsapp.entities.Visitors;

@Repository
public interface VisitorsRepository extends MongoRepository<Visitors, String> {

	List<Visitors> findByAppointmentstartDateTimeBetweenOrAppointmentendDateTimeBetween(LocalDateTime start,
			LocalDateTime end, LocalDateTime start2, LocalDateTime end2);

	Page<Visitors> findByStatus(String status, Pageable pageable);
	
    Page<Visitors> findByAppointmentstartDateTimeBetween(LocalDateTime from, LocalDateTime to, Pageable pageable);

    Optional<Visitors> findByContactNumber(String contactNumber);
	

}
