package com.example.test.meli.backend.repository;

import com.example.test.meli.backend.model.Item;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Repository
public class ItemRepository {

    private final List<Item> items;

    public ItemRepository() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        InputStream inputStream = getClass().getResourceAsStream("/data/items.json");
        this.items = mapper.readValue(inputStream, new TypeReference<List<Item>>() {});
    }

    public List<Item> findAll() {
        return items;
    }
}
