package org.cplcursos.java.Servicios;

import jakarta.persistence.EntityManager;
import org.cplcursos.java.Repositorios.ClienteRepoImpl;
import org.cplcursos.java.Repositorios.Repo;
import org.cplcursos.java.modelos.Cliente;

import java.util.List;
import java.util.Optional;

public class ClienteSrvcImpl implements ClienteSrvc{
    private EntityManager em;
    private Repo<Cliente> repoCli;

    public ClienteSrvcImpl(EntityManager em) {
        this.em = em;
        this.repoCli = new ClienteRepoImpl(em);
    }

    @Override
    public List<Cliente> listaCli(Integer num) {
        List<Cliente> lista =  repoCli.listar();
        return
    }

    @Override
    public Optional<Cliente> porId(Integer id) {
        return Optional.empty();
    }

    @Override
    public void guardar(Cliente cli) {

    }

    @Override
    public void eliminar(Integer id) {

    }
}
