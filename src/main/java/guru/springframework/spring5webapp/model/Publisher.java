package guru.springframework.spring5webapp.model;

import javax.persistence.*;

/**
 * Created by jt on 5/17/17.
 */
@Entity
public class Publisher {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String address;

    @OneToOne
    private Book book;

    @ManyToOne
    private PublisherGroupCpmpany publisherGroupCpmpany;

    public Publisher(String name, String address, Book book) {
        this.name = name;
        this.address = address;
        this.book = book;
    }

    public Publisher(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public Publisher() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public PublisherGroupCpmpany getPublisherGroupCpmpany() {
        return publisherGroupCpmpany;
    }

    public void setPublisherGroupCpmpany(PublisherGroupCpmpany publisherGroupCpmpany) {
        this.publisherGroupCpmpany = publisherGroupCpmpany;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Publisher publisher = (Publisher) o;

        return id != null ? id.equals(publisher.id) : publisher.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Publisher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
