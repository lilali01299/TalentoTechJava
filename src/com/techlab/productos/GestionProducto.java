package com.techlab.productos;

import java.util.ArrayList;
import java.util.List;

public class GestionProducto {
    private List<Producto> producto = new ArrayList<>();
    public void agregarProducto(String nombre, double precio, int stock) {
        producto.add (new Producto(nombre, precio, stock));
    }

    public void mostrarProductos() {
        if (producto.isEmpty()) {
            System.out.println("No hay productos registrados.");
        } else {
            for (Producto p : producto) {
                System.out.println(p);
            }
        }
    }

    public List<Producto> getProductos() {
        return producto;
    }

    public boolean eliminarProductoPorId(int id) {
        for (Producto p : producto) {
            if (p.getIdProducto() == id) {
                producto.remove(p);
                return true;
            }
        }
        return false; // no encontrado
    }

    public Producto buscarPorId(int id) {
        for (Producto p : producto) {
            if (p.getIdProducto() == id) return p;
        }
        return null;
    }
}
