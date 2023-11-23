
package com.bazar.bazar.service;

import com.bazar.bazar.dto.ClienteVentaProductoDTO;
import com.bazar.bazar.model.Producto;
import com.bazar.bazar.model.Venta;
import java.time.LocalDate;
import java.util.List;


public interface IVentaService {
    
    public void saveVenta(Venta venta);
    
    public List<Venta> getVenta();
    
    public void deleteVenta(Long id_venta);
    
    public Venta editVenta(Long id_venta, Venta venta_nuevo);
    
    public Venta getVentaID(Long id_venta);
   
    public List<Producto> getListaVenta(Long codigo_venta);
        
    public double totalDia(LocalDate fecha);
    
    public ClienteVentaProductoDTO clienteVentaProducto();
}
