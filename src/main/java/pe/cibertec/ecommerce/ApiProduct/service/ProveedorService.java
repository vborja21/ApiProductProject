package pe.cibertec.ecommerce.ApiProduct.service;

import java.util.List;
import pe.cibertec.ecommerce.ApiProduct.entity.Proveedor;

public interface ProveedorService {
    
    public List<Proveedor> findAll();
    public Proveedor findById(Long id);
    public Proveedor add(Proveedor proveedor);
    public Proveedor update(Proveedor proveedor);
    public void delete(Long id);
    
}
