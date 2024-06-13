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

        /*
        List<Cliente> listaCli = repoCli.listar();
        System.out.println("================ Lista de clientes =====================");
        System.out.println();
        */
        System.out.println("================ Buscar un cliente =====================");
        Cliente cli = repoCli.porId(Integer.valueOf(JOptionPane.showInputDialog("Ingrese el id del cliente a localizar:")));
        if (cli != null) {
            System.out.println(cli);
        } else {
            System.out.println("El cliente no existe.");
        }
        System.out.println("================ Nuevo cliente =====================");
        String nombre = JOptionPane.showInputDialog("Nombre del nuevo cliente");
        String dir = JOptionPane.showInputDialog("Dirección del nuevo cliente");
        String edad = JOptionPane.showInputDialog("Edad del nuevo cliente");
        // Reutilizo la variable porque los datos del cliente obtenido en la línea 23, no me hacen falta
        cli = new Cliente();
        cli.setNombre(nombre);
        cli.setDireccion(dir);
        cli.setEdad(Byte.valueOf(edad));
        repoCli.guardar(cli);
        System.out.println(cli);
        System.out.println("================ Modificar cliente =====================");
        Integer id = Integer.valueOf(JOptionPane.showInputDialog("Ingrese el id del cliente a modificar:"));
        cli = repoCli.porId(id);
        nombre = JOptionPane.showInputDialog("Nuevo Nombre del cliente", cli.getNombre());
        dir = JOptionPane.showInputDialog("Nueva Dirección del cliente", cli.getDireccion());
        edad = JOptionPane.showInputDialog("Nueva Edad del cliente", cli.getEdad());
        cli.setNombre(nombre);
        cli.setDireccion(dir);
        cli.setEdad(Byte.valueOf(edad));
        repoCli.guardar(cli);
        System.out.println(cli);

        System.out.println("================ Borrar cliente =====================");
        id = Integer.valueOf(JOptionPane.showInputDialog("Ingrese el id del cliente a eliminar:"));
        repoCli.eliminar(id);
        System.out.println("Cliente " + id + " borrado.");
        cli = repoCli.porId(id);
        if (cli != null) {
            System.out.println(cli);
        } else {
            System.out.println("El cliente no existe.");
        }



        // Una vez terminado de utilizar el repositorio, cerramos el em
        em.close();
    }
}
