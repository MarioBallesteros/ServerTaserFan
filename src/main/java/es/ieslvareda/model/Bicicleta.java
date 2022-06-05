package es.ieslvareda.model;

public class Bicicleta extends Vehiculo{
    private String tipo;

    public Bicicleta(String matricula, float precioHora, String marca, String descripcion, String color, int bateria, String fechaAdq, String estado, String carnet, TipoVehiculo tipoVehiculo,String tipo) {
        super(matricula, precioHora, marca, descripcion, color, bateria, fechaAdq, estado, carnet, tipoVehiculo);
        this.tipo = tipo;
    }


    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
