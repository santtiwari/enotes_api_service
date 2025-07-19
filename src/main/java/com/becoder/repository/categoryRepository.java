package com.becoder.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.becoder.dto.categoryDto;
import com.becoder.entity.Category;

public interface categoryRepository extends JpaRepository<Category, Integer> {

	List<Category> findByIsActiveTrue();


}
