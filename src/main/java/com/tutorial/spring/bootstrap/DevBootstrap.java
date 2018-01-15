package com.tutorial.spring.bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.tutorial.spring.model.Author;
import com.tutorial.spring.model.Book;
import com.tutorial.spring.model.Publisher;
import com.tutorial.spring.repositories.IAuthorRepositories;
import com.tutorial.spring.repositories.IBookRepositories;
import com.tutorial.spring.repositories.IPublisherRepositories;
/**
 * 
 * Prepare some date for the development at boot of the spring app
 * 
 * @author Bastian Bräunel
 *
 */
@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent>{

	private IAuthorRepositories authorRepository;
	private IBookRepositories bookRepository;
	private IPublisherRepositories publisherRepository;
	
	/**
	 * Constructor for injecting the repository objects through spring framework
	 * 
	 * @param authorRepository		CRUD repository object for the authors
	 * @param bookRepository		CRUD repository object for the books 
	 * @param publisherRepository	CRUD repository object for the publisher
	 */
	public DevBootstrap(IAuthorRepositories authorRepository, IBookRepositories bookRepository, IPublisherRepositories publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		initDataDB();
	}

	/**
	 * Bootstrap data for the database by creating some authors and books
	 */
	private void initDataDB() {
		
		// Authors
		//Hans
		Author hans = new Author("Hans", "Heiner");
		//Peter
		Author peter = new Author("Peter", "Lustig");
			
		// Publisher
		Publisher pubOne = new Publisher();
		pubOne.setName("Rapidprinting LTD");
		pubOne.setAddress("Dark Alley 12, London");
		
		Publisher pubTwo = new Publisher();
		pubTwo.setName("Trashcan Pros");
		pubTwo.setAddress("Dumproad 11a, Over There");
				
		// Books
		Book bookOne = new Book("Why it's cold coutside?", "12345", pubOne);
		Book bookTwo = new Book("Some funny thoughts", "987654",pubTwo);
		
		// add the books to the authors 
		peter.getBooks().add(bookOne);
		hans.getBooks().add(bookOne);
		peter.getBooks().add(bookTwo);
		
		// add the authors to the books
		bookOne.getAuthors().add(hans);
		bookTwo.getAuthors().add(peter);
		bookOne.getAuthors().add(peter);
		
		// save the data
		publisherRepository.save(pubOne);
		publisherRepository.save(pubTwo);
		
		authorRepository.save(hans);
		authorRepository.save(peter);
		
		bookRepository.save(bookOne);
		bookRepository.save(bookTwo);
	}

}
