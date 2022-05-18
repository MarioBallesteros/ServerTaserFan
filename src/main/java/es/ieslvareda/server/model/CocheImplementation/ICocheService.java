package es.ieslvareda.server.model.CocheImplementation;

import es.ieslvareda.model.Coche;
import es.ieslvareda.model.Result;

import java.util.List;

public interface ICocheService {

    // formar todo el CRUD y pasar parametros
    Result<Coche> createCoche(String matricula,float precioHora,String marca,String color,String estado,int idCarnet);
    Result<Coche> readCoche(String matricula);
    Result<Coche> updateCoche(String matricula,float precioHora,String marca,String color,String estado,int idCarnet);
    Result<Coche> deleteCoche(String matricula);
}
