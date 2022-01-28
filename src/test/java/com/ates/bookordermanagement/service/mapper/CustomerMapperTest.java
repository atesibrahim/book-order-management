package com.ates.bookordermanagement.service.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ates.bookordermanagement.dao.model.CustomerEntity;
import com.ates.bookordermanagement.service.model.CustomerModel;


@SpringBootTest
public class CustomerMapperTest {
	
	
	@Autowired
	CustomerMapper customerMapper;
	
	private CustomerEntity customerEntity;
	
	private CustomerModel customerModel;
	
	@BeforeEach
	public void init() {
		customerEntity = new CustomerEntity();
		customerEntity.setCustomerName("Customer Name");
		
		customerModel = new CustomerModel();
		customerModel.setCustomerName("Customer Model Name");
	}
	
	@Test
	public void whenCalledCustomerModelToEntity_thenReturnCorrect() {
		
		assertEquals(customerEntity.getCustomerName(), customerMapper.mapCustomerEntityToCustomerModel(customerEntity).getCustomerName());
	}
	
	@Test
	public void whenCalledCustomerEntityToModel_thenReturnCorrect() {
		
		assertEquals(customerModel.getCustomerName(), customerMapper.mapCustomerModelToEntity(customerModel).getCustomerName());
	}
	
	@Test
	public void whenCalledCustomerListModel_thenReturnCorrect() {
		
		List<CustomerEntity> list = new ArrayList<>();
		list.add(customerEntity);
		
		
		assertEquals(customerEntity.getCustomerName(), customerMapper.listCustomerModels(list).get(0).getCustomerName());
	}

}
