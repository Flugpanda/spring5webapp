package com.tutorial.spring.repositories;

import org.springframework.data.repository.CrudRepository;

import com.tutorial.spring.model.Author;

/**
 * Interface for CRUD operations on a repository for the author.
 * 
 * @author Bastian Bräunel
 */
public interface IAuthorRepositories extends CrudRepository<Author, Long>{

}
