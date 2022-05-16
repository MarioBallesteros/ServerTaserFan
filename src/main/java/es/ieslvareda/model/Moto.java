package es.ieslvareda.model;

public class Moto extends Vehiculo{
    private float velocidadMax;
    private int cilindrada;

    public Moto(String matricula, float precioHora, String marca, String color, String estado, int idCarnet,float velocidadMax,int cilindrada) {
        super(matricula, precioHora, marca, color, estado, idCarnet);
        this.velocidadMax = velocidadMax;
        this.cilindrada = cilindrada;
    }
}
