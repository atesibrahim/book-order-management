package com.ates.bookordermanagement.service.book;

import java.util.List;

import com.ates.bookordermanagement.dao.model.BookEntity;
import com.ates.bookordermanagement.service.model.BookModel;
import com.ates.bookordermanagement.utils.SufficientException;

public interface BookService {
	
	public List<BookModel> getAllBooks();
	
	public BookModel getBookInfo(Long id);
	
	public BookModel addBook(BookModel bookModel);
	
	public Boolean deleteBook(Long id);
	
	public BookEntity checkBookCount(Long bookId, int bookCount) throws SufficientException;

}
