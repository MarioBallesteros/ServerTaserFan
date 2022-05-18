package es.ieslvareda.server.model;

import es.ieslvareda.model.Result;

import java.util.List;

public interface ICocheService {

    // formar todo el CRUD y pasar parametros
    Result<Coche> createCoche(String dni);
    boolean update(Person person);
    boolean delete(String dni);
    Result<Person> add(Person person);

}
