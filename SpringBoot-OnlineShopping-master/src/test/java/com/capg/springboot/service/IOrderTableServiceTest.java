package com.capg.springboot.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.capg.springboot.dto.Orderdto;
import com.capg.springboot.entity.Address;
import com.capg.springboot.entity.OrderTable;
import com.capg.springboot.repository.IAddressRepository;
import com.capg.springboot.repository.IOrderRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class IOrderTableServiceTest {

	@InjectMocks
	private IOrderServiceImpl order_ser;

	@Mock
	private IOrderRepository order_repo;


	@Test
	public void deleteOrderTablest() {
		OrderTable delete = new OrderTable();

		delete.setOrderId("1");
		delete.setOrderDate(null);
		delete.setOrderStatus("ordered");

		order_ser.removeOrder(delete);
		verify(order_repo, times(1)).delete(delete);

	}
}
