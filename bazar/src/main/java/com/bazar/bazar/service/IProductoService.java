
package com.bazar.bazar.service;

import com.bazar.bazar.model.Producto;
import java.util.List;


public interface IProductoService {
    
    public void saveProducto(Producto producto);
    
    public List<Producto> getProducto();
    
    public void deleteProducto(Long id_producto);
    
    public Producto editProducto(Long id_producto, Producto producto_nuevo);
    
    public Producto getProductoID(Long id_producto);
    
    public List<Producto> faltaStock();
        
    
}
