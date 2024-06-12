package org.cplcursos.java;

import jakarta.persistence.EntityManager;
import org.cplcursos.java.modelos.Cliente;
import org.cplcursos.java.util.JpaUtil;

import javax.swing.*;

public class HibernateBorrar {
    public static void main(String[] args) {
        // Creo el entityManager para poder manejar la entidad
        EntityManager em = JpaUtil.getEntitymanager();

        try {

            //Preguntamos el id del cliente a eliminar y lo leemos desde la BBDD
            String id = JOptionPane.showInputDialog("Ingrese el Id del cliente a eliminar:");
            if(id != null && !id.isEmpty()){
                Cliente cliente = em.find(Cliente.class,
                        Integer.valueOf(id));

                //Iniciamos la transaccion
                em.getTransaction().begin();

                //Buscamos y eliminamos el cliente
                if (cliente != null) {
                    em.remove(cliente);
                    JOptionPane.showMessageDialog(null, "Cliente eliminado correctamente");
                }else {
                    JOptionPane.showMessageDialog(null, "No existe el cliente");
                }

                //Volcamos las operaciones realizadas en la BBDD
                em.getTransaction().commit();
            } else {
                // se ha pulsado el botón Cancelar en el diálogo o se ha devuelto -pulsado OK- sin valor
                JOptionPane.showMessageDialog(null, "No se ha indicado el cliente a eliminar");
            }


        }catch (Exception e) {
            //hacemos rollback por si la transaccion sale mal
            em.getTransaction().rollback();
            e.printStackTrace();
            System.out.println("Error al eliminar el cliente");
        }finally {
            //cerramos la entityManager
            em.close();
        }
    }
}
