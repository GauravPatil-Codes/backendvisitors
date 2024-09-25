package com.minister.visitorsapp.services;
import java.util.List;
import com.minister.visitorsapp.entities.Departments;

public interface DepartmentService {
public Departments CreateDepartments (Departments departments );
	public List<Departments> getAllDepartments();
    public Departments updateDepartment(String id, Departments departments);
    public  Departments deleteDepartment(String id);
    public Departments showById(String id);

}
