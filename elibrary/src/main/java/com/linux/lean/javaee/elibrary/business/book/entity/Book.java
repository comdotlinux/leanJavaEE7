package com.linux.lean.javaee.elibrary.business.book.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 *
 * @author guru.a.kulkarni
 */
@Entity
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Book implements Serializable {
    
    private static final long serialVersionUID = 34523513452345l;
    
    @Id
    @GeneratedValue
    private long id;
    
    private String author;
    
    private String title;
    
    @Temporal(TemporalType.DATE)
    @XmlJavaTypeAdapter(DateMapper.class)
    private Date releaseDate;

    public Book(String author, String title, Date releaseDate) {
        this.author = author;
        this.title = title;
        this.releaseDate = releaseDate;
    }

    public Book() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    
    
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    @Override
    public String toString() {
        return "Book{" + "id=" + id + ", author=" + author + ", title=" + title + ", releaseDate=" + releaseDate + '}';
    }
    
}
