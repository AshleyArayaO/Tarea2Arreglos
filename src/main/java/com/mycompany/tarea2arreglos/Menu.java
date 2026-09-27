/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tarea2arreglos;

import javax.swing.JOptionPane;

/**
 *
 * @author Thinkpad P52
 */
public class Menu {
     private int opcion;
    private Inventario inventario;

    public Menu() {
        inventario = new Inventario();
    }

    public void MenuPrincipal() {

        do {
            opcion = Integer.parseInt(JOptionPane.showInputDialog("MENU PRINCIPAL"
                            + "\n1. Registrar producto"
                            + "\n2. Mostrar productos"
                            + "\n3. Buscar producto por codigo"
                            + "\n4. Vender unidades"
                            + "\n5. Reabastecer producto"
                            + "\n6. Calcular valor total del inventario"
                            + "\n7. Salir"));

            switch (opcion) {

                case 1:
                    inventario.registrarProducto();
                    break;

                case 2:
                    inventario.mostrarProductos();
                    break;

                case 3:
                    buscarProducto();
                    break;

                case 4:
                    inventario.venderUnidades();
                    break;

                case 5:
                    inventario.reabastecerProducto();
                    break;

                case 6:
                    inventario.calcularValorTotal();
                    break;

                case 7:
                    JOptionPane.showMessageDialog(null,"Saliendo del programa...");
                    break;

                default:
                    JOptionPane.showMessageDialog(null,"Opción no valida...");
            }//fin del switch

        } while (opcion != 7);
    }//fin menuPrincipal

    public void buscarProducto() {
        int codigo = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el codigo del producto: "));
        Producto producto = inventario.buscarProducto(codigo);
        if (producto == null) {
            JOptionPane.showMessageDialog(null,"El producto no existe...");
        } else {
            JOptionPane.showMessageDialog(null,"Codigo: " + producto.getCodigo()
                    + "\nNombre: " + producto.getNombre()
                    + "\nPrecio: " + producto.getPrecio()
                    + "\nCantidad disponible: "+ producto.getCantidadDisponible());
        }//fin del else
    }//fin de buscarProducto
}//fin de la clase