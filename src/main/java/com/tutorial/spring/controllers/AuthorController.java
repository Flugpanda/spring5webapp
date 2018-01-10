package com.tutorial.spring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tutorial.spring.repositories.IAuthorRepositories;

/**
 * This class represents a very simple spring mvc controller for the authors
 * 
 * @author Bastian Bräunel
 *
 */
@Controller
public class AuthorController {

	private IAuthorRepositories authorRepository;
	private final String VIEW = "authors";

	/**
	 * default constructor to wire IAuthorRepositories
	 * 
	 * @param authorRepository	gets injected by spring framework
	 */
	public AuthorController(IAuthorRepositories authorRepository) {
		this.authorRepository = authorRepository;
	}
	
	@RequestMapping("/authors")
	public String getAuthors(Model model) {
		model.addAttribute("authors", authorRepository.findAll());
		
		return "authors";
	}
	
}
