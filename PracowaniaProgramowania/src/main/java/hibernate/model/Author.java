package hibernate.model;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="refId", scope=Author.class)
@Entity
@Table(name = "Authors", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"id"})})
public class Author {

    @Id @GeneratedValue
    @Column(name="id")
    private int id;

    @Column(name="last_name")
    private String last_name;

    @Column(name="country")
    private String country;

    @Column(name="birth")
    private String birth;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="BOOK_ID", referencedColumnName = "book_id")
    Book book;

    @ManyToMany(mappedBy = "subcategories", cascade = CascadeType.ALL)
    private List<Author> categories = new ArrayList<Author>();

    @ManyToMany(cascade = CascadeType.ALL)
    private List<Author> subcategories = new ArrayList<>();


    public Author() {}

    public List<Author> getCategories() {
        return categories;
    }

    public void setCategories(List<Author> categories) {
        this.categories=categories;
    }

    public List<Author> getSubcategories() {
        return subcategories;
    }

    public void setSubcategories(List<Author> subcategories) {
        this.subcategories=subcategories;
    }

    public int getId() {
        return id;
    }

    public void setId(int Id_author) {
        this.id=Id_author;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String Last_name) {
        this.last_name=Last_name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String Country) {
        this.country=Country;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String Birth) {
        this.birth=Birth;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book=book;
    }

}
