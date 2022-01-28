package com.ates.bookordermanagement.service.model;

import io.swagger.v3.oas.annotations.media.Schema;

public class BookModel {

	
	@Schema(description = "Unique identifier of the Order.", example = "1", required = true)
	private Long id;
	
	@Schema(description = "Book Name.", example = "1984", required = true)
	private String bookName;
	
	@Schema(description = "Book price.", example = "10.0", required = true)
	private Long price;

	@Schema(description = "Book Count which is avaliable in warehouse.", example = "120", required = true)
	private Integer count;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}
	
	

}
