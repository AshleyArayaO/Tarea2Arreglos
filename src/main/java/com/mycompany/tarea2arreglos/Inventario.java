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
public class Inventario {
     
    private Producto[] productos;//varable que es de un arreglo tipo objeto
    private int cantidad;
    
     public Inventario() {
        productos = new Producto[10];//se crean las 10 posiciones
        cantidad = 0;  //indica que inicialmente no hay nada , osea que esta vacio
     }
     
     //registrar el producto
     public void registrarProducto() {
        if (cantidad >= productos.length) {
            JOptionPane.showMessageDialog(null,"El inventario esta lleno...");
            return;
        }//fin del if
        
        int codigo;
        do {
            codigo = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el codigo del producto: "));
            
            if (codigo <= 0) {
                JOptionPane.showMessageDialog(null,"El codigo debe ser mayor que cero...");
            }//fin del if
            
        } while (codigo <= 0);//fin del do-while
        
        for (int i = 0; i < cantidad; i++) {

            if (productos[i].getCodigo() == codigo) {
                JOptionPane.showMessageDialog(null,"Ese codigo ya existe.");
                return;
            }//fin del if
        }//fin del for

        String nombre = JOptionPane.showInputDialog("Ingrese el nombre del producto: ");
        double precio;
        do {
            precio = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el precio del producto: "));
            if (precio <= 0) {
                JOptionPane.showMessageDialog(null,"El precio debe ser mayor que cero...");
            }//fin del if
        } while (precio <= 0);//fin del do-while
        int cantidadDisponible;
        do {
            cantidadDisponible = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad disponible: "));
            if (cantidadDisponible <= 0) {
               JOptionPane.showMessageDialog(null,"La cantidad debe ser mayor que cero..");
            }//fin del if
        } while (cantidadDisponible <= 0);//fin del do-while
        Producto nuevoProducto = new Producto(codigo,nombre,precio,cantidadDisponible);
        productos[cantidad] = nuevoProducto;
        cantidad++;
        JOptionPane.showMessageDialog(null,"Producto registrado correctamente...");
    }//fin de registrarProducto

     //metodo para mostrar el producto
     public void mostrarProductos() {  
     if (cantidad == 0) {
        JOptionPane.showMessageDialog(null,"No hay productos registrados...");
        return;
    }//fin del if
    String informacion = "";
    for (int i = 0; i < cantidad; i++) {
        informacion +="Codigo: " + productos[i].getCodigo()
                + "\nNombre: " + productos[i].getNombre()
                + "\nPrecio: " + productos[i].getPrecio()
                + "\nCantidad disponible: "+ productos[i].getCantidadDisponible()
                + "\n";
    }//fin del for
    JOptionPane.showMessageDialog(null, informacion);
}//fin de mostrarProductos
     
     //busca el producto
    public Producto buscarProducto(int codigo) {
    for (int i = 0; i < cantidad; i++) {
        if (productos[i].getCodigo() == codigo) {
            return productos[i];//da el producto que se busco
        }//fin del if
    }//fin del for
    return null;//no encontro el producto
}//fin de buscarProducto
    
    //metodo para vender unidades
    public void venderUnidades() {
    int codigo = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el codigo del producto: "));
    Producto producto = buscarProducto(codigo);
    if (producto == null) {
        JOptionPane.showMessageDialog(null,"El producto no existe...");
         return;
    }//fin del if
    int unidades = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de unidades a vender: "));
    if (unidades <= 0) {
        JOptionPane.showMessageDialog(null,"La cantidad debe ser mayor que cero..");
        return;
    }//fin del if
    if (unidades > producto.getCantidadDisponible()) {
        JOptionPane.showMessageDialog(null,"No hay suficientes unidades disponibles...");
        return;
    }//fin del if
    producto.setCantidadDisponible(producto.getCantidadDisponible() - unidades);
    JOptionPane.showMessageDialog(null,"Venta realizada correctamente...");
}//fin de vender unidades
    
    //metodo para devolver lo que se habia vendido
    public void reabastecerProducto() {
    int codigo = Integer.parseInt( JOptionPane.showInputDialog("Ingrese el codigo del producto: "));
    Producto producto = buscarProducto(codigo);
    if (producto == null) {
        JOptionPane.showMessageDialog(null,"El producto no existe..");
        return;
    }//fin del if
    int unidades = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad a reabastecer: "));
    if (unidades <= 0) {
        JOptionPane.showMessageDialog(null,"La cantidad debe ser mayor que cero.");
        return;
    }//fin del if
    producto.setCantidadDisponible(producto.getCantidadDisponible() + unidades);
    JOptionPane.showMessageDialog(null,"Producto reabastecido correctamente...");
}//fin de reabastecerProducto
    
    public void calcularValorTotal() {
    double total = 0;
    for (int i = 0; i < cantidad; i++) {
        total = total
                + productos[i].getPrecio()
                * productos[i].getCantidadDisponible();
    }//fin del for
    JOptionPane.showMessageDialog(null,String.format("Valor total del inventario: %.2f",total));
}//fin de calcularValorTotal
}//fin de la clase