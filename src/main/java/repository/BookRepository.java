package repository;

import entity.Book2Entity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import entity.Book2Entity;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface BookRepository extends CrudRepository<Book2Entity, Integer> {
    Book2Entity findById(int bookID);
    void deleteById(int id);
//    List<Book2Entity> findByAuthor(String author);
    List<Book2Entity> findByAuthorAndPrice (String author, double price);
//    List<Book2Entity> findByPriceOrNumberOfPage (double price, int numOfPage);
//    List<Book2Entity> findByPriceLessThan (double price);
//    List<Book2Entity> findByPriceGreaterThanEqual (double price);
//    List<Book2Entity> findByNameContaining (String searchWords);
//    Book2Entity findByIsbn (String isbn);
//    List<Book2Entity> findByPublishDateAfter (LocalDate date);
//
//
//    @Query("select b from BookEntity b where b.name like ?1%")
//    List<Book2Entity> getBookNameStartWith (String name);
//    @Query (value = "select * from b where b.price <?1 and b.numberPage >=?2" , nativeQuery = true)
//    List<Book2Entity> getBookWherePriceLessThanAndNumOfPageGreaterThan (double price, int numOfPage);

}
