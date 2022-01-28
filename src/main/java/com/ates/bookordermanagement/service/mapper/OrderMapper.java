package com.ates.bookordermanagement.service.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.ates.bookordermanagement.dao.model.OrderEntity;
import com.ates.bookordermanagement.service.model.OrderModel;

@Component
public class OrderMapper {

	public OrderEntity mapToOrderEntity(OrderModel orderModel) {
		OrderEntity orderEntity = new OrderEntity();
		orderEntity.setBookId(orderModel.getBookId());
		orderEntity.setCustomerId(orderModel.getCustomerId());
		orderEntity.setOrderAmount(orderModel.getOrderAmount());
		orderEntity.setBookCount(orderModel.getBookCount());
		return orderEntity;
	}
	
	public OrderModel mapToOrderModel(OrderEntity orderEntity) {
		OrderModel orderModel = new OrderModel();
		orderModel.setBookCount(orderEntity.getBookCount());
		orderModel.setBookId(orderEntity.getBookId());
		orderModel.setCustomerId(orderEntity.getCustomerId());
		orderModel.setOrderAmount(orderEntity.getOrderAmount());
		orderModel.setId(orderEntity.getId());
		return orderModel;
	}

	public List<OrderModel> mapToModelList(List<OrderEntity> orderEntities) {
		
		List<OrderModel> orderModels = new ArrayList<>();
		
		orderEntities.forEach(element -> {
			orderModels.add(mapToOrderModel(element));
		});
		
		return orderModels;
	}
	
}
