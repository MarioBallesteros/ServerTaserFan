package es.ieslvareda.model;

import java.sql.Date;

public class Coche extends Vehiculo{
    private int numPlazas;
    private int numPuertas;

    public Coche(String matricula, float precioHora, String marca, String descripcion, String color, float bateria, String fechaAdq, String estado, String carnet) {
        super(matricula, precioHora, marca, descripcion, color, bateria, fechaAdq, estado, carnet);
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
