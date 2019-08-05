package com.hcl.product.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.product.entity.Category;
import com.hcl.product.entity.CategoryCount;
import com.hcl.product.repository.CategoryCountRepository;
import com.hcl.product.repository.CategoryRepository;

@Service

public class CategoryServiceImpl implements CategoryService {
	@Autowired
	CategoryRepository categoryRepo;
	@Autowired
	CategoryCountRepository categoryCountRepo;

	@Override
	public List<Category> getCagetories() {
		return categoryRepo.findAll();
	}

	public Category getCategoryByCateId(int categoryId) {

		/*
		 * Category category = categoryRepo.findById(categoryId).get();
		 * 
		 * CategoryCount categoryCount = new CategoryCount();
		 * categoryCount.setCategoryCount(1);
		 * categoryCount.setCategoryInterested("interested");
		 * categoryCount.setUserId(1);
		 * 
		 * categoryCountRepo.save(categoryCount);
		 * 
		 * return category;
		 */
		int users = 2;

		Category categories = categoryRepo.findById(categoryId).get();

		CategoryCount categoryCount = categoryCountRepo
				.getCategoryCountByCategoryIdAndUserId(categories.getCategoryId(), users);

		if (categoryCount != null) {
        int count = 1;
			if (categoryCount.getCategoryId() == categoryId) {
				categoryCount.setCategoryCount(categoryCount.getCategoryCount() + 1);
			
				categoryCountRepo.save(categoryCount);
			}

		} else {

			CategoryCount categoryCount2 = new CategoryCount();
			categoryCount2.setCategoryCount(1);
			categoryCount2.setCategoryInterested("interested");
			categoryCount2.setUserId(2);
			categoryCount2.setCategoryId(categories.getCategoryId());

			categoryCountRepo.save(categoryCount2);
		}

		return categories;
	}

	@Override
	public List<?> getAnalyticsByCategory(int categoryId) {
		return categoryCountRepo.getCategoryCountByCategoryId(categoryId);
	}

}
