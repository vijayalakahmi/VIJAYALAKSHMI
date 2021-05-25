package com.abcSchool.service;

import java.util.List;

import com.abcSchool.entity.AdmissionEntity;

public interface AdmissionService {

	public List<AdmissionEntity> getAllAdmissionInfo();

	public AdmissionEntity getAdmissionInfo(String admNo);

	public void saveAdmissionInfo(AdmissionEntity admInfo);

}
