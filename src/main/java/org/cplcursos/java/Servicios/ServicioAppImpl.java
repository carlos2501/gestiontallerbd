package org.cplcursos.java.Servicios;

import jakarta.persistence.EntityManager;
import org.cplcursos.java.Entidades.*;
import org.cplcursos.java.Repositorios.*;

import java.util.List;
import java.util.Optional;

public class ServicioAppImpl implements ServicioApp{
    private Repo<Cliente> repoCli;
    private Repo<Albaran> repoAlb;
    private Repo<Cita> repoCita;
    private Repo<Proveedor> repoProv;
    private Repo<Pieza> repoPieza;

    public ServicioAppImpl(EntityManager em) {
        this.repoCli = new ClienteRepoImpl(em);
        this.repoAlb = new AlabranRepoImpl(em);
        this.repoCita = new CitaRepoImpl(em);
        this.repoProv = new RepoProvImpl(em);
        this.repoPieza = new RepoPiezaImpl(em);
    }

    @Override
    public List<Cliente> listaCli(Integer num) {
        return  repoCli.listar(num);
    }

    @Override
    public Optional<Cliente> porId(Integer id) {
        return Optional.ofNullable(repoCli.porId(id));
    }

    @Override
    public void guardar(Cliente cli) {
        repoCli.guardar(cli);
    }

    @Override
    public void eliminar(Integer id) {
        repoCli.eliminar(id);
    }

    @Override
    public List<Albaran> listaAlb(Integer num) {
        return repoAlb.listar(num);
    }

    @Override
    public Optional<Albaran> porIdAlbaran(Integer id) {
        return Optional.ofNullable(repoAlb.porId(id));
    }

    @Override
    public List<Cita> listaCitas() {
        return repoCita.listar(9999);
    }

    @Override
    public void guardarAlb(Albaran alb) {
        repoAlb.guardar(alb);
    }

    @Override
    public void eliminarAlb(Integer id) {
        repoAlb.eliminar(id);
    }



    @Override
    public Optional<Cita> porIdCita(Integer id) {
        return Optional.ofNullable(repoCita.porId(id));
    }

    @Override
    public void guardarCita(Cita cita) {
        repoCita.guardar(cita);
    }

    @Override
    public List<Proveedor> listaProv(Integer num) {
        return List.of();
    }

    @Override
    public Optional<Proveedor> porIdProv(Integer id) {
        return Optional.ofNullable(repoProv.porId(id));
    }

    @Override
    public void guardarProv(Proveedor prov) {
        repoProv.guardar(prov);
    }

    @Override
    public List<Pieza> listaPiezas(Integer num) {
        return List.of();
    }

    @Override
    public Optional<Pieza> porIdPieza(Integer id) {
        return Optional.ofNullable(repoPieza.porId(id));
    }

    @Override
    public void guardarPieza(Pieza pz) {
        repoPieza.guardar(pz);
    }
}
