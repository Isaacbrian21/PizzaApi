package com.pizzaria.paraiso.repository;

import com.pizzaria.paraiso.entity.Ingredients;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IngredientRepository extends JpaRepository<Ingredients, Long>{
    Optional<Ingredients> findById(Long id);
}
