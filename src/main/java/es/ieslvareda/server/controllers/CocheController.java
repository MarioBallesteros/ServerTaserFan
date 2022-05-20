package es.ieslvareda.server.controllers;

import es.ieslvareda.model.Result;
import es.ieslvareda.model.Vehiculo;
import es.ieslvareda.server.model.JsonTransformer;
import es.ieslvareda.server.model.VehiculoImplementation.IVehiculoService;
import es.ieslvareda.server.model.VehiculoImplementation.ImpVehiculoService;
import org.slf4j.LoggerFactory;

import java.util.logging.Logger;

public class CocheController {
    static Logger logger = LoggerFactory.getLogger(--------);
    private static IVehiculoService iVehiculoService = new ImpVehiculoService();
    private static JsonTransformer<Vehiculo> jsonTransformer = new JsonTransformer<>();

    public static Result createCoche(Request req, Response res){
        logger.info("Creating a new car");
        String body = req.body();

        Coche coche = jsonTransformer.getObjet(body, Coche.class);
        Result result = service.createCoche(coche);
        if(result instanceof Result.Success)
            res.status(200);
        else {
            Result.Error error = (Result.Error)result;
            res.status(error.getCode());
        }
        return result;
    }
    // update y delete iguales, read no lo sñe
}
