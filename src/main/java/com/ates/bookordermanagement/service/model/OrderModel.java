package com.ates.bookordermanagement.service.model;

import io.swagger.v3.oas.annotations.media.Schema;

public class OrderModel {

	@Schema(description = "Book Id which is ordered.", example = "1", required = true)
	private Long bookId;
	
	@Schema(description = "Customer Id who ordered.", example = "1", required = true)
	private Long customerId;
	
	@Schema(description = "Order Amount which is total fee for order.", example = "100", required = true)
	private Long orderAmount;

	@Schema(description = "Book Count which is ordered.", example = "1", required = true)
	private int bookCount;
	
	@Schema(description = "Unique identifier of the Order.", example = "1", required = true)
	private Long id;
	
	public Long getBookId() {
		return bookId;
	}
	

	public void setBookId(Long bookId) {
		this.bookId = bookId;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public Long getOrderAmount() {
		return orderAmount;
	}

	public void setOrderAmount(Long orderAmount) {
		this.orderAmount = orderAmount;
	}


	public int getBookCount() {
		return bookCount;
	}


	public void setBookCount(int bookCount) {
		this.bookCount = bookCount;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}
	
	
	
	
	
}
