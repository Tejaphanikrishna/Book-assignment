package com.mindtree.BookApplication.service;

import java.util.List;
import java.util.Optional;

import com.mindtree.BookApplication.dto.BookDto;
import com.mindtree.BookApplication.entity.Book;

public interface BookService {

	BookDto addBookDetails(BookDto book);

	Optional<Float> getAllBookDetails();

	List<Book> getAllBookAndWriterDetails();

	Book getAllBookDetailsById(int id);

}
