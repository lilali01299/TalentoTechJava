package com.techlab.pedidos;

import com.techlab.productos.GestionProducto;
import com.techlab.productos.Producto;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GestionPedido {
    private List<Pedido> pedidos = new ArrayList<>();
    private GestionProducto gestorProductos;

    public GestionPedido(GestionProducto gestorProductos) {
        this.gestorProductos = gestorProductos;
    }

    public void crearPedido(Scanner scanner) {
        Pedido pedido = new Pedido();

        while (true) {
            gestorProductos.mostrarProductos();
            System.out.print("Ingrese ID del producto a agregar al pedido (o 0 para finalizar): ");
            int id = Integer.parseInt(scanner.nextLine());
            if (id == 0) break;

            Producto producto = gestorProductos.buscarPorId(id);
            if (producto == null) {
                System.out.println("Producto no encontrado.");
                continue;
            }

            System.out.print("Cantidad deseada: ");
            int cantidad = Integer.parseInt(scanner.nextLine());

            if (cantidad <= 0 || cantidad > producto.getStock()) {
                System.out.println("Cantidad inválida o insuficiente stock.");
                continue;
            }

            pedido.agregarLinea(new LineaPedido(producto, cantidad));
        }

        if (!pedido.getLineas().isEmpty()) {
            for (LineaPedido lp : pedido.getLineas()) {
                Producto p = lp.getProducto();
                p.setStock(p.getStock() - lp.getCantidad());
            }
            pedidos.add(pedido);
            System.out.println("Pedido creado exitosamente.");
            System.out.println(pedido);
        } else {
            System.out.println("No se agregó ningún producto al pedido.");
        }
    }

    public void mostrarPedidos() {
        if (pedidos.isEmpty()) {
            System.out.println("No hay pedidos registrados.");
        } else {
            for (Pedido p : pedidos) {
                System.out.println("\n" + p);
            }
        }
    }

}

