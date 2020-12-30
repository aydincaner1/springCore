package com.bitirme.springboot.model;

public class BookContext {

    private Long bookno;
    private String booktitle;
    private String bookname;
    private String author;
    private String bookyear;
    private String bookaciklama;
    private String booknote;

    public Long getBookno() {
        return bookno;
    }

    public void setBookno(Long bookno) {
        this.bookno = bookno;
    }

    public String getBooktitle() {
        return booktitle;
    }

    public void setBooktitle(String booktitle) {
        this.booktitle = booktitle;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getBookyear() {
        return bookyear;
    }

    public void setBookyear(String bookyear) {
        this.bookyear = bookyear;
    }

    public String getBookaciklama() {
        return bookaciklama;
    }

    public void setBookaciklama(String bookaciklama) {
        this.bookaciklama = bookaciklama;
    }

    public String getBooknote() {
        return booknote;
    }

    public void setBooknote(String booknote) {
        this.booknote = booknote;
    }
}
