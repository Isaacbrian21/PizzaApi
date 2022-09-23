package com.pizzaria.paraiso.service;

import com.pizzaria.paraiso.entity.Pizza;
import com.pizzaria.paraiso.mapper.PizzaMapper;
import com.pizzaria.paraiso.repository.PizzaRepository;
import com.pizzaria.paraiso.request.PizzaRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PizzaService {

    private final PizzaRepository repository;


    public List<Pizza> getAll(){
        return repository.findAll();
    }
    public Optional<Pizza> findById(Long id){
        return repository.findById(id);
    }

    public Pizza postPizza(PizzaRequest request){
        return repository.save(PizzaMapper.pizza(request));
    }
    public Pizza update(Pizza pizza, Long id){
        Optional<Pizza> pizzas = repository.findById(id);

        if (pizzas.isPresent()){
             pizzas.get().setUrl(pizza.getUrl());
             pizzas.get().setName(pizza.getName());
             pizzas.get().setPrice(pizza.getPrice());
             pizzas.get().setIngredients(pizza.getIngredients());
            return repository.save(pizzas.get());
        }

        return repository.save(pizzas.get());

    }

    public void deletePizza(Long id){
      Optional<Pizza> pizza =  repository.findById(id);
        repository.delete(pizza.get());
    }
}
