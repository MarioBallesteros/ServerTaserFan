package es.ieslvareda.model;

public class Bicicleta extends Vehiculo{
    private String tipo;

    public Bicicleta(String matricula, float precioHora, String marca, String descripcion, String color, float bateria, String fechaAdq, String estado, String carnet,String tipo) {
        super(matricula, precioHora, marca, descripcion, color, bateria, fechaAdq, estado, carnet);
        this.tipo = tipo;
    }


    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
