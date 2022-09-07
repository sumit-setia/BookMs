/**
 * 
 */
package com.bookms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookms.model.Book;

/**
 * @author sumit
 *
 */
public interface BookRepository extends JpaRepository<Book, String> {

}
