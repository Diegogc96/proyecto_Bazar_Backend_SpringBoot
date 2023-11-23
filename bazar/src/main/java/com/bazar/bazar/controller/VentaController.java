
package com.bazar.bazar.controller;

import com.bazar.bazar.dto.ClienteVentaProductoDTO;
import com.bazar.bazar.model.Producto;
import com.bazar.bazar.model.Venta;
import com.bazar.bazar.service.IVentaService;
import java.time.LocalDate;
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
public class VentaController {
    
    @Autowired
    IVentaService serviVenta;
    
    @PostMapping("/ventas/crear")
    public String saveVentas(@RequestBody Venta venta){
        serviVenta.saveVenta(venta);
        return "Venta creada";
    }
    
    @GetMapping("/ventas/traer")
    public List<Venta> getVentas(){
        return serviVenta.getVenta();
    }
    
    @GetMapping("/ventas/{codigo_venta}")
    public Venta getVentasId(@PathVariable Long codigo_venta){
        return serviVenta.getVentaID(codigo_venta);
    }
    
    @DeleteMapping("/ventas/eliminar/{codigo_venta}")
    public String deleteVentas(@PathVariable Long codigo_venta){        
    serviVenta.deleteVenta(codigo_venta);
    return "Venta eliminada";
    }
    
    @PutMapping("/ventas/editar/{codigo_venta}")
    public Venta editVentas(@PathVariable Long codigo_venta,@RequestBody Venta venta){
      return serviVenta.editVenta(codigo_venta, venta);
    }
    
    @GetMapping("/ventas/productos/{codigo_venta}")
    public List<Producto> listIdVenta(@PathVariable Long codigo_venta){
        return serviVenta.getListaVenta(codigo_venta);
    }
    
    @GetMapping("/ventas/fecha/{fecha_venta}")
    public String totalFecha(@PathVariable LocalDate fecha_venta){
        return "El total de la fecha: "+ fecha_venta + " es de: "+ serviVenta.totalDia(fecha_venta); 
    } 

    @GetMapping("/ventas/mayor_venta")
    public ClienteVentaProductoDTO mayorVenta(){
        return serviVenta.clienteVentaProducto();
    }
}
