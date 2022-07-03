package az.farhad.library.entity;

import lombok.Data;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name="Author")
@DynamicInsert
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="author_id")
    private Long author_id;
    @Column(name = "author_name", length = 200)
    private String author_name;
    @Column(name="author_surname", length = 200)
    private String  author_surname;
    @ManyToMany(mappedBy = "authors")
    private List<Book> books;
    @Column(name = "data_date")
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataDate;
    @Column(name = "active")
    @ColumnDefault(value = "1")
    private Integer active;



}
