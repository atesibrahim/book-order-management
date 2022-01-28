package com.ates.bookordermanagement.controller.book;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.ates.bookordermanagement.service.book.BookServiceImpl;
import com.ates.bookordermanagement.service.model.BookModel;


@SpringBootTest
public class BookControllerTest {

	BookController bookController;
	
	@Mock
	BookServiceImpl bookServiceImpl;
	
	private BookModel bookModel;
	
	@BeforeEach
	public void init() {
		
		bookController = new BookController(bookServiceImpl);
		
		bookModel = new BookModel();
		bookModel.setPrice(50L);
		bookModel.setBookName("1984");
		bookModel.setId(3L);	
		bookModel.setCount(5);
	}
	
	@Test
	public void whenCalledGetAllBooks_thenReturnList() {
		
		List<BookModel> list = new ArrayList<>();
		list.add(bookModel);
		
		when(bookServiceImpl.getAllBooks()).thenReturn(list);

		
		assertTrue(bookController.getAllBooks().size()>0);
	}
	
	@Test
	public void whenCalledGetBookById_thenReturnTrue() {
		
		when(bookServiceImpl.getBookInfo(any())).thenReturn(bookModel);
		
		assertEquals(3L, bookController.getBookInfo(1L).getId());
	}
	
	@Test
	public void whenCalledCreateBook_thenReturnTrue() {
		
		when(bookServiceImpl.addBook(any())).thenReturn(bookModel);
		
		assertEquals(bookModel, bookController.addBook(bookModel));
	}
	
	@Test
	public void whenCalledDeleteBook_thenReturnTrue() {
		
		when(bookServiceImpl.deleteBook(any())).thenReturn(true);
		
		assertEquals(true, bookController.deleteBook(bookModel.getId()));
	}
	
}
