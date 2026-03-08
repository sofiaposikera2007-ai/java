package com.lab.fitnesstracker;

public class Tracker {
    private String name;
    private String imageUrl;
    private String description;
    private double price;
    private String material;

   public Tracker(String name, String imageUrl, String description, double price, String material){
       this.name = name;
       this.imageUrl = imageUrl;
       this.description = description;
       this.price = price;
       this.material = material;
   }
}
