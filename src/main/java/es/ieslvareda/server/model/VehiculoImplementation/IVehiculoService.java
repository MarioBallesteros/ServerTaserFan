package es.ieslvareda.server.model.VehiculoImplementation;

import es.ieslvareda.model.Result;
import es.ieslvareda.model.TipoVehiculo;
import es.ieslvareda.model.Vehiculo;

import java.util.List;

public interface IVehiculoService {
    List<Vehiculo> getAll();
    List <Vehiculo> getType(TipoVehiculo tipoVehiculo);

}
