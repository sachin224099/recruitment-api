package com.sachin.recruitmentapi.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.sachin.recruitmentapi.entity.Offer;
import com.sachin.recruitmentapi.repository.OfferRespository;

@ExtendWith(MockitoExtension.class)
public class TestOfferService {

	@Mock
	private OfferRespository offerRespository;
	
	@InjectMocks
	private OfferService offerService;
	
    private List<Offer> offers;
	
	@BeforeEach
	public void setUp() {
		this.offers = new ArrayList<>();
		
		Offer java = Offer.builder().id(1L).jobTitle("Java Developer").startDate(new Date()).build();
		Offer angular = Offer.builder().id(2L).jobTitle("Angular Developer").startDate(new Date()).build();
		
		this.offers.add(java);
		this.offers.add(angular);
	}
	
	@Test
	public void testGetAllOffer() {
		when(offerRespository.findAll()).thenReturn(offers);
		
		List<Offer> offers = offerService.getAllOffer();
		
		assertEquals(2, offers.size());
		
		verify(offerRespository, times(1)).findAll();
	}
}
