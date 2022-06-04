package es.ieslvareda.server.model.VehiculoImplementation;

import es.ieslvareda.model.MyDataSource;
import es.ieslvareda.model.Vehiculo;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ImpVehiculoService implements IVehiculoService {

    @Override
    public List<Vehiculo> getAll(){
        List<Vehiculo> vehiculosList = new ArrayList<>();
        DataSource dataSource = MyDataSource.getMyMariaDBDataSource();

        try(Connection connection = dataSource.getConnection();
        Statement statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery("select * from vehiculo")){
            String matricula;
            float precioHora;
            String marca;
            String color;
            String estado;
            String carnet;

            while (resultSet.next()){
                matricula = resultSet.getString("matricula");
                precioHora = resultSet.getFloat("precioHora");
                marca = resultSet.getString("marca");
                color = resultSet.getString("color");
                estado = resultSet.getString("estado");
                carnet = resultSet.getString("carnet");

                vehiculosList.add(new Vehiculo(matricula,precioHora,marca, descripcion, color, bateria, fechaAdq, estado,carnet));

            }
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }
    return vehiculosList;
    }

}
