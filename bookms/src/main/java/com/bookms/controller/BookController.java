/**
 * 
 */
package com.bookms.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookms.Exception.ResourceNotFoundException;
import com.bookms.dtos.BookDto;
import com.bookms.mapper.BookMapper;
import com.bookms.model.Book;
import com.bookms.service.BookService;

/**
 * @author sumit
 *
 */
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/book")
public class BookController {
	
	@Autowired
	BookService bookService;
	
	@Autowired
	RabbitTemplate template;
	
	@GetMapping("/fetch")
	public ResponseEntity<List<Book>> getAllBooks(){
		List<Book> list =bookService.getAllBooks();
		if(list.size()>0) {
			return new ResponseEntity<List<Book>>(list,HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@GetMapping("/fetch/{bookId}")
	public ResponseEntity<BookDto> getBookById(@PathVariable("bookId") String bookId) throws ResourceNotFoundException{
		
		BookDto book=bookService.getBookById(bookId).orElseThrow(()->new ResourceNotFoundException("Book is not found with id ="+bookId));
		/*
		 * if(bookData.isPresent()) { return new
		 * ResponseEntity<BookDto>(bookData.get(),HttpStatus.OK); }
		 */
		return ResponseEntity.ok().body(book);
		
		
		
	}
	
	@PostMapping("/add")
	public BookDto addNewBook(@RequestBody BookDto bookDto) {
		BookMapper mapper = new BookMapper();
		Book book = new Book();
		book=mapper.map(bookDto, book);
		BookDto bookDtoReturned= bookService.addNewBook(book);
		template.convertAndSend("MyExchange", "MyKey", "added successfully");
		return bookDtoReturned;
		
	}
	
	@DeleteMapping("/delete/{bookId}")
	public String deleteBook(@PathVariable("bookId") String bookId) {
		 bookService.deleteBook(bookId);
		 return "deleted Successfully";
	}
	
	@PutMapping("/edit/{bookId}")
	public BookDto editBook(@PathVariable("bookId") String bookId, @RequestBody Book book) {
		Optional<BookDto> bookDtoData =bookService.editBook(bookId,book);
		return bookDtoData.get();
		
		
	}
	
	
}
