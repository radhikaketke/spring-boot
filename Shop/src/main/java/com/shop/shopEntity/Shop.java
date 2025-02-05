package com.shop.shopEntity;

import java.util.List;

import org.hibernate.tool.schema.extract.internal.SequenceNameExtractorImpl;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "Shop")
public class Shop {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE , generator = "shop_generator")
	@SequenceGenerator(
			name = "shop_generator",
			sequenceName = "shop_sequence_generator",
			allocationSize = 3
			)
	@Column(name = "id")
	private int id;

	@Column(name = "name")
	private String name;

	@Column(name = "address")
	private String address;

	@Column(name = "phoneNo")
	private int phoneNo;

	
	
	@OneToMany(mappedBy = "shop", cascade = CascadeType.ALL)
	@JsonManagedReference
	private List<Brand> brands;
}
