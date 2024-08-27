package com.minister.visitorsapp.entities;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

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
    private LocalDateTime appointmentstartDateTime;
    
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime appointmentendDateTime;
    
    private String departmentName;
    private String organizationName;
    private String designation;
    private String officialAddress;
    private String grievanceDetails;
    
    private String status; // Pending, Approved, Rejected
    private String role; //admin, visitor
    private String remark; 
    private int meetingDuration; //minutes
    private String document;
    private String password;
    

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

	public LocalDateTime getAppointmentstartDateTime() {
		return appointmentstartDateTime;
	}

	public void setAppointmentstartDateTime(LocalDateTime appointmentstartDateTime) {
		this.appointmentstartDateTime = appointmentstartDateTime;
	}

	public LocalDateTime getAppointmentendDateTime() {
		return appointmentendDateTime;
	}

	public void setAppointmentendDateTime(LocalDateTime appointmentendDateTime) {
		this.appointmentendDateTime = appointmentendDateTime;
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

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public int getMeetingDuration() {
		return meetingDuration;
	}

	public void setMeetingDuration(int meetingDuration) {
		this.meetingDuration = meetingDuration;
	}

	public String getDocument() {
		return document;
	}

	public void setDocument(String document) {
		this.document = document;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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
			String purposeOfVisit, LocalDateTime appointmentstartDateTime, LocalDateTime appointmentendDateTime,
			String departmentName, String organizationName, String designation, String officialAddress,
			String grievanceDetails, String status, String role, String remark, int meetingDuration,
			String document, String password, LocalDateTime createdAt, LocalDateTime updatedAt) {
		super();
		this.id = id;
		this.fullName = fullName;
		this.age = age;
		this.gender = gender;
		this.contactNumber = contactNumber;
		this.emailAddress = emailAddress;
		this.purposeOfVisit = purposeOfVisit;
		this.appointmentstartDateTime = appointmentstartDateTime;
		this.appointmentendDateTime = appointmentendDateTime;
		this.departmentName = departmentName;
		this.organizationName = organizationName;
		this.designation = designation;
		this.officialAddress = officialAddress;
		this.grievanceDetails = grievanceDetails;
		this.status = status;
		this.role = role;
		this.remark = remark;
		this.meetingDuration = meetingDuration;
		this.document = document;
		this.password = password;
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
				+ purposeOfVisit + ", appointmentstartDateTime=" + appointmentstartDateTime
				+ ", appointmentendDateTime=" + appointmentendDateTime + ", departmentName=" + departmentName
				+ ", organizationName=" + organizationName + ", designation=" + designation + ", officialAddress="
				+ officialAddress + ", grievanceDetails=" + grievanceDetails + ", status=" + status + ", role=" + role
				+ ", remark=" + remark + ", meetingDuration=" + meetingDuration + ", document=" + document
				+ ", password=" + password + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + "]";
	}

	
	
    
    
}
