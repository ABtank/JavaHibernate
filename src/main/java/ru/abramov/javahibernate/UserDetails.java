package ru.abramov.javahibernate;

import javax.persistence.*;

@Entity
@Table(name ="users_details")
public class UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "email")
    private String email;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Column(name = "city")
    private String city;

    public UserDetails() {
    }

    @OneToOne(mappedBy = "details")
    private User user;

    @Override
    public String toString() {
        /*return "Item{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", price=" + price +
                '}';*/
        return String.format("Item [id=%d, email='%s', city=%s]", id, email, city);
    }
}
