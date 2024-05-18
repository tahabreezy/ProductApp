package ma.emsi.productapp.Repository;

import ma.emsi.productapp.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Long> {

    @Query("SELECT p FROM Product p WHERE p.Name LIKE %:name%")
    List<Product> findByNameContains(@Param("name") String name);
}
