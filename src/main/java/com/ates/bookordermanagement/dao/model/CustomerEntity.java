package com.ates.bookordermanagement.dao.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "customer")
public class CustomerEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3897811280783252922L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "name")
	private String customerName;

	@Column
	private Long balance;

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY,
		      cascade = {
		              CascadeType.ALL
		          })
	@JoinTable(name = "customer_orders", 
	joinColumns = {
			@JoinColumn(name = "customer_id", unique = true, referencedColumnName = "id", nullable = false) }, 
	inverseJoinColumns = {
			@JoinColumn(name = "order_id", unique = true, referencedColumnName = "id", nullable = false) })
	private Set<OrderEntity> orders = new HashSet<>();


	public CustomerEntity() {
		super();
	}

	public CustomerEntity(String customerName, Long balance, Set<OrderEntity> orders) {
		super();
		this.customerName = customerName;
		this.balance = balance;
		this.orders = orders;
	}
	
	public Long getId() {
		return id;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public Long getBalance() {
		return balance;
	}

	public void setBalance(Long balance) {
		this.balance = balance;
	}
	
	

	public Set<OrderEntity> getOrders() {
		return orders;
	}

	public void setOrders(Set<OrderEntity> orders) {
		this.orders = orders;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		CustomerEntity customer = (CustomerEntity) o;
		return id.equals(customer.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	
	

}
