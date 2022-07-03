package az.farhad.library.response;

import az.farhad.library.entity.Author;
import az.farhad.library.entity.Category;
import az.farhad.library.entity.Edition;
import az.farhad.library.entity.Publisher;
import lombok.Data;

@Data
public class RespBook {
    private Long id;
    private String title;
    private Publisher publisher;
    private Edition edition;
    private Category category;
    private Author author;
    private Integer quantity;
    private Integer price;
}
