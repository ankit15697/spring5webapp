package guru.springframework.repositories;

import guru.springframework.domain.Book;
import org.springframework.data.repository.CrudRepository;
/**
 * Create By Ankit Mishra on 14th August 2021
 */
public interface BookRepository extends CrudRepository<Book, Long> {
}
