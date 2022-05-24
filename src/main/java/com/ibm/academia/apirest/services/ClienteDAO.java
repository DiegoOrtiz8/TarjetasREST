package com.ibm.academia.apirest.services;

import com.ibm.academia.apirest.entities.Cliente;
import com.ibm.academia.apirest.entities.Preferencia;

public interface ClienteDAO extends GenericoDAO<Cliente> {
    public Cliente agregarPreferenciaCliente(Cliente cliente, Preferencia preferencia);
}
