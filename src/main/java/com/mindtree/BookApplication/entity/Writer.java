package com.mindtree.BookApplication.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Writer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Writer_Id")
	private int writerId;
	@Column(name = "Writer_Name")
	private String writerName;
	@ManyToOne
	@JsonIgnore
	private Book book;

	public Writer() {
		super();
	}

	public Writer(int writerId, String writerName, Book book) {
		super();
		this.writerId = writerId;
		this.writerName = writerName;
		this.book = book;
	}

	public int getWriterId() {
		return writerId;
	}

	public void setWriterId(int writerId) {
		this.writerId = writerId;
	}

	public String getWriterName() {
		return writerName;
	}

	public void setWriterName(String writerName) {
		this.writerName = writerName;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

}
