package com.minister.visitorsapp.repos;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.minister.visitorsapp.entities.Visitors;

@Repository
public interface VisitorsRepository extends MongoRepository<Visitors, String> {

	

}
