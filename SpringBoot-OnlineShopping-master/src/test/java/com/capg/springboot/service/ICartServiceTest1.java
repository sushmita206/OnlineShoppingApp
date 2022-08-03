package com.capg.springboot.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.capg.springboot.Exceptions.AddressNotFoundException;
import com.capg.springboot.entity.Address;
import com.capg.springboot.entity.Cart;
import com.capg.springboot.repository.IAddressRepository;
import com.capg.springboot.repository.ICartRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ICartServiceTest1 {

	@InjectMocks
	private ICartServiceImpl cart_ser;
	
	@Mock
	private ICartRepository cart_repo;
	
	@Test
    public void addCartTest() {
		Cart cart=new Cart();
		cart.setCartId("1235");
		Mockito.when(cart_repo.save(cart)).thenReturn(cart);
	}
	
}
