package es.ieslvareda.model;

import com.mysql.cj.jdbc.MysqlDataSource;
import es.ieslvareda.properties.MyConfig;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Model {

    // MariaDB
    public List<Empleado> getPersons(){

        List<Empleado> empleadoList = new ArrayList<>();
        DataSource dataSource = MyDataSource.getMyOracleDataSource();

        try(Connection con = dataSource.getConnection();
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from empleado")){

            String dni;
            String nombre;
            String apellidos;
            String email;

            while(resultSet.next()){
                dni = resultSet.getString("dni");
                nombre = resultSet.getString("nombre");
                apellidos = resultSet.getString("apellidos");
                email = resultSet.getString("email");

                empleadoList.add(new Empleado(dni,nombre,apellidos,email));

            }


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


        return empleadoList;

    }
    public Person addPerson(Person person){

        DataSource ds = MyDataSource.getMyMariaDBDataSource();

        try(Connection con = ds.getConnection();
        Statement statement = con.createStatement();) {
            String sql = "INSERT INTO " +
                    "person VALUES ('"+person.getDni()+"','"+person.getNombre()+"','"+person.getApellidos()+"',"+person.getEdad()+")";

            int count = statement.executeUpdate(sql);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return person;
    }
    public int updatePerson(Person person){
        DataSource ds = MyDataSource.getMyMariaDBDataSource();
        int count = 0 ;
        try(Connection con = ds.getConnection();
            Statement statement = con.createStatement();) {
            String sql = "UPDATE person SET " +
                    "nombre='"+person.getNombre()+"',apellidos='"+person.getApellidos()+"', edad="+person.getEdad()+
                    " WHERE dni='"+person.getDni()+"'";

            count = statement.executeUpdate(sql);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return count;
    }
    public int deletePerson(String dni){

        DataSource ds = MyDataSource.getMyMariaDBDataSource();
        int count = 0 ;
        String sql = "DELETE FROM person WHERE dni=?";

        try(Connection con = ds.getConnection();
            PreparedStatement pstmt = con.prepareStatement(sql);) {

            int pos = 0;
            pstmt.setString(++pos, dni);

            count = pstmt.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return count;
    }

    // Oracle
    public List<Empleado> getEmpleados(){

        List<Empleado> empleados = new ArrayList<>();
        try(Connection con = MyDataSource.getMyOracleDataSource().getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT NOMBRE FROM EMPLEADO")) {

            int pos;
            while (rs.next()){
                empleados.add(new Empleado(rs.getString(1)));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return empleados;
    }
    public boolean authenticate(String email,String password){
        boolean auth = false;

        String sql = "SELECT COUNT(*) FROM EMPLEADO WHERE " +
                    "EMAIL='"+email+"' AND "+
                    "PASSWORD=ENCRYPT_PASWD.encrypt_val('"+password+"')";

        DataSource ds = MyDataSource.getMyOracleDataSource();

        try(Connection con = ds.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql)) {

            rs.next();

            int count = rs.getInt(1);

            auth = (count==0)?false:true;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return auth;
    }


}
