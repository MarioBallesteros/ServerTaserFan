package es.ieslvareda.model;

public class Vehiculo {
    private String matricula;
    private float precioHora;
    private String marca;
    private String color;
    private String estado;
    private int idCarnet;


    public Vehiculo(String matricula, float precioHora, String marca, String color,String estado, int idCarnet) {
        this.matricula = matricula;
        this.precioHora = precioHora;
        this.marca = marca;
        this.color = color;
        this.estado = estado;
        this.idCarnet = idCarnet;
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
}

