package com.hcl.product.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.hcl.product.entity.ProductCount;

public interface ProductCountRepository extends JpaRepository<ProductCount, Integer>{

	@Query("select sum(productCount) from ProductCount p where p.prodId=:productId")
	  List<?> getProductCountByProdId(@Param ("productId")int productId);
	
	@Query(value = "select * FROM product_count cc  WHERE cc.prod_Id=:productId and cc.user_Id= :userId", nativeQuery = true )
	public ProductCount getProductCountByProdIdandUserId(@Param ("productId")int productId, @Param ("userId") int userId);
	
	

}
