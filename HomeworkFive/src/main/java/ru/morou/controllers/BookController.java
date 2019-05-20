package ru.morou.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.morou.entities.Book;
import ru.morou.services.BookService;

@Controller
@RequestMapping("/element")
public class BookController
{
    @Autowired
    private BookService bookService;

    @Autowired
    private ListController listController;

    @GetMapping("/edit")
    private String edit(final Model uiModel, final @RequestParam int bookId)
    {
        //Ищем книгу по ID в репозитории
        final Book book = bookService.findOne(bookId);
        if(book == null)
        {
            //если не находим - возвращаемся на страницу со списком книг
            return listController.displayView(uiModel);
        }
        else
        {
            //если находим - переходим на страницу редактирования
            uiModel.addAttribute("book", book);
            return "element-view";
        }
    }

    @GetMapping("/delete")
    private String delete(final Model uiModel, final @RequestParam int bookId)
    {
        //Ищем книгу по ID в репозитории
        final Book book = bookService.findOne(bookId);

        //Если книга найдена - удаляем
        if(book != null) bookService.delete(book);

        //возвращаемся на страницу со списком книг
        return listController.displayView(uiModel);
    }

    @PostMapping("/save")
    private String save(final Model uiModel, final @ModelAttribute Book book)
    {
        bookService.save(book);
        return listController.displayView(uiModel);
    }
}
