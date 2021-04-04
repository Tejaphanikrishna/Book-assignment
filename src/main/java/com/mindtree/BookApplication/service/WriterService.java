package com.mindtree.BookApplication.service;

import com.mindtree.BookApplication.dto.WriterDto;
import com.mindtree.BookApplication.exceptions.serviceexceptions.WriterServiceException;

public interface WriterService {

	WriterDto addWriterDetails(WriterDto dto, String name) throws WriterServiceException;

}
