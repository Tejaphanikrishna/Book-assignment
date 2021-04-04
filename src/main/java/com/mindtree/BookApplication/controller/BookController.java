package com.mindtree.BookApplication.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.BookApplication.dto.BookDto;
import com.mindtree.BookApplication.entity.Book;
import com.mindtree.BookApplication.service.BookService;

@RestController
@RequestMapping("/Book")
public class BookController {
	@Autowired
	private BookService bookService;

	// 1.Adding Book Details
	@PostMapping("/addBookDetails")
	public ResponseEntity<?> addDetails(@RequestBody BookDto book) {
		BookDto book1 = null;
		book1 = bookService.addBookDetails(book);
		return new ResponseEntity<BookDto>(book1, HttpStatus.ACCEPTED);

	}

	// 2.Get All Book Details
	@GetMapping("/getBookDetails")
	public Optional<Float> getDetails() {
		return bookService.getAllBookDetails();
	}

	// 3. Get All Books And Corresponding Writer Details
	@GetMapping("/getAllBookDetails")
	public List<Book> getAllDetails() {
		return bookService.getAllBookAndWriterDetails();
	}

	// 4.Get All Book Details by Passing Book Id as Path Variable
	@GetMapping("/getBookDetails/{id}")
	public Book getBookDetails(@PathVariable int id) {
		return bookService.getAllBookDetailsById(id);
	}
	

}
