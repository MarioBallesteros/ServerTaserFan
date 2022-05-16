package es.ieslvareda.server.model;

import es.ieslvareda.model.Result;
import es.ieslvareda.model.Vehiculo;

import java.util.List;

public interface IVehiculoService {
    List<Vehiculo> getAll();
    Result<Vehiculo> get(String matricula);

}
