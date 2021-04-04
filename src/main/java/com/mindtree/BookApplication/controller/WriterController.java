package com.mindtree.BookApplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.BookApplication.dto.WriterDto;
import com.mindtree.BookApplication.exceptions.ControllerException.ControllerException;
import com.mindtree.BookApplication.exceptions.serviceexceptions.WriterServiceException;
import com.mindtree.BookApplication.service.WriterService;

@RestController
@RequestMapping("/Writer")
public class WriterController {
	@Autowired
	private WriterService writerService;

	// Adding writer details b passing Book name as path variable
	@PostMapping("/addWriterDetails/{name}")
	public ResponseEntity<?> addDetails(@RequestBody WriterDto dto, @PathVariable String name)
			throws ControllerException {
		WriterDto w1 = null;
		try {
			w1 = writerService.addWriterDetails(dto, name);
			return new ResponseEntity<WriterDto>(w1, HttpStatus.ACCEPTED);
		} catch (WriterServiceException | DataAccessException e) {
			throw new ControllerException(e.getMessage());
		}

	}

}
