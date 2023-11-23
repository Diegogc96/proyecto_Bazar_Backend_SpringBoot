
package com.bazar.bazar.controller;

import com.bazar.bazar.model.Producto;
import com.bazar.bazar.service.IProductoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductoController {
    
    @Autowired
    IProductoService serviProdu;
    
    @PostMapping("/productos/crear")
    public String saveProducto(@RequestBody Producto producto){
        serviProdu.saveProducto(producto);
        return "Producto creado";
    }
    
    @GetMapping("/productos")
    public List<Producto> getProducto(){
        List<Producto> listaProductos=serviProdu.getProducto();
        return listaProductos;
    }
    
    @GetMapping("/productos/{id_producto}")
    public Producto getProductoId(@PathVariable Long id_producto){
        Producto producto=serviProdu.getProductoID(id_producto);
        return producto;
    }
        
    @DeleteMapping("/productos/eliminar/{id_producto}")
    public String deleteProducto(@PathVariable Long id_producto){
        serviProdu.deleteProducto(id_producto);
       return "Producto eliminado";
    }
    
    @PutMapping("/productos/editar/{codigo_producto}")
    public Producto editProducto(@PathVariable Long codigo_producto, @RequestBody Producto producto){
       
       return serviProdu.editProducto(codigo_producto, producto);
        
    }
    
    @GetMapping("/productos/falta_stock")
    public List<Producto> getLowStock(){
    
        return serviProdu.faltaStock();
    }
}
