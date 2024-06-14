package org.cplcursos.java.Entidades;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name="albaranes")
@Getter
@Setter
@NoArgsConstructor
public class Albaran {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

   private LocalDateTime fecha;
   private Float importe;

   @ManyToOne
   @JoinColumn(name = "id_cliente")
   private Cliente cliente;

}
