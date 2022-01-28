package com.ates.bookordermanagement.controller.customer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.ates.bookordermanagement.service.customer.CustomerServiceImpl;
import com.ates.bookordermanagement.service.model.CustomerModel;
import com.ates.bookordermanagement.service.model.OrderModel;


@SpringBootTest
public class CustomerControllerTest {

	CustomerController customerController;
	
	@Mock
	CustomerServiceImpl customerServiceImpl;
	
	private CustomerModel customerModel;
	
	@BeforeEach
	public void init() {
		
		customerController = new CustomerController(customerServiceImpl);
		
		customerModel = new CustomerModel();
		customerModel.setBalance(50L);
		customerModel.setCustomerName("ibrahim");
		customerModel.setId(3L);	
	}
	
	@Test
	public void whenCalledGetAllCustomers_thenReturnList() {
		
		List<CustomerModel> list = new ArrayList<>();
		list.add(customerModel);
		
		when(customerServiceImpl.getAllCustomers()).thenReturn(list);

		
		assertTrue(customerController.getAllCustomers().size()>0);
	}
	
	@Test
	public void whenCalledGetCustomerById_thenReturnTrue() {
		
		when(customerServiceImpl.getCustomerInfo(any())).thenReturn(customerModel);
		
		assertEquals(3L, customerController.getCustomerInfo(1L).getId());
	}
	
	@Test
	public void whenCalledCreateCustomer_thenReturnTrue() {
		
		when(customerServiceImpl.addCustomer(any())).thenReturn(customerModel);
		
		assertEquals(customerModel, customerController.addCustomer(customerModel));
	}
	
	@Test
	public void whenCalledDeleteCustomer_thenReturnTrue() {
		
		when(customerServiceImpl.deleteCustomer(any())).thenReturn(true);
		
		assertEquals(true, customerController.deleteCustomer(customerModel.getId()));
	}
	
	@Test
	public void whenCalledGetCustomersOrders_thenReturnList() {
		
		List<CustomerModel> list = new ArrayList<>();
		list.add(customerModel);
	
		OrderModel orderModel = new OrderModel();
		orderModel.setBookId(1L);
		orderModel.setBookCount(100);
		Set<OrderModel> orderSet = new HashSet<>();
		orderSet.add(orderModel);
		
		when(customerServiceImpl.getCustomerOrders(any())).thenReturn(orderSet);

		
		assertTrue(customerController.getCustomerOrders(1L).size()>0);
	}
	
	
}
