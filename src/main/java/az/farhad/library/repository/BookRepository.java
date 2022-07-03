package az.farhad.library.repository;

import az.farhad.library.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findAllByActive(Integer active);

    Book findBookByIdAndActive(Long id, Integer active);

    @Query(value = "select  * from farhad1998db.book b where  b.title=:title and b.active=1 ", nativeQuery = true)
    Book getBookByTitleAndActive(String title,Integer active );
}
