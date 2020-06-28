package com.sachin.recruitmentapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sachin.recruitmentapi.entity.Offer;

@Repository
public interface OfferRespository extends JpaRepository<Offer, Long>{

}
