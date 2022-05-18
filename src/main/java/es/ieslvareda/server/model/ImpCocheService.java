package es.ieslvareda.server.model;

import es.ieslvareda.model.Coche;
import es.ieslvareda.model.MyDataSource;
import es.ieslvareda.model.Result;
import es.ieslvareda.model.Vehiculo;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ImpCocheService implements ICocheService{

    // rellenar parametros
    @Override
    public Result<Coche> createCoche(String matricula...){

        DataSource dataSource = MyDataSource.getMyOracleDataSource();

        ////////////////////////////////////////////////////////////
        String sql = "{call GESTIONVEHICULOS.insertarCoche(?,?,?,?,?,?,?,?,?,?,?)}";
        try(Connection connection = dataSource.getConnection();
            // este es callable statement
            CallableStatement callableStatement = connection.prepareCall(sql);
       {
                callableStatement.setString(1,matricula);
                matricula = resultSet.getString("matricula");
                precioHora = resultSet.getFloat("precioHora");
                marca = resultSet.getString("marca");
                color = resultSet.getString("color");
                estado = resultSet.getString("estado");
                idCarnet = resultSet.getInt("idCarnet");

                callableStatement.execute();


        }catch (SQLException throwables){
            throwables.printStackTrace();
        }
    return new Result.Success<>(200);
    }



}
