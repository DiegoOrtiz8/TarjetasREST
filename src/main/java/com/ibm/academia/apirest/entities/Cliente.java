package com.ibm.academia.apirest.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.ibm.academia.apirest.enums.TipoTarjeta;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "clientes", schema = "bancos")
public class Cliente implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "No puede ser nulo")
    @NotEmpty(message = "No puede se vacio")
    @Column(name = "nombre")
    @Size(min = 3, max = 20, message = "Longitud debe de ser de 3 a 20 caracteres")
    private String nombre;

    @NotNull(message = "No puede ser nulo")
    @NotEmpty(message = "No puede se vacio")
    @Size(min = 3, max = 20, message = "Longitud debe de ser de 3 a 20 caracteres")
    @Column(name = "apellido")
    private String apellido;

    @NotNull(message = "No puede ser nulo")
    @Positive(message = "Debe de ser mayor a cero")
    @Column(name = "salario")
    private Double salario;

    @NotNull(message = "No puede ser nulo")
    @Positive(message = "Debe de ser mayor a cero")
    @Column(name = "edad")
    private Integer edad;

    @Column(name = "fecha_alta")
    private Date fechaAlta;

    @Column(name = "fecha_modificacion")
    private Date fechaModificacion;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "preferencia_id", foreignKey = @ForeignKey(name = "FK_PREFERENCIA_ID"))
    @JsonIgnoreProperties({"hibernateLazyInitializer", "clientes"})
    private Preferencia preferencia;

    public Cliente(Integer id, String nombre, String apellido, Double salario, Integer edad) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.salario = salario;
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", salario=" + salario +
                ", edad=" + edad +
                ", fechaAlta=" + fechaAlta +
                ", fechaModificacion=" + fechaModificacion +
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
