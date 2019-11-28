package com.cie.springbootdemo.repository;

import com.cie.springbootdemo.model.Driver;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaDriverRepository extends JpaRepository<Driver,Long> {
}
