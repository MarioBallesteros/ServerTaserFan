package es.ieslvareda.server.model.PatineteImplementation;

import es.ieslvareda.model.*;
import es.ieslvareda.server.model.MotoImplementation.IMotoService;

import javax.sql.DataSource;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

public class ImpPatineteService implements IPatineteService {

    DataSource dataSource = MyDataSource.getMyOracleDataSource();

    @Override
    public Result<Patinete> createPatinete(Patinete coche){
        String sql = "{call GESTIONVEHICULOS.createPatinete(?,?,?,?,?,?,?,?,?,?,?)}";
        try(Connection connection = dataSource.getConnection();
            // este es callable statement
            CallableStatement callableStatement = connection.prepareCall(sql)) {

            callableStatement.setString(1,coche.getMatricula());
            callableStatement.setFloat(2,coche.getPrecioHora());
            // AÑADIR TAMBIEN NUMPUERTAS Y NUMPLAZAS /////////
            callableStatement.setString(3,coche.getMarca());
            callableStatement.setString(4,coche.getDescripcion());
            callableStatement.setString(5,coche.getColor());
            callableStatement.setInt(6,coche.getBateria());
            callableStatement.setString(7,coche.getFechaAdq());
            callableStatement.setString(8,coche.getEstado());
            callableStatement.setString(9,coche.getCarnet());
            callableStatement.setInt(10,coche.getNumRuedas());
            callableStatement.setFloat(11,coche.getTamanyo());
            callableStatement.execute();

            return new Result.Success<Patinete>(coche);
        }catch (SQLException throwables){
            return new Result.Error(throwables.getErrorCode(), throwables.getMessage());
        }
    }

    @Override
    public Result<Patinete> readPatinete(String matricula) {
        String sql = "{call GESTIONVEHICULOS.readPatinete(?,?,?,?,?,?,?,?,?,?,?)}";

        try(Connection connection = dataSource.getConnection();
            // este es callable statement
            CallableStatement callableStatement = connection.prepareCall(sql)) {

            callableStatement.setString(1,matricula);
            callableStatement.registerOutParameter(2, Types.NUMERIC);
            callableStatement.registerOutParameter(3, Types.VARCHAR);
            callableStatement.registerOutParameter(4, Types.VARCHAR);
            callableStatement.registerOutParameter(5, Types.VARCHAR);
            callableStatement.registerOutParameter(6, Types.NUMERIC);
            callableStatement.registerOutParameter(7, Types.VARCHAR);
            callableStatement.registerOutParameter(8, Types.VARCHAR);
            callableStatement.registerOutParameter(9, Types.VARCHAR);
            callableStatement.registerOutParameter(10, Types.NUMERIC);
            callableStatement.registerOutParameter(11, Types.NUMERIC);

            TipoVehiculo tipoVehiculo = TipoVehiculo.PATINETE;
            callableStatement.execute();

            Patinete patinete = new Patinete(matricula, callableStatement.getFloat(2),callableStatement.getString(3),callableStatement.getString(4),callableStatement.getString(5),callableStatement.getInt(6),callableStatement.getString(7),callableStatement.getString(8),callableStatement.getString(9),tipoVehiculo,callableStatement.getInt(10),callableStatement.getInt(11));

            return new Result.Success<Patinete>(patinete);
        }catch (SQLException throwables){
            return new Result.Error(throwables.getErrorCode(), throwables.getMessage());
        }
    }

    @Override
    public Result<Patinete> updatePatinete(Patinete coche) {
        String sql = "{call GESTIONVEHICULOS.updatePatinete(?,?,?,?,?,?,?,?,?,?,?)}";
        try(Connection connection = dataSource.getConnection();
            // este es callable statement
            CallableStatement callableStatement = connection.prepareCall(sql)) {

            callableStatement.setString(1,coche.getMatricula());
            callableStatement.setFloat(2,coche.getPrecioHora());
            callableStatement.setString(3,coche.getMarca());
            callableStatement.setString(4,coche.getDescripcion());
            callableStatement.setString(5,coche.getColor());
            callableStatement.setInt(6,coche.getBateria());
            callableStatement.setString(7,coche.getFechaAdq());
            callableStatement.setString(8,coche.getEstado());
            callableStatement.setString(9,coche.getCarnet());
            callableStatement.setInt(10,coche.getNumRuedas());
            callableStatement.setFloat(11,coche.getTamanyo());
            callableStatement.execute();

            return new Result.Success<Patinete>(coche);
        }catch (SQLException throwables){
            return new Result.Error(throwables.getErrorCode(), throwables.getMessage());
        }
    }

    @Override
    public Result<String> deletePatinete(String matricula) {
        String sql = "{call GESTIONVEHICULOS.deletePatinete(?)}";
        try(Connection connection = dataSource.getConnection();
            // este es callable statement
            CallableStatement callableStatement = connection.prepareCall(sql)) {

            callableStatement.setString(1,matricula);
            callableStatement.execute();

            return new Result.Success<String>(matricula);
        }catch (SQLException throwables){
            return new Result.Error(throwables.getErrorCode(), throwables.getMessage());
        }
    }
}


