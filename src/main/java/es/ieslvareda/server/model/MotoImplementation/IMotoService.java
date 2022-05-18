package es.ieslvareda.server.model.MotoImplementation;

import es.ieslvareda.model.Coche;
import es.ieslvareda.model.Result;

public interface IMotoService {

    // formar todo el CRUD y pasar parametros
    Result<Coche> createMoto(String matricula,float precioHora,String marca,String color,String estado,int idCarnet);
    Result<Coche> readMoto(String matricula);
    Result<Coche> updateMoto(String matricula,float precioHora,String marca,String color,String estado,int idCarnet);
    Result<Coche> deleteMoto(String matricula);
}
