package repositories;

import org.springframework.data.repository.CrudRepository;

import com.tutorial.spring.model.Author;

/**
 * Interface for CRUD operations on a repository for the author.
 * 
 * @author santa
 */
public interface IAuthorRespositories extends CrudRepository<Author, Long>{

}
