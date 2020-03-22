package ru.abramov.javahibernate.many_to_many;

import javax.persistence.*;
import java.util.List;

@Entity
@Table (name = "readers")
public class Reader {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column (name = "name")
    private String name;

    @ManyToMany
    @JoinTable(
            name = "books_readers",
            joinColumns = @JoinColumn(name = "reader_id"),
            inverseJoinColumns = @JoinColumn( name = "book_id")
    )
    private List<Book> books;

    public Reader() {
    }

    @Override
    public String toString() {
        return String.format("Reader [id=%d, name='%s']", id, name);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
