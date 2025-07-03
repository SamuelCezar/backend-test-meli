package com.example.test.meli.backend.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.example.test.meli.backend.exception.ItemNotFoundException;
import com.example.test.meli.backend.model.Item;
import com.example.test.meli.backend.model.Seller;
import com.example.test.meli.backend.service.ItemService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(ItemController.class)
public class ItemControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ItemService itemService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testGetItemById_ReturnsItem() throws Exception {
        Item item = getItem();

        when(itemService.getItemById("1")).thenReturn(item);

        mockMvc.perform(get("/api/items/1")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value("1"))
                .andExpect(jsonPath("$.title").value("Notebook Dell Inspiron"))
                .andExpect(jsonPath("$.price").value(4500.0));
    }

    @Test
    public void testGetItemById_ReturnsNotFound() throws Exception {
        when(itemService.getItemById("999")).thenThrow(new ItemNotFoundException("Item not found"));

        mockMvc.perform(get("/api/items/999")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
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

