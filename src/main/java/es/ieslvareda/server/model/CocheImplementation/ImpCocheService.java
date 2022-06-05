package es.ieslvareda.server.model.CocheImplementation;

import es.ieslvareda.model.Coche;
import es.ieslvareda.model.MyDataSource;
import es.ieslvareda.model.Result;
import es.ieslvareda.model.TipoVehiculo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.sql.DataSource;
import java.sql.*;

public class ImpCocheService implements ICocheService {

    static Logger logger = LoggerFactory.getLogger(ImpCocheService.class);
    DataSource dataSource = MyDataSource.getMyOracleDataSource();

    @Override
    public Result<Coche> createCoche(Coche coche){
        String sql = "{call GESTIONVEHICULOS.createCoche(?,?,?,?,?,?,?,?,?,?,?)}";
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
             callableStatement.setInt(10,coche.getNumPlazas());
             callableStatement.setInt(11,coche.getNumPuertas());
             callableStatement.execute();

            return new Result.Success<Coche>(coche);
        }catch (SQLException throwables){
           return new Result.Error(throwables.getErrorCode(), throwables.getMessage());
        }
    }

    @Override
    public Result<Coche> readCoche(String matricula) {
        String sql = "{call GESTIONVEHICULOS.readCoche(?,?,?,?,?,?,?,?,?,?,?)}";

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

            TipoVehiculo tipoVehiculo = TipoVehiculo.COCHE;
            callableStatement.execute();

            Coche coche = new Coche(matricula, callableStatement.getFloat(2),callableStatement.getString(3),callableStatement.getString(4),callableStatement.getString(5),callableStatement.getInt(6),callableStatement.getString(7),callableStatement.getString(8),callableStatement.getString(9),tipoVehiculo,callableStatement.getInt(10),callableStatement.getInt(11));

            return new Result.Success<Coche>(coche);
        }catch (SQLException throwables){
            return new Result.Error(throwables.getErrorCode(), throwables.getMessage());
        }
    }

    @Override
    public Result<Coche> updateCoche(Coche coche) {
        String sql = "{call GESTIONVEHICULOS.updateCoche(?,?,?,?,?,?,?,?,?,?,?)}";
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
            callableStatement.setInt(10,coche.getNumPlazas());
            callableStatement.setInt(11,coche.getNumPuertas());
            callableStatement.execute();

            return new Result.Success<Coche>(coche);
        }catch (SQLException throwables){
            return new Result.Error(throwables.getErrorCode(), throwables.getMessage());
        }
    }

    @Override
    public Result<String> deleteCoche(String matricula) {
        String sql = "{call GESTIONVEHICULOS.deleteCoche(?)}";
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
