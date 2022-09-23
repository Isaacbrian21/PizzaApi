package com.pizzaria.paraiso.controller;

import com.pizzaria.paraiso.entity.Pizza;
import com.pizzaria.paraiso.request.PizzaRequest;
import com.pizzaria.paraiso.service.PizzaService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/pizza")
@CrossOrigin(origins = "http://localhost:4200")
public class PizzaController {
    private final PizzaService service;

    @GetMapping()
    public List<Pizza> get(){
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Pizza> getId(Long id){
        return service.findById(id);
    }

    @PostMapping()
    public Pizza post(@RequestBody @Validated PizzaRequest request){
        return service.postPizza(request);
    }

    @PutMapping("/{id}")
    public Pizza edit(@RequestBody Pizza pizza, @PathVariable("id") Long id){
        return service.update(pizza, id);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable("id") Long id){
        service.deletePizza(id);
    }
}
