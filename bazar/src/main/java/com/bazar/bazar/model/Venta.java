
package com.bazar.bazar.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;

import jakarta.persistence.OneToOne;
import java.time.LocalDate;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Venta {
    
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private Long codigo_venta;
    private LocalDate fecha_venta;
    private Double total;
    
    @OneToOne
    @JoinColumn(name = "id_cliente", referencedColumnName = "id_cliente")
    private Cliente unCliente;
    
    @JsonIgnore
    @ManyToMany
    private List<Producto> listaProductos;
    
    public Venta() {
    }

    public Venta(Long codigo_venta, LocalDate fecha_venta, Double total, Cliente unCliente, List<Producto> listaProductos) {
        this.codigo_venta = codigo_venta;
        this.fecha_venta = fecha_venta;
        this.total = total;
        this.unCliente = unCliente;
        this.listaProductos = listaProductos;
    }

   
    
    
}
