package com.example.test.meli.backend.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.List;

import com.example.test.meli.backend.exception.ItemNotFoundException;
import com.example.test.meli.backend.model.Item;
import com.example.test.meli.backend.model.Seller;
import com.example.test.meli.backend.repository.ItemRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class ItemServiceTest {

    @Mock
    private ItemRepository itemRepository;

    @InjectMocks
    private ItemService itemService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetItemById_ReturnsItem() {
        Item item1 = getItem();
        Item item2 = getItem();
        item2.setId("2");
        item2.setPrice(2000);

        when(itemRepository.findAll()).thenReturn(List.of(item1, item2));

        Item result = itemService.getItemById("1");

        assertNotNull(result);
        assertEquals("1", result.getId());
        assertEquals("Notebook Dell Inspiron", result.getTitle());
    }

    @Test
    void testGetItemById_ThrowsExceptionWhenNotFound() {
        when(itemRepository.findAll()).thenReturn(List.of());

        ItemNotFoundException ex = assertThrows(ItemNotFoundException.class, () -> {
            itemService.getItemById("999");
        });

        assertEquals("Item id: 999 not found.", ex.getMessage());
    }

    private Item getItem() {
        Item item = new Item();
        item.setTitle("Notebook Dell Inspiron");
        item.setId("1");
        item.setPrice(4500.0);
        item.setDescription("Description");

        Seller seller = new Seller();
        seller.setId("1");
        seller.setName("Seller name");

        item.setSeller(seller);
        return item;
    }
}

