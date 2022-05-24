package com.ibm.academia.apirest.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
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

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JoinColumn(name = "preferencia_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "tarjetaPreferencias"})
    private Preferencia preferencia;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JoinColumn(name = "tarjeta_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "tarjetaPreferencias"})
    private Tarjeta tarjeta;
}
