package es.ieslvareda.model;

public class Patinete extends Vehiculo{
    private String matricula;
    private float precioHora;
    private String marca;
    private String color;
    private String estado;
    private int idCarnet;
    private int numRuedas;
    private float tamanyo;


    public Patinete(String matricula, float precioHora, String marca, String color, String estado, int idCarnet,int numRuedas,float tamanyo) {
        super(matricula, precioHora, marca, descripcion, color, bateria, fechaAdq, estado, idCarnet, tabla);
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
