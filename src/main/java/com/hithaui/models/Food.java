package com.hithaui.models;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Nationalized;


@Entity
@Table(name = "Foods")
public class Food {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Food_Id")
	private Integer id;
	
	@Nationalized
	@Column(name = "foodName", nullable = false, length = 1000)
	private String foodName;
	
	@Column(name = "img", nullable = false)
	private String img;
	
	@Nationalized
	@Column(name = "material", nullable = false, length = 10000)
	private String material;
	
	@Nationalized
	@Column(name ="recipes", nullable = false,	length = 10000)
	private String recipes;
	
	@Nationalized
	@Column(name = "nutrition", nullable =false)
	private String nutrition;
	
	@Column(name = "public_Id",nullable = false)
	private String publicId;

	public Food() {
		super();
	}

	public Food(Integer id, String foodName, String img, String material, String recipes, String nutrition,
			String publicId) {
		super();
		this.id = id;
		this.foodName = foodName;
		this.img = img;
		this.material = material;
		this.recipes = recipes;
		this.nutrition = nutrition;
		this.publicId = publicId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public String getPublicId() {
		return publicId;
	}

	public void setPublicId(String publicId) {
		this.publicId = publicId;
	}
	
	

	
}
