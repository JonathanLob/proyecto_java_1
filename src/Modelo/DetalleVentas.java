package Modelo;

public class DetalleVentas {
    //atributos
    int id;
    int idVentas;
    int idProductos;
    int cantidad;
    double preVenta;
    //metodos constructor

    public DetalleVentas() {
    }

    public DetalleVentas(int id, int idVentas, int idProductos, int cantidad, double preVenta) {
        this.id = id;
        this.idVentas = idVentas;
        this.idProductos = idProductos;
        this.cantidad = cantidad;
        this.preVenta = preVenta;
    }
    //metodos get y set

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdVentas() {
        return idVentas;
    }

    public void setIdVentas(int idVentas) {
        this.idVentas = idVentas;
    }

    public int getIdProductos() {
        return idProductos;
    }

    public void setIdProductos(int idProductos) {
        this.idProductos = idProductos;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPreVenta() {
        return preVenta;
    }

    public void setPreVenta(double preVenta) {
        this.preVenta = preVenta;
    }
    
}
