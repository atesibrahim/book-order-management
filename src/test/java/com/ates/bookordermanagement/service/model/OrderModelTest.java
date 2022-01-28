package com.ates.bookordermanagement.service.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class OrderModelTest {

	
	private OrderModel orderModel;
	
	@BeforeEach
	public void init() {
		orderModel = new OrderModel();
	}
	
	@Test
	public void whenCalledGetCustomerId_thenCorrect() {
		orderModel.setCustomerId(2L);
		assertEquals(2L, orderModel.getCustomerId());
	}
	
	@Test
	public void whenCalledGetBookId_thenCorrect() {
		orderModel.setBookId(5L);
		assertEquals(5L, orderModel.getBookId());
	}
	
	@Test
	public void whenCalledGetBookCount_thenCorrect() {
		orderModel.setBookCount(150);
		assertEquals(150, orderModel.getBookCount());
	}
	
	@Test
	public void whenCalledGetOrderAmount_thenCorrect() {
		orderModel.setOrderAmount(150L);
		assertEquals(150L, orderModel.getOrderAmount());
	}
}
