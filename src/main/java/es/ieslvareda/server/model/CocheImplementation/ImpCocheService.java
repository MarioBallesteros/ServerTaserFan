package es.ieslvareda.server.model.CocheImplementation;

import es.ieslvareda.model.Coche;
import es.ieslvareda.model.MyDataSource;
import es.ieslvareda.model.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.sql.DataSource;
import java.sql.*;

public class ImpCocheService implements ICocheService {

    static Logger logger = LoggerFactory.getLogger(ImpCocheService.class);
    @Override
    public Result<Coche> createCoche(Coche coche){

        DataSource dataSource = MyDataSource.getMyOracleDataSource();

        String sql = "{call GESTIONVEHICULOS.insertarCoche(?,?,?,?,?,?,?,?,?,?,?)}";
        try(Connection connection = dataSource.getConnection();
            // este es callable statement
            CallableStatement callableStatement = connection.prepareCall(sql)) {

            callableStatement.setString(1,coche.getMatricula());
            callableStatement.setFloat(2,coche.getPrecioHora());
             // AÑADIR TAMBIEN NUMPUERTAS Y NUMPLAZAS /////////
             callableStatement.setString(3,coche.getMarca());
             callableStatement.setString(4,coche.getDescripcion());
             callableStatement.setString(5,coche.getColor());
             callableStatement.setFloat(6,coche.getBateria());
             callableStatement.setString(7,coche.getFechaAdq());
             callableStatement.setString(8,coche.getCarnet());
             callableStatement.setString(9,coche.getEstado());
             callableStatement.setString(10,coche.getMatricula());
            callableStatement.execute();


        }catch (SQLException throwables){
            throwables.printStackTrace();
        }
    return new Result.Success<>(200);
    }

    @Override
    public Result<Coche> readCoche(String matricula) {
        return null;
    }

    @Override
    public Result<Coche> updateCoche(Coche coche) {
        return null;
    }

    @Override
    public Result<Coche> deleteCoche(String matricula) {
        return null;
    }


}
