package com.bootcamp.msitems.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Item {

    private Product product;
    private Integer quantity;

    public Double getAmount() {
        return product.getPrice() * quantity.doubleValue();
    }
}
