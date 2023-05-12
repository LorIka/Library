package com.example.lidraryTest.entity;

import jakarta.persistence.*;

@Entity
@Table(name ="BOOKS")
public class Books {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name="NAME_BOOK")
    private String bookName;

    @ManyToOne
    @JoinColumn(name = "ID_AUTHOR")
    private Authors idAuthor;
    public Books(String bookName, Authors idAuthor) {
        this.bookName = bookName;
        this.idAuthor = idAuthor;
    }
    public Books(){}

    //set&get
    public Long getId() {
        return id;
    }

    public String getBookName() {
        return bookName;
    }

    public Authors getIdAuthor() {
        return idAuthor;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public void setIdAuthor(Authors idAuthor) {
        this.idAuthor = idAuthor;
    }

    @Override
    public String toString() {
        return "Books{" +
                "id=" + id +
                ", bookName='" + bookName + '\'' +
                ", authorId='" + idAuthor + '\'' +
                '}';
    }
}
