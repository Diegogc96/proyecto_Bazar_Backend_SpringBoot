package com.bazar.bazar.controller;

import com.bazar.bazar.model.Cliente;
import com.bazar.bazar.service.ClienteService;
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
public class ClienteController {
    
    @Autowired
    ClienteService serviCliente;
    
    @PostMapping("/clientes/crear")
    public String saveCliente(@RequestBody Cliente cliente) {
        serviCliente.saveCliente(cliente);
        return "Cliente creado";
    }
    
    @GetMapping("/clientes")
    public List<Cliente> getClientes() {
        List<Cliente> listaClientes = serviCliente.getCliente();
        return listaClientes;
    }
    
    @GetMapping("/clientes/{id_cliente}")
    public Cliente getClienteId(@PathVariable Long id_cliente) {
        Cliente cliente = serviCliente.getClienteID(id_cliente);
        return cliente;
    }
    
    @DeleteMapping("/clientes/eliminar/{id_cliente}")
    public String deleteCliente(@PathVariable Long id_cliente) {
        serviCliente.deleteCliente(id_cliente);
       return "Cliente eliminado";
    }
    
    @PutMapping("/clientes/editar/{id_cliente}")
    public Cliente editCLiente(@PathVariable Long id_cliente, @RequestBody Cliente cliente){
        return serviCliente.editCliente(id_cliente, cliente);
    }
}
