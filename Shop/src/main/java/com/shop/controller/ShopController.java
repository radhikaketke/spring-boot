package com.shop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shop.service.ShopServiceImpl;
import com.shop.shopDto.ShopDto;
import com.shop.shopEntity.Shop;

@RestController
@RequestMapping("/shops")
public class ShopController {

	@Autowired
	private ShopServiceImpl shopServiceImpl;
	
	@PostMapping("/saveShops")
	public Shop saveShop(@RequestBody ShopDto shopDto) {
		return shopServiceImpl.saveShop(shopDto);
	}
	
	@GetMapping("/shopLists")
	public List<Shop> getShops(){
		return shopServiceImpl.getShops(); 
	}
	
	@GetMapping("/shop/{id}")
	public Shop getShop(@PathVariable int id ) {
		return shopServiceImpl.getShopById(id);
	}
	
	 @GetMapping("/search/{name}")
	    public List<Shop> searchShopsByName(@PathVariable String name) {
	        return shopServiceImpl.getShopByName(name);
	    }
	
	@DeleteMapping("/{id}")
	public String deleteShop(@PathVariable int id) {
		return shopServiceImpl.deleteShop(id);
	}
	
	@GetMapping("/searchJpql/{name}")
	public List<Shop> searchShopsByNameJpql(@PathVariable String name){
		return shopServiceImpl.getShopByNameJpql(name);
	}
}
