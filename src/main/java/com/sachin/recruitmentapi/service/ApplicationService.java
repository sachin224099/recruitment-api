package com.sachin.recruitmentapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sachin.recruitmentapi.entity.Application;
import com.sachin.recruitmentapi.repository.ApplicationRepository;

@Service
public class ApplicationService {

	
	@Autowired
	private ApplicationRepository applicationRespository;
	
	public List<Application> getAllAppliactions(){
		return applicationRespository.findAll();
	}
	
	public Application getAppliactionById(Long id){
		return applicationRespository.findById(id).get();
	}
	
	public void createAppliaction(Application application) {
		applicationRespository.save(application);
	}
	
	public void updateAppliaction(Application application) {
		applicationRespository.saveAndFlush(application);
	}
	
	public void removeAppliactionById(Long id) {
		applicationRespository.deleteById(id);
	}
	
	public void removeAppliaction(Application application) {
		applicationRespository.delete(application);
	}
	
	public List<Application> getApplicationsByOfferId(Long offerId){
		return applicationRespository.findAllApplicationByOfferId(offerId);
	}

}
