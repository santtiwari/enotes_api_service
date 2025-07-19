package com.becoder.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.becoder.entity.Category;
import com.becoder.repository.categoryRepository;
import com.becoder.service.categoryService;

@Service
public class categoryServiceImpl implements categoryService {

	@Autowired 
	private categoryRepository catRepository;
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

}
