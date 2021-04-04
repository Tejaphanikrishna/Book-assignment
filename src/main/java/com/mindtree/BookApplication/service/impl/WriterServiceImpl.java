package com.mindtree.BookApplication.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.mindtree.BookApplication.dto.WriterDto;
import com.mindtree.BookApplication.entity.Book;
import com.mindtree.BookApplication.entity.Writer;
import com.mindtree.BookApplication.exceptions.serviceexceptions.NoSuchNameFoundException;
import com.mindtree.BookApplication.exceptions.serviceexceptions.WriterServiceException;
import com.mindtree.BookApplication.repository.BookRepository;
import com.mindtree.BookApplication.repository.WriterRepository;
import com.mindtree.BookApplication.service.WriterService;

@Service
public class WriterServiceImpl implements WriterService {
	@Autowired
	private WriterRepository writerRep;
	@Autowired
	private BookRepository bookRep;
	static ModelMapper mapper = new ModelMapper();

	@Override
	public WriterDto addWriterDetails(WriterDto dto, String name) throws WriterServiceException {
		Writer w = mapper.map(dto, Writer.class);
		Book book;
		try {
			book = bookRep.findByName(name)
					.orElseThrow(() -> new NoSuchNameFoundException("No such Name exists in Database"));
			w.setBook(book);
			w = writerRep.save(w);
			List<Writer> list = new ArrayList<Writer>();
			list.add(w);
			book.setWriters(list);
			bookRep.save(book);
			return mapper.map(w, WriterDto.class);

		} catch (DataAccessException e) {
			throw new WriterServiceException(e);
		}

	}

}
