package org.cplcursos.java;

import jakarta.persistence.EntityManager;
import org.cplcursos.java.Entidades.Cliente;
import org.cplcursos.java.util.JpaUtil;

import javax.swing.*;

public class HibernateEditar {
    public static void main(String[] args) {
        // Creo el entityManager para poder manejar la entidad
        EntityManager em = JpaUtil.getEntitymanager();

        // Modificar un registro implica que primero debemos disponer del registro a modificar
        try{

            // Pregunamos el id del cliente a modificar y lo leemos desde la BBDD
            Cliente cli = em.find(Cliente.class,
                    Integer.valueOf(JOptionPane.showInputDialog("Ingrese el id del cliente a modificar:")));

            // Preguntamos los datos
            String nombre = JOptionPane.showInputDialog("Nombre del cliente", cli.getNombre());
            String dir = JOptionPane.showInputDialog("Dirección del cliente", cli.getDireccion());
            String edad = JOptionPane.showInputDialog("Edad del cliente", cli.getEdad());

            // Inciiamos la transacción
            em.getTransaction().begin();
            // asignamos los valores a las propiedades -campos- de la entidad
            cli.setNombre(nombre);
            cli.setDireccion(dir);
            cli.setEdad(Byte.valueOf(edad));

            // actualizamos la entidad en la BBDD (recordar que estamos dentro de una transacción)
            em.merge(cli);

            // Volcamos las operaciones en la BBDD
            em.getTransaction().commit();

            System.out.println("El cliente " + cli.getId() + "Se ha modificado correctamente.");
            System.out.println("Los nuevos datos son: " + cli);
        } catch (Exception e) {
            // Deshacemos las operaciones preparadas anteriormente para la BBDD
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }
}
