package es.ieslvareda.server.model.MotoImplementation;

import es.ieslvareda.model.*;

import javax.sql.DataSource;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

public class ImpMotoService implements IMotoService {

    DataSource dataSource = MyDataSource.getMyOracleDataSource();

    @Override
    public Result<Moto> createMoto(Moto moto){
        String sql = "{call GESTIONVEHICULOS.createMoto(?,?,?,?,?,?,?,?,?,?,?)}";
        try(Connection connection = dataSource.getConnection();
            // este es callable statement
            CallableStatement callableStatement = connection.prepareCall(sql)) {

            callableStatement.setString(1,moto.getMatricula());
            callableStatement.setFloat(2,moto.getPrecioHora());
            callableStatement.setString(3,moto.getMarca());
            callableStatement.setString(4,moto.getDescripcion());
            callableStatement.setString(5,moto.getColor());
            callableStatement.setInt(6,moto.getBateria());
            callableStatement.setString(7,moto.getFechaAdq());
            callableStatement.setString(8,moto.getEstado());
            callableStatement.setString(9,moto.getCarnet());
            callableStatement.setFloat(10,moto.getVelocidadMax());
            callableStatement.setInt(11,moto.getCilindrada());
            callableStatement.execute();

            return new Result.Success<Moto>(moto);
        }catch (SQLException throwables){
            return new Result.Error(throwables.getErrorCode(), throwables.getMessage());
        }
    }

    @Override
    public Result<Moto> readMoto(String matricula) {
        String sql = "{call GESTIONVEHICULOS.readMoto(?,?,?,?,?,?,?,?,?,?,?)}";

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

            TipoVehiculo tipoVehiculo = TipoVehiculo.MOTO;
            callableStatement.execute();

            Moto moto = new Moto(matricula, callableStatement.getFloat(2),callableStatement.getString(3),callableStatement.getString(4),callableStatement.getString(5),callableStatement.getInt(6),callableStatement.getString(7),callableStatement.getString(8),callableStatement.getString(9),tipoVehiculo,callableStatement.getFloat(10),callableStatement.getInt(11));

            return new Result.Success<Moto>(moto);
        }catch (SQLException throwables){
            return new Result.Error(throwables.getErrorCode(), throwables.getMessage());
        }
    }

    @Override
    public Result<Moto> updateMoto(Moto coche) {
        String sql = "{call GESTIONVEHICULOS.updateMoto(?,?,?,?,?,?,?,?,?,?,?)}";
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
            callableStatement.setFloat(10,coche.getVelocidadMax());
            callableStatement.setInt(11,coche.getCilindrada());
            callableStatement.execute();

            return new Result.Success<Moto>(coche);
        }catch (SQLException throwables){
            return new Result.Error(throwables.getErrorCode(), throwables.getMessage());
        }
    }

    @Override
    public Result<String> deleteMoto(String matricula) {
        String sql = "{call GESTIONVEHICULOS.deleteMoto(?)}";
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
