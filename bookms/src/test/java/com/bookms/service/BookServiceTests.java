/**
 * 
 */
package com.bookms.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.bookms.model.Book;
import com.bookms.repository.BookRepository;

/**
 * @author sumit
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class BookServiceTests {
	
	@Autowired
	private BookService service;
	
	@MockBean
	private BookRepository bookRepo;
	
	Book b1 =new Book("3","abc123","My Book", new Date(0),4,0,"Sumit");
	Book b2 =new Book("4","abc124","My Book", new Date(0),5,0,"Mehak");
	List<Book> bookList = new ArrayList<Book>();
	@Test
	public void getBookTest() {
		bookList.add(b1);
		bookList.add(b2);
		when(bookRepo.findAll()).thenReturn(bookList);
		assertEquals(2,service.getAllBooks().size());
				
	}
}
