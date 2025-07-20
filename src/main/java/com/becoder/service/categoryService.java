package com.becoder.service;

import java.util.List;

import com.becoder.dto.categoryDto;
import com.becoder.dto.categoryResponse;
import com.becoder.entity.Category;

public interface categoryService {
	
	public Boolean saveCategory(Category category);
	
	public List<Category> getAllCategory();
	
	public Boolean saveCategoryDto(categoryDto categorydto);
	
	public List<categoryDto> getAllCategories();

	public List<categoryResponse> getActiveCategories();

	public categoryDto getCategoryById(Integer id);

	public Boolean deleteCategory(Integer id);

}
