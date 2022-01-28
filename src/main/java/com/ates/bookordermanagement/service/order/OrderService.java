package com.ates.bookordermanagement.service.order;

import java.util.List;

import com.ates.bookordermanagement.service.model.OrderModel;
import com.ates.bookordermanagement.utils.SufficientException;

public interface OrderService {

	public List<OrderModel> getAllOrders();
	
	public List<OrderModel> getCustomerOrders(Long customerId);
	
	public Long createOrder(OrderModel orderModel) throws SufficientException;
}
