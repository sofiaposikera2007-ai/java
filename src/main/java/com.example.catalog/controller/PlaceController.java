package com.example.catalog.controller;

import com.example.catalog.model.Place;
import com.example.catalog.repository.PlaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/places")

public class PlaceController {

    @Autowired
    private   PlaceRepository repository;


    // GET: отримати всі місця
    @GetMapping
    public String listPlaces(Model model) {
        model.addAttribute("places", repository.findAll());
        return "place-list";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("place", new Place());
        return "place-form";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Place place = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Невірний ID туристичного місця: " + id));
        model.addAttribute("place", place);
        return "place-form";
    }

    @PostMapping("/save")
    public String savePlace(@ModelAttribute("place") Place place) {
        repository.save(place);
        return "redirect:/places";
    }


    @GetMapping("/delete/{id}")
    public String deletePlace(@PathVariable Long id) {
        repository.deleteById(id);
        return "redirect:/places";
    }

}
