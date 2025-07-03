package com.example.test.meli.backend.controller;

import com.example.test.meli.backend.model.Item;
import com.example.test.meli.backend.service.ItemService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/api/items")
public class ItemController {

    private final ItemService itemService;

    /**
     * Endpoint to get item details
     * @param id item identifier
     * @return item details
     */

    @Operation(summary = "Find an Item by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Item sucessfully found"),
            @ApiResponse(responseCode = "404", description = "Item not found",
                    content = @Content(mediaType = "application/json"))
    })
    @GetMapping("/{id}")
    public ResponseEntity<Item> getItemById(@PathVariable String id) {
                return ResponseEntity.ok(itemService.getItemById(id));
    }

}
