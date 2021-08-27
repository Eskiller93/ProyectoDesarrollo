package model;

public class Proveedor {
        
    private String idProveedor;
    private String nombreEmpresa;
    private String direccion;
    private String correo;
    private String telefono;
    private String tipoServicio;

    public Proveedor() {
    }

    public Proveedor(String idProveedor, String nombreEmpresa, String direccion, String correo, String telefono, String tipoServicio) {
        this.idProveedor = idProveedor;
        this.nombreEmpresa = nombreEmpresa;
        this.direccion = direccion;
        this.correo = correo;
        this.telefono = telefono;
        this.tipoServicio = tipoServicio;
    }

    public String getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(String idProveedor) {
        this.idProveedor = idProveedor;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getTipoServicio() {
        return tipoServicio;
    }

    public void setTipoServicio(String tipoServicio) {
        this.tipoServicio = tipoServicio;
    }

    @Override
    public String toString() {
        return "Proveedor{" + "idProveedor=" + idProveedor + ", nombreEmpresa=" + nombreEmpresa + ", direccion=" + direccion + ", correo=" + correo + ", telefono=" + telefono + ", tipoServicio=" + tipoServicio + '}';
    }

    
}


