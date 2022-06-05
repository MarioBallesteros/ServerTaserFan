package es.ieslvareda.server.model.CocheImplementation;

import es.ieslvareda.model.Coche;
import es.ieslvareda.model.Result;

import java.util.List;

public interface ICocheService {

    // formar todo el CRUD y pasar parametros
    Result<Coche> createCoche(Coche coche);
    Result<Coche> readCoche(String matricula);
    Result<Coche> updateCoche(Coche coche);
    Result<String> deleteCoche(String matricula);
}
