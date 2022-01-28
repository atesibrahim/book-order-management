package com.ates.bookordermanagement.service.order;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.ates.bookordermanagement.service.book.BookService;
import com.ates.bookordermanagement.service.customer.CustomerService;
import com.ates.bookordermanagement.service.mapper.OrderMapper;
import com.ates.bookordermanagement.service.model.OrderModel;
import com.ates.bookordermanagement.utils.SufficientException;
import com.ates.bookordermanagement.dao.model.BookEntity;
import com.ates.bookordermanagement.dao.model.OrderEntity;
import com.ates.bookordermanagement.dao.order.OrderRepository;


@SpringBootTest
public class OrderServiceTest {


	@Mock
	private OrderRepository orderRepository;
	
	@Mock
	private CustomerService customerServiceImpl;
	
	@Mock
	private BookService bookServiceImpl;
	
	private OrderMapper orderMapper = new OrderMapper();
	
	private OrderServiceImpl orderServiceImpl;
	
	private List<OrderEntity> orderEntities = new ArrayList<>();
	
	private OrderEntity orderEntity;
	
	private OrderModel orderModel;
	
	@BeforeEach
	public void init() {
		
		orderServiceImpl = new OrderServiceImpl(customerServiceImpl, bookServiceImpl, orderRepository, orderMapper);
		
		orderEntity = new OrderEntity();
		orderEntity.setOrderAmount(100L);
		orderEntity.setBookCount(5);
		orderEntity.setCustomerId(3L);
		orderEntity.setBookId(1L);
		orderEntities.add(orderEntity);
		
		orderModel = new OrderModel();
		

		orderModel.setOrderAmount(100L);
		orderModel.setBookCount(5);
		orderModel.setCustomerId(3L);
		orderModel.setBookId(1L);
		
	}
	
	@Test
	public void whenCalledGetAllOrder_thenReturnList() {
		
		when(orderRepository.findAll()).thenReturn(orderEntities);
		
		assertTrue(orderServiceImpl.getAllOrders().size()>0);
		
	}
	
	@Test
	public void whenCalledGetCustomerOrders_thenReturnList() {
		
		when(orderRepository.findByCustomeridEquals(anyLong())).thenReturn(orderEntities);
		
		assertTrue(orderServiceImpl.getCustomerOrders(1L).size()>0);
		
	}
	
	@Test
	public void whenCalledCheckBalanceAndCount_thenReturnTrue() throws SufficientException {
		
		BookEntity bookEntity = new BookEntity();
		bookEntity.setId(1L);
		bookEntity.setCount(20);
		bookEntity.setPrice(10L);
		
		when(bookServiceImpl.checkBookCount(anyLong(), anyInt())).thenReturn(bookEntity);
		
		doNothing().when(customerServiceImpl).checkCustomerBalance(any(), any());
		
		when(orderRepository.save(any())).thenReturn(orderEntity);
		
		when(customerServiceImpl.addOrderToCustomer(anyLong(), any())).thenReturn(true);
		
		assertEquals(null, orderServiceImpl.createOrder(orderModel));
		
	}
	
}
