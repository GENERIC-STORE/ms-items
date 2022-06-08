package com.bootcamp.msitems.service;

import com.bootcamp.msitems.model.Item;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ItemServiceImpl implements IItemService{
    @Override
    public Flux<Item> findAll() {
        return null;
    }

    @Override
    public Mono<Item> findById(Long id, Integer quantity) {
        return null;
    }
}
