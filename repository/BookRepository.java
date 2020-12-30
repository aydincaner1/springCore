package com.bitirme.springboot.repository;

import com.bitirme.springboot.entity.Author;
import com.bitirme.springboot.entity.Books;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends CrudRepository<Books, Long> {

    //hql sorgularim
    @Query(value = "SELECT b FROM Books b WHERE b.bookno = :bookno")
    public Books findWithId(@Param("bookno") Long id);

    @Query(value = "SELECT MAX(b.bookno) FROM Books b")
    public Long findMaxId();

    //yazar list
    @Query(value = "SELECT a FROM Author a")
    public List<Author> getAllAuthorList();

    //kitap list
    @Query(value = "SELECT b FROM Books b ")
    public List<Books> getAllBooksList();

    //aciklamaya göre
    @Query(value = "SELECT * FROM books b WHERE b.booktitle like %:booktitle%", nativeQuery = true)
    public List<Books> searchBook(@Param("booktitle") String keyword );

    //kitap ve yazar isime göre
    @Query(value = "SELECT * FROM books b WHERE b.bookname like %:bookname% or like %:author%", nativeQuery = true)
    public List<Books> searchName(@Param("bookname") String keyword );

}
