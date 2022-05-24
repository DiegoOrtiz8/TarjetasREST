package com.ibm.academia.apirest.services;

import com.ibm.academia.apirest.entities.Cliente;
import com.ibm.academia.apirest.entities.Preferencia;
import com.ibm.academia.apirest.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClienteDAOImpl extends GenericoDAOImpl<Cliente, ClienteRepository> implements ClienteDAO {

    @Autowired
    public ClienteDAOImpl(ClienteRepository repository) {
        super(repository);
    }

    @Override
    @Transactional
    public Cliente agregarPreferenciaCliente(Cliente cliente, Preferencia preferencia) {

        Cliente clienteSeleccionado = null;
        cliente.setPreferencia(preferencia);
        clienteSeleccionado = repository.save(cliente);

        return clienteSeleccionado;
    }
}
