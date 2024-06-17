package org.cplcursos.java.Entidades;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name="proveedores")
public class Proveedor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    private String nombre;

    @ManyToMany
    @JoinTable(name="proveedorespiezas",
        joinColumns={@JoinColumn(name="id_Prov")},
        inverseJoinColumns={@JoinColumn(name="id_pieza")})
    private Set<Pieza> piezas = new HashSet<>();

    @Override
    public String toString() {
        return "Proveedor{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", piezas=" + piezas +
                '}';
    }
}
