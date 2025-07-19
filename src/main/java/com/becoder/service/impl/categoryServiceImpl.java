package com.becoder.service.impl;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.becoder.dto.categoryDto;
import com.becoder.dto.categoryResponse;
import com.becoder.entity.Category;
import com.becoder.repository.categoryRepository;
import com.becoder.service.categoryService;

@Service
public class categoryServiceImpl implements categoryService {

	@Autowired 
	private categoryRepository catRepository;
	
	@Autowired
	private ModelMapper mapper;
	
	@Override
	public Boolean saveCategory(Category category) {
		category.setIsDeleted(false);
		category.setCreatedBy(1);
		category.setCreatedOn(new Date());
		Category saveCategory = catRepository.save(category);
		if(ObjectUtils.isEmpty(saveCategory)) {
			return false;
		}
		return true;
	}

	@Override
	public List<Category> getAllCategory() {
		List<Category> categories = catRepository.findAll();
		return categories;
	}

	@Override
	public Boolean saveCategoryDto(categoryDto categorydto) {
		
//		Category category = new Category();
//		category.setName(categorydto.getName());
//		category.setDescription(categorydto.getDescription());
//		category.setIsActive(categorydto.getIsActive());
		Category category = mapper.map(categorydto, Category.class);
	
		category.setIsDeleted(false);
		category.setCreatedBy(1);
		category.setCreatedOn(new Date());
		Category saveCategory = catRepository.save(category);
		if(ObjectUtils.isEmpty(saveCategory)) {
			return false;
		}
		return true;
	}

	@Override
	public List<categoryDto> getAllCategories() {
		List<Category> categories = catRepository.findAll();
		//for java 16 and upper version
		//categories.stream().map(cat->mapper.map(cat,categoryDto.class)).toList();
         
		//java 8 version support
		List<categoryDto> categoryDtoList = categories.stream()
		    .map(cat -> mapper.map(cat, categoryDto.class))
		    .collect(Collectors.toList());

		return categoryDtoList;
	}

	@Override
	public List<categoryResponse> getActiveCategories() {
		
		List<Category> categories = catRepository.findByIsActiveTrue();
		List<categoryResponse> categoryList = categories.stream()
	    .map(cat -> mapper.map(cat, categoryResponse.class))
	    .collect(Collectors.toList());
		return categoryList;
	}
	
	
	
	

}
