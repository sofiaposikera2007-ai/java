package com.example.catalog.controller;

import com.example.catalog.model.Place;
import com.example.catalog.repository.PlaceRepository;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation .*;
import org.springframework.security.access.prepost.PreAuthorize;


import java.util.List;

@Slf4j
@CrossOrigin(origins = "http://localhost:5174")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/places")
public class PlaceController {
    private final PlaceRepository destinationRepository;

    @Operation(summary = "Отримати всі туристичні місця")

    @GetMapping
    public List<Place> getAllDestinations() {
        log.info("GET /api/destinations - отримати всі туристичні місця");
        return destinationRepository.findAll();
    }

    @Operation(summary = "Отримати туристичне місце по ID")
    @GetMapping("/{id}")
    public Place getDestinationById(@PathVariable Long id) {
        log.info("GET /api/destinations/{} - отримати туристичне місце", id);
        return destinationRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Туристичне місце не знайдено"));
    }


    @Operation(summary = "Створити нове туристичне місце")
    @PostMapping
    public Place createDestination(@RequestBody Place destination) {
        log.info("POST /api/destinations - створити туристичне місце: {}", destination.getName());
        return destinationRepository.save(destination);
    }

    @Operation(summary = "Оновити туристичне місце за ID")
    @PutMapping("/{id}")
    public ResponseEntity<Place> updateDestination(
            @PathVariable Long id,
            @RequestBody Place destinationDetails) {
        log.info("PUT /api/destinations/{} - запит на оновлення туристичного місця", id);

        return destinationRepository.findById(id)
                .map(existingDestination -> {
                    updateDestinationFields(existingDestination,destinationDetails);
                    Place updated = destinationRepository.save(existingDestination);
                    log.info("Туристичне місце з ID={} успішно оновлено", id);
                    return ResponseEntity.ok(updated);
                })

                .orElseGet(() -> {
                    log.warn("Туристичне місце з ID={} не знайдено для оновлення", id);
                    return ResponseEntity.notFound().build();
                });
    }

    private void updateDestinationFields(Place target, Place source) {
        target.setName(source.getName());
        target.setDescription(source.getDescription());
        target.setImageUrl(source.getImageUrl());
    }
    @Operation(summary = "Видалити туристичне місце")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDestination(@PathVariable Long id) {
        log.warn("DELETE /api/destinations/{} - видалити туристичне місце", id);

        if (destinationRepository.existsById(id)) {
            destinationRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            log.warn("Туристичне місце з ID={} не знайдено", id);
            return ResponseEntity.notFound().build();
        }
    }

}