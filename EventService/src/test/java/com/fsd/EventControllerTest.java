package com.fsd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.fsd.controller.EventController;
import com.fsd.entity.Event;
import com.fsd.service.EventService;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class EventControllerTest {

    @Mock
    private EventService eventService;

    @InjectMocks
    private EventController eventController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void createEvent() {
        Event event = new Event(); // Create a sample event
        when(eventService.createEvent(event)).thenReturn(event); // Mock the behavior of EventService

        ResponseEntity<Event> responseEntity = eventController.createEvent(event); // Call the method under test

        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode()); // Verify HTTP status code
        assertEquals(event, responseEntity.getBody()); // Verify response body

        verify(eventService, times(1)).createEvent(event); // Verify that EventService method is called once
    }

    @Test
    void getAllEvents() {
        List<Event> events = new ArrayList<>(); // Create a sample list of events
        when(eventService.getAllEvents()).thenReturn(events); // Mock the behavior of EventService

        ResponseEntity<List<Event>> responseEntity = eventController.getAllEvents(); // Call the method under test

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode()); // Verify HTTP status code
        assertEquals(events, responseEntity.getBody()); // Verify response body

        verify(eventService, times(1)).getAllEvents(); // Verify that EventService method is called once
    }

    // Similar tests can be written for getEventById, updateEvent, and deleteEvent methods
}

