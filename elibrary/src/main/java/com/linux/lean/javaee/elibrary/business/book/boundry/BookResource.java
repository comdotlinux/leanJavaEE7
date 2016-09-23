package com.linux.lean.javaee.elibrary.business.book.boundry;

import com.linux.lean.javaee.elibrary.business.book.entity.Book;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author guru.a.kulkarni
 */
@Path("book")
@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
public class BookResource {
    
    @Inject
    BookManager manager;
    
    @GET
    @Path("{id}")
    public Book find(@PathParam("id") long id) {
        return manager.findById(id);
    }
    
    @POST
    public Book add(Book book) {
        return manager.add(book);
    }
    
}
