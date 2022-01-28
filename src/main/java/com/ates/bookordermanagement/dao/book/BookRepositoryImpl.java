package com.ates.bookordermanagement.dao.book;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import com.ates.bookordermanagement.dao.model.BookEntity;
import com.ates.bookordermanagement.utils.DeleteException;

@Component
public class BookRepositoryImpl {
	
	BookRepository bookRepository;
	
	@Autowired
	public BookRepositoryImpl(@Lazy BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}
	

	public List<BookEntity> getAllBooks() {
		
		return bookRepository.findAll();
	}

	@Transactional
	public BookEntity addBook(BookEntity bookEntity) {

		return bookRepository.save(bookEntity);
	}


	public BookEntity getBookInfo(Long id) {
		
		return bookRepository.getById(id);
	}


	public void deleteBook(Long id) throws DeleteException{

		try {
			bookRepository.deleteById(id);

		} catch (Exception e) {
			throw new DeleteException("Delete exception occurred.");
		}
	}


}
