package com.globallogic.LibraryManagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.globallogic.LibraryManagement.entity.Book;
import com.globallogic.LibraryManagement.service.BookService;

@Controller
@RequestMapping("/app")
public class BookController {

	@Autowired
	BookService bookService;

	@GetMapping("/bookList")
	public String bookList(Model model) {
		List<Book> bookList = bookService.getBookList();
		model.addAttribute("bookList", bookList);
		return "bookList";
	}

	@GetMapping("/showForm")
	public String showFormForAdd(Model model) {
		Book book = new Book();
		model.addAttribute("book", book);
		return "bookForm";
	}

	@PostMapping("/saveBook")
	public String saveBook(@ModelAttribute("book") Book book) {
		bookService.saveBook(book);
		return "redirect:/app/bookList";
	}

	@GetMapping("/updateForm")
	public String showFormForUpdate(@RequestParam("id") int id, Model model) {
		Book book = bookService.getBook(id);
		model.addAttribute("book", book);
		return "bookForm";
	}

	@GetMapping("/delete")
	public String deleteBook(@RequestParam("id") int id) {
		bookService.deleteBook(id);
		return "redirect:/app/bookList";
	}
}
