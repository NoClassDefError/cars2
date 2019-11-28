package com.cie.springbootdemo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class Car {
    private long id;
    private String start;
    private String arrival;
    private Driver driver;
    private List<Journey> journeys;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "start", length = 50)
    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    @Basic
    @Column(name = "arrival", length = 50)
    public String getArrival() {
        return arrival;
    }

    public void setArrival(String arrival) {
        this.arrival = arrival;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return id == car.id &&
                Objects.equals(start, car.start) &&
                Objects.equals(arrival, car.arrival);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, start, arrival);
    }

    @ManyToOne(targetEntity = Driver.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "belonger", referencedColumnName = "id")
    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    @OneToMany(mappedBy = "car",targetEntity = Journey.class)
    public List<Journey> getJourneys() {
        return journeys;
    }

    public void setJourneys(List<Journey> journeys) {
        this.journeys = journeys;
    }
}
