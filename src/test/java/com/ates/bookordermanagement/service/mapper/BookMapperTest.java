package com.ates.bookordermanagement.service.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ates.bookordermanagement.dao.model.BookEntity;
import com.ates.bookordermanagement.service.model.BookModel;


@SpringBootTest
public class BookMapperTest {
	
	
	@Autowired
	BookMapper bookMapper;
	
	private BookEntity bookEntity;
	
	private BookModel bookModel;
	
	@BeforeEach
	public void init() {
		bookEntity = new BookEntity();
		bookEntity.setBookName("Book Name");
		
		bookModel = new BookModel();
		bookModel.setBookName("Book Model Name");
	}
	
	@Test
	public void whenCalledBookModelToEntity_thenReturnCorrect() {
		
		assertEquals(bookEntity.getBookName(), bookMapper.mapBookEntityToBookModel(bookEntity).getBookName());
	}
	
	@Test
	public void whenCalledBookEntityToModel_thenReturnCorrect() {
		
		assertEquals(bookModel.getBookName(), bookMapper.mapBookModelToEntity(bookModel).getBookName());
	}
	
	@Test
	public void whenCalledBookListModel_thenReturnCorrect() {
		
		List<BookEntity> list = new ArrayList<>();
		list.add(bookEntity);
		
		
		assertEquals(bookEntity.getBookName(), bookMapper.listBookModels(list).get(0).getBookName());
	}

}
