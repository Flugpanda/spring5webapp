package repositories;

import org.springframework.data.repository.CrudRepository;

import com.tutorial.spring.model.Book;

/**
 * Interface for CRUD operations on a repository for the book.
 * 
 * @author santa
 */
public interface IBookRepositories extends CrudRepository<Book, Long>{

}
