package com.ates.bookordermanagement.service.customer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ates.bookordermanagement.service.model.CustomerModel;
import com.ates.bookordermanagement.dao.model.CustomerEntity;


@SpringBootTest
public class CustomerServiceTest {

	
	@Autowired
	private CustomerServiceImpl customerServiceImpl;
	
	private List<CustomerEntity> customerEntities = new ArrayList<>();
	
	private CustomerEntity customerEntity;
	
	private CustomerModel customerModel;
	
	@BeforeEach
	public void init() {
		customerEntity = new CustomerEntity();
		customerEntity.setBalance(100L);
		customerEntity.setCustomerName("ibrahim");
		customerEntities.add(customerEntity);
		
		customerModel = new CustomerModel();
		
		customerModel.setCustomerName(customerEntity.getCustomerName());
		customerModel.setId(customerEntity.getId());
		customerModel.setBalance(customerEntity.getBalance());	
		
	}
	
	@Test
	public void whenCalledGetAllCustomer_thenReturnList() {
		
		
		assertTrue(customerServiceImpl.getAllCustomers().size()>0);
		
		assertEquals("ibrahim",customerServiceImpl.getAllCustomers().get(0).getCustomerName());
	}
	
	@Test
	public void whenCalledGetCustomerById_thenReturn() {
		
		
		assertEquals("ibrahim",customerServiceImpl.getCustomerInfo(1L).getCustomerName());
	}
	
	@Test
	public void whenCalledCreateCustomer_thenReturnTrue() {
		
		assertEquals(true,customerServiceImpl.deleteCustomer(1L));

		
		assertEquals(customerEntity.getCustomerName(),customerServiceImpl.addCustomer(customerModel).getCustomerName());
	}
	
	@Test
	public void whenCalledDeleteCustomerById_thenReturnTrue(){
	
		assertEquals(true,customerServiceImpl.deleteCustomer(1L));
				
		
	}
}
