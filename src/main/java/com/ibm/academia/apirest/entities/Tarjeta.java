package com.ibm.academia.apirest.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.ibm.academia.apirest.enums.TipoTarjeta;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "tarjetas", schema = "bancos")
public class Tarjeta implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "No puede ser nulo")
    @NotEmpty(message = "No puede ser vacio")
    @Column(name = "nombre", nullable = false, unique = true)
    private String nombre;

    @Column(name = "tipo_tarjeta", nullable = false)
    private TipoTarjeta tipoTarjeta;

    @Column(name = "fecha_alta")
    private Date fechaAlta;

    @Column(name = "fecha_modificacion")
    private Date fechaModificacion;

    @OneToMany(mappedBy = "preferencia")
    @JsonIgnoreProperties({"preferencia"})
    private List<TarjetaPreferencia> tarjetaPreferencias;

    public Tarjeta(Integer id, String nombre, TipoTarjeta tipoTarjeta) {
        this.id = id;
        this.nombre = nombre;
        this.tipoTarjeta = tipoTarjeta;
    }

    @Override
    public String toString() {
        return "Tarjeta{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", tipoTarjeta=" + tipoTarjeta +
                '}';
    }

    @PrePersist
    private void antesPersistir(){
        this.fechaAlta = new Date();
    }

    @PreUpdate
    private void antesActualizar(){
        this.fechaModificacion = new Date();
    }
}


