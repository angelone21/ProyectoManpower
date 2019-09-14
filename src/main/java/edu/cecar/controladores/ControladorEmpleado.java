/**
 * Clase: ControladorEmpleado
 * 
 * @version: 0.1
 *  
 * @since: 12/08/2019
 * 
 * Fecha de Modificación:
 * 
 * @author: Vincenzo Angelone Salgado
 * 
 * Copyrigth: CECAR
 */

package edu.cecar.controladores;

import edu.cecar.componentes.singletons.SingletonConexionBD;
import edu.cecar.modelos.Empleado;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * Clase que controla las operaciones CRUD de los empleados.
 */
public class ControladorEmpleado {
            
    
    public void guardar(Empleado empleado) throws SQLException{
        
        PreparedStatement preparedStatement = SingletonConexionBD.getinstance().prepareStatement("insert into empleado values(?,?,?,?)");
        preparedStatement.setString(1, empleado.getCodigo());
        preparedStatement.setString(2, empleado.getNombres());
        preparedStatement.setString(3, empleado.getApellidos());
        preparedStatement.setString(4, empleado.getFechaNacimiento());
        preparedStatement.execute();
    
    }
    public Empleado consultar(String codigo) throws SQLException{
        Empleado empleado = null;
        PreparedStatement preparedStatement = SingletonConexionBD.getinstance().prepareStatement("select nombres,apellidos,fechanacimiento from empleado where cedula= ?");
        preparedStatement.setString(1, codigo);
        ResultSet resultado = preparedStatement.executeQuery();
        
        if(resultado.next()){
            empleado = new Empleado(codigo,resultado.getString(1),resultado.getString(2),resultado.getString(3));
        }
        return empleado;
    }
    
    public void actualizar(Empleado empleado) throws SQLException{
        PreparedStatement preparedStatement = SingletonConexionBD.getinstance().prepareStatement("update empleado set nombres = ?,apellidos=?,fechanacimiento=? where cedula = ?");
        preparedStatement.setString(1,empleado.getNombres());
        preparedStatement.setString(2,empleado.getApellidos());
        preparedStatement.setString(3,empleado.getFechaNacimiento());
        preparedStatement.setString(4,empleado.getCodigo());
        preparedStatement.execute();
    }
    public void eliminar(Empleado empleado) throws SQLException{
        PreparedStatement preparedStatement = SingletonConexionBD.getinstance().prepareStatement("delete from empleado where cedula = ?");
        preparedStatement.setString(1,empleado.getCodigo());
        preparedStatement.execute();
    }
    
    public void eliminarTodo() throws SQLException{
        PreparedStatement preparedStatement = SingletonConexionBD.getinstance().prepareStatement("delete from empleado");
        preparedStatement.execute();
    }
}
