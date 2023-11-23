
package com.bazar.bazar.service;

import com.bazar.bazar.model.Producto;
import com.bazar.bazar.repository.IProductoRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoService implements IProductoService{

    @Autowired
    IProductoRepository repoProducto;
    
    @Override
    public void saveProducto(Producto producto) {
        repoProducto.save(producto);
    }

    @Override
    public List<Producto> getProducto() {
        List<Producto> listaProducto= repoProducto.findAll();
        return listaProducto;
    }

    @Override
    public void deleteProducto(Long id_producto) {
        repoProducto.deleteById(id_producto);
    }

    @Override
    public Producto editProducto(Long id_producto, Producto producto_nuevo) {
        Producto producto=this.getProductoID(id_producto);
        producto.setNombre(producto_nuevo.getNombre());
        producto.setMarca(producto_nuevo.getMarca());
        producto.setCosto(producto_nuevo.getCosto());
        producto.setCantidad_disponible(producto_nuevo.getCantidad_disponible());
        producto.setCodigo_producto(producto_nuevo.getCodigo_producto());
        
        this.saveProducto(producto);
        
        return producto;
    }

    @Override
    public Producto getProductoID(Long id_producto) {
        Producto producto=repoProducto.findById(id_producto).orElse(null);

        return producto;
    }

    @Override
    public List<Producto> faltaStock() {
        List<Producto> listadoGeneral = this.getProducto();
        List<Producto> listadoLowStock = new ArrayList<Producto>();
        
        for (Producto producto : listadoGeneral) {
            if(producto.getCantidad_disponible()<5){
                listadoLowStock.add(producto);
            }
        }
        return listadoLowStock;
    }

    
    
    
    
}
