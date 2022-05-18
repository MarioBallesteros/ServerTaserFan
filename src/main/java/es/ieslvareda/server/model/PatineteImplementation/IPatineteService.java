package es.ieslvareda.server.model.PatineteImplementation;

import es.ieslvareda.model.Coche;
import es.ieslvareda.model.Result;

public interface IPatineteService {

    // formar todo el CRUD y pasar parametros
    Result<Coche> createPatinete(String matricula,float precioHora,String marca,String color,String estado,int idCarnet);
    Result<Coche> readPatinete(String matricula);
    Result<Coche> updatePatinete(String matricula,float precioHora,String marca,String color,String estado,int idCarnet);
    Result<Coche> deletePatinete(String matricula);
}
