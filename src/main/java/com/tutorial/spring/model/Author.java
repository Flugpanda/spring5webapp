package com.tutorial.spring.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

/**
 * 
 * A class that represents an author.
 *
 * @author Bastian Bräunel
 *
 */
@Entity
public class Author {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String firstName;
	private String lastName;

	@ManyToMany(mappedBy="authors")
	private Set<Book> books = new HashSet<Book>();

	/**
	 * default constructor
	 */
	public Author() {
		firstName = "";
		lastName = "";
	}
	
	/**
	 * Constructor that crates an author.
	 * @param first	the first name of the author
	 * @param last	the last name if the author
	 */
	public Author(String first, String last) {
		firstName = first;
		lastName = last;
	}
	
	/**
	 * 
	 * Constructor that crates an author.
	 * @param first	the first name of the author
	 * @param last	the last name if the author
	 * @param books	a set of book that are written by the author
	 */
	public Author(String first, String last, Set<Book> books) {
		firstName = first;
		lastName = last;
		this.books = books;
	}
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Set<Book> getBooks() {
		return books;
	}

	public void setBooks(Set<Book> books) {
		this.books = books;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public String toString() {
		return "Author [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + "]";
	}
}
