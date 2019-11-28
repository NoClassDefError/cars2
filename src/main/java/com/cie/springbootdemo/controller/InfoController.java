package com.cie.springbootdemo.controller;

import com.alibaba.fastjson.JSON;
import com.cie.springbootdemo.model.Car;
import com.cie.springbootdemo.repository.JourneyDao;
import com.cie.springbootdemo.repository.JpaCarRepository;
import com.cie.springbootdemo.repository.JpaDriverRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/info")
public class InfoController extends BaseController {

    public InfoController(JpaCarRepository jpaCarRepository,
                          JpaDriverRepository jpaDriverRepository,
                          JourneyDao jpaJourneyRepository) {
        super(jpaCarRepository, jpaDriverRepository, jpaJourneyRepository);
    }

    /**
     * getcars的控制器
     * <ul>
     *     <li>
     *         地址示例：http://localhost:8888/springbootdemo/info/getcars
     *     </li>
     * </ul>
     */
    @RequestMapping(value = "/getcars", method = RequestMethod.GET)
    public String getCars() {
        logger.info("Finding cars...");
        List<Car> cars = jpaCarRepository.findAll();
        //logger.info("Getting the driver's username " + cars.get(0).getDriver().getUsername());
        logger.info("Founded:" + JSON.toJSONString(cars));
        return JSON.toJSONString(cars);
    }
}
