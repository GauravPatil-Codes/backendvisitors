package com.minister.visitorsapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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

}
