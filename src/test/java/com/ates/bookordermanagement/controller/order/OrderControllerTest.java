package com.ates.bookordermanagement.controller.order;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.ates.bookordermanagement.service.order.OrderService;
import com.ates.bookordermanagement.utils.SufficientException;
import com.ates.bookordermanagement.service.model.OrderModel;


@SpringBootTest
public class OrderControllerTest {

	OrderController orderController;
	
	@Mock
	OrderService orderService;
	
	private OrderModel orderModel;
	
	@BeforeEach
	public void init() {
		
		orderController = new OrderController(orderService);
		
		orderModel = new OrderModel();
		orderModel.setOrderAmount(50L);
		orderModel.setBookId(3L);	
		orderModel.setBookCount(10);
		orderModel.setCustomerId(4L);	
	}
	
	@Test
	public void whenCalledGetAllOrders_thenReturnList() {
		
		List<OrderModel> list = new ArrayList<>();
		list.add(orderModel);
		
		when(orderService.getAllOrders()).thenReturn(list);

		
		assertTrue(orderController.getAllOrders().size()>0);
	}
	
	@Test
	public void whenCalledGetOrderById_thenReturnTrue() {
		
		List<OrderModel> list = new ArrayList<>();
		list.add(orderModel);
		
		when(orderService.getCustomerOrders(any())).thenReturn(list);
		
		assertEquals(4L, orderController.getAllCustomerOrders(1L).get(0).getCustomerId());
	}
	
	@Test
	public void whenCalledCreateOrder_thenReturnTrue() throws SufficientException {
		
		when(orderService.createOrder(any())).thenReturn(2L);
		
		assertEquals(2L, orderController.createOrder(orderModel));
	}
	
}
