package es.ieslvareda.server.model.VehiculoImplementation;

import es.ieslvareda.model.MyDataSource;
import es.ieslvareda.model.TipoVehiculo;
import es.ieslvareda.model.Vehiculo;
import oracle.jdbc.OracleTypes;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ImpVehiculoService implements IVehiculoService {

    @Override
    public List<Vehiculo> getType(TipoVehiculo tipoVehiculo) {
        List<Vehiculo> vehiculoList = new ArrayList<>();

        String sql = "{call gestionvehiculos.listarvehiculos(?, ?)}";
        ResultSet rs;
        try(Connection con = MyDataSource.getMyOracleDataSource().getConnection();
        CallableStatement callableStatement = con.prepareCall(sql)) {

            callableStatement.setString(1,tipoVehiculo.toString());
            callableStatement.registerOutParameter(2, OracleTypes.CURSOR);
            callableStatement.execute();

            rs = (ResultSet) callableStatement.getObject(2);

            while (rs.next()){
                vehiculoList.add(new Vehiculo(rs.getString("c1"),rs.getFloat("n1"),rs.getString("c2"),
                        rs.getString("c3"),rs.getString("c4"),rs.getInt("n2"),rs.getString("c5"),
                        rs.getString("c6"),rs.getString("c7"),tipoVehiculo));
            }
        } catch (SQLException throwables) {
                throwables.printStackTrace();
        }

        return vehiculoList;
    }
    @Override
    public List<Vehiculo> getAll(){
        List<Vehiculo> vehiculos = new ArrayList<>();

        for(Vehiculo vehiculo : getType(TipoVehiculo.COCHE)){
            vehiculos.add(vehiculo);
        }
        for(Vehiculo vehiculo : getType(TipoVehiculo.MOTO)){
            vehiculos.add(vehiculo);
        }
        for(Vehiculo vehiculo : getType(TipoVehiculo.PATINETE)){
            vehiculos.add(vehiculo);
        }
        for(Vehiculo vehiculo : getType(TipoVehiculo.BICICLETA)){
            vehiculos.add(vehiculo);
        }
        return vehiculos;
    }



}
