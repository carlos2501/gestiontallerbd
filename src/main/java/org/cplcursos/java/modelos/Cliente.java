package org.cplcursos.java.modelos;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

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
}
