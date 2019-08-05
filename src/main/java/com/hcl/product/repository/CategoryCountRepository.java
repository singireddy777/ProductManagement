package com.hcl.product.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hcl.product.entity.CategoryCount;

@Repository
public interface CategoryCountRepository extends JpaRepository<CategoryCount, Integer>{

	@Query("select sum(categoryCount) FROM CategoryCount cc WHERE cc.categoryId= :categoryId")
	List<?> getCategoryCountByCategoryId(@Param("categoryId") int categoryId);

	//public Category getCategoryCountByCategoryId(categoryId);
	
	
	@Query(value="select * FROM category_count cc WHERE cc.category_Id= :categoryId and cc.user_Id=:userId",nativeQuery=true)
	public CategoryCount getCategoryCountByCategoryIdAndUserId(@Param("categoryId") int categoryId,@Param("userId") int userId);
}
