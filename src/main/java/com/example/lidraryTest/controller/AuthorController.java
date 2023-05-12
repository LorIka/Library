package com.example.lidraryTest.controller;

import com.example.lidraryTest.entity.Authors;
import com.example.lidraryTest.entity.Books;
import com.example.lidraryTest.repository.AuthorRep;
import com.zaxxer.hikari.util.SuspendResumeLock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class AuthorController {
    @Autowired
    private AuthorRep authorRep;

    @RequestMapping(value = "/author")
    public String hello(Model model) {
        Iterable<Authors> all = authorRep.findAll();
        //StringBuilder authors = new StringBuilder();
        //all.forEach(b -> authors.append(b.getFirstName()).append(" ").append(b.getLastName()).append(";<br>"));
        model.addAttribute("authors", all);
        return "authors";
    }

    @RequestMapping(value = "/addAuthors")
    public String addA() {
        return "addAuthor";
    }

    @PostMapping("/addAuthors")
    public String postAuthors(@RequestParam String firstName, @RequestParam String lastName) {
        List<Long> allID = authorRep.findById();
        System.out.println(allID);
        Authors a2 = new Authors();
        long c = authorRep.count();
        try {
            if (c != 0) {
                a2.setFirstName(firstName);
                a2.setLastName(lastName);
                authorRep.save(a2);
                System.out.println(a2);
                return "redirect:/author";
            }
            System.out.println(a2);
            return "redirect:/author";
        } catch (Exception exception) {
            exception.getMessage();
            System.out.println(c);
            return "redirect:/author";
        }
        //Authors authors = new Authors(firstName, lastName);

        //authorRep.save(authors);

        //return "redirect:/author";
    }
}
