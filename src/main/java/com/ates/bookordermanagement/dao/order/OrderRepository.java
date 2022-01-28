package com.ates.bookordermanagement.dao.order;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ates.bookordermanagement.dao.model.OrderEntity;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, Long>{
	
	
	@Query(value="SELECT * FROM ORDERS WHERE CUSTOMERID = :customerId", nativeQuery=true)
    List<OrderEntity> findByCustomeridEquals(@Param("customerId") Long customerId);

}
