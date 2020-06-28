package com.sachin.recruitmentapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sachin.recruitmentapi.entity.Application;
import com.sachin.recruitmentapi.service.ApplicationService;

@RestController
@RequestMapping("/api/applications")
public class ApplicationController {
	
	@Autowired
	private ApplicationService applicationService;
	
	
	@PostMapping(consumes = {"application/json"})
	public ResponseEntity<String> createApplication(@RequestBody Application application) {

		applicationService.createAppliaction(application);

		return new ResponseEntity<>("Application Submited succesfully", HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity<List<Application>> getAllApplication() {

		return new ResponseEntity<>(applicationService.getAllAppliactions(), HttpStatus.OK);
	}

	@GetMapping("/{appId}")
	public ResponseEntity<Application> getApplicationById(@PathVariable Long appId) {

		return new ResponseEntity<>(applicationService.getAppliactionById(appId), HttpStatus.OK);
	}

	@PutMapping
	public ResponseEntity<String> updateApplication(@RequestBody Application application) {

		applicationService.updateAppliaction(application);

		return new ResponseEntity<>("updated", HttpStatus.OK);
	}

	@DeleteMapping("/{appId}")
	public ResponseEntity<String> deleteApplicationById(@PathVariable Long appId) {

		applicationService.removeAppliactionById(appId);

		return new ResponseEntity<>("deleted", HttpStatus.OK);
	}

	@DeleteMapping
	public ResponseEntity<String> deleteApplication(@RequestBody Application application) {

		applicationService.removeAppliaction(application);

		return new ResponseEntity<>("deleted", HttpStatus.OK);
	}


}
