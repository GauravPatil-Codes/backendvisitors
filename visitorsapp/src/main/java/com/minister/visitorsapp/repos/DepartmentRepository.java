package com.minister.visitorsapp.repos;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.minister.visitorsapp.entities.Departments;


@Repository
public interface DepartmentRepository extends MongoRepository<Departments, String>  {

}
