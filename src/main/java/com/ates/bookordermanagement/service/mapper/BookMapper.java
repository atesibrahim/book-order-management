package com.ates.bookordermanagement.service.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.ates.bookordermanagement.dao.model.BookEntity;
import com.ates.bookordermanagement.service.model.BookModel;

@Component
public class BookMapper {
	
	public BookModel mapBookEntityToBookModel(BookEntity bookEntity) {
		
		BookModel bookModel = new BookModel();
		
		bookModel.setPrice(bookEntity.getPrice());
		
		bookModel.setCount(bookEntity.getCount());
		
		bookModel.setBookName(bookEntity.getBookName());
		
		bookModel.setId(bookEntity.getId());
		
		return bookModel;
	}
	
	public List<BookModel> listBookModels(List<BookEntity> bookEntities){
		
		List<BookModel> bookList = new ArrayList<>();
		
		bookEntities.forEach(element -> {
			bookList.add(mapBookEntityToBookModel(element));
		});
		
		return bookList;
	}

	public BookEntity mapBookModelToEntity(BookModel bookModel) {
		
		BookEntity bookEntity = new BookEntity();
		
		bookEntity.setCount(bookModel.getCount());
		
		bookEntity.setPrice(bookModel.getPrice());
		
		bookEntity.setBookName(bookModel.getBookName());
		
		bookEntity.setId(bookModel.getId());
		
		return bookEntity;
	}

}
