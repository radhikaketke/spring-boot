package com.shop.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.repository.ShopRepository;
import com.shop.shopDto.ShopDto;
import com.shop.shopEntity.Brand;
import com.shop.shopEntity.Shop;

@Service
public class ShopServiceImpl implements ShopService {

	@Autowired
	private ShopRepository shopRepository;
	
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	 public Shop saveShop(ShopDto shopDto) {
	        Shop shop = modelMapper.map(shopDto, Shop.class);
	        List<Brand> brands = new ArrayList<>();
	        
	        if (shopDto.getBrands() != null) {
	            for (Brand brandDto : shopDto.getBrands()) {
	                Brand brand = modelMapper.map(brandDto, Brand.class);
	                brand.setShop(shop);
	                brands.add(brand);
	            }
	        }

	        shop.setBrands(brands);
	        return shopRepository.save(shop);
	    }
	
	@Override
	public List<Shop> getShops(){
		 return shopRepository.findAll();
	}
	
	@Override
	public List<Shop> getShopByNameJpql(String name) {
    return shopRepository.findByNameJpql(name);
	}
	
	@Override
	 public List<Shop> getShopByName(String name) {
        return shopRepository.findByName(name);
    }
	
//	public List<Shop> getShopByNameNative(String name) {
//        return shopRepository.findByNameNative(name);
//    }
	
	@Override
	public String deleteShop(int id) {
		 shopRepository.deleteById(id);
		 return "data deleted successfully";
	}
	
	@Override
	public Shop getShopById(int id) {
		return shopRepository.findById(id).orElse(null);
	}
	
}
