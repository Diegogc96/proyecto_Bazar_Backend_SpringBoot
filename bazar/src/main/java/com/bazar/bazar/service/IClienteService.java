
package com.bazar.bazar.service;

import com.bazar.bazar.model.Cliente;
import java.util.List;


public interface IClienteService {
    
   public void saveCliente(Cliente cliente);
    
    public List<Cliente> getCliente();
    
    public void deleteCliente(Long id_cliente);
    
    public Cliente editCliente(Long id_cliente, Cliente cliente_nuevo);
    
    public Cliente getClienteID(Long id_cliente);
    
}
