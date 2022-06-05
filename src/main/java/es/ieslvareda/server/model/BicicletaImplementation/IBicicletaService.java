package es.ieslvareda.server.model.BicicletaImplementation;

import es.ieslvareda.model.Bicicleta;
import es.ieslvareda.model.Coche;
import es.ieslvareda.model.Result;

public interface IBicicletaService {

    // formar todo el CRUD y pasar parametros
    Result<Bicicleta> createBicicleta(Bicicleta coche);
    Result<Bicicleta> readBicicleta(String matricula);
    Result<Bicicleta> updateBicicleta(Bicicleta coche);
    Result<String> deleteBicicleta(String matricula);
}
