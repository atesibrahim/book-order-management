package com.ates.bookordermanagement.service.book;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ates.bookordermanagement.service.model.BookModel;
import com.ates.bookordermanagement.dao.model.BookEntity;


@SpringBootTest
public class BookServiceTest {

	
	@Autowired
	private BookServiceImpl bookServiceImpl;
	
	private List<BookEntity> bookEntities = new ArrayList<>();
	
	private BookEntity bookEntity;
	
	private BookModel bookModel;
	
	@BeforeEach
	public void init() {
		bookEntity = new BookEntity();
		bookEntity.setPrice(100L);
		bookEntity.setBookName("1984");
		bookEntity.setId(4L);
		bookEntity.setCount(25);
		bookEntities.add(bookEntity);
		
		bookModel = new BookModel();
		
		bookModel.setBookName(bookEntity.getBookName());
		bookModel.setCount(bookEntity.getCount());
		bookModel.setId(bookEntity.getId());
		bookModel.setPrice(bookEntity.getPrice());
		
		
	}
	
	@Test
	public void whenCalledGetAllBook_thenReturnList() {
		
		
		assertTrue(bookServiceImpl.getAllBooks().size()>0);
		
		assertEquals("1984",bookServiceImpl.getAllBooks().get(0).getBookName());
	}
	
	@Test
	public void whenCalledGetBookById_thenReturn() {
		
		
		assertEquals("What Men Live By",bookServiceImpl.getBookInfo(2L).getBookName());
	}
	
	@Test
	public void whenCalledCreateBook_thenReturnTrue() {
		
		
		assertEquals("1984",bookServiceImpl.addBook(bookModel).getBookName());
	}
	
	@Test
	public void whenCalledDeleteBookById_thenReturnTrue(){
	
		assertEquals(true,bookServiceImpl.deleteBook(1L));
				
		
	}
}
