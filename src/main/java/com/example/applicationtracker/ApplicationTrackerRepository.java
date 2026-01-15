package com.example.applicationtracker;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicationTrackerRepository extends JpaRepository<Application, Integer> {


}
