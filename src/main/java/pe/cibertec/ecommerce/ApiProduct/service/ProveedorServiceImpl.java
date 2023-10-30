package pe.cibertec.ecommerce.ApiProduct.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.cibertec.ecommerce.ApiProduct.dao.ProveedorRepository;
import pe.cibertec.ecommerce.ApiProduct.entity.Proveedor;
import pe.cibertec.ecommerce.ApiProduct.exception.EntityNotFoundException;

@Service
public class ProveedorServiceImpl implements ProveedorService {

    @Autowired

    private ProveedorRepository proveedorRepository;

    @Override
    public List<Proveedor> findAll() {

        return (List<Proveedor>) proveedorRepository.findAll();

    }

    @Override
    public Proveedor findById(Long id) {
        return proveedorRepository
                .findById(id)
                .orElseThrow(()
                        -> new EntityNotFoundException("Product not found with id " + id.toString()));
    }

    @Override
    public Proveedor add(Proveedor proveedor) {

        return proveedorRepository.save(proveedor);

    }

    @Override
    public Proveedor update(Proveedor proveedor) {

        var proveedorDB = proveedorRepository.findById(proveedor.getId()).get();
        proveedorDB.setRUC(proveedor.getRUC());
        proveedorDB.setNameEmpresa(proveedor.getNameEmpresa());
        return proveedorRepository.save(proveedorDB);

    }

    @Override
    public void delete(Long id) {

        var proveedorDB = proveedorRepository.findById(id).get();
        proveedorRepository.delete(proveedorDB);

    }

}
