package com.example.controller;

import com.example.model.Place;
import com.example.repository.PlaceRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/places")
@CrossOrigin(origins = "http://localhost:5173")
public class PlaceController {

    private final PlaceRepository repository;

    public PlaceController(PlaceRepository repository) {
        this.repository = repository;
    }

    // GET: отримати всі місця
    @GetMapping
    public List<Place> getAllPlaces() {
        return repository.findAll();
    }

}
