package es.ieslvareda.model;

public class Empleado {

    private String dni;
    private String nombre;
    private String apellidos;
    private String domicilio;
    private String cp;

    public Empleado(String dni,String nombre,String apellidos,String domicilio, String cp){
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.domicilio = domicilio;
        this.cp = cp;
    }
    public Empleado(String nombre) {
        this.nombre = nombre;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getDni() {
        return dni;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    public String getCp() {
        return cp;
    }


}
