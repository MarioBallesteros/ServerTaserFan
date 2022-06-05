package es.ieslvareda.server.model.EmpleadoImplementation;

import es.ieslvareda.model.AuthenticateData;
import es.ieslvareda.model.Empleado;
import es.ieslvareda.model.MyDataSource;
import es.ieslvareda.model.Result;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ImpEmpleadoService implements IEmpleadoService {
    DataSource dataSource = MyDataSource.getMyOracleDataSource();
    @Override
    public List<Empleado> getEmpleados() {
        List<Empleado> empleados = new ArrayList<>();
        String sql = "select * from empleado";
        try(Connection connection = dataSource.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql))
        {
            String dni;
            String nombre;
            String apellidos;
            String email;
            String domicilio;

            while (resultSet.next()){
                dni = resultSet.getString("dni");
                nombre = resultSet.getString("nombre");
                apellidos = resultSet.getString("apellidos");
                email = resultSet.getString("email");
                domicilio = resultSet.getString("domicilio");

                empleados.add(new Empleado(dni,nombre,apellidos,email,domicilio));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return empleados;
    }

    @Override
    public Result<Empleado> auth(AuthenticateData authenticateData) {
        Empleado empleado = null;
        String sql = "select * from empleado where email like ? and ENCRYPT_PASWD.decrypt_val(password) like ?";
        try(Connection connection = dataSource.getConnection();
            PreparedStatement pstmt = connection.prepareCall(sql);) {
            int pos = 0;
            pstmt.setString(++pos,authenticateData.getEmail());
            pstmt.setString(++pos,authenticateData.getPasswd());
            ResultSet resultSet = pstmt.executeQuery();

            if (resultSet.next()){
                String dni = resultSet.getString("DNI");
                String nombre = resultSet.getString("nombre");
                String apellidos = resultSet.getString("nombre");
                String email = resultSet.getString("email");
                String domicilio = resultSet.getString("domicilio");

                empleado = new Empleado(dni,nombre,apellidos,email,domicilio);
                return new Result.Success<Empleado>(empleado);
            }else
                return new Result.Error(400,"");
        }catch (SQLException throwables){
            return new Result.Error(throwables.getErrorCode(), throwables.getMessage());
        }
    }
}
