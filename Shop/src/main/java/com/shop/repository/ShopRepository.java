package com.shop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.shop.shopEntity.Shop;

public interface ShopRepository extends JpaRepository<Shop, Integer>  {
//	 List<Shop> findByName( String name);
	// custom query method
	
	  @Query("SELECT s FROM Shop s WHERE s.name = :name")
	    List<Shop> findByNameJpql(@Param("name") String name);
//	   jpql quey method
	  
	 @Query(value = "SELECT * FROM shop WHERE name = :name", nativeQuery = true)
	    List<Shop> findByName(@Param("name") String name);
	 
//	  @Query("SELECT * FROM Shop WHERE name = :name", native = true)
//	    List<Shop> radikha(@Param("name") String name);
//	  
//	  @Query("Select * From Shop where age > :age")
//	  List<shop> findAgeGreaterThan(@Param(age) String age);
}
