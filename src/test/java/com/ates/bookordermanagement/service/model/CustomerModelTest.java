package com.ates.bookordermanagement.service.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CustomerModelTest {

	
	private CustomerModel customerModel;
	
	@BeforeEach
	public void init() {
		customerModel = new CustomerModel();
	}
	
	@Test
	public void whenCalledGetCustomerName_thenCorrect() {
		customerModel.setCustomerName("Ibrahim Ates");
		assertEquals("Ibrahim Ates", customerModel.getCustomerName());
	}
	
	@Test
	public void whenCalledGetBalance_thenCorrect() {
		customerModel.setBalance(2500L);
		assertEquals(2500L, customerModel.getBalance());
	}
	
	@Test
	public void whenCalledGetId_thenCorrect() {
		customerModel.setId(3L);
		assertEquals(3L, customerModel.getId());
	}
}
