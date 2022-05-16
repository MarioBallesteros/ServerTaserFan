package es.ieslvareda.model;

public class Bicicleta extends Vehiculo{
    private String tipo;


    public Bicicleta(String matricula, float precioHora, String marca, String color, String estado, int idCarnet,String tipo) {
        super(matricula, precioHora, marca, color, estado, idCarnet);
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
