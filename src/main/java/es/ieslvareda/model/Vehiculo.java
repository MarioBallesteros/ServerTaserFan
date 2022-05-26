package es.ieslvareda.model;

import java.sql.Date;

public class Vehiculo {
    private String matricula;
    private float precioHora;
    private String marca;
    private String descripcion;
    private String color;
    private float bateria;
    private Date fechaAdq;
    private int idCarnet;
    private String estado;
    private Tabla tabla;


    public Vehiculo(String matricula, float precioHora, String marca, String descripcion, String color, float bateria, Date fechaAdq, String estado, int idCarnet, Tabla tabla) {
        this.matricula = matricula;
        this.precioHora = precioHora;
        this.marca = marca;
        this.descripcion = descripcion;
        this.color = color;
        this.bateria = bateria;
        this.fechaAdq = fechaAdq;
        this.estado = estado;
        this.idCarnet = idCarnet;
        this.tabla = tabla;
    }


    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public float getPrecioHora() {
        return precioHora;
    }

    public void setPrecioHora(float precioHora) {
        this.precioHora = precioHora;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getIdCarnet() {
        return idCarnet;
    }

    public void setIdCarnet(int idCarnet) {
        this.idCarnet = idCarnet;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public float getBateria() {
        return bateria;
    }

    public void setBateria(float bateria) {
        this.bateria = bateria;
    }

    public Date getFechaAdq() {
        return fechaAdq;
    }

    public void setFechaAdq(Date fechaAdq) {
        this.fechaAdq = fechaAdq;
    }

    public Tabla getTabla() {
        return tabla;
    }

    public void setTabla(Tabla tabla) {
        this.tabla = tabla;
    }
}

