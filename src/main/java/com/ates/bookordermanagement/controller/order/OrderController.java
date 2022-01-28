package com.ates.bookordermanagement.controller.order;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ates.bookordermanagement.service.model.OrderModel;
import com.ates.bookordermanagement.service.order.OrderService;
import com.ates.bookordermanagement.utils.SufficientException;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/orders")
@Tag(name = "orders", description = "the orders API")
public class OrderController {
	
	@Autowired
	OrderService orderService;
	
	@Autowired
	public OrderController(OrderService orderService) {
		super();
		this.orderService = orderService;
	}
	
    @Operation(summary = "Get All Orders", description = "Get All Orders", tags = { "orders" })
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "successful operation", 
                content = @Content(array = @ArraySchema(schema = @Schema(implementation = OrderModel.class)))) })	
    @GetMapping(produces = "application/json")
	public List<OrderModel> getAllOrders(){
		return orderService.getAllOrders();
	}
	
    @Operation(summary = "Get Customers Orders", description = "Get Customers Orders", tags = { "orders" })
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "successful operation", 
                content = @Content(array = @ArraySchema(schema = @Schema(implementation = OrderModel.class)))) })	
    @GetMapping(value="/{customerId}", produces = "application/json")
	public List<OrderModel> getAllCustomerOrders(@PathVariable Long customerId){
		return orderService.getCustomerOrders(customerId);
	}


    @Operation(summary = "Create new order", description = "create new order", tags = { "orders" })
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "successful operation", 
                content = @Content(schema = @Schema(defaultValue = "1"))) })
	@PostMapping
	public Long createOrder(@RequestBody OrderModel order) throws SufficientException {
		System.out.println("Order created for that customer :"+order.getCustomerId()+"  and for this book "+order.getBookId());
		return orderService.createOrder(order);
	}
}
