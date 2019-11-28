package com.cie.springbootdemo.controller;

import com.alibaba.fastjson.JSONObject;
import com.cie.springbootdemo.model.Car;
import com.cie.springbootdemo.model.Driver;
import com.cie.springbootdemo.repository.JourneyDao;
import com.cie.springbootdemo.repository.JpaCarRepository;
import com.cie.springbootdemo.repository.JpaDriverRepository;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/login")
public class LoginController extends BaseController {


    public LoginController(JpaCarRepository jpaCarRepository, JpaDriverRepository jpaDriverRepository, JourneyDao jpaJourneyRepository) {
        super(jpaCarRepository, jpaDriverRepository, jpaJourneyRepository);
    }

    @RequestMapping(value = "/addcar", method = RequestMethod.GET)
    public String getCar() {
        Driver driver = new Driver();
        driver.setName("123");
        driver.setUsername("username");
        driver.setPassword("123456");
        jpaDriverRepository.save(driver);
        Car car = new Car();
        car.setDriver(driver);
        car.setStart("afqwf");
        jpaCarRepository.save(car);
        return "OK";
    }

    /**
     * login的控制器
     * <ul>
     *     <li> 传入信息示例：
     *          {"passwrd":"123456","userName":"gehanchen"}
     *     </li>
     *     <li>
     *         地址示例：http://localhost:8888/springbootdemo/login/login
     *     </li>
     * </ul>
     * <p><b>注意此处接收json的方式</b>
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@RequestBody JSONObject jsonObject) {
        logger.debug("getinfo:" + jsonObject.toJSONString());
        Driver driver = new Driver();
        driver.setUsername(jsonObject.getString("userName"));
        driver.setPassword(jsonObject.getString("passwrd"));
        logger.info("finding: " + driver.toString());
        ExampleMatcher exampleMatcher = ExampleMatcher.matching()
                .withMatcher("username", ExampleMatcher.GenericPropertyMatchers.exact())
                .withMatcher("password", ExampleMatcher.GenericPropertyMatchers.exact())
                .withIgnorePaths("name").withIgnorePaths("id");
        Optional<Driver> result = jpaDriverRepository.findOne(Example.of(driver, exampleMatcher));
        logger.info("result:" + result.isPresent());
        if (result.isPresent())
            return "success";
        else return "error";
    }



}
