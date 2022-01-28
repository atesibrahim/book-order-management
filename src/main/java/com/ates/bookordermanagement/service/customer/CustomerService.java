package com.ates.bookordermanagement.service.customer;

import java.util.List;
import java.util.Set;

import com.ates.bookordermanagement.service.model.CustomerModel;
import com.ates.bookordermanagement.service.model.OrderModel;
import com.ates.bookordermanagement.utils.SufficientException;

public interface CustomerService {
	
	List<CustomerModel> getAllCustomers();
	
	CustomerModel getCustomerInfo(Long id);
	
	CustomerModel addCustomer(CustomerModel customerModel);
	
	Boolean deleteCustomer(Long id);
	
	Set<OrderModel> getCustomerOrders(Long id);
	
	Boolean addOrderToCustomer(Long orderId, Long customerModel);
	
	void checkCustomerBalance(Long id, Long amount) throws SufficientException;

}
