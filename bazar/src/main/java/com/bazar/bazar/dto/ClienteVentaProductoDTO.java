
package com.bazar.bazar.dto;

import com.bazar.bazar.model.Producto;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ClienteVentaProductoDTO {
    
    private Long codigo_venta;
    private Double total;
    private int cant_productos;
    private String nombre_cliente;
    private String apellido_cliente;

    public ClienteVentaProductoDTO() {
    }

    public ClienteVentaProductoDTO(Long codigo_venta, Double total, int cant_productos, String nombre_cliente, String apellido_cliente) {
        this.codigo_venta = codigo_venta;
        this.total = total;
        this.cant_productos = cant_productos;
        this.nombre_cliente = nombre_cliente;
        this.apellido_cliente = apellido_cliente;
    }

    
    
    
    
}
