package guru.springframework.repositories;
import guru.springframework.domain.Author;
import org.springframework.data.repository.CrudRepository;
/**
 * Create By Ankit Mishra on 14th August 2021
 */
public interface AuthorRepository extends CrudRepository<Author, Long> {
}
