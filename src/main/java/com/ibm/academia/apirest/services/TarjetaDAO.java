package com.ibm.academia.apirest.services;

import com.ibm.academia.apirest.dto.TarjetaDTO;
import com.ibm.academia.apirest.entities.Tarjeta;

public interface TarjetaDAO extends GenericoDAO<Tarjeta> {
    public Iterable<TarjetaDTO> obtenerRecomendacionTarjetaPorEdadSalarioPreferencia(Integer edad, Double salario, String preferencia);
}
