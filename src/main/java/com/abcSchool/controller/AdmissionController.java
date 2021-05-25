package com.abcSchool.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import org.springframework.web.bind.annotation.CrossOrigin;


import com.abcSchool.entity.AdmissionEntity;
import com.abcSchool.service.AdmissionService;

@RestController
@CrossOrigin(origins="http://localhost:3000/")
@RequestMapping("/abcSchool")
public class AdmissionController {

	@Autowired
	AdmissionService admService;

	@PostMapping("/saveAdmInfo")
	public List<AdmissionEntity> addNewAdmission(@RequestBody AdmissionEntity admEntity) {
		admService.saveAdmissionInfo(admEntity);
		return admService.getAllAdmissionInfo();
	}

	@GetMapping("/getAdmInfo/{admNo}")
	public AdmissionEntity getAdmissionInfo(@PathVariable("admNo") String admNo) {
		return admService.getAdmissionInfo(admNo);
	}

	@GetMapping("/getAllAdmInfo")
	public List<AdmissionEntity> getAllAdmissionInfo() {
		return admService.getAllAdmissionInfo();
	}

}
