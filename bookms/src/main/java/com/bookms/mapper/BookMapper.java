/**
 * 
 */
package com.bookms.mapper;

import java.util.List;

import com.bookms.dtos.BookDto;
import com.bookms.model.Book;

/**
 * @author sumit
 *
 */
public class BookMapper {

	public List<BookDto> map(List<Book> bookList,List<BookDto> bookDtoList) {
		for(Book book : bookList)
		{
			BookDto bookDto = new BookDto();
			bookDto.setAuthor(book.getAuthor());
			bookDto.setBookId(book.getBookId());
			bookDto.setIsbn(book.getIsbn());
			bookDto.setIssuedCopies(book.getIssuedCopies());
			bookDto.setPublishedCopies(book.getPublishedCopies());
			bookDto.setPublishedDate(book.getPublishedDate());
			bookDto.setTitle(book.getTitle());
			bookDtoList.add(bookDto);
		}
		return bookDtoList;
	}
	
	public BookDto map(Book book, BookDto bookDto) {
		bookDto.setAuthor(book.getAuthor());
		bookDto.setBookId(book.getBookId());
		bookDto.setIsbn(book.getIsbn());
		bookDto.setIssuedCopies(book.getIssuedCopies());
		bookDto.setPublishedCopies(book.getPublishedCopies());
		bookDto.setPublishedDate(book.getPublishedDate());
		bookDto.setTitle(book.getTitle());
		return bookDto;
	}
	
	public Book map(BookDto bookDto, Book book) {
		book.setAuthor(bookDto.getAuthor());
		book.setBookId(bookDto.getBookId());
		book.setIsbn(bookDto.getIsbn());
		book.setIssuedCopies(bookDto.getIssuedCopies());
		book.setPublishedCopies(bookDto.getPublishedCopies());
		book.setPublishedDate(bookDto.getPublishedDate());
		book.setTitle(bookDto.getTitle());
		return book;
	}
	
}
