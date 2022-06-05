package es.ieslvareda.server.controllers;

import es.ieslvareda.model.*;
import es.ieslvareda.server.model.JsonTransformer;
import es.ieslvareda.server.model.VehiculoImplementation.IVehiculoService;
import es.ieslvareda.server.model.VehiculoImplementation.ImpVehiculoService;
import org.eclipse.jetty.client.api.Request;
import org.eclipse.jetty.client.api.Response;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import java.util.List;

public class VehiculoController {
    static Logger logger = LoggerFactory.getLogger(VehiculoController.class);
    private static IVehiculoService iVehiculoService = new ImpVehiculoService();

    private static JsonTransformer<Vehiculo> vehiculoTransformer = new JsonTransformer<>();

    public static List<Vehiculo> getAllVehicles(Request request, Response response){
        logger.info("Receiving all vehicles");
        return iVehiculoService.getAll();
    }
}
