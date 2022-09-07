/**
 * 
 */
package com.bookms.model;


import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author sumit
 *
 */
@Entity
@Table(name="book_details")
public class Book {
	
	
	
	
	/**
	 * @param bookId
	 * @param isbn
	 * @param title
	 * @param publishedDate
	 * @param publishedCopies
	 * @param issuedCopies
	 * @param author
	 */
	public Book(String bookId, String isbn, String title, Date publishedDate, int publishedCopies, int issuedCopies,
			String author) {
		super();
		this.bookId = bookId;
		this.isbn = isbn;
		this.title = title;
		this.publishedDate = publishedDate;
		this.publishedCopies = publishedCopies;
		this.issuedCopies = issuedCopies;
		this.author = author;
	}

	public Book() {
	}

	@Id
	@Column(name="book_id")
	String bookId;
	
	@Column(name="isbn")
	private String isbn;
	
	@Column(name="title")
	private String title;
	
	@Column(name="published_date")
	private Date publishedDate;
	
	@Column(name="published_copies")
	private int publishedCopies;
	
	@Column(name="issued_copies")
	private int issuedCopies;
	
	@Column(name="author")
	private String author;

	public String getBookId() {
		return bookId;
	}

	public void setBookId(String bookId) {
		this.bookId = bookId;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getPublishedDate() {
		return publishedDate;
	}

	public void setPublishedDate(Date publishedDate) {
		this.publishedDate = publishedDate;
	}

	public int getPublishedCopies() {
		return publishedCopies;
	}

	public void setPublishedCopies(int publishedCopies) {
		this.publishedCopies = publishedCopies;
	}

	public int getIssuedCopies() {
		return issuedCopies;
	}

	public void setIssuedCopies(int issuedCopies) {
		this.issuedCopies = issuedCopies;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
	
	
	
	
}
