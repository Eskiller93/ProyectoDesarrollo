package model;

public class Articulo {
    private int idArticulos;
    private String modeloSKU;
    private String marca;
    private String tallasDisponibles;
    private int Precio;
    private String Detalle;
    private int cantidad;
    private String ubicacion;

    public Articulo() {
    }

    public Articulo(String modeloSKU, String marca, String tallasDisponibles, int Precio, String Detalle, int cantidad, String ubicacion) {
        this.modeloSKU = modeloSKU;
        this.marca = marca;
        this.tallasDisponibles = tallasDisponibles;
        this.Precio = Precio;
        this.Detalle = Detalle;
        this.cantidad = cantidad;
        this.ubicacion = ubicacion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }
    
    public String getDetalle() {
        return Detalle;
    }

    public void setDetalle(String Detalle) {
        this.Detalle = Detalle;
    }

    public int getIdArticulos() {
        return idArticulos;
    }

    public void setIdArticulos(int idArticulos) {
        this.idArticulos = idArticulos;
    }

    public String getModeloSKU() {
        return modeloSKU;
    }

    public void setModeloSKU(String modeloSKU) {
        this.modeloSKU = modeloSKU;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getTallasDisponibles() {
        return tallasDisponibles;
    }

    public void setTallasDisponibles(String tallasDisponibles) {
        this.tallasDisponibles = tallasDisponibles;
    }

    public int getPrecio() {
        return Precio;
    }

    public void setPrecio(int Precio) {
        this.Precio = Precio;
    }
    
    
}
