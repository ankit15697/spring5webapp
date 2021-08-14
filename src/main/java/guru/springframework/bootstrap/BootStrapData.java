package guru.springframework.bootstrap;

import guru.springframework.domain.Author;
import guru.springframework.domain.Book;
import guru.springframework.domain.Publisher;
import guru.springframework.repositories.AuthorRepository;
import guru.springframework.repositories.BookRepository;
import guru.springframework.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
/**
 * Create By Ankit Mishra on 14th August 2021
 */
@Component
public class BootStrapData implements CommandLineRunner {
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;
    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Publisher publisher = new Publisher();
        publisher.setName("Raj Kamal");
        publisher.setCity("Kanpur");
        publisher.setAddressLine("Pared");
        publisher.setState("Uttar Pradesh");
        publisher.setZipCode("208001");
        // have to save publisher before using it for other object
        publisherRepository.save(publisher);

        Author ankit = new Author("Ankit", "Mishra");
        Book cBook = new Book("C Programming", "123");

        ankit.getBooks().add(cBook);
        cBook.getAuthors().add(ankit);
        cBook.setPublisher(publisher);
        publisher.getBooks().add(cBook);
        authorRepository.save(ankit);
        bookRepository.save(cBook);
        publisherRepository.save(publisher);

        Author rahul = new Author("Rahul", "Kumar");
        Book j2EE = new Book("Head first java", "321");
        rahul.getBooks().add(j2EE);
        j2EE.getAuthors().add(rahul);
        j2EE.setPublisher(publisher);
        publisher.getBooks().add(j2EE);
        authorRepository.save(rahul);
        bookRepository.save(j2EE);
        publisherRepository.save(publisher);
        System.out.println("Started Boot !!!");
        System.out.println("Number of books : " +bookRepository.count());
        System.out.println("Publisher : " + publisherRepository.count());
    }
}
