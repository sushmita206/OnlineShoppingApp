package com.capg.springboot.service;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.capg.springboot.entity.Product;
import com.capg.springboot.repository.IProductRepository;


@RunWith(SpringRunner.class)
@SpringBootTest
public class IProdServiceTest {

	@InjectMocks
	private IProductServiceImpl iproductservice;
	
	@Mock
	private IProductRepository iproductrepository;

	@Test
	public void addProductTest1() {
		Product product=new Product();
	    product.setColor("red");
	    product.setDimension("square");
	    product.setManufacturer("nokia");
	    
	    Mockito.when(iproductrepository.save(product)).thenReturn(product);
	}
	
}