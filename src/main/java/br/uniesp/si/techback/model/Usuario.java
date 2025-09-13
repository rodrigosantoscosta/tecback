package br.uniesp.si.techback.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nome;

    @Column(nullable = false, name = "data_nascimento")
    private LocalDate dataNascimento;

    @Column(nullable = false, name = "cpf",unique = true, length = 11)
    private String cpf;

    @Column(nullable = false, name = "email",length = 100)
    private String email;

    @Column(nullable = false, name = "usuario", unique = true, length = 20)
    private String usuario;
    @Column(nullable = false, name = "senha")
    private String senha;

}
