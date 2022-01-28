package com.ates.bookordermanagement.service.customer;

import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ates.bookordermanagement.dao.customer.CustomerRepositoryImpl;
import com.ates.bookordermanagement.dao.model.CustomerEntity;
import com.ates.bookordermanagement.dao.model.OrderEntity;
import com.ates.bookordermanagement.dao.order.OrderRepository;
import com.ates.bookordermanagement.service.mapper.CustomerMapper;
import com.ates.bookordermanagement.service.mapper.OrderMapper;
import com.ates.bookordermanagement.service.model.CustomerModel;
import com.ates.bookordermanagement.service.model.OrderModel;
import com.ates.bookordermanagement.utils.SufficientException;
import com.ates.bookordermanagement.utils.DeleteException;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService{
	
	Logger logger = LoggerFactory.getLogger(CustomerServiceImpl.class);
	
	@Autowired
	CustomerRepositoryImpl customerRepository;
	
	@Autowired
	CustomerMapper customerMapper;
	
	@Autowired
	OrderRepository orderRepository;
	
	@Autowired
	OrderMapper orderMapper;

	@Override
	public List<CustomerModel> getAllCustomers() {
		
		logger.debug("service get all customers method was called");
		
		return customerMapper.listCustomerModels(customerRepository.getAllCustomers());
	}

	@Override
	public CustomerModel addCustomer(CustomerModel customerModel) {
		
		CustomerEntity customerEntity = customerMapper.mapCustomerModelToEntity(customerModel);
		
		customerEntity = customerRepository.addCustomer(customerEntity);

		return customerMapper.mapCustomerEntityToCustomerModel(customerEntity);
	}

	@Override
	public CustomerModel getCustomerInfo(Long id) {
		
		return customerMapper.mapCustomerEntityToCustomerModel(customerRepository.getCustomerInfo(id));
	}

	@Override
	public Boolean deleteCustomer(Long id){

		Boolean result = true;
		try {
			customerRepository.deleteCustomer(id);

		} catch (DeleteException e) {
			logger.error("service delete customer method error occured. Error :"+e.getMessage());

			result = false;
		}
		return result;
	}
	
	public void checkCustomerBalance(Long id, Long amount) throws SufficientException {
		CustomerEntity customerEntity = customerRepository.getCustomerInfo(id);
		if(customerEntity.getBalance()>=amount) {
			customerEntity.setBalance(customerEntity.getBalance()-amount);
			customerRepository.addCustomer(customerEntity);
		}
		else {
			throw new SufficientException("Your balance is not sufficient");
		}
		
	}

	@Override
	public Set<OrderModel> getCustomerOrders(Long id) {
		return getCustomerInfo(id).getOrders();
	}

	@Override
	public Boolean addOrderToCustomer(Long orderId, Long customerId) {
		
		Boolean resultBoolean = true;

		OrderEntity orderEntity = orderRepository.findById(orderId).orElseThrow();
		
		CustomerModel customerModel =  getCustomerInfo(customerId);
		
		customerModel.getOrders().add(orderMapper.mapToOrderModel(orderEntity));
		
	    try{
	         addCustomer(customerModel);
	         
	        }catch (Exception exception){
	        	resultBoolean = false;
	        	System.out.println(exception.getMessage());
	            //logger.info("Error occured while delete customer from branch. error message:", exception.getMessage());
	          //throw new ResourceNotImplementedException("Error occured while delete customer from branch:" + exception.getMessage());
	        }
		
		
		return resultBoolean;
	}

}
