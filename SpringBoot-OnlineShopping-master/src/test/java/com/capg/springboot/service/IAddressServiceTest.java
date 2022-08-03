package com.capg.springboot.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.capg.springboot.Exceptions.AddressNotFoundException;
import com.capg.springboot.entity.Address;
import com.capg.springboot.repository.IAddressRepository;


/*/*****************************************************************************
 * class for AddressTest
 * 
 * Created By: Siddharth Shitole
 * Date:08/01/2022 
 *******************************************************************************/

@RunWith(SpringRunner.class)
@SpringBootTest
public class IAddressServiceTest {

	@Autowired
	private IAddressService iaddressservice;

	@MockBean
	private IAddressRepository iaddressrepository;
	
	
	@Test
	public void deleteAddressTest() 
	{
		Address delete = new Address();

		delete.setBuildingName("Siddharth_buil");
		delete.setAddressId("123");
		delete.setCity("Mumbai");
		delete.setCountry("India");
		delete.setState("Maharashtra");
		delete.setPincode("555555");
		
		iaddressservice.removeAddress(delete);		
		verify(iaddressrepository,times(1)).delete(delete);
		
	}

//*********************************************************************************************************************	
	
	@Test
	public void getaddressTest() throws AddressNotFoundException {
		Address add = new Address();

		add.setBuildingName("Siddharth_buil");
		add.setAddressId("123");
		add.setCity("Mumbai");
		add.setCountry("India");
		add.setState("Maharashtra");
		add.setPincode("555555");

		Address add1 = new Address();

		add.setBuildingName("Siddharth_buil");
		add.setAddressId("123");
		add.setCity("Mumbai");
		add.setCountry("India");
		add.setState("Maharashtra");
		add.setPincode("555555");

		when(iaddressrepository.findAll()).thenReturn(Stream.of(add, add1).collect(Collectors.toList()));
		assertEquals(2, iaddressservice.viewAllAddress().size());
	}

//*********************************************************************************************************************	
	
	@Test
	public void saveAddressTest() {
		Address save = new Address();

		save.setBuildingName("Siddharth_buil");
		save.setAddressId("123");
		save.setCity("Mumbai");
		save.setCountry("India");
		save.setState("Maharashtra");
		save.setPincode("555555");

		when(iaddressrepository.save(save)).thenReturn(save);
		assertEquals(save, iaddressservice.addAddress(save));
	}


}
