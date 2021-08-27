package model;


public class Empleados {
    private int id;
    private String idEmpleado;
    private String nombre;
    private String apellido;
    private String cargoLaboral;
    private String salario;
    private String genero;  

    public Empleados() {
    }

    public Empleados(String idEmpleado, String nombre, String apellido, String cargoLaboral, String salario, String genero) {
        this.idEmpleado = idEmpleado;
        this.nombre = nombre;
        this.apellido = apellido;
        this.cargoLaboral = cargoLaboral;
        this.salario = salario;
        this.genero = genero;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(String idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCargoLaboral() {
        return cargoLaboral;
    }

    public void setCargoLaboral(String cargoLaboral) {
        this.cargoLaboral = cargoLaboral;
    }

    public String getSalario() {
        return salario;
    }

    public void setSalario(String salario) {
        this.salario = salario;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
    
    
}
