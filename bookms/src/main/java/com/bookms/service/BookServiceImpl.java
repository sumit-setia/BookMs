package com.bookms.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookms.dtos.BookDto;
import com.bookms.mapper.BookMapper;
import com.bookms.model.Book;
import com.bookms.repository.BookRepository;

@Service
public class BookServiceImpl implements BookService{

	@Autowired
	BookRepository bookRepo;
	
	@Override
	public List<Book> getAllBooks() {
		List<Book> bookList = bookRepo.findAll();
		/*
		 * BookMapper mapper = new BookMapper(); List<BookDto> bookDtoList = new
		 * ArrayList<>();
		 */
		//bookDtoList =mapper.map(bookList, bookDtoList);
		return bookList;
	}

	@Override
	public Optional<BookDto> getBookById(String bookId) {
		Optional<Book> bookData = bookRepo.findById(bookId);
		BookMapper mapper = new BookMapper();
		BookDto bookDto = new BookDto();
		if(bookData.isPresent()) {
		return Optional.of(mapper.map(bookData.get(),bookDto));
		}
		return Optional.empty();
		
	}

	@Override
	public BookDto addNewBook(Book book) {
		Book returnedBook = bookRepo.save(book);
		BookMapper mapper = new BookMapper();
		BookDto bookDto = new BookDto();
		return mapper.map(returnedBook, bookDto);
		 
	}

	@Override
	public void deleteBook(String bookId) {
		bookRepo.deleteById(bookId);
	}

	@Override
	public Optional<BookDto> editBook(String bookId, Book book) {
		Optional<Book> bookData =bookRepo.findById(bookId);
		if(bookData.isPresent()) {
			Book returnedBook=bookRepo.save(book);
			BookMapper mapper = new BookMapper();
			BookDto bookDto = new BookDto();
			return Optional.of(mapper.map(returnedBook, bookDto));
			
		}
		return null;
	}

	

}
