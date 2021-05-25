package com.abcSchool.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.abcSchool.entity.AdmissionEntity;


@Repository
public interface AdmissionRepository extends MongoRepository<AdmissionEntity, String> {

	AdmissionEntity findByAdmNo(String admNo);

}
