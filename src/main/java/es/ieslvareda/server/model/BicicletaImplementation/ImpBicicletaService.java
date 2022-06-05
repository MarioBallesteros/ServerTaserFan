package es.ieslvareda.server.model.BicicletaImplementation;

import es.ieslvareda.model.*;
import es.ieslvareda.server.model.BicicletaImplementation.IBicicletaService;

import javax.sql.DataSource;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

public class ImpBicicletaService implements IBicicletaService {


    DataSource dataSource = MyDataSource.getMyOracleDataSource();

    @Override
    public Result<Bicicleta> createBicicleta(Bicicleta coche){
        String sql = "{call GESTIONVEHICULOS.createBicicleta(?,?,?,?,?,?,?,?,?,?)}";
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
            callableStatement.setString(10,coche.getTipo());
            callableStatement.execute();

            return new Result.Success<Bicicleta>(coche);
        }catch (SQLException throwables){
            return new Result.Error(throwables.getErrorCode(), throwables.getMessage());
        }
    }

    @Override
    public Result<Bicicleta> readBicicleta(String matricula) {
        String sql = "{call GESTIONVEHICULOS.readBicicleta(?,?,?,?,?,?,?,?,?,?)}";

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
            callableStatement.registerOutParameter(10, Types.VARCHAR);

            TipoVehiculo tipoVehiculo = TipoVehiculo.BICICLETA;
            callableStatement.execute();

            Bicicleta bicicleta = new Bicicleta(matricula, callableStatement.getFloat(2),callableStatement.getString(3),callableStatement.getString(4),callableStatement.getString(5),callableStatement.getInt(6),callableStatement.getString(7),callableStatement.getString(8),callableStatement.getString(9),tipoVehiculo,callableStatement.getString(10));

            return new Result.Success<Bicicleta>(bicicleta);
        }catch (SQLException throwables){
            return new Result.Error(throwables.getErrorCode(), throwables.getMessage());
        }
    }

    @Override
    public Result<Bicicleta> updateBicicleta(Bicicleta coche) {
        String sql = "{call GESTIONVEHICULOS.updateBicicleta(?,?,?,?,?,?,?,?,?,?)}";
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
            callableStatement.setString(10,coche.getTipo());
            callableStatement.execute();

            return new Result.Success<Bicicleta>(coche);
        }catch (SQLException throwables){
            return new Result.Error(throwables.getErrorCode(), throwables.getMessage());
        }
    }

    @Override
    public Result<String> deleteBicicleta(String matricula) {
        String sql = "{call GESTIONVEHICULOS.deleteBicicleta(?)}";
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
