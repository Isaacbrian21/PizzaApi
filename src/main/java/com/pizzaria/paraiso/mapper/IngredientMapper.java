package com.pizzaria.paraiso.mapper;

import com.pizzaria.paraiso.entity.Ingredients;
import com.pizzaria.paraiso.request.IngredientsRequest;

public class IngredientMapper {
    public IngredientMapper(){}

    public static Ingredients ingredients(IngredientsRequest request){
        return Ingredients.builder()
                .name(request.getName()).build();
    }
}
