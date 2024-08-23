package com.minister.visitorsapp.services;




import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.minister.visitorsapp.entities.Visitors;

public interface VisitorsService {

	public Visitors CreateVisitors (Visitors visitors );
	public Page<Visitors> getAllVisitors(Pageable pageable);
	public Visitors updateVisitorById(String id, Visitors visitors);
}
