package guru.springframework.spring5webapp.model;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
public class PublisherGroupCpmpany {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<Publisher> publisher;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Publisher> getPublisher() {
        return publisher;
    }

    public void setPublisher(Set<Publisher> publisher) {
        this.publisher = publisher;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PublisherGroupCpmpany that = (PublisherGroupCpmpany) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }
}
