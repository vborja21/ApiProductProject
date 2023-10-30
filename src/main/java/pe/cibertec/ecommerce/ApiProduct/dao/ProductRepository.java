package pe.cibertec.ecommerce.ApiProduct.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.cibertec.ecommerce.ApiProduct.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
    
    Product findByProductName(String productName);
    
}
