package repository;

import entity.CustomerEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends CrudRepository<CustomerEntity, Integer> {
//    List<CustomerEntity> findAll();
//
//        Optional<CustomerEntity> findById(Integer id);

//    List<CustomerEntity> findByName(String name);
//
//   List<CustomerEntity> findByPhoneOrEmail(int phone, String email);

    @Query("SELECT b FROM CustomerEntity b WHERE b.sex = :sex AND (YEAR(CURRENT_DATE) - YEAR(b.publishDate)) BETWEEN 20 AND 30")
    List<CustomerEntity> findMenAgedBetween20And30(@Param("sex") String sex);

}
