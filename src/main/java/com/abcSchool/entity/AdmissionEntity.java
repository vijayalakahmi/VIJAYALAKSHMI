package com.abcSchool.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "AdmissionInfo")
public class AdmissionEntity {

	@Id
	private String admId;
	
	private String name;
	
	private String dob;
	
	private String std;
	
	private String division;
	
	private String gender;
	
	private String admNo;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getStd() {
		return std;
	}

	public void setStd(String std) {
		this.std = std;
	}

	public String getDivision() {
		return division;
	}

	public void setDivision(String division) {
		this.division = division;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAdmNo() {
		return admNo;
	}

	public void setAdmNo(String admNo) {
		this.admNo = admNo;
	}

	public AdmissionEntity(String name, String dob, String std, String division, String gender, String admNo) {
		super();
		this.name = name;
		this.dob = dob;
		this.std = std;
		this.division = division;
		this.gender = gender;
		this.admNo = admNo;
	}

	public AdmissionEntity() {
		
	}

	@Override
	public String toString() {
		return "AdmissionEntity [admId=" + admId + ", name=" + name + ", dob=" + dob + ", std=" + std + ", division="
				+ division + ", gender=" + gender + ", admNo=" + admNo + "]";
	}
	
	
}
