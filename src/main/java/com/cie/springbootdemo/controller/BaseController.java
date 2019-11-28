package com.cie.springbootdemo.controller;

import com.cie.springbootdemo.repository.JourneyDao;
import com.cie.springbootdemo.repository.JpaCarRepository;
import com.cie.springbootdemo.repository.JpaDriverRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RestController;

@RestController
public abstract class BaseController {
    JpaCarRepository jpaCarRepository;
    JpaDriverRepository jpaDriverRepository;
    JourneyDao jpaJourneyRepository;
    Logger logger;
    ObjectMapper objectMapper;
    public BaseController(JpaCarRepository jpaCarRepository, JpaDriverRepository jpaDriverRepository, JourneyDao jpaJourneyRepository) {
        this.jpaCarRepository = jpaCarRepository;
        this.jpaDriverRepository = jpaDriverRepository;
        this.jpaJourneyRepository = jpaJourneyRepository;
        logger= LoggerFactory.getLogger(this.getClass());
        objectMapper = new ObjectMapper();
    }
}
