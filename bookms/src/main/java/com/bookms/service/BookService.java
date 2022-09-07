/**
 * 
 */
package com.bookms.service;

import java.util.List;
import java.util.Optional;

import com.bookms.dtos.BookDto;
import com.bookms.model.Book;

/**
 * @author sumit
 *
 */
public interface BookService {

	public List<Book> getAllBooks();
	public Optional<BookDto> getBookById(String bookId);
	public BookDto addNewBook(Book book);
	public void deleteBook(String bookId);
	public Optional<BookDto> editBook(String bookId, Book book);
}
