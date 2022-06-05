package es.ieslvareda.server.model.EmpleadoImplementation;

import es.ieslvareda.model.AuthenticateData;
import es.ieslvareda.model.Empleado;
import es.ieslvareda.model.Result;

import java.util.List;

public interface IEmpleadoService {
    List<Empleado> getEmpleados();
    Result<Empleado> auth(AuthenticateData authenticateData);
}
