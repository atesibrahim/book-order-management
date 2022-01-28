package com.ates.bookordermanagement.dao.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "book")
public class BookEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3897811280783253242L;

	@Id
	private Long id;
	
	@Column(name = "name")
	private String bookName;
	
	@Column
	private Long price;
	
	@Column
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
