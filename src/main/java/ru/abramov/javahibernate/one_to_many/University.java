package ru.abramov.javahibernate.one_to_many;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "universities")
public class University implements Serializable {
    public static final long serialVersionUID = -289123754859778673L;

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "title")
    private String title;

    @OneToMany(mappedBy = "university")
    private List<Student> students;

    public University() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return String.format("Student [id=%d, title='%s' , students_count = %d]", id, title,students.size());
    }
}
