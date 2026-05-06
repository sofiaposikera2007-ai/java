package com.example.catalog.controller;

import com.example.catalog.model.Place;
import com.example.catalog.repository.PlaceRepository;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation .*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/places")
public class PlaceController {
    private final PlaceRepository repository;

    @Operation(summary = "Отримати всі туристичні місця")
    @GetMapping
    public List<Place> getAllDestinations() {
        log.info("GET /api/places - отримати всі туристичні місця");
        return repository.findAll();
    }

    @Operation(summary = "Отримати туристичне місце по ID")
    @GetMapping("/{id}")
    public Place getDestinationById(@PathVariable Long id) {
        log.info("GET /api/places/{} - отримати туристичне місце", id);
        return repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Туристичне місце не знайдено"));
    }


    @Operation(summary = "Створити нове туристичне місце")
    @PostMapping
    public Place createDestination(@RequestBody Place destination) {
        log.info("POST /api/places - створити туристичне місце: {}", destination.getName());
        return repository.save(destination);
    }

    @Operation(summary = "Оновити туристичне місце за ID")
    @PutMapping("/{id}")
    public ResponseEntity<Place> updateDestination(
            @PathVariable Long id,
            @RequestBody Place destinationDetails) {
        log.info("PUT /api/places/{} - запит на оновлення туристичного місця", id);

        return repository.findById(id)
                .map(existingDestination -> {
                    updateDestinationFields(existingDestination,destinationDetails);
                    Place updated = repository.save(existingDestination);
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
        log.warn("DELETE /api/places/{} - видалити туристичне місце", id);

        if (repository.existsById(id)) {
            repository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            log.warn("Туристичне місце з ID={} не знайдено", id);
            return ResponseEntity.notFound().build();
        }
    }

}