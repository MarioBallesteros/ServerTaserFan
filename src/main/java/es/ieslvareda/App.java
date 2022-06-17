package es.ieslvareda;

import es.ieslvareda.server.API;
import es.ieslvareda.server.controllers.VehiculoController;
import es.ieslvareda.server.model.JsonTransformer;

import static spark.Spark.*;

public class App {

    public static void main(String[] args) {

        get(API.Routes.ALL_VEHICLES, VehiculoController::getAllVehicles, new JsonTransformer<>());
//        post(API.Routes.NEW_CITY,CiudadController::addCity, new JsonTransformer<>());

        // Oracle
        // post(API.Routes.AUTHENTICATE, EmpleadoController::authenticate, new JsonTransformer<>());
    }

}