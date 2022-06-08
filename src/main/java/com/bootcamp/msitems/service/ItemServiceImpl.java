package com.bootcamp.msitems.service;

import com.bootcamp.msitems.model.Item;
import com.bootcamp.msitems.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ItemServiceImpl implements IItemService{

    @Autowired
    private RestTemplate restClient;

    @Override
    public Flux<Item> findAll() {
        List<Product> products = Arrays.asList(restClient.getForObject("http://localhost:3000/product", Product[].class));

        List<Item> a = products.stream().map(p -> new Item(p, 1)).collect(Collectors.toList());

        return Flux.fromIterable(a);
    }

    @Override
    public Mono<Item> findById(Long id, Integer quantity) {
        Map<String, String> pathVariables = new HashMap<>();
        pathVariables.put("id", id.toString());

        Product product = restClient.getForObject("http://localhost:3000/product/{id}", Product.class, pathVariables);

        return Mono.just(new Item(product, quantity));
    }
}
