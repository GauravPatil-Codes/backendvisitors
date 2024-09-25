package com.minister.visitorsapp.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Departments {
@Id
    private String id;  // Primary Key
    
    private String departmentName;
    private String departmentemail;

    public void setId(String id) {
        this.id = id;
    }
    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }
    public void setDepartmentemail(String departmentemail) {
        this.departmentemail = departmentemail;
    }
       
    public String getId() {
        return id;
    }
    public String getDepartmentName() {
        return departmentName;
    }
    public String getDepartmentemail() {
        return departmentemail;
    }
    public Departments() {
		super();
		// TODO Auto-generated constructor stub
	}
    @Override
    public String toString() {
        return "Departments [id=" + id + ", departmentName=" + departmentName + ", departmentemail=" + departmentemail
                + "]";
    }
    public Departments(String id, String departmentName, String departmentemail) {
        this.id = id;
        this.departmentName = departmentName;
        this.departmentemail = departmentemail;
    }
}
