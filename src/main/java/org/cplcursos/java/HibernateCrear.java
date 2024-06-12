package org.cplcursos.java;

import jakarta.persistence.EntityManager;
import org.cplcursos.java.modelos.Cliente;
import org.cplcursos.java.util.JpaUtil;

import javax.swing.*;

public class HibernateCrear {
    public static void main(String[] args) {
        // Creo el entityManager para poder manejar la entidad
        EntityManager em = JpaUtil.getEntitymanager();
        try {

            String nombre = JOptionPane.showInputDialog("Nombre del cliente");
            String dir = JOptionPane.showInputDialog("Dirección del cliente");
            String edad = JOptionPane.showInputDialog("Edad del cliente");

            // Marco el incio de la transacción
            em.getTransaction().begin();

            Cliente cli = new Cliente();
            cli.setNombre(nombre);
            cli.setDireccion(dir);
            cli.setEdad(Byte.valueOf(edad));

            em.persist(cli);

            // Si hasta aquí no se ha producido ningún error, vuelco las operaciones anteriores en la BBDD
            em.getTransaction().commit();

            System.out.println("El id del cliente nuevo es " + cli.getId());

            cli = em.find(Cliente.class, cli.getId());
            System.out.println(cli);
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }
}
