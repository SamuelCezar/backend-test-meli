package com.example.test.meli.backend.service;

import com.example.test.meli.backend.exception.ItemNotFoundException;
import com.example.test.meli.backend.model.Item;
import com.example.test.meli.backend.repository.ItemRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class ItemService {

    private final ItemRepository itemRepository;

    public Item getItemById(String id) {
        log.info("Getting item by id: " + id);

        return itemRepository.findAll().stream()
                .filter(item -> item.getId().equalsIgnoreCase(id))
                .findFirst()
                .orElseThrow(() -> new ItemNotFoundException("Item id: " + id + " not found."));
    }
}
