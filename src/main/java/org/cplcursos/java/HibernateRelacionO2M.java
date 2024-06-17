package org.cplcursos.java;

import jakarta.persistence.EntityManager;
import org.cplcursos.java.Entidades.*;
import org.cplcursos.java.Servicios.ServicioApp;
import org.cplcursos.java.Servicios.ServicioAppImpl;
import org.cplcursos.java.util.JpaUtil;

import java.security.cert.PolicyNode;

public class HibernateRelacionO2M {
    public static void main(String[] args) {
        // Creamos el Entitymanager en la capa que use el repositorio
        EntityManager em = JpaUtil.getEntitymanager();
        // Creamos una instancia de la capa de servicio que vamos a utilizar
        ServicioApp srvcapp = new ServicioAppImpl(em);
        /*
            En el main definido en HibernateRelacionM2O habíamos definido una relación muchos a uno entre
            Albaran y Cliente.

            Eso nos permitió asignar a varios albaranes el mismo cliente y, además, gracias a haber incluido una
            propiedad del tipo "Cliente" dentro del objeto "Albarán", podemos acceder a los datos del cliente -nombre,
            dirección, etc.- desde el mismo albarán sin necesidad de hacer una nueva consulta a la bbdd.

            Pero ¿Cómo podemos saber qué albaranes se han emitido a un determinado cliente?
            Tendríamos que hacer una consulta a la tabla de albaranes y filtrar por el campo "id_cliente" (que es el
            que definimos en la relación @ManyToOne).

            Sin embargo, también podemos crear una relación "Uno a Muchos" entre Cliente y Albaran.

            Esta relación crea una tabla auxiliar que contiene un registro con el id de Cliente y el id de Albaran para
            cada registro que se crea en la tabla "albaranes"
         */
        System.out.println("------------------ Listar los albaranes de un cliente --------------");
        System.out.println(srvcapp.porId(6).get());




    }
}
