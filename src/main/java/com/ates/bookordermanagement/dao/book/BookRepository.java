package com.ates.bookordermanagement.dao.book;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ates.bookordermanagement.dao.model.BookEntity;

public interface BookRepository extends JpaRepository<BookEntity, Long>{
}
