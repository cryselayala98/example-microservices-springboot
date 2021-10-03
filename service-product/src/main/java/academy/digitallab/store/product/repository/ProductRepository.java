package academy.digitallab.store.product.repository;


import academy.digitallab.store.product.entity.Category;
import academy.digitallab.store.product.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    /*
    * Todos los productos de una categoría determinada
    * */
    public List<Product> findByCategory(Category category); //automaticamente esto ya se implementa con una query
}
