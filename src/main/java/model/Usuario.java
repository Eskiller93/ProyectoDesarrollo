package model;

public class Usuario {
    private int id;
    private String Usuario;
    private String Contrasena;
    private String tipoDeUsuario;
    private String correoUsuario;
    private String Nombre;
    private String Apellido;
    private boolean activo;

    public Usuario(String Usuario, String Contrasena, String tipoDeUsuario, String correoUsuario, String Nombre, String Apellido, boolean activo) {
        this.Usuario = Usuario;
        this.Contrasena = Contrasena;
        this.tipoDeUsuario = tipoDeUsuario;
        this.correoUsuario = correoUsuario;
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.activo = activo;
    }

    public Usuario() {
    }

    public Usuario(String Usuario, String Nombre, String Apellido, String tipoDeUsuario, boolean activo) {
        this.Usuario = Usuario;
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.tipoDeUsuario = tipoDeUsuario;
        this.activo = activo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String Usuario) {
        this.Usuario = Usuario;
    }

    public String getContrasena() {
        return Contrasena;
    }

    public void setContrasena(String Contrasena) {
        this.Contrasena = Contrasena;
    }

    public String getTipoDeUsuario() {
        return tipoDeUsuario;
    }

    public void setTipoDeUsuario(String tipoDeUsuario) {
        this.tipoDeUsuario = tipoDeUsuario;
    }

    public String getCorreoUsuario() {
        return correoUsuario;
    }

    public void setCorreoUsuario(String correoUsuario) {
        this.correoUsuario = correoUsuario;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
    
    
    
}
