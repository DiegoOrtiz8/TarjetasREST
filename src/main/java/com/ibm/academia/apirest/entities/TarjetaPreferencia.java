package com.ibm.academia.apirest.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.io.Serializable;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "tarjetas_preferencias", schema = "bancos")
public class TarjetaPreferencia implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "No puede ser nulo")
    @Positive(message = "Debe de ser mayor a 0")
    @Column(name = "edad_minima", nullable = false)
    private Integer edadMinima;

    @NotNull(message = "No puede ser nulo")
    @Positive(message = "Debe de ser mayor a 0")
    @Column(name = "edad_maxima", nullable = false)
    private Integer edadMaxima;

    @NotNull(message = "No puede ser nulo")
    @Positive(message = "Debe de ser mayor a 0")
    @Column(name = "salario_minimo", nullable = false)
    private Integer salarioMinimo;

    @NotNull(message = "No puede ser nulo")
    @Positive(message = "Debe de ser mayor a 0")
    @Column(name = "salario_maximo", nullable = false)
    private Integer salarioMaximo;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JoinColumn(name = "preferencia_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "tarjetaPreferencias"})
    private Preferencia preferencia;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JoinColumn(name = "tarjeta_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "tarjetaPreferencias"})
    private Tarjeta tarjeta;
}
