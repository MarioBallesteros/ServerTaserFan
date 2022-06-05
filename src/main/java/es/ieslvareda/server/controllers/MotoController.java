package es.ieslvareda.server.controllers;

import es.ieslvareda.model.Moto;
import es.ieslvareda.model.Result;

import es.ieslvareda.server.model.JsonTransformer;
import es.ieslvareda.server.model.MotoImplementation.IMotoService;
import es.ieslvareda.server.model.MotoImplementation.ImpMotoService;
import spark.Request;
import spark.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class MotoController {
    static Logger logger = LoggerFactory.getLogger(MotoController.class);
    private static IMotoService iMotoService = new ImpMotoService();
    private static JsonTransformer<Moto> jsonTransformer = new JsonTransformer<>();

    public static Result createMoto(Request req, Response res){
        logger.info("Creating a new motorcycle");
        String body = req.body();

        Moto moto = jsonTransformer.getObject(body, Moto.class);
        Result result = iMotoService.createMoto(moto);
        if(result instanceof Result.Success)
            res.status(200);
        else {
            Result.Error error = (Result.Error)result;
            res.status(error.getCode());
        }
        return result;
    }
    public static Result readMoto(Request req,Response res){
        logger.info("Reading a motorcycle");
        String matricula = req.queryParams("matricula");

        Result result = iMotoService.readMoto(matricula);
        if(result instanceof Result.Success)
            res.status(200);
        else {
            Result.Error error = (Result.Error)result;
            res.status(error.getCode());
        }
        return result;
    }

    public static Result updateMoto(Request req, Response res){
        logger.info("Updating an existing motorcycle");
        String body = req.body();

        Moto moto = jsonTransformer.getObject(body, Moto.class);
        Result result = iMotoService.updateMoto(moto);
        if(result instanceof Result.Success)
            res.status(200);
        else {
            Result.Error error = (Result.Error)result;
            res.status(error.getCode());
        }
        return result;
    }

    public static Result deleteMoto(Request req,Response res){
        logger.info("Deleting a motorcycle");
        String matricula = req.queryParams("matricula");

        Result result = iMotoService.deleteMoto(matricula);
        if(result instanceof Result.Success)
            res.status(200);
        else {
            Result.Error error = (Result.Error)result;
            res.status(error.getCode());
        }
        return result;
    }
}
