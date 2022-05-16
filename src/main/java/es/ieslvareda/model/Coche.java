package es.ieslvareda.model;

public class Coche extends Vehiculo{
    private int numPlazas;
    private int numPuertas;

    public Coche(String matricula, float precioHora, String marca, String color, String estado, int idCarnet,int numPlazas,int numPuertas) {
        super(matricula, precioHora, marca, color, estado, idCarnet);
        this.numPlazas = numPlazas;
        this.numPuertas = numPuertas;
    }

    public int getNumPlazas() {
        return numPlazas;
    }

    public void setNumPlazas(int numPlazas) {
        this.numPlazas = numPlazas;
    }

    public int getNumPuertas() {
        return numPuertas;
    }

    public void setNumPuertas(int numPuertas) {
        this.numPuertas = numPuertas;
    }
}
