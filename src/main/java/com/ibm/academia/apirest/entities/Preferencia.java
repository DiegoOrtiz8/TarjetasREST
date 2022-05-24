package com.ibm.academia.apirest.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "preferencias", schema = "bancos")
public class Preferencia implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "No puede ser nulo")
    @NotEmpty(message = "No puede ser vacio")
    @Column(name = "preferencia", nullable = false, unique = true)
    private String preferencia;

    @Column(name = "fecha_alta")
    private Date fechaAlta;

    @Column(name = "fecha_modificacion")
    private Date fechaModificacion;

    @OneToMany(mappedBy = "preferencia")
    @JsonIgnoreProperties({"preferencia"})
    private List<TarjetaPreferencia> tarjetaPreferencias;

    @OneToMany(mappedBy = "preferencia", fetch = FetchType.LAZY)
    @JsonIgnoreProperties({"preferencia"})
    private Set<Cliente> clientes;

    public Preferencia(Integer id, String preferencia) {
        this.id = id;
        this.preferencia = preferencia;
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
