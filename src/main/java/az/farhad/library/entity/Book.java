package az.farhad.library.entity;

import lombok.Data;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Flow;

@Data
@Entity
@Table(name = "Book")
@DynamicInsert
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="book_id")
    private Long book_id;
    @Column(name="title", length =200)
    private String title;
    @ManyToOne
    @JoinColumn(name = "publisher_id")
    private Publisher publisher;

    @ManyToOne
    @JoinColumn(name = "edition_id")
    private Edition edition;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
    @ManyToMany
    @JoinTable(name="Book_Author", joinColumns = @JoinColumn(name="book_id"), inverseJoinColumns = @JoinColumn(name="author_id"))
    private List<Author> authors;
    @Column(name="quantity")
    private Integer quantity;
    @Column(name="price")
    private Integer price;
    @Column(name = "data_date")
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataDate;
    @Column(name = "active")
    @ColumnDefault(value = "1")
    private Integer active;

    @Override
    public String toString() {
        return "Book{" +
                "book_id=" + book_id +
                ", title='" + title + '\'' +
                ", publisher=" + publisher +
                ", edition=" + edition +
                ", category=" + category +
                ", authors=" + authors +
                ", quantity=" + quantity +
                ", price=" + price +
                ", dataDate=" + dataDate +
                ", active=" + active +
                '}';
    }
}
