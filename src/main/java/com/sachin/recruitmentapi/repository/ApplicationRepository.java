package com.sachin.recruitmentapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sachin.recruitmentapi.entity.Application;

@Repository
public interface ApplicationRepository extends JpaRepository<Application, Long>{
	
	public List<Application> findAllApplicationByOfferId(Long offerId); 
	
}
