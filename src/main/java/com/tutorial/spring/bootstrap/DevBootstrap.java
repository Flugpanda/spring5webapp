package com.tutorial.spring.bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.tutorial.spring.model.Author;
import com.tutorial.spring.model.Book;

import repositories.IAuthorRespositories;
import repositories.IBookRepositories;
/**
 * 
 * Prepare some date for the development at boot
 * 
 * @author Bastian Bräunel
 *
 */
@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent>{

	private IAuthorRespositories authorRepository;
	private IBookRepositories bookRepository;
	
	/**
	 * Constructor for injecting the repository objects through spring framework
	 * 
	 * @param authorRepository	CRUD repository object for the authors
	 * @param bookRepository	CRUD repository object for the books 
	 */
	public DevBootstrap(IAuthorRespositories authorRepository, IBookRepositories bookRepository) {
		super();
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		initDataDB();
	}

	/**
	 * Bootstrap data for the database by creating some authors nad books
	 */
	private void initDataDB() {
		
		// Authors
		//Hans
		Author alice = new Author("Hans", "Heiner");
		//Peter
		Author peter = new Author("Peter", "Lustig");
		
		// Books
		Book bookOne = new Book("Why it's cold coutside?", "12345", "Rapidprinting LTD");
		Book bookTwo = new Book("Some funny thoughts", "987654", "Trashcan Pros");
		
		// add the books to the authors 
		alice.getBooks().add(bookOne);
		peter.getBooks().add(bookOne);
		peter.getBooks().add(bookTwo);
		
		// save the data
		authorRepository.save(alice);
		authorRepository.save(peter);
		
		bookRepository.save(bookOne);
		bookRepository.save(bookTwo);
	}

}
