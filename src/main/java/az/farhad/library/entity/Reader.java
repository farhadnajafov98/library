package az.farhad.library.entity;

import lombok.Data;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name="Reader")
@DynamicInsert
public class Reader {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="reader_id")
    private Long reader_id;
    @Column(name="name", length = 200)
    private String name;
    @Column(name = "surname", length = 200)
    private String surname;
    @Column(name = "dob")
    @DateTimeFormat(style = "YYYY-MM-DD")
    private Date dob;
    @Column(name="address")
    private String address;
    @Column(name = "contact")
    private Integer contact;
    @Column(name = "data_date")
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataDate;
    @Column(name = "active")
    @ColumnDefault(value = "1")
    private Integer active;


}
