package org.cplcursos.java;

import jakarta.persistence.EntityManager;
import org.cplcursos.java.Repositorios.ClienteRepoImpl;
import org.cplcursos.java.Repositorios.Repo;
import org.cplcursos.java.modelos.Cliente;
import org.cplcursos.java.util.JpaUtil;

import javax.swing.*;
import java.util.List;

public class HibernateRepo {
    public static void main(String[] args) {
        // Creamos el Entitymanager en la capa que use el repositorio
        EntityManager em = JpaUtil.getEntitymanager();
        // Enviamos este em creado para que lo utilice el repositorio. De esta forma, podemos cerrarlo al finalizar su uso
        Repo<Cliente> repoCli = new ClienteRepoImpl(em);

        List<Cliente> listaCli = repoCli.listar();
        System.out.println("================ Lista de clientes =====================");
        System.out.println(listaCli);
        System.out.println("================ Buscar un cliente =====================");
        Cliente cli = repoCli.porId(Integer.valueOf(JOptionPane.showInputDialog("Ingrese el id del cliente a modificar:")));
        System.out.println(cli);

        // Una vez terminado de utilizar el repositorio, cerramos el em
        em.close();
    }
}
