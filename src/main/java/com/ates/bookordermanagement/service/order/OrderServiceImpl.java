package com.ates.bookordermanagement.service.order;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ates.bookordermanagement.dao.order.OrderRepository;
import com.ates.bookordermanagement.service.book.BookService;
import com.ates.bookordermanagement.service.book.BookServiceImpl;
import com.ates.bookordermanagement.service.customer.CustomerService;
import com.ates.bookordermanagement.service.customer.CustomerServiceImpl;
import com.ates.bookordermanagement.service.mapper.OrderMapper;
import com.ates.bookordermanagement.service.model.OrderModel;
import com.ates.bookordermanagement.utils.SufficientException;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {
	
	Logger logger = LoggerFactory.getLogger(OrderServiceImpl.class);
	
	@Autowired
	CustomerService customerService;
	
	@Autowired
	BookService bookService;
	
	@Autowired
	OrderRepository orderRepository;
	
	@Autowired
	OrderMapper orderMapper;
	
	public OrderServiceImpl() {
		super();
	}
	
	@Autowired
	public OrderServiceImpl(CustomerService customerService, BookService bookService,
			OrderRepository orderRepository, OrderMapper orderMapper) {
		super();
		this.customerService = customerService;
		this.bookService = bookService;
		this.orderRepository = orderRepository;
		this.orderMapper = orderMapper;
	}



	@Override
	public Long createOrder(OrderModel orderModel) throws SufficientException {
		Long result = 0L;
		try {
			
			// check Book count if count enough exists then reduce count	
			Long priceLong = bookService.checkBookCount(orderModel.getBookId(), orderModel.getBookCount()).getPrice();
			
			
			if(priceLong!=null) {
				orderModel.setOrderAmount(priceLong*orderModel.getBookCount());
			}


			// check customer and Balance if exists then reduce demand amount
			customerService.checkCustomerBalance(orderModel.getCustomerId(), orderModel.getOrderAmount());
			
			// create order
			
			result = orderRepository.save(orderMapper.mapToOrderEntity(orderModel)).getId();
			
			customerService.addOrderToCustomer(result, orderModel.getCustomerId());
			
		} catch (Exception e) {
			String errorMessage = "Sufficient exception occured. Order has not been create.";
			logger.error(errorMessage);
			throw new SufficientException(e, errorMessage);
			
		}
		
		// if all success then return that is success
		return result;
	}

	@Override
	public List<OrderModel> getAllOrders() {
		
		return orderMapper.mapToModelList(orderRepository.findAll());
		
	}

	@Override
	public List<OrderModel> getCustomerOrders(Long customerId) {
		
		return orderMapper.mapToModelList(orderRepository.findByCustomeridEquals(customerId));
	
	}

}
