package ru.morou.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.morou.entities.Book;
import ru.morou.repositories.BookRepository;


import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class BookService
{
    @Autowired
    private BookRepository bookRepository;

    @PostConstruct
    private void init()
    {
        boolean emptySet = true;
        for(final Book book : bookRepository.findAll())
        {
            emptySet = false;
            break;
        }

        if(emptySet)
        {
            String randomNames[] = {
                    "The Machine the Ticket Spoke",
                    "John, the Inheritance West",
                    "The North's Air",
                    "Legion Owning",
                    "Circle Burning"
            };

            final Random randomGenerator = new Random();
            for(final String name : randomNames)
            {
                final Book book = new Book();
                book.setName(name);
                book.setIssueDate(new Date(1000 * randomGenerator.nextInt(1558079353) + 1));
                save(book);
            }
        }
    }

    public List<Book> findAll()
    {
        return (List<Book>)bookRepository.findAll();
    }

    public void save(final Book book)
    {
        bookRepository.save(book);
    }

    public void delete(final Book book)
    {
        bookRepository.deleteById(book.getId());
    }

    public Book findOne(final int id) {
        Optional<Book> book = bookRepository.findById(id);
        return book.orElse(null);
    }
}
