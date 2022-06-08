package com.bootcamp.msitems.controller;

import com.bootcamp.msitems.model.Item;
import com.bootcamp.msitems.service.IItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Controller
@RequestMapping("item")
public class ItemController {
    @Autowired
    private IItemService service;

    @GetMapping()
    public Mono<ResponseEntity<Flux<Item>>> findAll() {
        return Mono.just(
                ResponseEntity.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(service.findAll())
        );
    }

    @GetMapping("/{id}/quantity/{quantity}")
    public Mono<ResponseEntity<Mono<Item>>> findById(@PathVariable Long id, @PathVariable Integer quantity) {
        return Mono.just(
                ResponseEntity.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(service.findById(id, quantity))
        );
    }
}
