package com.hithaui.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hithaui.models.Food;

@Repository
public interface FoodRepository extends JpaRepository<Food, Integer> {
		Food findByfoodName(String foodName);
}
