package com.minister.visitorsapp.services;

import java.util.Optional;

import com.minister.visitorsapp.entities.Visitors;

public interface AuthService {
	
	 public Visitors register(Visitors visitor);
	 public Optional<Visitors> login(String contactNumber, String password);

}
