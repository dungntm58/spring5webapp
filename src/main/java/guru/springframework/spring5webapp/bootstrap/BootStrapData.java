package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

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
        System.out.println("Started in Boostrap");
        Publisher publisher = new Publisher("XL Foundation", null, "Hanoi", "CLGT", null);
        publisherRepository.save(publisher);
        System.out.println("Number of publishers: " + publisherRepository.count());

        Author robert = new Author("Robert", "Nguyen");
        Book xl = new Book("XamlozisReal", "123123");
        robert.getBooks().add(xl);
        xl.getAuthors().add(robert);
        xl.setPublisher(publisher);

        publisher.getBooks().add(xl);

        authorRepository.save(robert);
        bookRepository.save(xl);
        publisherRepository.save(publisher);

        Author rod = new Author("Rod", "Wesley");
        Book xl2 = new Book("XamlozisReal2", "123124");
        rod.getBooks().add(xl2);
        xl2.getAuthors().add(rod);
        xl2.setPublisher(publisher);

        publisher.getBooks().add(xl2);

        authorRepository.save(rod);
        bookRepository.save(xl2);
        publisherRepository.save(publisher);

        System.out.println("Number of books: " + bookRepository.count());
        System.out.println("Publisher book count: " + publisher.getBooks().size());
    }
}
