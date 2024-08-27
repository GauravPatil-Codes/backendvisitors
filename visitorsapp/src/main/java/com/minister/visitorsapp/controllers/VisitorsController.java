package com.minister.visitorsapp.controllers;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
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
import com.minister.visitorsapp.services.VisitorsServiceImpl;

@RestController
public class VisitorsController {
	
	@Autowired
	VisitorsServiceImpl visitorsServiceImpl;
	
	@Autowired
	PaginatedResponse paginatedResponse;
	
	@PostMapping("/addvisitor")
	public ResponseEntity<Visitors> CreateVisitors (@RequestBody Visitors visitors){
		
		return ResponseEntity.ok(visitorsServiceImpl.CreateVisitors(visitors));
	}
	
	@GetMapping("/getallvisitors")
	@ResponseBody
	public ResponseEntity<PaginatedResponse<Visitors>> getAllVisitors(
	        @RequestParam(defaultValue = "1") int page,
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

}
