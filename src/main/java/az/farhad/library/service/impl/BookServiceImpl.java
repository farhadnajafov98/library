package az.farhad.library.service.impl;

import az.farhad.library.entity.*;
import az.farhad.library.enums.EnumAvailableStatus;
import az.farhad.library.exception.ElibraryExceptions;
import az.farhad.library.exception.ExceptionConstant;
import az.farhad.library.repository.BookRepository;
import az.farhad.library.request.ReqBook;
import az.farhad.library.response.RespBook;
import az.farhad.library.response.RespStatus;
import az.farhad.library.response.RespStatusList;
import az.farhad.library.response.Response;
import az.farhad.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    BookRepository bookRepository;

    @Override
    public Response<List<RespBook>> getBookList(ReqBook reqBook) {
        Response<List<RespBook>> response = new Response<>();
        List<RespBook> respBookList;
        try {
            List<Book> bookList = bookRepository.findAllByActive(EnumAvailableStatus.ACTIVE.getValue());
            if (bookList.isEmpty()) {
                throw new ElibraryExceptions(ExceptionConstant.BOOK_NOT_FOUND, "BOOK NOT FOUND");
            }
            respBookList = new ArrayList<>();
            for (Book book : bookList) {
                RespBook respBook = new RespBook();
                respBook.setId(book.getBook_id());
                respBook.setTitle(book.getTitle());
                respBook.setPublisher(book.getPublisher());
                respBook.setEdition(book.getEdition());
                respBook.setCategory(book.getCategory());
                respBook.setQuantity(book.getQuantity());
                respBook.setPrice(book.getPrice());
                respBookList.add(respBook);
                response.setT(respBookList);
                response.setStatus(RespStatus.getSuccessMessage());

            }
        } catch (ElibraryExceptions ex) {
            response.setStatus(new RespStatus(ex.getCode(), ex.getMessage()));

        } catch (Exception exx) {
            exx.printStackTrace();
            response.setStatus(new RespStatus(ExceptionConstant.INTERNAL_EXCEPTION, "INTERNAL EXCEPTION"));


        }

        return response;
    }

    @Override
    public Response<RespBook> getBookById(Long bookId) {
        Response<RespBook> response = new Response<>();

        try {
            if (bookId == null) {
                throw new ElibraryExceptions(ExceptionConstant.INVALID_REQUEST_DATA, "INVALID REQUEST DATA");
            }
            Book book = bookRepository.findBookByIdAndActive(bookId, EnumAvailableStatus.ACTIVE.getValue());
            if (book == null) {
                throw new ElibraryExceptions(ExceptionConstant.BOOK_NOT_FOUND, "BOOK NOT FOUND");

            }
            RespBook respBook = new RespBook();
            respBook.setId(bookId);
            respBook.setTitle(book.getTitle());
            respBook.setPublisher(book.getPublisher());
            respBook.setEdition(book.getEdition());
            respBook.setCategory(book.getCategory());
            respBook.setQuantity(book.getQuantity());
            respBook.setPrice(book.getPrice());
            response.setT(respBook);
            response.setStatus(RespStatus.getSuccessMessage());


        } catch (ElibraryExceptions ex) {
            response.setStatus(new RespStatus(ex.getCode(), ex.getMessage()));
        } catch (Exception exx) {
            exx.printStackTrace();
            response.setStatus(new RespStatus(ExceptionConstant.INTERNAL_EXCEPTION, "INTERNAL EXCEPTION"));
        }
        return response;
    }

    @Override
    public Response<RespBook> getBookByTitle(String bookTitle) {
        Response<RespBook> response = new Response<>();
        try {
            if (bookTitle == null) {
                throw new ElibraryExceptions(ExceptionConstant.INVALID_REQUEST_DATA, "INVALID REQUEST DATA");
            }
            Book book = bookRepository.getBookByTitleAndActive(bookTitle, EnumAvailableStatus.ACTIVE.getValue());
            if (book == null) {
                throw new ElibraryExceptions(ExceptionConstant.BOOK_NOT_FOUND, "BOOK NOT FOUND");
            }
            RespBook respBook = new RespBook();
            respBook.setId(book.getBook_id());
            respBook.setTitle(bookTitle);
            respBook.setEdition(book.getEdition());
            respBook.setPublisher(book.getPublisher());
            respBook.setCategory(book.getCategory());
            respBook.setQuantity(book.getQuantity());
            respBook.setPrice(book.getPrice());
            response.setT(respBook);
            response.setStatus(RespStatus.getSuccessMessage());
        }catch (ElibraryExceptions ex){
            response.setStatus(new RespStatus(ex.getCode(), ex.getMessage()));
        } catch (Exception exx){
            exx.printStackTrace();
            response.setStatus(new RespStatus(ExceptionConstant.INTERNAL_EXCEPTION,"INTERNAL EXCEPTION"));
        }
        return response;
    }

    @Override
    public RespStatusList addBook(ReqBook reqBook) {
        RespStatusList respStatusList = new RespStatusList();
        try {
            Long id = reqBook.getId();
            String title = reqBook.getTitle();
            Publisher publisher = reqBook.getPublisher();
            Edition edition = reqBook.getEdition();
            Category category = reqBook.getCategory();
            Integer quantity = reqBook.getQuantity();
            Integer price = reqBook.getPrice();
            if (id == null || title == null || publisher == null || edition == null || edition == null || category == null || quantity == null || price == null) {
                throw new ElibraryExceptions(ExceptionConstant.INVALID_REQUEST_DATA, "Invalid Request Data");

            }
            Book book = new Book();
            book.setBook_id(id);
            book.setTitle(title);
            book.setPublisher(publisher);
            book.setEdition(edition);
            book.setCategory(category);
            book.setQuantity(quantity);
            book.setPrice(price);
            bookRepository.save(book);
        } catch (ElibraryExceptions ex) {
            respStatusList.setStatus(RespStatus.getSuccessMessage());
        } catch (Exception exx) {
            exx.printStackTrace();
            respStatusList.setStatus(new RespStatus(ExceptionConstant.INTERNAL_EXCEPTION, "INTERNAL EXCEPTION"));
        }


        return respStatusList;
    }

    @Override
    public RespStatusList updateBook(ReqBook reqBook) {
        RespStatusList response = new RespStatusList();
        try{
            Long bookId = reqBook.getId();
            String title = reqBook.getTitle();
            Publisher publisher = reqBook.getPublisher();
            Edition edition = reqBook.getEdition();
            Category category = reqBook.getCategory();
            Integer quantity = reqBook.getQuantity();
            Integer price = reqBook.getPrice();
            if (bookId == null || title == null || publisher == null || edition == null || category == null || quantity == null || price == null) {
                throw new ElibraryExceptions(ExceptionConstant.INVALID_REQUEST_DATA, "Invalid Request Data");
            }
            Book book = bookRepository.findBookByIdAndActive(bookId, EnumAvailableStatus.ACTIVE.getValue());
            if(book==null){
                throw new ElibraryExceptions(ExceptionConstant.BOOK_NOT_FOUND, "BOOK NOT FOUND");
            }
            book.setBook_id(bookId);
            book.setTitle(title);
            book.setPublisher(publisher);
            book.setEdition(edition);
            book.setCategory(category);
            book.setQuantity(quantity);
            book.setPrice(price);
            bookRepository.save(book);

        }catch (ElibraryExceptions ex){
            response.setStatus(new RespStatus(ex.getCode(), ex.getMessage()));

        }catch (Exception exx){
            exx.printStackTrace();
            response.setStatus(new RespStatus(ExceptionConstant.INTERNAL_EXCEPTION, "INTERNAL EXCEPTION"));
        }

        return response;
    }

    @Override
    public RespStatusList deleteBook(Long bookId) {
        RespStatusList response = new RespStatusList();
        try {
            if (bookId==null){
                throw new ElibraryExceptions(ExceptionConstant.INVALID_REQUEST_DATA,"INVALID REQUEST DATA");
            }
            Book book = bookRepository.findBookByIdAndActive(bookId, EnumAvailableStatus.ACTIVE.getValue());
            if(book==null){
                throw new ElibraryExceptions(ExceptionConstant.BOOK_NOT_FOUND,"BOOK NOT FOUND");
            }
            book.setActive(EnumAvailableStatus.DEACTIVE.getValue());
            bookRepository.save(book);
            response.setStatus(RespStatus.getSuccessMessage());
        }catch (ElibraryExceptions ex){
            response.setStatus(new RespStatus(ex.getCode(), ex.getMessage()));
        }catch (Exception exx){
            exx.printStackTrace();
            response.setStatus(new RespStatus(ExceptionConstant.INTERNAL_EXCEPTION, "INTERNAL EXCEPTION"));
        }
        return response;
    }
}
