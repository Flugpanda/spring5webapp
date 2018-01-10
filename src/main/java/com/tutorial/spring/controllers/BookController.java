package com.tutorial.spring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tutorial.spring.repositories.IBookRepositories;

/**
 * This class represents a very simple spring mvc controller for the books
 * 
 * @author Bastian Bräunel
 *
 */
@Controller
public class BookController {

	private IBookRepositories bookRepository;
	
	
	/**
	 * default constructor
	 * 
	 * @param bookRepository	gets injected by spring framework
	 */
	public BookController(IBookRepositories bookRepository) {
		this.bookRepository = bookRepository;
	}

	/**
	 * This controller method manipulates the model an tells spring to
	 * open a view called "books"
	 * 
	 * @param model		injected by the spring framework
	 * @return			a string that is associated with the view
	 */
	@RequestMapping("/books")
	public String getBooks(Model model) {
		
		// add an attribute to the model called "books"
		// fill it with the result from hibernate result 
		model.addAttribute("books", bookRepository.findAll());
		
		// return a string called books
		// this tells spring mvc to associate this with a view called "books"
		return "books";
	}
}
