
package com.bazar.bazar.service;

import com.bazar.bazar.model.Cliente;
import com.bazar.bazar.repository.IClienteRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService implements IClienteService{

    @Autowired
     IClienteRepository serviCliente;
    
    @Override
    public void saveCliente(Cliente cliente) {
      serviCliente.save(cliente);
    }

    @Override
    public List<Cliente> getCliente() {
       List<Cliente> listaCliente = serviCliente.findAll();
    
       return listaCliente;
    }

    @Override
    public void deleteCliente(Long id_cliente) {
        serviCliente.deleteById(id_cliente);
    }

    @Override
    public Cliente editCliente(Long id_cliente, Cliente cliente_nuevo) {
        Cliente cliente=this.getClienteID(id_cliente);
        cliente.setNombre(cliente_nuevo.getNombre());
        cliente.setApellido(cliente_nuevo.getApellido());
        cliente.setDni(cliente_nuevo.getDni());
        cliente.setId_cliente(cliente_nuevo.getId_cliente());

        this.saveCliente(cliente);
        
        return cliente;
    }

    @Override
    public Cliente getClienteID(Long id_cliente) {
       Cliente cliente = serviCliente.findById(id_cliente).orElse(null);
        return  cliente;
    }
    
}
