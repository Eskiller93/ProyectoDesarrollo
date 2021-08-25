package model;

public class Inventario {
    String modeloSKU;
    int cantidad;
    String ubicacion;

    public Inventario() {
    }

    public Inventario(String modeloSKU, int cantidad, String ubicacion) {
        this.modeloSKU = modeloSKU;
        this.cantidad = cantidad;
        this.ubicacion = ubicacion;
    }

    public String getModeloSKU() {
        return modeloSKU;
    }

    public void setModeloSKU(String modeloSKU) {
        this.modeloSKU = modeloSKU;
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
    
    
}
