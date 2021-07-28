package com.cg.bms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.bms.entity.Book;
import com.cg.bms.service.BookService;

@RestController
public class BookController {
	
	@Autowired
	BookService service;
	
	@PostMapping("/addBook")
	public Book addBook(@RequestBody Book book){
		return service.addBook(book);
	}
	
	@PutMapping("/updateBook")
	public Book updateBook(@RequestBody Book book){
		return service.updateBook(book);
	}
	
	@DeleteMapping("/deleteBook/{bookId}")
	public void deleteBook(@PathVariable("bookId") String bookId){
		service.deleteBook(bookId);
	}
	
	@GetMapping("/getBook/{bookId}")
	public Book getBook(@PathVariable("bookId") String bookId){
		return service.getBook(bookId);
	}
	
	@GetMapping("/getAllBooks")
	 public List<Book> getAllBooks() {
        List<Book> bookList = service.getAllBooks();
        return bookList;
    } 

}
