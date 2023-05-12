package com.example.lidraryTest.controller;

import com.example.lidraryTest.entity.Authors;
import com.example.lidraryTest.entity.Books;
import com.example.lidraryTest.repository.AuthorRep;
import com.example.lidraryTest.repository.BookRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@Controller
public class BookController {
    @Autowired
    private BookRep bookRep;
    @Autowired
    private AuthorRep authorRep;
    @RequestMapping(value = "/book")
    public String hello(Model model) {
        Iterable<Books> allB = bookRep.findAll();

        //StringBuilder books = new StringBuilder();
        //allB.forEach(b -> books.append(b.getIdAuthor().getFirstName()));
        //Iterable<Books> allB = bookRep.findByBookNameLike("ADVENTURE HARRY");
        //System.out.println(allB);

        model.addAttribute("books", allB);
        return "books";
    }
    @RequestMapping(value = "/addBooks")
    public String addB(Model model){
        Iterable<Authors> authorsList = authorRep.findAll();
        //StringBuilder aLists = new StringBuilder();
        //authorsList.forEach(a->aLists.append(a.getFirstName()).append(" ").append(a.getLastName()));
        model.addAttribute("authorsLists", authorsList);
        return "addBook";
    }
    @PostMapping("/addBooks")
    public String postBooks(@RequestParam String bookName, @RequestParam Authors idAuthor, Model model){
        Books books1 = new Books(bookName, idAuthor);
        bookRep.save(books1);
        return "redirect:/book";
    }
}
