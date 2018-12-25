package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.model.Author;
import guru.springframework.spring5webapp.model.Book;
import guru.springframework.spring5webapp.model.Publisher;
import guru.springframework.spring5webapp.model.PublisherGroupCpmpany;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherGroupCpmpanyRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by jt on 5/16/17.
 */
@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;
    private PublisherGroupCpmpanyRepository publisherGroupCpmpanyRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository, PublisherGroupCpmpanyRepository publisherGroupCpmpanyRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
        this.publisherGroupCpmpanyRepository = publisherGroupCpmpanyRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData(){

        Publisher publisher = new Publisher();
        publisher.setName("foo");
        publisher.setAddress("12th Street, LA");
       // publisherRepository.save(publisher);
        publisherRepository.save(publisher);

        Publisher publisher2 = new Publisher();
        publisher2.setName("Ankara Yayıncılık");
        publisher2.setAddress("Ankara");
        // publisherRepository.save(publisher);
        publisherRepository.save(publisher2);



        //Eric
        Author eric = new Author("Eric", "Evans");
       // Author egemen= new Author("Egemen","Ozkan");
        Set<Author> authorliste=new HashSet<>(Arrays.asList(eric));
        Book  ddd = new Book("Domain Driven Design", "1234", publisher,authorliste);
       // ddd.setAuthors(authorliste);
       // ddd.setPublisher(publisher);
        Set<Book> bookliste=new HashSet<>(Arrays.asList(ddd));
        publisher.setBook(ddd);
        eric.setBooks(bookliste);

       // eric.getBooks().add(ddd);
        //ddd.getAuthors().add(eric);


        authorRepository.save(eric);
        //bookRepository.save(ddd);
       // publisherRepository.save(publisher);
       // publisherRepository.save(publisher2);
       /*
        //Rod

        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development without EJB", "23444", publisher );
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);
        authorRepository.save(rod);
      //  bookRepository.save(noEJB);
        */

        PublisherGroupCpmpany Idefix =new PublisherGroupCpmpany();
        Idefix.setName("Idefix Publish House");
        publisherGroupCpmpanyRepository.save(Idefix);

        publisher.setPublisherGroupCpmpany(Idefix);
        publisherRepository.save(publisher);

        PublisherGroupCpmpany Kitapyurdu =new PublisherGroupCpmpany();
        Kitapyurdu.setName("Kitapyurdu Publish House");
        publisherGroupCpmpanyRepository.save(Kitapyurdu);

        publisher2.setPublisherGroupCpmpany(Kitapyurdu);
        publisherRepository.save(publisher2);

        HashSet<Publisher> publishers1= new HashSet<>();
        publishers1.add(publisher);
        Kitapyurdu.setPublisher(publishers1);
        publisherGroupCpmpanyRepository.save(Kitapyurdu);

        HashSet<Publisher> publishers2= new HashSet<>();
        publishers2.add(publisher2);
        Idefix.setPublisher(publishers2);
        publisherGroupCpmpanyRepository.save(Idefix);





        System.out.println("DENEME");

        System.out.println(Kitapyurdu.getPublisher());

        System.out.println("DENEME2");

        System.out.println(Idefix.getPublisher());


    }
}
