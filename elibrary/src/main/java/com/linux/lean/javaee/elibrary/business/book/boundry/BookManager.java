package com.linux.lean.javaee.elibrary.business.book.boundry;

import com.linux.PerformanceMonitor;
import com.linux.lean.javaee.elibrary.business.book.entity.Book;
import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.interceptor.Interceptors;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author guru.a.kulkarni
 */
@Stateless
@Interceptors(PerformanceMonitor.class)
public class BookManager {
    
    @PersistenceContext
    EntityManager em;
    
    @Inject
    Event<Book> bookEvent;
    
    public Book findById(long id) {
        return em.find(Book.class, id);
    }
    
    public Book add(Book book) {
        bookEvent.fire(book);
        return em.merge(book);
    }

    public void delete(long id) {
        em.remove(findById(id));
    }
    
    
//    public void method(@Observes Book book) {
//        System.out.println("com.linux.lean.javaee.elibrary.business.book.boundry.BookManager.method()");
//    }
    
}
