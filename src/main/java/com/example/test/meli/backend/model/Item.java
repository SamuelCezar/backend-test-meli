package com.example.test.meli.backend.model;

import lombok.Data;

import java.util.List;

@Data
public class Item {

    private String id;
    private String title;
    private String description;
    private double price;
    private List<String> paymentMethods;
    private Seller seller;
    private int stock;
    private double rating;
    private List<String> imageUrls;
}
