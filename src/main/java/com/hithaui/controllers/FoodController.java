package com.hithaui.controllers;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.hithaui.exception.DuplicateException;
import com.hithaui.exception.NotFoundException;
import com.hithaui.models.Food;
import com.hithaui.repositories.FoodRepository;



@RestController
@RequestMapping("/api/food")
public class FoodController {
	
		@Autowired
		private FoodRepository foodRepository;
		
		@Autowired
		private Cloudinary cloudinary;
		
		@GetMapping
		public ResponseEntity<?> getAllFood(){
			List<Food> foods = foodRepository.findAll();
			if(foods == null) {
				ResponseEntity.status(404).build();
			}
			return ResponseEntity.status(200).body(foods);
			
		}
		
		@PostMapping
		public ResponseEntity<?> createNewFood (@RequestParam("foodName") String foodName,@RequestParam("material") String material,
				@RequestParam("recipes") String recipes, @RequestParam("nutrition") String nutrition,
				@RequestParam("img") MultipartFile file) throws IOException{ 
				
				Food food  = foodRepository.findByfoodName(foodName);
				
				if (food != null) {
						throw new DuplicateException("Duplicate foodName");
				}
				
				Map<?, ?> map = cloudinary.uploader().upload(file.getBytes(), ObjectUtils.emptyMap());
				
				String imgLink = (String) map.get("secure_url");
				String imgid = (String) map.get("public_id");
				
				Food food_One = new Food();
				food_One.setFoodName(foodName);
				food_One.setImg(imgLink);
				food_One.setMaterial(material);
				food_One.setNutrition(nutrition);
				food_One.setRecipes(recipes);
				food_One.setPublicId(imgid);
				Food newFood = foodRepository.save(food_One);
				
				return ResponseEntity.status(201).body(newFood);
			
		}
		@DeleteMapping("{FoodId}")
		public ResponseEntity<?> deleteFood(@PathVariable("FoodId") Integer FoodId) throws IOException{
			Optional<Food> optinalFood = foodRepository.findById(FoodId);
			
			if(!optinalFood.isPresent()) {
					throw new NotFoundException("Food ID not found");
			}
			
			Food food =  optinalFood.get();
			
			cloudinary.uploader().destroy(food.getPublicId(),ObjectUtils.emptyMap()) ;
			foodRepository.deleteById(food.getId());
			
			return ResponseEntity.status(200).body(food);
		}
		
		
}
