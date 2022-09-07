/**
 * 
 */
package com.bookms.dtos;

import java.io.Serializable;
import java.sql.Date;

/**
 * @author sumit
 *
 */
public class BookDto implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String bookId;
	
	private String isbn;
	
	private String title;
	
	private Date publishedDate;
	
	private int publishedCopies;
	
	private int issuedCopies;
	
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
