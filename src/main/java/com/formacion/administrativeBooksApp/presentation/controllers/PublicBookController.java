package com.formacion.administrativeBooksApp.presentation.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.formacion.administrativeBooksApp.persistence.entities.enums.Gender;
import com.formacion.administrativeBooksApp.persistence.entities.enums.Language;
import com.formacion.administrativeBooksApp.presentation.dtos.AuthorBean;
import com.formacion.administrativeBooksApp.presentation.dtos.BookForm;
import com.formacion.administrativeBooksApp.presentation.dtos.BookSearch;
import com.formacion.administrativeBooksApp.presentation.dtos.CategoryBean;
import com.formacion.administrativeBooksApp.presentation.services.BookServices;

@Controller
@RequestMapping("/publicBook")
public class PublicBookController {
	@Autowired
	private BookServices booksServices;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView index() {
		return new ModelAndView("public/books/bookIndex");
	}
	
	@RequestMapping(value = "/books", method = RequestMethod.GET)
	public ModelAndView findAllBooks(@ModelAttribute("bookSearchModel") BookSearch bookSearch, Pageable page) {
		ModelAndView model = new ModelAndView();
		model.addObject("Books", booksServices.findAll(page));
		model.addObject("itIsAnAdvancedSearch", false);
		model.setViewName("public/books/bookList");
		return model;
	}
	
	@RequestMapping(value = "/books/advancedSearch", method = RequestMethod.GET)
	public ModelAndView findAllBooksByAnAdvancedSearch(@Valid @ModelAttribute("bookSearchModel") BookSearch bookSearch, BindingResult result) {
		ModelAndView model = new ModelAndView();
		model.setViewName("public/books/bookList");
		
		if(result.hasErrors()) {
			model.addObject("Books", booksServices.findAll());
			return model;
		}
		
		model.addObject("Books", booksServices.findAllByBookModel(bookSearch));
		model.addObject("itIsAnAdvancedSearch", true);
		
		return model;
	}
	
	@RequestMapping(value = "/book/{id}", method = RequestMethod.GET)
    public ModelAndView readbook(@PathVariable("id") int findBookId) {
		ModelAndView model = new ModelAndView();
		model.addObject("Book", booksServices.findById(findBookId));
		model.setViewName("public/books/book");
		return model;
    }
	
	@GetMapping(value = "/book/administrative/add")
	public ModelAndView createBook(@ModelAttribute("bookFormModel") BookForm book, Model model) {
		return new ModelAndView("public/books/bookForm");
	}
	
	@RequestMapping(value = "/book/administrative/{id}/update", method = RequestMethod.GET)
    public ModelAndView modifyBook(@PathVariable("id") int findBookId) {
		ModelAndView model = new ModelAndView();
		model.addObject("bookFormModel", booksServices.findByIdToUpdate(findBookId));
		model.setViewName("public/books/bookForm");
		return model;
    }
	
	@PostMapping(value = "/book/administrative/save", params="save")
	public ModelAndView saveOrUpdateBook(@Valid @ModelAttribute("bookFormModel") BookForm book, BindingResult result, RedirectAttributes attributes,
							@RequestParam("fileImage") MultipartFile multiPart, HttpServletRequest request) {

		if(result.hasErrors())  //Validate errors
			return new ModelAndView("public/books/bookForm");
		
		if (!multiPart.isEmpty()) {  //check for file input
			String imageName = booksServices.saveImage(multiPart, request);
			book.setImgUrl(imageName);
		}
		
		if(book.getId()==0) {
			booksServices.insert(book);
			attributes.addFlashAttribute("bookCreateMessage", "Book created"); //attributes is a RedirectAttributes that spring inicializated becauses its has to implement some methods
		}	else {
			booksServices.update(book);
			attributes.addFlashAttribute("bookCreateMessage", "Book updated");
		}
		
		return new ModelAndView("redirect:/publicBook/books");
	}
	
	@PostMapping(value = "/book/administrative/save", params="cancel")
	public ModelAndView cancelCreateBook() {
		return new ModelAndView("redirect:/publicBook/books");
	}
	
	@RequestMapping(value = "/book/administrative/{id}/delete", method = RequestMethod.GET)
    public ModelAndView deleteBook(@PathVariable("id") int findBookId, RedirectAttributes attributes) {
		booksServices.delete(findBookId);
		attributes.addFlashAttribute("bookCreateMessage", "Book deleted");
		return new ModelAndView("redirect:/publicBook/books");
    }

	@ModelAttribute("displayLanguagues")
	 public List<Language> getBookLanguages() {
		 return booksServices.getBookLanguague();
	 }
	
	@ModelAttribute("displayCategories")
	 public List<CategoryBean> getBookCategories() {
		return booksServices.getBookCategories();
	 }
	
	@ModelAttribute("displayAuthors")
	 public List<AuthorBean> getAuthors() {
		return booksServices.getAuthors();
	 }
}
