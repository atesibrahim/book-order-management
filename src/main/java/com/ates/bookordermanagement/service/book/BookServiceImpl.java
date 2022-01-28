package com.ates.bookordermanagement.service.book;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ates.bookordermanagement.dao.book.BookRepositoryImpl;
import com.ates.bookordermanagement.dao.model.BookEntity;
import com.ates.bookordermanagement.service.mapper.BookMapper;
import com.ates.bookordermanagement.service.model.BookModel;
import com.ates.bookordermanagement.utils.DeleteException;
import com.ates.bookordermanagement.utils.SufficientException;

@Service
@Transactional
public class BookServiceImpl implements BookService{
	
	@Autowired
	BookRepositoryImpl bookRepository;
	
	@Autowired
	BookMapper bookMapper;

	@Override
	public List<BookModel> getAllBooks() {
		
		return bookMapper.listBookModels(bookRepository.getAllBooks());
	}

	@Override
	public BookModel addBook(BookModel bookModel) {
		
		BookEntity bookEntity = bookMapper.mapBookModelToEntity(bookModel);
		
		bookEntity = bookRepository.addBook(bookEntity);

		return bookMapper.mapBookEntityToBookModel(bookEntity);
	}

	@Override
	public BookModel getBookInfo(Long id) {
		
		return bookMapper.mapBookEntityToBookModel(bookRepository.getBookInfo(id));
	}

	@Override
	public Boolean deleteBook(Long id){

		Boolean result = true;
		try {
			bookRepository.deleteBook(id);

		} catch (DeleteException e) {
			result = false;
		}
		return result;
	}

	public BookEntity checkBookCount(Long bookId, int bookCount) throws SufficientException {
		BookEntity bookEntity = bookRepository.getBookInfo(bookId);
		
		if(bookEntity.getCount()>=bookCount) {
			bookEntity.setCount(bookEntity.getCount()-bookCount);
			return bookRepository.addBook(bookEntity);
		}else {
			throw new SufficientException("There is no that book count in store :"+bookCount);
		}
		
	}

}
