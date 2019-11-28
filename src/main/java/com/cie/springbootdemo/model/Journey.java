package com.cie.springbootdemo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class Journey {
    private long id;
    private Timestamp start;
    private Timestamp arrival;
    private Long gain;
    private Integer passengers;
    private String remark;
    private Car car;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "start")
    public Timestamp getStart() {
        return start;
    }

    public void setStart(Timestamp start) {
        this.start = start;
    }

    @Basic
    @Column(name = "arrival")
    public Timestamp getArrival() {
        return arrival;
    }

    public void setArrival(Timestamp arrival) {
        this.arrival = arrival;
    }

    @Basic
    @Column(name = "gain")
    public Long getGain() {
        return gain;
    }

    public void setGain(Long gain) {
        this.gain = gain;
    }

    @Basic
    @Column(name = "passengers")
    public Integer getPassengers() {
        return passengers;
    }

    public void setPassengers(Integer passengers) {
        this.passengers = passengers;
    }

    @Basic
    @Column(name = "remark", length = 1000)
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Journey journey = (Journey) o;
        return id == journey.id &&
                Objects.equals(start, journey.start) &&
                Objects.equals(arrival, journey.arrival) &&
                Objects.equals(gain, journey.gain) &&
                Objects.equals(passengers, journey.passengers) &&
                Objects.equals(remark, journey.remark);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, start, arrival, gain, passengers, remark);
    }

    @ManyToOne(targetEntity = Car.class)
    @JoinColumn(name = "car_id", referencedColumnName = "id")//字段命名不建议以驼峰命名
    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
}
