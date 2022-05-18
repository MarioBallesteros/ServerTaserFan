package es.ieslvareda.server.model.BicicletaImplementation;

import es.ieslvareda.model.Coche;
import es.ieslvareda.model.Result;

public interface IBicicletaService {

    // formar todo el CRUD y pasar parametros
    Result<Coche> createBicicleta(String matricula, float precioHora, String marca, String color, String estado, int idCarnet);
    Result<Coche> readBicicleta(String matricula);
    Result<Coche> updateBicicleta(String matricula,float precioHora,String marca,String color,String estado,int idCarnet);
    Result<Coche> deleteBicicleta(String matricula);
}
