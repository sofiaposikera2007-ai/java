package com.example.catalog.controller;

import com.example.catalog.model.Place;
import com.example.catalog.repository.PlaceRepository;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@RestController
@RequestMapping("/api/places")
@CrossOrigin(origins = "http://localhost:5173")
public class PlaceController {

    @Autowired
    private PlaceRepository repository;

    // GET: отримати всі місця
    @GetMapping
    public List<Place> getAllPlaces() {
        return repository.findAll();
    }

    @PostMapping
    public Place createPlace(@RequestBody Place place) {
        return repository.save(place);
    }

    @PutMapping("/{id}")
    public Place updatePlace(@PathVariable Long id, @RequestBody Place placeDetails) {
        Place place = repository.findById(id).orElseThrow();

        place.setName(placeDetails.getName());
        place.setDescription(placeDetails.getDescription());
        place.setImageUrl(placeDetails.getImageUrl());

        return repository.save(place);
    }

    @DeleteMapping("/{id}")
    public void deleteDestination(@PathVariable Long id) {
        repository.deleteById(id);
    }

}

