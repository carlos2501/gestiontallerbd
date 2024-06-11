package org.cplcursos.java;

import jakarta.persistence.EntityManager;
import org.cplcursos.java.modelos.Cliente;
import org.cplcursos.java.util.JpaUtil;

import java.util.List;

public class HibernateListarWhere {
    public static void main(String[] args) {
        // Creo el entityManager para poder manejar la entidad
        EntityManager em = JpaUtil.getEntitymanager();
        /* Ejecuto el método del entityManager que me permite obtener los datos (enm este aso, un a consulta SELECT)
           La consulta NO ES SQL, es HQL -Hibernate Query language- que hace referencia a Objetos -clases- del código
           NO a tablas de la BBDD.

           El proceso es:
           1 - La em se conecta a la BBDD (internamente, JPA obtiene una conexión del pool de conexiones que abre al
                conectarse a la BBD)
           2 - Con esa conexión traduce la consulta HQL a SQL sustituyendo las entidades (etiquetadas con @Entity)
                por sus tablas correspondientes.
           3 - Ejecuta la sentencia SQL en la BBDD, que le devuelve el resultado
           4 - Coloca el resultado en la variable "clientes"
         */
        List<Cliente> clientes = em.createQuery("SELECT c FROM Cliente c WHERE c.id <= 10", Cliente.class).getResultList();
        clientes.forEach(System.out::println);
        em.close();

    }
}
