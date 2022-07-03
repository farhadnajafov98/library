package az.farhad.library.service;

import az.farhad.library.entity.Book;
import az.farhad.library.request.ReqBook;
import az.farhad.library.response.RespBook;
import az.farhad.library.response.RespStatus;
import az.farhad.library.response.RespStatusList;
import az.farhad.library.response.Response;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface BookService {
    Response<List<RespBook>> getBookList(ReqBook reqBook);
    Response<RespBook> getBookById(Long bookId);
    Response<RespBook> getBookByTitle(String bookTitle);
    RespStatusList addBook(ReqBook reqBook);
    RespStatusList updateBook(ReqBook reqBook);
    RespStatusList deleteBook(Long bookId);

}
