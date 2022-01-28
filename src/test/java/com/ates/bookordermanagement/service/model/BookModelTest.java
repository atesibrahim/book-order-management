package com.ates.bookordermanagement.service.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BookModelTest {

	
	private BookModel bookModel;
	
	@BeforeEach
	public void init() {
		bookModel = new BookModel();
	}
	
	@Test
	public void whenCalledGetBookName_thenCorrect() {
		bookModel.setBookName("1984");
		assertEquals("1984", bookModel.getBookName());
	}
	
	@Test
	public void whenCalledGetPrice_thenCorrect() {
		bookModel.setPrice(2500L);
		assertEquals(2500L, bookModel.getPrice());
	}
	
	@Test
	public void whenCalledGetCount_thenCorrect() {
		bookModel.setCount(150);
		assertEquals(150, bookModel.getCount());
	}
	
	@Test
	public void whenCalledGetId_thenCorrect() {
		bookModel.setId(3L);
		assertEquals(3L, bookModel.getId());
	}
}
