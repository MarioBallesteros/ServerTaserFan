package es.ieslvareda.model;

public class Moto extends Vehiculo{
    private float velocidadMax;
    private int cilindrada;

    public Moto(String matricula, float precioHora, String marca, String descripcion, String color, int bateria, String fechaAdq, String estado, String carnet, TipoVehiculo tipoVehiculo,float velocidadMax,int cilindrada) {
        super(matricula, precioHora, marca, descripcion, color, bateria, fechaAdq, estado, carnet, tipoVehiculo);
        this.velocidadMax = velocidadMax;
        this.cilindrada = cilindrada;
    }


    public float getVelocidadMax() {
        return velocidadMax;
    }

    public void setVelocidadMax(float velocidadMax) {
        this.velocidadMax = velocidadMax;
    }

    public int getCilindrada() {
        return cilindrada;
    }

    public void setCilindrada(int cilindrada) {
        this.cilindrada = cilindrada;
    }
}
