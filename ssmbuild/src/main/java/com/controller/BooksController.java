package com.controller;

import com.pojo.Books;
import com.service.BookServiceImpl;
import com.service.Bookservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.swing.*;
import java.util.List;

@Controller
@RequestMapping("/book")
public class BooksController {
    @Autowired
    @Qualifier("BookServiceImpl")
    private Bookservice bookService;

    @RequestMapping("/allBook")
    public String list(Model model) {
        List <Books> list = bookService.queryAllBook();
        model.addAttribute("list", list);
        return "allBook";
    }

    @RequestMapping("/toAddBook")
    public String toaddBook(){
        return "addBook";
    }

    @RequestMapping("/addBook")
    public String addPaper(Books books){
        System.out.println(books);
        bookService.addBook(books);
        return "redirect:/book/allBook";
    }

    @RequestMapping("/toUpdateBook")
    public String toupdateBook(Model model,int id){
        Books books = bookService.queryBookById(id);
        System.out.println(books);
        model.addAttribute("books" , books);
        return "UpdateBook";
    }
    @RequestMapping("/update")
    public String updateBook(Books books){
        bookService.updateBook(books);
        System.out.println(books);
        return "redirect:/book/allBook";
    }

    @RequestMapping("/del/{bookId}")
    public String deleteBook(@PathVariable("bookId") int id) {
        bookService.deleteBookById(id);
        return "redirect:/book/allBook";
    }

}
