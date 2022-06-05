package es.ieslvareda.server.controllers;

import es.ieslvareda.model.AuthenticateData;
import es.ieslvareda.model.Empleado;
import es.ieslvareda.model.Result;
import es.ieslvareda.server.model.EmpleadoImplementation.IEmpleadoService;
import es.ieslvareda.server.model.EmpleadoImplementation.ImpEmpleadoService;
import es.ieslvareda.server.model.JsonTransformer;
import spark.Request;
import spark.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class EmpleadoController {
    static Logger logger = LoggerFactory.getLogger(EmpleadoController.class);
    private static IEmpleadoService iEmpleadoService = new ImpEmpleadoService();

    private static JsonTransformer<AuthenticateData> authTransformer = new JsonTransformer<>();

    public static Result<Empleado> authEmpleado(Request req,Response res){
        logger.info("autenticating Empleado");
        Result result;
        String body = req.body();
        AuthenticateData authenticateData = authTransformer.getObject(body,AuthenticateData.class);
        result = iEmpleadoService.auth(authenticateData);

        if (result instanceof Result.Success){
            res.status(200);
        } else {
            res.status(404);
        }

        return result;
        }

}
