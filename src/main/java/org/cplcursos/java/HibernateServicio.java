package org.cplcursos.java;

import jakarta.persistence.EntityManager;
import org.cplcursos.java.Servicios.ClienteSrvc;
import org.cplcursos.java.Servicios.ClienteSrvcImpl;
import org.cplcursos.java.modelos.Cliente;
import org.cplcursos.java.util.JpaUtil;

import javax.swing.*;
import java.util.List;

public class HibernateServicio {
    public static void main(String[] args) {
        // Creamos el Entitymanager en la capa que use el repositorio
        EntityManager em = JpaUtil.getEntitymanager();
        // Creamos una instancia de la capa de servicio que vamos a utilizar
        ClienteSrvc clienteSrvc = new ClienteSrvcImpl(em);

        System.out.println("================ Lista de clientes =====================");
        Integer numcli = Integer.valueOf(JOptionPane.showInputDialog("Número de registros a mostrar: "));
        List<Cliente> lista =  clienteSrvc.listaCli(numcli);
        System.out.println(lista);
        System.out.println("================ Buscar un cliente =====================");

        System.out.println("================ Nuevo cliente =====================");

        System.out.println("================ Modificar cliente =====================");

        System.out.println("================ Borrar cliente =====================");
    }
}
