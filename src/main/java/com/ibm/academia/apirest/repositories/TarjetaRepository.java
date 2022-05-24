package com.ibm.academia.apirest.repositories;

import com.ibm.academia.apirest.entities.Tarjeta;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface TarjetaRepository extends CrudRepository<Tarjeta, Integer> {
    @Query("Select t from Tarjeta t join fetch t.tarjetaPreferencias td join fetch td.preferencia p " +
            "where lower(p.preferencia) = lower(?3) and td.edadMaxima >= ?1 " +
            "and td.edadMinima <= ?1 " + "and td.salarioMaximo >= ?2" + "and td.salarioMinimo <= ?2")
    public obtenerRecomendacionTarjetaPorEdadSalarioPreferencia(Integer edad, Double salario, String preferencia);
}
