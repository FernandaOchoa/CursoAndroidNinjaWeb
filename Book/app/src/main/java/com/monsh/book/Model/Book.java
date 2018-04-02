package com.monsh.book.Model;

public class Book {

    private int id;
    private String title;
    private String author;

    public Book (){  }

    public Book (String title, String author){
        super();
        this.title= title;
        this.author = author;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getId() {  return id;  }
    public String getTitle() {  return title;  }
    public String getAuthor() {  return author;  }

    @Override
    public String toString() {
        return "Book [id="+id + ",title=" +title +", author= "+
        author + "]";
    }
}
