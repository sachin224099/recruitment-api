package com.sachin.recruitmentapi.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Application implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6094786039750013937L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String candidateEmail;
	
	private String resumeText;
	
	@Enumerated(EnumType.STRING)
	private ApplicationStatus applicationStatus;
	
	@ManyToOne
	private Offer offer;
}
