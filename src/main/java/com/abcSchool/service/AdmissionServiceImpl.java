package com.abcSchool.service;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abcSchool.entity.AdmissionEntity;
import com.abcSchool.repository.AdmissionRepository;

@Service
public class AdmissionServiceImpl implements AdmissionService {

	@Autowired
	AdmissionRepository admRepo;
	
	private final static Random random = new Random();

	@Override
	public List<AdmissionEntity> getAllAdmissionInfo() {

		return admRepo.findAll();

	}

	@Override
	public AdmissionEntity getAdmissionInfo(String admNo) {
		return admRepo.findByAdmNo(admNo);
	}

	@Override
	public void saveAdmissionInfo(AdmissionEntity admInfo) {

		admInfo.setAdmNo(generateAdmNo());
		admRepo.save(admInfo);
	}

	public String generateAdmNo() {
		
		String init = "R-";
		int numbers = random.nextInt(9000) + 1000;
		String admNo = init + numbers;
		return admNo;

	}

}
