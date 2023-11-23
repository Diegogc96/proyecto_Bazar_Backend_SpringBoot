
package com.bazar.bazar.service;

import com.bazar.bazar.dto.ClienteVentaProductoDTO;
import com.bazar.bazar.model.Producto;
import com.bazar.bazar.model.Venta;
import com.bazar.bazar.repository.IVentaRepository;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VentaService implements IVentaService{

    @Autowired
    IVentaRepository ventaRepo;
    
    @Override
    public void saveVenta(Venta venta) {
        ventaRepo.save(venta);
    }

    @Override
    public List<Venta> getVenta() {
        return ventaRepo.findAll();
    }

    @Override
    public void deleteVenta(Long id_venta) {
        ventaRepo.deleteById(id_venta);
    }

    @Override
    public Venta editVenta(Long id_venta, Venta venta_nuevo) {
        Venta venta= this.getVentaID(id_venta);
        venta.setCodigo_venta(venta_nuevo.getCodigo_venta());
        venta.setFecha_venta(venta_nuevo.getFecha_venta());
        venta.setListaProductos(venta_nuevo.getListaProductos());
        venta.setTotal(venta_nuevo.getTotal());
        venta.setUnCliente(venta_nuevo.getUnCliente());
        
        this.saveVenta(venta);
        
        return venta;
    }

    @Override
    public Venta getVentaID(Long id_venta) {
        return ventaRepo.findById(id_venta).orElse(null);
    }

    @Override
    public List<Producto> getListaVenta(Long codigo_venta) {
        List<Venta> listaVentas= this.getVenta();
        List<Producto>listaProducto=new ArrayList<Producto>();
        Venta ventaRar = null;
        
        for (Venta venta :listaVentas) {
            if(Objects.equals(venta.getCodigo_venta(), codigo_venta)){
                ventaRar=venta;
            }
        }
        for(Producto producto : ventaRar.getListaProductos()){
            Producto productoEspecifico=new Producto();
            
            productoEspecifico.setNombre(producto.getNombre());
            productoEspecifico.setCodigo_producto(producto.getCodigo_producto());
            productoEspecifico.setNombre(producto.getNombre());
            productoEspecifico.setCosto(producto.getCosto());
            productoEspecifico.setCantidad_disponible(producto.getCantidad_disponible());
            productoEspecifico.setMarca(producto.getMarca());
//            productoEspecifico.setListaVenta(producto.getListaVenta());
            listaProducto.add(productoEspecifico);
        }
        
        
    return listaProducto;
    }

    @Override
    public double totalDia(LocalDate fecha) {
        List<Venta> listaVentas= this.getVenta();
        double total=0;
        
         for (Venta venta :listaVentas) {
            if(venta.getFecha_venta().equals(fecha)){
               total=total+venta.getTotal();
            }
        }
      
         return total;
         
    }

    @Override
    public ClienteVentaProductoDTO clienteVentaProducto() {
        ClienteVentaProductoDTO clienteVentaProducto= new ClienteVentaProductoDTO();
        List<Venta> listaVentas= this.getVenta();
        double max=0;
        Venta ventaMayor = null;
        
        for (Venta venta : listaVentas) {
            max=venta.getTotal();
            
           if(venta.getTotal()>=max){
               ventaMayor= venta;
           } 
           
        }
        clienteVentaProducto.setApellido_cliente(ventaMayor.getUnCliente().getApellido());
        clienteVentaProducto.setNombre_cliente(ventaMayor.getUnCliente().getNombre());
        clienteVentaProducto.setCant_productos(ventaMayor.getListaProductos().size());
        clienteVentaProducto.setCodigo_venta(ventaMayor.getCodigo_venta());
        clienteVentaProducto.setTotal(ventaMayor.getTotal());
        
        
        return clienteVentaProducto;
    }
    
    
    
}
