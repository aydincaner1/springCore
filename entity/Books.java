package com.bitirme.springboot.entity;


import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "books")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Books {

    @Id
    @Column(name = "bookno")
    private Long bookno;

    @Column(name = "bookname")
    private String bookname;

    @Column(name = "booktitle")
    private String booktitle;

    @Column(name = "author")
    private String author;

    @Column(name = "book_aciklama")
    private String bookaciklama;

    @Column(name = "book_year")
    private String bookyear;

    @Column(name = "book_note")
    private String booknote;

   /* @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(
            name = "books",
            joinColumns = { @JoinColumn(name = "book_no") },
            inverseJoinColumns =  { @JoinColumn(name = "auth_id") }
    )
    private List<Author> authors;*/

    @OneToMany(mappedBy = "books", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Author> authors;

}
