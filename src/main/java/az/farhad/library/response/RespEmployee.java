package az.farhad.library.response;

import az.farhad.library.entity.Position;
import lombok.Data;

import java.util.Date;

@Data
public class RespEmployee {
    private Long id;
    private String name;
    private String surname;
    private Date dob;
    private String address;
    private Integer contact;
    private Position position;
    private Integer salary;
}
