package com.mindtree.BookApplication.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "book")
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Book_Id")
	private int bookId;
	@Column(name = "Book_Name")
	private String bookName;
	@Column(name = "Book_Price")
	private double bookPrice;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "Date")
	private Date createdDate = new Date();
	@OneToMany(mappedBy = "book")
	
	private List<Writer> writers;

	public Book() {
		super();
	}

	public Book(int bookId, String bookName, double bookPrice, Date createdDate, List<Writer> writers) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
		this.bookPrice = bookPrice;
		this.createdDate = createdDate;
		this.writers = writers;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public double getBookPrice() {
		return bookPrice;
	}

	public void setBookPrice(double bookPrice) {
		this.bookPrice = bookPrice;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public List<Writer> getWriters() {
		return writers;
	}

	public void setWriters(List<Writer> writers) {
		this.writers = writers;
	}

}
