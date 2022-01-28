package com.ates.bookordermanagement.service.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ates.bookordermanagement.dao.model.CustomerEntity;
import com.ates.bookordermanagement.service.model.CustomerModel;

@Component
public class CustomerMapper {
	
	@Autowired
	OrderMapper orderMapper;
	
	public CustomerModel mapCustomerEntityToCustomerModel(CustomerEntity customerEntity) {
		
		CustomerModel customerModel = new CustomerModel();
		
		customerModel.setBalance(customerEntity.getBalance());
		
		customerModel.setCustomerName(customerEntity.getCustomerName());
		
		customerModel.setId(customerEntity.getId());
		
		customerEntity.getOrders().forEach(element -> {
			customerModel.getOrders().add(orderMapper.mapToOrderModel(element));
		});
		
		return customerModel;
	}
	
	public List<CustomerModel> listCustomerModels(List<CustomerEntity> customerEntities){
		
		List<CustomerModel> customerList = new ArrayList<>();
		
		customerEntities.forEach(element -> {
			customerList.add(mapCustomerEntityToCustomerModel(element));
		});
		
		return customerList;
	}

	public CustomerEntity mapCustomerModelToEntity(CustomerModel customerModel) {
		
		CustomerEntity customerEntity = new CustomerEntity();
		
		customerEntity.setBalance(customerModel.getBalance());
		
		customerEntity.setCustomerName(customerModel.getCustomerName());
				
		customerModel.getOrders().forEach(element -> {
			customerEntity.getOrders().add(orderMapper.mapToOrderEntity(element));
		});
		
		return customerEntity;
	}

}
