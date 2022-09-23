package com.pizzaria.paraiso.controller;

import com.pizzaria.paraiso.entity.Ingredients;
import com.pizzaria.paraiso.request.IngredientsRequest;
import com.pizzaria.paraiso.service.IngredientService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/ingredients")
@CrossOrigin(origins = "http://localhost:4200")
public class IngredientController {

    private final IngredientService service;

    @GetMapping("/{id}")
    public Optional<Ingredients> getID(@PathVariable("id") Long id){
        return service.getById(id);
    }

    @GetMapping()
    public List<Ingredients> getALl(){
        return  service.findAll();
    }

    @PostMapping()
    public Ingredients post(@RequestBody @Validated IngredientsRequest request){
        return service.postIng(request);

    }
    @PutMapping("/{id}")
    public Ingredients updateIng(@RequestBody Ingredients ingredient, @PathVariable("id") Long id){
        return service.update(ingredient, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id){
        service.deletar(id);
    }
}
