package es.ieslvareda.server.model.MotoImplementation;

import es.ieslvareda.model.Coche;
import es.ieslvareda.model.MyDataSource;
import es.ieslvareda.model.Result;

import javax.sql.DataSource;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

public class ImpMotoService implements IMotoService {

    // rellenar parametros
    @Override
    public Result<Coche> createMoto(String matricula,float precioHora,String marca,String color,String estado,int idCarnet){

        DataSource dataSource = MyDataSource.getMyOracleDataSource();

        String sql = "{call GESTIONVEHICULOS.insertarMoto(?,?,?,?,?,?,?,?,?,?,?)}";
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
    public Result<Coche> readMoto(String matricula) {
        return null;
    }

    @Override
    public Result<Coche> updateMoto(String matricula, float precioHora, String marca, String color, String estado, int idCarnet) {
        return null;
    }

    @Override
    public Result<Coche> deleteMoto(String matricula) {
        return null;
    }


}
