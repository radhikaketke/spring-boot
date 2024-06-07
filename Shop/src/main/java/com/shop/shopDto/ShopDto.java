package com.shop.shopDto;

import java.util.List;

import com.shop.shopEntity.Brand;

import lombok.Data;

@Data
public class ShopDto {

	private int id;
	private String name;
	private String address;
	private int phoneNo;
	private List<Brand> brands ;
}
