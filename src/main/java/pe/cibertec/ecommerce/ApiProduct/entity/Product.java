package pe.cibertec.ecommerce.ApiProduct.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import java.math.BigDecimal;
import java.util.Set;
import lombok.Data;

@Data
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String productName;
    private BigDecimal unitPrice;
    
    @ManyToMany
    @JoinTable (name = "Prod_Prove", joinColumns = @JoinColumn (name = "producto_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "proveedor_id", referencedColumnName = "id" ))
    
    private Set<Proveedor> proveedor;
    
}
