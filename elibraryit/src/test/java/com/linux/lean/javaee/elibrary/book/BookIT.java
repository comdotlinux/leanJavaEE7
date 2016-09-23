/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.linux.lean.javaee.elibrary.book;

import java.math.BigDecimal;
import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.core.IsCollectionContaining.*;
import static org.hamcrest.MatcherAssert.*;
import org.junit.Before;

/**
 *
 * @author guru.a.kulkarni
 */
public class BookIT {

    private WebTarget target;

    @Before
    public void setUp() {
        Client client = ClientBuilder.newClient();
        this.target = client.target("http://localhost:8080/elibrary/resources/book");
    }
     
    @Test
    public void crud() {
        
        JsonObject book = Json.createObjectBuilder()
                .add("author", "Rudyard Kipling")
                .add("title", "Jungle Book")
                .add("releaseDate", "01-08-2016")
                .build();
        
        Response response = target.request().post(Entity.json(book));
        
        book = response.readEntity(JsonObject.class);
        System.out.println("com.linux.lean.javaee.elibrary.book.BookIT.crud " + book);
        assertThat(response.getStatus(), is(200));
        
        int id = book.getInt("id");
        
        
        response = target.path("/" + id).request().get();
        assertThat(response.getStatus(), is(200));
        JsonObject b = response.readEntity(JsonObject.class);
        assertThat(b.getString("author"), is(equalTo("Rudyard Kipling")));
    }
     
}