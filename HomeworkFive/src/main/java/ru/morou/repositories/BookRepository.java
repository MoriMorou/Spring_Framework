package ru.morou.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import ru.morou.entities.Book;


@Repository
public interface BookRepository extends PagingAndSortingRepository<Book, Integer> {

}
