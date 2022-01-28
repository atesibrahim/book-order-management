package com.ates.bookordermanagement.service.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ates.bookordermanagement.dao.model.OrderEntity;
import com.ates.bookordermanagement.service.model.OrderModel;


@SpringBootTest
public class OrderMapperTest {
	
	
	@Autowired
	OrderMapper orderMapper;
	
	private OrderEntity orderEntity;
	
	private OrderModel orderModel;
	
	@BeforeEach
	public void init() {
		orderEntity = new OrderEntity();
		orderEntity.setBookCount(10);
		orderEntity.setBookId(1L);
		orderEntity.setCustomerId(2L);
		orderEntity.setOrderAmount(150L);
		
		orderModel = new OrderModel();
		orderModel.setBookId(2L);
		orderModel.setBookCount(120);
		orderModel.setCustomerId(3L);
		orderModel.setOrderAmount(160L);
	}
	
	@Test
	public void whenCalledOrderModelToEntity_thenReturnCorrect() {
		
		assertEquals(orderEntity.getBookId(), orderMapper.mapToOrderModel(orderEntity).getBookId());
	}
	
	@Test
	public void whenCalledOrderEntityToModel_thenReturnCorrect() {
		
		assertEquals(orderModel.getBookId(), orderMapper.mapToOrderEntity(orderModel).getBookId());
	}
	
	@Test
	public void whenCalledOrderListModel_thenReturnCorrect() {
		
		List<OrderEntity> list = new ArrayList<>();
		list.add(orderEntity);
		
		
		assertEquals(orderEntity.getBookId(), orderMapper.mapToModelList(list).get(0).getBookId());
	}

}
