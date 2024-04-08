package com.fsd.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fsd.entity.Event;
import com.fsd.repository.EventRepository;

@Service
//business logic exist here..
public class EventService {
	// Autowired annotation is used for automatic dependency injection of EventRepository.
	@Autowired
	private EventRepository eventRepository;

	// method to create an event.
	public Event createEvent(Event event) {
		// Save the provided event object using the eventRepository's save method, which
		// persists the event to the database.
		return eventRepository.save(event);
	}

	// method to get list an event.
	public List<Event> getAllEvents() {
		return eventRepository.findAll();
	}

	// method to get an event by id.
	public Event getEventById(Long id) {
		return eventRepository.findById(id).orElse(null);
	}

	// method to update an event.
	public Event updateEvent(Long id, Event event) {
		if (eventRepository.existsById(id)) {
			event.setId(id);
			return eventRepository.save(event);
		}
		return null;
	}

	// method to delete an event.
	public void deleteEvent(Long id) {
		eventRepository.deleteById(id);
	}

}
