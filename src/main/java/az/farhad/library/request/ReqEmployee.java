package az.farhad.library.request;

import az.farhad.library.entity.Position;
import lombok.Data;

import java.util.Date;

@Data
public class ReqEmployee {
    private Long id;
    private String name;
    private String surname;
    private Date dob;
    private String address;
    private Integer contact;
    private Position position;
    private Integer salary;

}
