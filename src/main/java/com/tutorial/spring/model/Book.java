package com.tutorial.spring.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

/**
 * 
 * A class that represents an book.
 * 
 * @author Bastian Bräunel
 */
@Entity
public class Book {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String isbn;
	private String title;
	
	@OneToOne
	@JoinTable(name="publisher_book", joinColumns=@JoinColumn(name="book_id"), inverseJoinColumns=@JoinColumn(name="publisher_id"))
	private Publisher publisher;

	/**
	 * change hibernates default generated mapping
	 * 
	 * @JoinTable(name="author_book"			> creates a single join table called author_book
	 * joinColumns=@JoinColumn(name="book_id")	> joining authors and books by the book_id
	 * inverseJoinColumns=@JoinColumn(name="author_id")	> specifying the other direction of the join by the author_id
	 */
	@ManyToMany
	@JoinTable(name="author_book", joinColumns=@JoinColumn(name="book_id"), inverseJoinColumns=@JoinColumn(name="author_id"))
	private Set<Author> authors = new HashSet<Author>();
	
	/**
	 * default constructor
	 */
	public Book() {
		this.title = "no title";
		this.isbn = "no isbn";
		this.publisher = new Publisher();
	}
	
	/**
	 * Constructor to create a book
	 * @param title		the title of the book
	 * @param isbn		the isbn number of the book
	 * @param publisher	the publisher of the book
	 */
	public Book(String title, String isbn, Publisher  publisher) {
		this.title = title;
		this.isbn = isbn;
		this.publisher = publisher;
	}
	
	/**
	 * 
	 * Constructor to create a book
	 * @param title		the title of the book
	 * @param isbn		he isbn number of the book
	 * @param publisher	the publisher of the book
	 * @param authors	a set of authors that wrote this book
	 */
	public Book(String title, String isbn, Publisher publisher, Set<Author> authors) {
		this.title = title;
		this.isbn = isbn;
		this.publisher = publisher;
		this.authors = authors;
	}

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Publisher getPublischer() {
		return publisher;
	}

	public void setPublischer(Publisher publischer) {
		this.publisher = publischer;
	}

	public Set<Author> getAuthors() {
		return authors;
	}

	public void setAuthors(Set<Author> authors) {
		this.authors = authors;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", isbn=" + isbn + ", title=" + title + ", publisher=" + publisher.toString() + ", authors="
				+ authors + "]";
	}	
}
