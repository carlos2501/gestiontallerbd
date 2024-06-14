package org.cplcursos.java.Servicios;

import org.cplcursos.java.Entidades.Albaran;
import org.cplcursos.java.Entidades.Cliente;

import java.util.List;
import java.util.Optional;

public interface ServicioApp {
    List<Cliente> listaCli(Integer num);
    Optional<Cliente> porId(Integer id);
    void guardar(Cliente cli);
    void eliminar(Integer id);

    List<Albaran> listaAlb(Integer num);
    Optional<Albaran> porIdAlbaran(Integer id);
    void guardarAlb(Albaran cli);
    void eliminarAlb(Integer id);
}
