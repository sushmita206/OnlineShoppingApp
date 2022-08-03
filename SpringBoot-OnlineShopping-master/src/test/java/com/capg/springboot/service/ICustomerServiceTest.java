package com.capg.springboot.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.capg.springboot.Exceptions.CustomerNotFoundException;
import com.capg.springboot.entity.Customer;
import com.capg.springboot.repository.ICustomerRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ICustomerServiceTest {

	@InjectMocks
	private ICustomerService icustomerservice;
	
	@Mock
	private ICustomerRepository icustomerrepository;
	
	@Test
	public void addCustomerTest() throws CustomerNotFoundException{
		System.out.println("hello");
		
		  Customer cust = new Customer();
		  
		  cust.setCustomerId("321"); 
		  cust.setEmail("test@gmail");			
		  cust.setFirstName("Sumit");
		  
		  Mockito.doReturn(cust).when(icustomerrepository).findByCustomerId(Mockito.any());
		  
		  assertEquals(cust.getCustomerId(),icustomerservice.findByCustomerId(cust).getCustomerId());
		  
		 
	}
	
	
}
