package com.ibm.academia.apirest.dto;

import com.ibm.academia.apirest.enums.TipoTarjeta;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class TarjetaDTO {

    private Integer id;
    @NotNull(message = "No puede ser nulo")
    @NotEmpty(message = "No puede estar vacio")
    private String nombre;
    private TipoTarjeta tipoTarjeta;
}
