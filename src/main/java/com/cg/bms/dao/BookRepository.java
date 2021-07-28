package com.cg.bms.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.cg.bms.entity.Book;

@Repository
public class BookRepository {
	
	 private static final Map<String, Book> bookMap = new HashMap<String, Book>();
	 
	    static {
	        initBooks();
	    }
	 
	    private static void initBooks() {
	        Book book1 = new Book("101", "Java", "James Gosling", 1000);
	        Book book2 = new Book("102", "C", "Dennis Ritchie", 550);
	        Book book3 = new Book("103", "Python", "Eric Mathew", 750);
	        
	        bookMap.put(book1.getBookId(), book1);
	        bookMap.put(book2.getBookId(), book2);
	        bookMap.put(book3.getBookId(), book3);
	    }
	 
	    public Book getBook(String bookId) {
	        return bookMap.get(bookId);
	    }
	 
	    public Book addBook(Book book) {
	        bookMap.put(book.getBookId(), book);
	        return book;
	    }
	 
	    public Book updateBook(Book book) {
	        bookMap.put(book.getBookId(), book);
	        return book;
	    }
	 
	    public void deleteBook(String bookId) {
	        bookMap.remove(bookId);
	    }
	 
	    public List<Book> getAllBooks() {
	        Collection<Book> b = bookMap.values();
	        List<Book> list = new ArrayList<Book>();
	        list.addAll(b);
	        return list;
	    }

}
