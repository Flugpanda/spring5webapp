package com.tutorial.spring.repositories;

import org.springframework.data.repository.CrudRepository;

import com.tutorial.spring.model.Book;

/**
 * Interface for CRUD operations on a repository for the book.
 * 
 * @author Bastian Bräunel
 */
public interface IBookRepositories extends CrudRepository<Book, Long>{

}
