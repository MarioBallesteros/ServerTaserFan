package es.ieslvareda.server.controllers;

import es.ieslvareda.model.Vehiculo;
import es.ieslvareda.server.model.JsonTransformer;
import es.ieslvareda.server.model.VehiculoImplementation.IVehiculoService;
import es.ieslvareda.server.model.VehiculoImplementation.ImpVehiculoService;
import org.eclipse.jetty.client.api.Request;
import org.eclipse.jetty.client.api.Response;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.logging.Logger;

public class VehiculoController {
    static Logger logger = LoggerFactory.getLogger(--------);
    private static IVehiculoService iVehiculoService = new ImpVehiculoService();
    private static JsonTransformer<Vehiculo> jsonTransformer = new JsonTransformer<>();

    public static List<Vehiculo> getAllVehicles(Request request, Response response){
        logger.info("Receiving all vehicles");
        return iVehiculoService.getAll();
    }
}
