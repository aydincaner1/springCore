package com.bitirme.springboot.service;

import com.bitirme.springboot.entity.Author;
import com.bitirme.springboot.entity.Books;
import com.bitirme.springboot.model.BookContext;
import com.bitirme.springboot.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements IBookService {

    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Books findWithId(Long id) {
        return bookRepository.findWithId(id);
    }

    @Override
    public List<Books> getAllBooksList() {
        return bookRepository.getAllBooksList();
    }

    @Override
    public List<Author> getAllAuthorList() {
        return bookRepository.getAllAuthorList();
    }

    @Override
    public List<Books> searchBook(BookContext booksContext) {
        return bookRepository.getAllBooksList();
    }

    @Override
    public List<Books> searchName(BookContext booksContext) {
        return bookRepository.getAllBooksList();
    }

    @Override
    public Long save(BookContext booksContext) {

        if (booksContext.getBookname()== null || booksContext.getBookyear()== null   )
            throw new IllegalArgumentException("Kitap adi ve kitap basim yili bos olamaz !!");

        Books bookkayit= new Books();
        bookkayit.setBookno(bookRepository.findMaxId()+1);
        return getaLong(booksContext, bookkayit);
    }

    @Override
    public Long update(BookContext booksContext) {

        if (booksContext.getBookno()== null )
            throw new IllegalArgumentException("Kitap numarasi bulunamadi !!");

        Books bookupdate= new Books();
        return getaLong(booksContext, bookupdate);
    }

    private Long getaLong(BookContext booksContext, Books bookupdate) {
        bookupdate.setAuthor(booksContext.getAuthor());
        bookupdate.setBooktitle(booksContext.getBooktitle());
        bookupdate.setBookaciklama(booksContext.getBookaciklama());
        bookupdate.setBookyear(booksContext.getBookyear());
        bookupdate.setBooknote(booksContext.getBooknote());
        bookupdate = bookRepository.save(bookupdate);

        return bookupdate.getBookno();
    }

    @Override
    public Long delete(Long bookNo) {
        bookRepository.deleteById(bookNo);
        return null;
    }
}
