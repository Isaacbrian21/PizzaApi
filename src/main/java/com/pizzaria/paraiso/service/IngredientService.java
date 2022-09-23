package com.pizzaria.paraiso.service;

import com.pizzaria.paraiso.entity.Ingredients;
import com.pizzaria.paraiso.mapper.IngredientMapper;
import com.pizzaria.paraiso.repository.IngredientRepository;
import com.pizzaria.paraiso.request.IngredientsRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class IngredientService {
    private final IngredientRepository repository;


    public List<Ingredients> findAll(){
        return repository.findAll();
    }

    public Optional<Ingredients> getById(Long id){
        return repository.findById(id);
    }

    public Ingredients postIng(IngredientsRequest request){
      return repository.save(IngredientMapper.ingredients(request));
    }
    public Ingredients update(Ingredients ingredients, Long id){
        Optional<Ingredients> ingredientss = repository.findById(id);
        if(ingredientss.isPresent()){
            ingredientss.get().setName(ingredients.getName());
        return repository.save(ingredientss.get());
        }else {
            return null;
        }
    }

    public void deletar(Long id){
        Optional<Ingredients> ingredients = repository.findById(id);
        repository.delete(ingredients.get());
    }
}
