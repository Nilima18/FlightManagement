package com.flightapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.flightapp.entity.Passenger;

@Repository
public interface PassengerRepository extends JpaRepository<Passenger, Long> {

}
