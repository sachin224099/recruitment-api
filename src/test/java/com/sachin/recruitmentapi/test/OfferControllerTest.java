package com.sachin.recruitmentapi.test;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.sachin.recruitmentapi.controller.OfferController;
import com.sachin.recruitmentapi.entity.Offer;
import com.sachin.recruitmentapi.service.ApplicationService;
import com.sachin.recruitmentapi.service.OfferService;

@WebMvcTest(OfferController.class)
public class OfferControllerTest {

	@Autowired
	private MockMvc mockMvc;
	@MockBean
	private OfferService offerService;
	@MockBean
	private ApplicationService applicationService;
	
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
	public void testGetAllOffer() throws Exception {
		when(offerService.getAllOffer()).thenReturn(offers);

		mockMvc.perform(get("/api/offers")).andExpect(status().isOk())
		                                   .andExpect(jsonPath("$.size()", is(offers.size())));
	}
	
	
	@Test
	public void testGetOfferById() throws Exception {
		Long id = 1L;
		Offer java = Offer.builder().id(id).jobTitle("Java Developer").build();
		
		when(offerService.getOfferById(1L)).thenReturn(java);

		mockMvc.perform(get("/api/offers/{id}", id))
		                      .andExpect(status().isOk())
		                      .andExpect(jsonPath("$.jobTitle", is(java.getJobTitle())));
	}

}
