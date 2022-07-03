package az.farhad.library.request;

import lombok.Data;

import java.util.Date;

@Data
public class ReqReader {
    private Long id;
    private String name;
    private String surname;
    private Date dob;
    private String address;
    private Integer contact;


}
