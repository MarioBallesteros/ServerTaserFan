package es.ieslvareda.server.controllers;

import es.ieslvareda.model.Coche;
import es.ieslvareda.model.Result;
import es.ieslvareda.model.Vehiculo;
import es.ieslvareda.server.model.CocheImplementation.ICocheService;
import es.ieslvareda.server.model.CocheImplementation.ImpCocheService;
import es.ieslvareda.server.model.JsonTransformer;
import es.ieslvareda.server.model.VehiculoImplementation.IVehiculoService;
import es.ieslvareda.server.model.VehiculoImplementation.ImpVehiculoService;
import org.slf4j.LoggerFactory;
import spark.Request;
import spark.Response;

import java.util.logging.Logger;

public class CocheController {
    static Logger logger = LoggerFactory.getLogger(---------------);
    private static ICocheService iCocheService = new ImpCocheService();
    private static JsonTransformer<Coche> jsonTransformer = new JsonTransformer<>();

    public static Result createCoche(Request req, Response res){
        logger.info("Creating a new car");
        String body = req.body();

        Coche coche = jsonTransformer.getObject(body, Coche.class);
        Result result = iCocheService.createCoche(coche);
        if(result instanceof Result.Success)
            res.status(200);
        else {
            Result.Error error = (Result.Error)result;
            res.status(error.getCode());
        }
        return result;
    }
    public static Result readCoche(Request req,Response res){
        logger.info("Reading a car");
        String body = req.body();

        Coche coche = jsonTransformer.getObject(body, Coche.class);
        Result result = iCocheService.readCoche(coche.getMatricula());
        if(result instanceof Result.Success)
            res.status(200);
        else {
            Result.Error error = (Result.Error)result;
            res.status(error.getCode());
        }
        return result;
    }

    public static Result updateCoche(Request req, Response res){
        logger.info("Updating an existing car");
        String body = req.body();

        Coche coche = jsonTransformer.getObject(body, Coche.class);
        Result result = iCocheService.updateCoche(coche);
        if(result instanceof Result.Success)
            res.status(200);
        else {
            Result.Error error = (Result.Error)result;
            res.status(error.getCode());
        }
        return result;
    }

    public static Result deleteCoche(Request req,Response res){
        logger.info("Deleting a car");
        String body = req.body();

        Coche coche = jsonTransformer.getObject(body, Coche.class);
        Result result = iCocheService.deleteCoche(coche.getMatricula());
        if(result instanceof Result.Success)
            res.status(200);
        else {
            Result.Error error = (Result.Error)result;
            res.status(error.getCode());
        }
        return result;
    }
    // update y delete iguales, read no lo se
}
