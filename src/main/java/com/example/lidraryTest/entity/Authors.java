package com.example.lidraryTest.entity;

import jakarta.persistence.*;
import org.springframework.lang.NonNull;

import java.util.List;

@Entity
@Table(name = "AUTHORS")
//@SecondaryTable(name = "BOOKS")

public class Authors {
    @Id
    @NonNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "F_NAME")
    private String firstName;

    @Column(name = "L_NAME")
    private String lastName;

    @OneToMany(mappedBy = "idAuthor")
    private List<Books> books;

    public Authors( String firstName, String lastName) {
        //this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Authors() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setFirstName(String first_name) {
        this.firstName = first_name;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setLastName(String last_name) {
        this.lastName = last_name;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return "Authors{" +
                "id=" + getId() +
                ", firstName='" + getFirstName() + '\'' +
                ", lastName='" + getLastName() + '\'' +
                '}';
    }

}
