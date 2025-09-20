package br.uniesp.si.techback.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//plano
//id UUID PK
//codigo VARCHAR(20) UNIQUE NOT NULL
//limite_diario SMALLINT NOT NULL
//streams_simultaneos SMALLINT NOT NULL

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "planos")
public class Plano{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 20, name = "codigo")
    private String codigo;

    @Column(nullable = false, name = "limite_diario")
    private int limiteDiario ;

    @Column(nullable = false, name = "streams_simultaneos")
    private int streamSimultaneos;
}
