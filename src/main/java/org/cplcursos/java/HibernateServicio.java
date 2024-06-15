package org.cplcursos.java;

import jakarta.persistence.EntityManager;
import org.cplcursos.java.Servicios.ClienteSrvc;
import org.cplcursos.java.Servicios.ClienteSrvcImpl;
import org.cplcursos.java.Entidades.Cliente;
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
        numcli = Integer.valueOf(JOptionPane.showInputDialog("Introduzca el id del cliente a localizar: "));
        // mediante programación funcional
        clienteSrvc.porId(numcli).ifPresent(c -> System.out.println(c));

        // Aún más simplificada la función Lambda ...
        //clienteSrvc.porId(numcli).ifPresent(System.out::println);

        // Mediante programación procedimental
         /*
        if(clienteSrvc.porId(numcli).isPresent()){
            Cliente cli = clienteSrvc.porId(numcli).get();
            System.out.println(cli);
        } else {
            System.out.println("No se encuentra el cliente solicitado");
        }
        */

        System.out.println("================ Nuevo cliente =====================");
        String nombre = JOptionPane.showInputDialog("Nombre del nuevo cliente");
        String dir = JOptionPane.showInputDialog("Dirección del nuevo cliente");
        String edad = JOptionPane.showInputDialog("Edad del nuevo cliente");
        Cliente cli = new Cliente();
        cli.setNombre(nombre);
        cli.setDireccion(dir);
        cli.setEdad(Byte.valueOf(edad));
        clienteSrvc.guardar(cli);
        System.out.println(clienteSrvc.porId(cli.getId()));

        System.out.println("================ Modificar cliente =====================");
        Integer id = Integer.valueOf(JOptionPane.showInputDialog("Introduzca el id del cliente a modificar: "));
        if(clienteSrvc.porId(id).isPresent()){
            cli = clienteSrvc.porId(id).get();
            nombre = JOptionPane.showInputDialog("Nuevo Nombre del cliente", cli.getNombre());
            dir = JOptionPane.showInputDialog("Nueva Dirección del cliente", cli.getDireccion());
            edad = JOptionPane.showInputDialog("Nueva Edad del cliente", cli.getEdad());
            cli.setNombre(nombre);
            cli.setDireccion(dir);
            cli.setEdad(Byte.valueOf(edad));
            clienteSrvc.guardar(cli);
            System.out.println(clienteSrvc.porId(cli.getId()));
        } else {
            System.out.println("No se encuentra el cliente solicitado");
        }
        System.out.println("================ Borrar cliente =====================");
        id = Integer.valueOf(JOptionPane.showInputDialog("Introduzca el id del cliente a eliminar: "));
        if(clienteSrvc.porId(id).isPresent()){
            clienteSrvc.eliminar(id);
        } else {
            System.out.println("No se encuentra el cliente indicado. No se puede borrar lo que no existe. ");
        }
    }
}
