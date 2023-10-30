
package pe.cibertec.ecommerce.ApiProduct.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import pe.cibertec.ecommerce.ApiProduct.dao.ProductRepository;
import pe.cibertec.ecommerce.ApiProduct.entity.Product;
import pe.cibertec.ecommerce.ApiProduct.exception.EntityNotFoundException;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;
    
    @Override
    public List<Product> findAll() {
        return (List<Product>) productRepository.findAll();
    }

    @Override
    public Product findById(Long id) {
        return productRepository
          .findById(id)
          .orElseThrow(()->
          new EntityNotFoundException("Product not found with id "+id.toString()));
    }

    @Override
    public Product add(Product product) {
       return productRepository.save(product);
    }

    @Override
    public Product update(Product product) {
        var productDB = productRepository.findById(product.getId()).get();
        productDB.setProductName(product.getProductName());
        productDB.setUnitPrice(product.getUnitPrice());
        return productRepository.save(productDB);
    }

    @Override
    public void delete(Long id) {
        var productDB = productRepository.findById(id).get();
        productRepository.delete(productDB);
    }

    @Override
    public Page<Product> findAll(int page, int size) {
        return 
        productRepository
        .findAll(PageRequest.of(page, size));
    }

    @Override
    public Product findByProductName(String productName) {
        return productRepository.findByProductName(productName);
    }
    
}
