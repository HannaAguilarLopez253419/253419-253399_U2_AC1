import java.util.Comparator;
import java.util.LinkedList;


public class Almacen {
    private LinkedList<Producto> listaProductos;


    public Almacen() {
        this.listaProductos = new LinkedList<>();
    }

    public void agregarProducto(Producto p) {
        this.listaProductos.add(p);
    }

    public void ordenarPorPrecio() {
        this.listaProductos.sort(Comparator.comparingDouble(Producto::getPrecio));
    }

    public void ordenarPorNombre() {
        this.listaProductos.sort(Comparator.comparing(Producto::getNombre, String.CASE_INSENSITIVE_ORDER));
    }


    public void visualizarListaProductos() {
        if (listaProductos.isEmpty()) {
            System.out.println("El almacén no contiene productos registrados.");
            return;
        }
        for (int i = 0; i < listaProductos.size(); i++) {
            System.out.println(listaProductos.get(i));
        }
    }

    public int buscarProducto(double precioBuscado) {
        return busquedaBinariaRecursiva(0, listaProductos.size() - 1, precioBuscado);
    }


    private int busquedaBinariaRecursiva(int inicio, int fin, double precioBuscado) {
        if (inicio > fin) {
            return -1; 
        }


        int medio = inicio + (fin - inicio) / 2;
        double precioMedio = listaProductos.get(medio).getPrecio();


        if (Math.abs(precioMedio - precioBuscado) < 0.0001) {
            return medio;
        } else if (precioMedio > precioBuscado) {
            return busquedaBinariaRecursiva(inicio, medio - 1, precioBuscado);
        } else {
            return busquedaBinariaRecursiva(medio + 1, fin, precioBuscado);
        }
    }


    public Producto getProductoEnIndice(int index) {
        if (index >= 0 && index < listaProductos.size()) {
            return listaProductos.get(index);
        }
        return null;
    }
}