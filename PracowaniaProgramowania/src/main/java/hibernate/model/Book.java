package hibernate.model;

import javax.persistence.*;
import javax.security.auth.login.CredentialException;

@Entity
@Table(name ="Books", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"book_id"})})
public class Book {

    @Id @GeneratedValue(generator = "gen")
    @SequenceGenerator(name="gen", sequenceName = "author_seq")
    @Column(name ="book_id")
    private int book_id;

    @Column(nullable = false, name="author")
    private String author;

    @Column(nullable = false, name="title")
    private String title;

    @Column(name ="price")
    private int price;

    @Column(name ="created")
    private String created;

    public Book() {}

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int id) {
        this.book_id=id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String Author) {
        this.author=Author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String Title) {
        this.title=Title;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int Price) {
        this.price=Price;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }
}
