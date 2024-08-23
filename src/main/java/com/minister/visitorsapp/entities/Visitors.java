package com.minister.visitorsapp.entities;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

@Document
public class Visitors {

	@Id
    private String id;  // Primary Key
    
    private String fullName;
    private int age;
    private String gender;
    private String contactNumber;
    private String emailAddress;
    private String purposeOfVisit;
    
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime appointmentDateTime;
    
    private String departmentName;
    private String organizationName;
    private String designation;
    private String officialAddress;
    private String grievanceDetails;
    
    private String status; // Pending, Approved, Rejected

    @CreatedDate
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime createdAt;

    @LastModifiedDate
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime updatedAt;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getPurposeOfVisit() {
		return purposeOfVisit;
	}

	public void setPurposeOfVisit(String purposeOfVisit) {
		this.purposeOfVisit = purposeOfVisit;
	}

	public LocalDateTime getAppointmentDateTime() {
		return appointmentDateTime;
	}

	public void setAppointmentDateTime(LocalDateTime appointmentDateTime) {
		this.appointmentDateTime = appointmentDateTime;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getOrganizationName() {
		return organizationName;
	}

	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getOfficialAddress() {
		return officialAddress;
	}

	public void setOfficialAddress(String officialAddress) {
		this.officialAddress = officialAddress;
	}

	public String getGrievanceDetails() {
		return grievanceDetails;
	}

	public void setGrievanceDetails(String grievanceDetails) {
		this.grievanceDetails = grievanceDetails;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Visitors(String id, String fullName, int age, String gender, String contactNumber, String emailAddress,
			String purposeOfVisit, LocalDateTime appointmentDateTime, String departmentName, String organizationName,
			String designation, String officialAddress, String grievanceDetails, String status, LocalDateTime createdAt,
			LocalDateTime updatedAt) {
		super();
		this.id = id;
		this.fullName = fullName;
		this.age = age;
		this.gender = gender;
		this.contactNumber = contactNumber;
		this.emailAddress = emailAddress;
		this.purposeOfVisit = purposeOfVisit;
		this.appointmentDateTime = appointmentDateTime;
		this.departmentName = departmentName;
		this.organizationName = organizationName;
		this.designation = designation;
		this.officialAddress = officialAddress;
		this.grievanceDetails = grievanceDetails;
		this.status = status;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public Visitors() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Visitors [id=" + id + ", fullName=" + fullName + ", age=" + age + ", gender=" + gender
				+ ", contactNumber=" + contactNumber + ", emailAddress=" + emailAddress + ", purposeOfVisit="
				+ purposeOfVisit + ", appointmentDateTime=" + appointmentDateTime + ", departmentName=" + departmentName
				+ ", organizationName=" + organizationName + ", designation=" + designation + ", officialAddress="
				+ officialAddress + ", grievanceDetails=" + grievanceDetails + ", status=" + status + ", createdAt="
				+ createdAt + ", updatedAt=" + updatedAt + "]";
	}
    
    
}
