package com.ates.bookordermanagement.dao.customer;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import com.ates.bookordermanagement.dao.model.CustomerEntity;
import com.ates.bookordermanagement.utils.DeleteException;

@Component
public class CustomerRepositoryImpl {
	
	CustomerRepository customerRepositori;
	
	@Autowired
	public CustomerRepositoryImpl(@Lazy CustomerRepository customerRepository) {
		this.customerRepositori = customerRepository;
	}
	

	public List<CustomerEntity> getAllCustomers() {
		
		return customerRepositori.findAll();
	}


	@Transactional
	public CustomerEntity addCustomer(CustomerEntity customerEntity) {

		return customerRepositori.save(customerEntity);
	}


	public CustomerEntity getCustomerInfo(Long id) {
		
		return customerRepositori.findById(id).orElse(null);
	}


	@Transactional
	public void deleteCustomer(Long id) throws DeleteException{

		try {
			customerRepositori.deleteById(id);

		} catch (Exception e) {
			throw new DeleteException("Delete exception occurred.");
		}
	}


}
