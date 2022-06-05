package es.ieslvareda.server.model.PatineteImplementation;

import es.ieslvareda.model.Coche;
import es.ieslvareda.model.Moto;
import es.ieslvareda.model.Patinete;
import es.ieslvareda.model.Result;

public interface IPatineteService {

    // formar todo el CRUD y pasar parametros
    Result<Patinete> createPatinete(Patinete moto);
    Result<Patinete> readPatinete(String matricula);
    Result<Patinete> updatePatinete(Patinete coche);
    Result<String> deletePatinete(String matricula);
}
