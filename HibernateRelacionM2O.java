package org.cplcursos.java;

import jakarta.persistence.EntityManager;
import org.cplcursos.java.Entidades.Albaran;
import org.cplcursos.java.util.JpaUtil;

public class HibernateRelacionM2O {
    public static void main(String[] args) {
        // Creamos el Entitymanager en la capa que use el repositorio
        EntityManager em = JpaUtil.getEntitymanager();

        Albaran alb = new Albaran();
    }
}
