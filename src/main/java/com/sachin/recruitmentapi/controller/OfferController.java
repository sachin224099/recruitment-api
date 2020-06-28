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
import com.sachin.recruitmentapi.entity.Offer;
import com.sachin.recruitmentapi.service.ApplicationService;
import com.sachin.recruitmentapi.service.OfferService;

@RestController
@RequestMapping("/api/offers")
public class OfferController {

	@Autowired
	private OfferService offerService;

	@Autowired
	private ApplicationService applicationService;

	@PostMapping(consumes = {"application/json"})
	public ResponseEntity<String> createOffer(@RequestBody Offer offer) {

		offerService.createOffer(offer);

		return new ResponseEntity<>("Created succesfully", HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity<List<Offer>> getAllOffer() {

		return new ResponseEntity<>(offerService.getAllOffer(), HttpStatus.OK);
	}

	@GetMapping("/{offerId}")
	public ResponseEntity<Offer> getOfferById(@PathVariable Long offerId) {

		return new ResponseEntity<>(offerService.getOfferById(offerId), HttpStatus.OK);
	}

	@PutMapping
	public ResponseEntity<String> updateOffer(@RequestBody Offer offer) {

		offerService.updateOffer(offer);

		return new ResponseEntity<>("updated", HttpStatus.OK);
	}

	@DeleteMapping("/{offerId}")
	public ResponseEntity<String> deleteOfferById(@PathVariable Long offerId) {

		offerService.removeOfferById(offerId);

		return new ResponseEntity<>("deleted", HttpStatus.OK);
	}

	@DeleteMapping
	public ResponseEntity<String> deleteOffer(@RequestBody Offer offer) {

		offerService.removeOffer(offer);

		return new ResponseEntity<>("deleted", HttpStatus.OK);
	}

	@GetMapping("/{offerId}/applications")
	public ResponseEntity<List<Application>> getAllApplicationByOfferId(@PathVariable Long offerId) {

		return new ResponseEntity<>(applicationService.getApplicationsByOfferId(offerId), HttpStatus.OK);
	}

	@GetMapping("/{offerId}/applications/{appId}")
	public ResponseEntity<Application> getApplicationByOfferIdAndApplicationId(@PathVariable Long offerId,
			@PathVariable Long appId) {

		Application app = applicationService.getApplicationsByOfferId(offerId).parallelStream().findFirst().get();

		return new ResponseEntity<>(app, HttpStatus.OK);
	}

}
