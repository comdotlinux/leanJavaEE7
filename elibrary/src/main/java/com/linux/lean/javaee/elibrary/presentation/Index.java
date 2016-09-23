package com.linux.lean.javaee.elibrary.presentation;


import com.linux.lean.javaee.elibrary.business.book.entity.Book;
import com.linux.lean.javaee.elibrary.business.book.boundry.BookManager;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;

/**
 *
 * @author guru.a.kulkarni
 */
@Model
public class Index {

    private static final Logger LOGGER = Logger.getLogger(Index.class.getSimpleName());
    
    @Inject 
    BookManager manager;
    
    private Book book;
    
    @PostConstruct
    public void init() {
        this.book = new Book();
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
    
    public Object submit() {
        LOGGER.log(Level.INFO, "Added book {0}", book);
        manager.add(book);
        return null;
    }
    
    
}
