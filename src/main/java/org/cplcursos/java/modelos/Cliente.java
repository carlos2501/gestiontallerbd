package org.cplcursos.java.modelos;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Entity
@Table(name="clientes")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "nombre", nullable = false, length = 45)
    private String nombre;

    @Column(name = "direccion", length = 80)
    private String direccion;

    @Column(name = "dni", length = 10)
    private String dni;

    @Column(name = "edad")
    private Byte edad;

    @Column(name = "emilio", length = 50)
    private String emilio;

    @Column(name="creadoel")
    private LocalDateTime creadoEl;

    @Column(name="ultimamodificacion")
    private LocalDateTime ultimaModificacion;

    @PrePersist
    public void prePersist() {
        //this.creadoEl = LocalDateTime.now();
        System.out.println("Antes del persist");
    }

    @PostPersist
    public void postPersist() {
        System.out.println("Después del persist");
    }

    @PreUpdate
    public void preMerge() {
        this.ultimaModificacion = LocalDateTime.now();
    }
}
