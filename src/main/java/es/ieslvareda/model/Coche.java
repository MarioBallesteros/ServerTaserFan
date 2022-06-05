package es.ieslvareda.model;

import java.sql.Date;

public class Coche extends Vehiculo{
    private int numPlazas;
    private int numPuertas;

    public Coche(String matricula, float precioHora, String marca, String descripcion, String color, int bateria, String fechaAdq, String estado, String carnet, TipoVehiculo tipoVehiculo,int numPlazas,int numPuertas) {
        super(matricula, precioHora, marca, descripcion, color, bateria, fechaAdq, estado, carnet, tipoVehiculo);
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

    @Override
    public TipoVehiculo getTipoVehiculo() {
        return super.getTipoVehiculo();
    }

    @Override
    public void setTipoVehiculo(TipoVehiculo tipoVehiculo) {
        super.setTipoVehiculo(tipoVehiculo);
    }
}
