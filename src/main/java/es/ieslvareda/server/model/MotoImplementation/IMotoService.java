package es.ieslvareda.server.model.MotoImplementation;

import es.ieslvareda.model.Coche;
import es.ieslvareda.model.Moto;
import es.ieslvareda.model.Result;

public interface IMotoService {

    // formar todo el CRUD y pasar parametros
    Result<Moto> createMoto(Moto moto);
    Result<Moto> readMoto(String matricula);
    Result<Moto> updateMoto(Moto coche);
    Result<String> deleteMoto(String matricula);
}
