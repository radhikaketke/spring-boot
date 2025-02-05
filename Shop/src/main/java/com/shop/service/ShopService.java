package com.shop.service;

import java.util.List;

import com.shop.shopDto.ShopDto;
import com.shop.shopEntity.Shop;

public interface ShopService {

	 public Shop saveShop(ShopDto shopDto);
	 public List<Shop> getShops();
	 public List<Shop> getShopByNameJpql(String name);
	 public List<Shop> getShopByName(String name);
	 public Shop getShopById(int id);
	 public String deleteShop(int id); 
}
