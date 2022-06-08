package com.bootcamp.msitems.service;

import com.bootcamp.msitems.model.Item;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IItemService {
    public Flux<Item> findAll();
    public Mono<Item> findById(Long id, Integer quantity);
}
