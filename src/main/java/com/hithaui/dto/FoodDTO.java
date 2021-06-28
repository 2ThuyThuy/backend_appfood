package com.hithaui.dto;



public class FoodDTO {
	
	private String foodName;
	
	private String img;
	
	private String material;
	
	private String recipes;
	
	private String nutrition;

	public FoodDTO() {
		super();
	}

	public FoodDTO(String foodName, String img, String material, String recipes, String nutrition) {
		super();
		this.foodName = foodName;
		this.img = img;
		this.material = material;
		this.recipes = recipes;
		this.nutrition = nutrition;
	}

	public String getFoodName() {
		return foodName;
	}

	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public String getRecipes() {
		return recipes;
	}

	public void setRecipes(String recipes) {
		this.recipes = recipes;
	}

	public String getNutrition() {
		return nutrition;
	}

	public void setNutrition(String nutrition) {
		this.nutrition = nutrition;
	}
	
}
