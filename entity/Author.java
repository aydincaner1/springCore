package com.bitirme.springboot.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.awt.print.Book;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "authors")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "auth_id")
    private Long authorid;

    @Column(name = "auth_name")
    private String authorname;

   /* @ManyToMany(mappedBy = "authors", fetch = FetchType.LAZY)
    private List<Books> books; */

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author")
    private Books books;
}
