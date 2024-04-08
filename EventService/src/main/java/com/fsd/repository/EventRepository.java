package com.fsd.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fsd.entity.Event;
//a DAOs (Data Access Object) that access the database directly. 
//The repository does all the operations related to the database.
public interface EventRepository extends JpaRepository<Event, Long> {

}
