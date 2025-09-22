package br.uniesp.si.techback.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "favoritos", uniqueConstraints = @UniqueConstraint(
        name = "uk_favorito_usuario_filme",
        columnNames = {"usuario_id", "filme_id"}
))
public class Favorito {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "usuario_id", nullable = false)
    private Long usuarioId;

    @Column(name = "filme_id", nullable = false)
    private Long filmeId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id", insertable = false, updatable = false)
    private Usuario usuario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "filme_id", insertable = false, updatable = false)
    private Filme filme;

    @Column(name = "criado_em", nullable = false, precision = 3)
    @Builder.Default
    private LocalDateTime criadoEm = LocalDateTime.now();
}
