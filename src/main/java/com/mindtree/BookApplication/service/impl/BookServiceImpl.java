package com.mindtree.BookApplication.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.BookApplication.dto.BookDto;
import com.mindtree.BookApplication.entity.Book;
import com.mindtree.BookApplication.repository.BookRepository;
import com.mindtree.BookApplication.service.BookService;

@Service
public class BookServiceImpl implements BookService {
	@Autowired
	private BookRepository bookRep;

	@Override
	public BookDto addBookDetails(BookDto book) {
		Book b = dtoToEntity(book);
		bookRep.save(b);
		return book;
	}

	private Book dtoToEntity(BookDto book) {
		Book b = new Book();
		ModelMapper mapper = new ModelMapper();
		b = mapper.map(book, Book.class);
		return b;
	}

	@Override
	public Optional<Float> getAllBookDetails() {
		List<Book> list = bookRep.findAll();
		List<Float> priceList = new ArrayList<>();
		for (Book b : list) {
			priceList.add((float) b.getBookPrice());
		}
		Optional<Float> sumOfPrices = priceList.stream().reduce((a, b)->a+b);
		int count = (int) priceList.stream().count();
		Optional<Float> avg = sumOfPrices.map(x->x/count);
		//OptionalDouble avg1 = priceList.stream().mapToDouble(x->x).average();
		return avg;
	}

	@Override
	public Book getAllBookDetailsById(int id) {
		Book b1 = bookRep.findById(id).get();
		return b1;
	}

	@Override
	public List<Book> getAllBookAndWriterDetails() {
		List<Book> bookList = new ArrayList<Book>();
		bookList = bookRep.findAll();
		bookList = bookList.stream().filter(x -> x.getBookPrice() >= 500).collect(Collectors.toList());
		Collections.sort(bookList, new Comparator<Book>() {

			@Override
			public int compare(Book o1, Book o2) {
				int res = 0;
				res = (int) (o2.getBookPrice() - o1.getBookPrice());
				if (res == 0)
					res = o1.getBookName().compareTo(o2.getBookName());
				return res;
			}
		});
		return bookList;

	}

}
