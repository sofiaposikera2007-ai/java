package com.example.catalog.repository;

import com.example.catalog.model.Place;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "places")
public interface PlaceRepository extends JpaRepository<Place, Long> {}


