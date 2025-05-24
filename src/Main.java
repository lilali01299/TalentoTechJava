import com.techlab.pedidos.GestionPedido;
import com.techlab.pedidos.Pedido;
import com.techlab.productos.GestionProducto;
import com.techlab.productos.Producto;

import java.util.ArrayList;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        GestionProducto gestor = new GestionProducto();
        GestionPedido gestorPedidos = new GestionPedido(gestor);


        System.out.println("=== SISTEMA DE GESTIÓN - TECHLAB ===");
        System.out.println("Ingrese el número de la opoción que querés realizar");

        while (true) {
            System.out.println("\n1. Agregar producto");
            System.out.println("2. Mostrar productos");
            System.out.println("3. Eliminar producto por ID");
            System.out.println("4. Crear nuevo pedido");
            System.out.println("5. Mostrar pedidos");
            System.out.println("6. Salir");


            String opcion = scanner.nextLine(); // leemos como texto

            switch (opcion) {
                case "1":
                try{
                    System.out.println("Nombre del producto: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Precio: ");
                    double precio = Double.parseDouble(scanner.nextLine());
                    System.out.print("Cantidad en stock: ");
                    int stock = Integer.parseInt(scanner.nextLine());
                    gestor.agregarProducto(nombre, precio, stock);
                    System.out.println("Producto agregado con éxito.");
                }
                catch (NumberFormatException e) {
                    System.out.println("Error: entrada numérica inválida.");
                }
                    break;
                case "2":
                   gestor.mostrarProductos();

                break;
                case "3":
                try{
                    System.out.print("Ingrese el ID del producto a eliminar: ");
                    int idEliminar = Integer.parseInt(scanner.nextLine());
                    System.out.print("¿Está seguro que desea eliminar el producto con ID " + idEliminar + "? (si/no): ");
                    String confirmacion = scanner.nextLine();

                    if (confirmacion.equalsIgnoreCase("si")) {
                        boolean eliminado = gestor.eliminarProductoPorId(idEliminar);
                        if (eliminado) {
                            System.out.println("Producto eliminado con éxito.");
                        } else {
                            System.out.println("No se encontró un producto con ese ID.");
                        }
                    } else {
                        System.out.println("Eliminación cancelada.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("ID inválido.");
                }
                    break;

                case "4":
                        gestorPedidos.crearPedido(scanner);
                        break;
                case "5":
                    gestorPedidos.mostrarPedidos();
                    break;

                case "6":
                    System.out.println("Saliendo...");
                    scanner.close();
                    return;


                }

            }
        }
    }}
