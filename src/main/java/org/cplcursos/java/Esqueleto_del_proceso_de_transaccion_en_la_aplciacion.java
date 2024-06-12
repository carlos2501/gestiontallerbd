package org.cplcursos.java;

import jakarta.persistence.EntityManager;
import org.cplcursos.java.util.JpaUtil;

public class Esqueleto_del_proceso_de_transaccion_en_la_aplciacion {
    public static void main(String[] args) {
        // Creo el entityManager para poder manejar la entidad
        EntityManager em = JpaUtil.getEntitymanager();

        try {

            // Iniciamos la transacción
            em.getTransaction().begin();

            // Volcamos las operaciones realizadas a la BBDD -transaction.commit()-
            em.getTransaction().commit();

        } catch (Exception e) {
            // Deshacemos las operaciones pendientes anteriores
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            // Cerramos la EntityManager
            em.close();
        }
    }
}
