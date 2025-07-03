package com.example.test.meli.backend.repository;

import static org.junit.jupiter.api.Assertions.*;

import com.example.test.meli.backend.model.Item;
import com.example.test.meli.backend.service.ItemService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import java.util.List;

public class ItemRepositoryTest {

    @InjectMocks
    private ItemRepository repository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFindAllReturnsItems() {
        List<Item> items = repository.findAll();

        assertNotNull(items);
        assertFalse(items.isEmpty());

        Item firstItem = items.get(0);
        assertNotNull(firstItem.getId());
        assertNotNull(firstItem.getTitle());
    }
}

