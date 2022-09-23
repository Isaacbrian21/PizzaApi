package com.pizzaria.paraiso.request;

import com.pizzaria.paraiso.entity.Ingredients;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PizzaRequest {
    @NotNull
    private String url;
    @NotNull
    private String name;
    @NotNull
    private Integer price;
    @NotNull
    private ArrayList ingredients;
}
