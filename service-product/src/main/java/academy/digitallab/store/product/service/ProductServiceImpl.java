package academy.digitallab.store.product.service;

import academy.digitallab.store.product.entity.Category;
import academy.digitallab.store.product.entity.Product;
import academy.digitallab.store.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    //@Autowired
    private final ProductRepository productRepository; //para pasar este dato por constructor

    @Override
    public List<Product> listAllProduct() {
        return productRepository.findAll();
    }

    @Override
    public Product getProduct(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public Product createProduct(Product product) {
        product.setStatus("CREATED");
        product.setCreatedAt(new Date());

        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(Product product) {
        Product productQuery = getProduct(product.getId());

        if(productQuery == null){
            return null;
        }

        productQuery.setName(product.getName());
        productQuery.setDescription(product.getDescription());
        productQuery.setCategory(product.getCategory());
        productQuery.setPrice(product.getPrice());

        return productRepository.save(productQuery);
    }

    @Override
    public Product deleteProduct(Long id) {
        Product productQuery = getProduct(id);

        if(productQuery == null){
            return null;
        }

        productQuery.setStatus("DELETED");

        return productRepository.save(productQuery);
    }

    @Override
    public List<Product> findByCategory(Category category) {
        return productRepository.findByCategory(category);
    }

    @Override
    public Product updateStock(Long id, Double quantity) {
        Product productQuery = getProduct(id);

        if(productQuery == null){
            return null;
        }
        Double stock = productQuery.getStock() + quantity;
        productQuery.setStock(stock);

        return productRepository.save(productQuery);
    }
}
