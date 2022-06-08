package com.bootcamp.msitems.service;

import com.bootcamp.msitems.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ItemServiceImpl implements IItemService{

    @Autowired
    private RestTemplate restClient;

    @Override
    public Flux<Item> findAll() {
        return null;
    }

    @Override
    public Mono<Item> findById(Long id, Integer quantity) {
        return null;
    }
}
