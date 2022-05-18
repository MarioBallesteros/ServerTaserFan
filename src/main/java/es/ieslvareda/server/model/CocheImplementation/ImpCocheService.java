package es.ieslvareda.server.model.CocheImplementation;

import es.ieslvareda.model.Coche;
import es.ieslvareda.model.MyDataSource;
import es.ieslvareda.model.Result;
import es.ieslvareda.server.model.CocheImplementation.ICocheService;

import javax.sql.DataSource;
import java.sql.*;

public class ImpCocheService implements ICocheService {

    // rellenar parametros
    @Override
    public Result<Coche> createCoche(String matricula,float precioHora,String marca,String color,String estado,int idCarnet){

        DataSource dataSource = MyDataSource.getMyOracleDataSource();

        String sql = "{call GESTIONVEHICULOS.insertarCoche(?,?,?,?,?,?,?,?,?,?,?)}";
        try(Connection connection = dataSource.getConnection();
            // este es callable statement
            CallableStatement callableStatement = connection.prepareCall(sql)) {

                callableStatement.setString(1,matricula);
                callableStatement.setFloat(2,precioHora);
                callableStatement.setString(3,marca);
                callableStatement.setString(4,color);
                callableStatement.setString(5,estado);
                callableStatement.setInt(6,idCarnet);
                // AÑADIR TAMBIEN NUMPUERTAS Y NUMPLAZAS /////////
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
    public Result<Coche> updateCoche(String matricula, float precioHora, String marca, String color, String estado, int idCarnet) {
        return null;
    }

    @Override
    public Result<Coche> deleteCoche(String matricula) {
        return null;
    }


}
