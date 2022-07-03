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
@Table(name = "Employee")
@DynamicInsert
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private Long employee_id;
    @Column(name = "name", length = 200)
    private String name;
    @Column(name = "surname", length = 200)
    private String surname;
    @DateTimeFormat(style = "YYYY-MM-DD")
    @Column(name = "dob")
    private Date dob;
    @Column(name="address")
    private String address;
    @Column(name = "contact")
    private Integer contact;
    @ManyToOne
    @JoinColumn(name = "position_id")
    private Position position;
    @Column(name = "salary")
    private Integer salary;
    @Column(name = "data_date")
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataDate;
    @Column(name = "active")
    @ColumnDefault(value = "1")
    private Integer active;

}
