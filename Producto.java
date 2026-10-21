public class Producto {
    private double precio;
    private String nombre;

    public Producto(String nombre,double precio){
        this.nombre=nombre;
        this.precio=precio;
    }

    public Producto(String nombre){
        this.nombre=nombre;
    }

    public String getNombre(){
        return nombre;
    }

    public double getPrecio(){
        return precio;
    }

    public void setPrecio(double precio){
        this.precio=precio;
    }

    public void setNombre(String nombre){
        this.nombre=nombre;
    }

    @Override 
    public String toString(){
        return String.format("producto {Nombre:%-15s | Precio: $%.2f}" , nombre, precio);
    }
}
