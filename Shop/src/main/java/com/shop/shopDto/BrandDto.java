package com.shop.shopDto;

import com.shop.shopEntity.Shop;

import lombok.Data;

@Data
public class BrandDto {

	private int id;
	private String name;
	private Shop shop;
}
