package com.ates.bookordermanagement.controller.book;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ates.bookordermanagement.service.book.BookServiceImpl;
import com.ates.bookordermanagement.service.model.BookModel;
import com.ates.bookordermanagement.service.model.CustomerModel;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping(value = "/books")
@Tag(name = "books", description = "the books API")
public class BookController {

	@Autowired
	BookServiceImpl bookService;
	
	
	@Autowired
    public BookController(BookServiceImpl bookService) {
		super();
		this.bookService = bookService;
	}

	@Operation(summary = "Get All Books", description = "Get All Books", tags = { "books" })
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "successful operation", 
                content = @Content(array = @ArraySchema(schema = @Schema(implementation = BookModel.class)))) })	
    @GetMapping(produces = "application/json")
	public List<BookModel> getAllBooks() {
		
		return bookService.getAllBooks();
	}
	
    @Operation(summary = "Get Book by Id", description = "Get Book Info by Id", tags = { "books" })
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "successful operation", 
                content = @Content(schema = @Schema(implementation = CustomerModel.class))) })	
    @GetMapping(value="/{id}", produces = "application/json")
	public BookModel getBookInfo(@PathVariable Long id) {
		return bookService.getBookInfo(id);
	}
	
    @Operation(summary = "Create New Book", description = "Create New Book", tags = { "books" })
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "successful operation", 
                content = @Content(schema = @Schema(implementation = CustomerModel.class))) })	
    @PostMapping(produces = "application/json")	
	public BookModel addBook(@RequestBody BookModel bookModel) {
		
		return bookService.addBook(bookModel);
	}
	
	@Operation(summary = "Delete Book By id", description = "Delete Book By id", tags = { "books" })
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "successful operation", 
                content = @Content(schema = @Schema(defaultValue = "True"))) })	
	@DeleteMapping("/{id}")
	public Boolean deleteBook(@PathVariable Long id) {
		
		return bookService.deleteBook(id);
	}
	
	
	

}
