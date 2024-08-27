package com.minister.visitorsapp.services;




import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.minister.visitorsapp.entities.Visitors;

public interface VisitorsService {

	public Visitors CreateVisitors (Visitors visitors );
	public Page<Visitors> getAllVisitors(Pageable pageable);
	public Visitors updateVisitorById(String id, Visitors visitors);
	public Optional<Visitors> getVisitorsById(String id);
	boolean isTimeSlotAvailable(LocalDateTime start, LocalDateTime end, String excludeVisitorId);
	Page<Visitors> getAllPendingVisitors(Pageable pageable);
	Page<Visitors> getAllRejectedVisitors(Pageable pageable);
	Page<Visitors> getPastVisitors(LocalDateTime from, LocalDateTime to, Pageable pageable);
}
