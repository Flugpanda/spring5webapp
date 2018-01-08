package com.tutorial.spring.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

import com.tutorial.spring.model.Publisher;

/**
 * Interface for CRUD operations on a repository for the publisher.
 * 
 * @author Bastian Bräunel
 */
public interface IPublisherRepositories extends CrudRepository<Publisher, Long>{

}
