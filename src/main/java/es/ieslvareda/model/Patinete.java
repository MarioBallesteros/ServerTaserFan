package es.ieslvareda.model;

public class Patinete extends Vehiculo{
    private int numRuedas;
    private float tamanyo;

    public Patinete(String matricula, float precioHora, String marca, String descripcion, String color, int bateria, String fechaAdq, String estado, String carnet, TipoVehiculo tipoVehiculo,int numRuedas,float tamanyo) {
        super(matricula, precioHora, marca, descripcion, color, bateria, fechaAdq, estado, carnet, tipoVehiculo);
        this.numRuedas = numRuedas;
        this.tamanyo = tamanyo;
    }


    public void setNumRuedas(int numRuedas) {
        this.numRuedas = numRuedas;
    }

    public int getNumRuedas() {
        return numRuedas;
    }

    public void setTamanyo(float tamanyo) {
        this.tamanyo = tamanyo;
    }

    public float getTamanyo() {
        return tamanyo;
    }
}
