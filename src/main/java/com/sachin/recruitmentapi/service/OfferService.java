package com.sachin.recruitmentapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sachin.recruitmentapi.entity.Offer;
import com.sachin.recruitmentapi.repository.OfferRespository;

@Service
public class OfferService {
	
	@Autowired
	private OfferRespository offerRespository;
	
	public List<Offer> getAllOffer(){
		return offerRespository.findAll();
	}
	
	public Offer getOfferById(Long id){
		return offerRespository.findById(id).get();
	}
	
	public void createOffer(Offer offer) {
		offerRespository.save(offer);
	}
	
	public void updateOffer(Offer offer) {
		offerRespository.saveAndFlush(offer);
	}
	
	public void removeOfferById(Long id) {
		offerRespository.deleteById(id);
	}
	
	public void removeOffer(Offer offer) {
		offerRespository.delete(offer);
	}
	
}
