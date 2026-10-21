import java.util.Scanner;


public class main {


    public static void main(String[] args) {
        menu();
    }


    public static void menu() {
        Almacen gestorAlmacen = new Almacen();
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;


        while (continuar) {
            System.out.println("\n=== SISTEMA DE GESTIÓN DE ALMACÉN ===");
            System.out.println("1. Registrar nuevo producto");
            System.out.println("2. Mostrar lista de productos");
            System.out.println("3. Ordenar productos por precio (Menor a Mayor)");
            System.out.println("4. Ordenar productos por nombre (A - Z)");
            System.out.println("5. Buscar producto por precio (Búsqueda Binaria)");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");


            int opcion = scanner.nextInt();
            scanner.nextLine(); 


            switch (opcion) {
                case 1:
                    System.out.println("\n--- REGISTRO DE NUEVO PRODUCTO ---");
                    System.out.print("Nombre del producto: ");
                    String nombre = scanner.nextLine();


                    System.out.print("Precio del producto ($): ");
                    double precio = scanner.nextDouble();
                    scanner.nextLine(); 


                    Producto nuevoProducto = new Producto(nombre, precio);
                    gestorAlmacen.agregarProducto(nuevoProducto);
                    System.out.println("¡Producto '" + nombre + "' registrado con éxito!");
                    break;


                case 2:
                    System.out.println("\n--- INVENTARIO DEL ALMACÉN ---");
                    gestorAlmacen.visualizarListaProductos();
                    break;


                case 3:
                    System.out.println("\n--- ORDENANDO POR PRECIO ---");
                    gestorAlmacen.ordenarPorPrecio();
                    System.out.println("Productos ordenados correctamente por precio.");
                    gestorAlmacen.visualizarListaProductos();
                    break;


                case 4:
                    System.out.println("\n--- ORDENANDO POR NOMBRE ---");
                    gestorAlmacen.ordenarPorNombre();
                    System.out.println("Productos ordenados alfabéticamente por nombre.");
                    gestorAlmacen.visualizarListaProductos();
                    break;


                case 5:
                    System.out.println("\n--- BÚSQUEDA BINARIA POR PRECIO ---");
                    System.out.print("Ingrese el precio exacto a buscar: $");
                    double precioBuscar = scanner.nextDouble();
                    scanner.nextLine();

                    gestorAlmacen.ordenarPorPrecio();

                    int indice = gestorAlmacen.buscarProducto(precioBuscar);

                    if (indice != -1) {
                        System.out.println("¡Producto encontrado en la posición " + indice + "!");
                        System.out.println("Detalles: " + gestorAlmacen.getProductoEnIndice(indice));
                    } else {
                        System.out.println("No se encontró ningún producto con el precio $" + precioBuscar + ".");
                    }
                    break;

                case 6:
                    System.out.println("Saliendo del sistema de gestión. ¡Hasta luego!");
                    continuar = false;
                    break;

                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
                    break;
            }
        }
    }
}