package ru.morou.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.morou.entities.Book;
import ru.morou.services.BookService;


@Controller
@RequestMapping("/list")
public class ListController {
    @Autowired
    private BookService bookService;

    @RequestMapping("")
    public String displayView(final Model uiModel)
    {
        uiModel.addAttribute("books", bookService.findAll());
        uiModel.addAttribute("newBook", new Book());
        return "list-view";
    }
}