package es.ieslvareda.server.model.PatineteImplementation;

import es.ieslvareda.model.Coche;
import es.ieslvareda.model.MyDataSource;
import es.ieslvareda.model.Result;
import es.ieslvareda.server.model.MotoImplementation.IMotoService;

import javax.sql.DataSource;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

public class ImpPatineteService implements IPatineteService {

    // rellenar parametros
    @Override
    public Result<Coche> createPatinete(String matricula, float precioHora, String marca, String color, String estado, int idCarnet) {

        DataSource dataSource = MyDataSource.getMyOracleDataSource();

        String sql = "{call GESTIONVEHICULOS.insertarPatinete(?,?,?,?,?,?,?,?,?,?,?)}";
        try (Connection connection = dataSource.getConnection();
             // este es callable statement
             CallableStatement callableStatement = connection.prepareCall(sql)) {

            callableStatement.setString(1, matricula);
            callableStatement.setFloat(2, precioHora);
            callableStatement.setString(3, marca);
            callableStatement.setString(4, color);
            callableStatement.setString(5, estado);
            callableStatement.setInt(6, idCarnet);
            // AÑADIR TAMBIEN NUMPUERTAS Y NUMPLAZAS /////////
            callableStatement.execute();


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return new Result.Success<>(200);
    }

    @Override
    public Result<Coche> readPatinete(String matricula) {
        return null;
    }

    @Override
    public Result<Coche> updatePatinete(String matricula, float precioHora, String marca, String color, String estado, int idCarnet) {
        return null;
    }

    @Override
    public Result<Coche> deletePatinete(String matricula) {
        return null;
    }
}


