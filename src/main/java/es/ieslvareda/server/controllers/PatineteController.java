package es.ieslvareda.server.controllers;

import es.ieslvareda.model.Coche;
import es.ieslvareda.model.Patinete;
import es.ieslvareda.model.Result;
import es.ieslvareda.server.model.CocheImplementation.ImpCocheService;
import es.ieslvareda.server.model.JsonTransformer;
import es.ieslvareda.server.model.PatineteImplementation.IPatineteService;
import es.ieslvareda.server.model.PatineteImplementation.ImpPatineteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import spark.Request;
import spark.Response;

public class PatineteController {
    static Logger logger = LoggerFactory.getLogger(PatineteController.class);
    private static IPatineteService iPatineteService = new ImpPatineteService();
    private static JsonTransformer<Patinete> jsonTransformer = new JsonTransformer<>();

    public static Result createPatinete(Request req, Response res){
        logger.info("Creating a new patinete");
        String body = req.body();

        Patinete patinete = jsonTransformer.getObject(body, Patinete.class);
        Result result = iPatineteService.createPatinete(patinete);
        if(result instanceof Result.Success)
            res.status(200);
        else {
            Result.Error error = (Result.Error)result;
            res.status(error.getCode());
        }
        return result;
    }
    public static Result readPatinete(Request req,Response res){
        logger.info("Reading a patinete");
        String matricula = req.queryParams("matricula");

        Result result = iPatineteService.readPatinete(matricula);
        if(result instanceof Result.Success)
            res.status(200);
        else {
            Result.Error error = (Result.Error)result;
            res.status(error.getCode());
        }
        return result;
    }

    public static Result updatePatinete(Request req, Response res){
        logger.info("Updating an existing patinete");
        String body = req.body();

        Patinete patinete = jsonTransformer.getObject(body, Patinete.class);
        Result result = iPatineteService.updatePatinete(patinete);
        if(result instanceof Result.Success)
            res.status(200);
        else {
            Result.Error error = (Result.Error)result;
            res.status(error.getCode());
        }
        return result;
    }

    public static Result deletePatinete(Request req,Response res){
        logger.info("Deleting a patinete");
        String matricula = req.queryParams("matricula");

        Result result = iPatineteService.deletePatinete(matricula);
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
