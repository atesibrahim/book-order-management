package com.ates.bookordermanagement.controller.customer;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ates.bookordermanagement.service.customer.CustomerServiceImpl;
import com.ates.bookordermanagement.service.model.CustomerModel;
import com.ates.bookordermanagement.service.model.OrderModel;

import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;

@RestController
@RequestMapping(value = "/customers")
@Tag(name = "customers", description = "the customers API")
public class CustomerController {

	@Autowired
	CustomerServiceImpl customerService;
	
	
	@Autowired
    public CustomerController(CustomerServiceImpl customerService) {
		super();
		this.customerService = customerService;
	}

	@Operation(summary = "Get All Customers", description = "Get All Customers", tags = { "customers" })
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "successful operation", 
                content = @Content(array = @ArraySchema(schema = @Schema(implementation = CustomerModel.class)))) })	
    @GetMapping(produces = "application/json")
	public List<CustomerModel> getAllCustomers() {
		
		return customerService.getAllCustomers();
	}
	
    @Operation(summary = "Get Customer By id", description = "Get Customer Info By id", tags = { "customers" })
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "successful operation", 
                content = @Content(schema = @Schema(implementation = CustomerModel.class))) })	
	@GetMapping(value= "/{id}", produces = "application/json")
	public CustomerModel getCustomerInfo(@PathVariable Long id) {
		return customerService.getCustomerInfo(id);
	}
	
    @Operation(summary = "Get Customers order", description = "Get Customers order", tags = { "customers" })
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "successful operation", 
                content = @Content(array = @ArraySchema(schema = @Schema(implementation = OrderModel.class)))) })	
    
    @GetMapping(value = "/{id}/orders", produces = "application/json")
	public Set<OrderModel> getCustomerOrders(Long id){
		return customerService.getCustomerOrders(id);
	}
	
	@Operation(summary = "Create Customer ", description = "Create new Customer", tags = { "customers" })
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "successful operation", 
                content = @Content(schema = @Schema(implementation = CustomerModel.class))) })	
	
	@PostMapping(produces = "application/json")
	public CustomerModel addCustomer(@RequestBody CustomerModel customerModel) {
		
		return customerService.addCustomer(customerModel);
	}
	
	@Operation(summary = "Delete Customer By id", description = "Delete Customer By id", tags = { "customers" })
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "successful operation", 
                content = @Content(schema = @Schema(defaultValue = "True"))) })	
	
	@DeleteMapping("/{id}")
	public Boolean deleteCustomer(@PathVariable Long id) {
		
		return customerService.deleteCustomer(id);
	}
	
	
	

}
