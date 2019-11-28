package com.cie.springbootdemo.repository;

import com.cie.springbootdemo.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//重要：spring中抽象类不能被注入，但接口可以被注入
//若该接口有多种实现，则使用@Qualifier指定实现方式，或者使用@Primary指定默认实现方式
@Repository
public interface JpaCarRepository extends JpaRepository<Car,Long> {

}
