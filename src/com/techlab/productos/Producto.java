package com.techlab.productos;

public class Producto {
    private static int contador = 1;
    private int idProducto;
    private String nombre;
    private double precio;
    private int stock;

    public Producto(String nombre, double precio, int stock) {
        this.idProducto  =contador++;
        this.nombre = nombre;
        this.precio = precio;
        this.stock= stock;

    }

    public int getIdProducto() {
        return idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "ID: " + idProducto + " | Nombre: " + nombre + " | Precio: $" + precio + " | Stock: " + stock;
    }
    void printName(){
        System.out.println("Producto: " + this.nombre);
    }
}
