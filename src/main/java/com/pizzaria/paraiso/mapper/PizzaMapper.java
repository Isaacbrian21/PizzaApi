package com.pizzaria.paraiso.mapper;

import com.pizzaria.paraiso.entity.Pizza;
import com.pizzaria.paraiso.request.PizzaRequest;

public class PizzaMapper {
    public PizzaMapper(){}
    public static Pizza pizza(PizzaRequest request){
        return Pizza.builder()
                .url(request.getUrl())
                .name(request.getName())
                .price(request.getPrice())
                .ingredients(request.getIngredients())
                .build();
        }
}

