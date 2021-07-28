package com.cg.bms.service;

import java.util.List;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.bms.dao.BookRepository;
import com.cg.bms.entity.Book;
import com.cg.bms.exception.BookException;

@Service
public class BookService {
	
	@Autowired
	BookRepository repository;
	
	public Book addBook(Book book) throws BookException{
		Book book1 = new Book();
		String bookId = book.getBookId();
		String regEx = "^[0-9]{5}$";
		if(Pattern.matches(regEx,bookId)){
			book1 = repository.addBook(book);
		}
		else{
			throw new BookException("Book Id is invalid");
		}
		return book1;
	}
	
	public Book updateBook(Book book) throws BookException{
		Book book1 = new Book();
		String bookId = book.getBookId();
		String regEx = "^[0-9]{5}$";
		if(Pattern.matches(regEx,bookId)){
			book1 = repository.updateBook(book);
		}
		else{
			throw new BookException("Book Id is invalid");
		}
		return book1;
	}
	
	public void deleteBook(String bookId){
		repository.deleteBook(bookId);
	}
	
	public Book getBook(String bookId){
		return repository.getBook(bookId);
	}
	
	public List<Book> getAllBooks() throws BookException{
		List<Book> bookList=repository.getAllBooks();
		if(bookList.size()>0){
			return bookList;
		}
		else{
			throw new BookException("No books found");
		}
	}

}
