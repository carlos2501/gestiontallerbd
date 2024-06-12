package org.cplcursos.java.Repositorios;

import jakarta.persistence.EntityManager;
import org.cplcursos.java.modelos.Cliente;

import java.util.List;

public class ClienteRepoImpl implements Repo<Cliente> {
    /*
        El repositorio utiliza el EntityManager, pero sabemos que hay que cerrarlo después de ser utilizado.
        Si lo cerramos en cualquiera de los métodos del repositorio, no podrá ser utilizado de nuevo en posteriores
        llamadas. Por tanto, el em debe ser proporcionado por la capa superior que utilice este repositorio y cerrado
        por esa misma capa
     */
    private EntityManager em;

    public ClienteRepoImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<Cliente> listar() {
        return em.createQuery("SELECT c FROM Cliente c", Cliente.class).getResultList();
    }

    @Override
    public Cliente porId(Integer id) {
        return em.find(Cliente.class, id);
    }

    @Override
    public void guardar(Cliente cliente) {

    }

    @Override
    public void eliminar(Integer id) {

    }
}
