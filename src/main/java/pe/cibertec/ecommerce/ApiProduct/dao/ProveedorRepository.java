package pe.cibertec.ecommerce.ApiProduct.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.cibertec.ecommerce.ApiProduct.entity.Proveedor;

public interface ProveedorRepository extends JpaRepository<Proveedor, Long> {
    
}
