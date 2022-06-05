package es.ieslvareda.server.controllers;

import es.ieslvareda.model.Bicicleta;
import es.ieslvareda.model.Coche;
import es.ieslvareda.model.Result;
import es.ieslvareda.server.model.BicicletaImplementation.IBicicletaService;
import es.ieslvareda.server.model.BicicletaImplementation.ImpBicicletaService;
import es.ieslvareda.server.model.CocheImplementation.ImpCocheService;
import es.ieslvareda.server.model.JsonTransformer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import spark.Request;
import spark.Response;

public class BicicletaController {
    static Logger logger = LoggerFactory.getLogger(BicicletaController.class);
    private static IBicicletaService iBicicletaService = new ImpBicicletaService();
    private static JsonTransformer<Bicicleta> jsonTransformer = new JsonTransformer<>();

    public static Result createBicicleta(Request req, Response res){
        logger.info("Creating a new bicycle");
        String body = req.body();

        Bicicleta bicicleta = jsonTransformer.getObject(body, Bicicleta.class);
        Result result = iBicicletaService.createBicicleta(bicicleta);
        if(result instanceof Result.Success)
            res.status(200);
        else {
            Result.Error error = (Result.Error)result;
            res.status(error.getCode());
        }
        return result;
    }
    public static Result readBicicleta (Request req,Response res){
        logger.info("Reading a bicycle");
        String matricula = req.queryParams("matricula");

        Result result = iBicicletaService.readBicicleta(matricula);
        if(result instanceof Result.Success)
            res.status(200);
        else {
            Result.Error error = (Result.Error)result;
            res.status(error.getCode());
        }
        return result;
    }

    public static Result updateBicicleta(Request req, Response res){
        logger.info("Updating an existing bicycle");
        String body = req.body();

        Bicicleta bicicleta = jsonTransformer.getObject(body, Bicicleta.class);
        Result result = iBicicletaService.updateBicicleta(bicicleta);
        if(result instanceof Result.Success)
            res.status(200);
        else {
            Result.Error error = (Result.Error)result;
            res.status(error.getCode());
        }
        return result;
    }

    public static Result deleteBicicleta(Request req,Response res){
        logger.info("Deleting a bicycle");
        String matricula = req.queryParams("matricula");

        Result result = iBicicletaService.deleteBicicleta(matricula);
        if(result instanceof Result.Success)
            res.status(200);
        else {
            Result.Error error = (Result.Error)result;
            res.status(error.getCode());
        }
        return result;
    }
    // update y delete mismos parametros
}
