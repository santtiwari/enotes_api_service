package com.becoder.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.becoder.dto.categoryDto;
import com.becoder.dto.categoryResponse;
import com.becoder.entity.Category;
import com.becoder.service.categoryService;

@RestController
@RequestMapping("/api/vi/category")
public class categoryController {
	
	@Autowired
	private categoryService categoryservice;
	
	@PostMapping("/save-category")
	public ResponseEntity<?> saveCategory(@RequestBody Category category){
		
		Boolean saveCategory = categoryservice.saveCategory(category);
		if(saveCategory) {
		return new ResponseEntity<>("saved success", HttpStatus.CREATED);
		}else {
			return new ResponseEntity<>("not saved", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/")
	public ResponseEntity<?> getAllCategory(){
		
		List<Category> allCategory = categoryservice.getAllCategory();
		if(CollectionUtils.isEmpty(allCategory)) {
		return ResponseEntity.noContent().build();
		}else {
			return new ResponseEntity<>(allCategory, HttpStatus.OK);
		}
	}
	
	@PostMapping("/save-categoryDto")
	public ResponseEntity<?> saveCategoryDto(@RequestBody categoryDto categorydto){
		
		Boolean saveCategory = categoryservice.saveCategoryDto(categorydto);
		if(saveCategory) {
		return new ResponseEntity<>("saved success", HttpStatus.CREATED);
		}else {
			return new ResponseEntity<>("not saved", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/categorydto")
	public ResponseEntity<?> getAllCategoryDto(){
		
		List<categoryDto> allCategory = categoryservice.getAllCategories();
		if(CollectionUtils.isEmpty(allCategory)) {
		return ResponseEntity.noContent().build();
		}else {
			return new ResponseEntity<>(allCategory, HttpStatus.OK);
		}
	}
	
	@GetMapping("/active")
	public ResponseEntity<?> getActiveCategory(){
		
		List<categoryResponse> activeCategory = categoryservice.getActiveCategories();
		if(CollectionUtils.isEmpty(activeCategory)) {
		return ResponseEntity.noContent().build();
		}else {
			return new ResponseEntity<>(activeCategory, HttpStatus.OK);
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getAllCategoryById(@PathVariable Integer id){
		
		categoryDto categorydto = categoryservice.getCategoryById(id);
		if(ObjectUtils.isEmpty(categorydto)) {
			return new ResponseEntity<>("category not found with id = "+id,HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(categorydto,HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteCategoryById(@PathVariable Integer id){
		
		Boolean deleted = categoryservice.deleteCategory(id);
		if(deleted) {
			return new ResponseEntity<>("category deleted successfully",HttpStatus.OK);
		}
		return new ResponseEntity<>("category not deleted",HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
