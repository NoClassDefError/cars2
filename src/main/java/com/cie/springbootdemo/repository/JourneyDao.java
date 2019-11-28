package com.cie.springbootdemo.repository;

import com.cie.springbootdemo.model.Journey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JourneyDao extends JpaRepository<Journey,Long> {

}
