package az.farhad.library.response;

import lombok.Data;

import java.util.Date;

@Data
public class RespReader {
    private Long id;
    private String name;
    private String surname;
    private Date dob;
    private String address;
    private Integer contact;
}
