/**
 * Clase: TestControladorEmpleado
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
package edu.cecar.test;


import edu.cecar.controladores.ControladorEmpleado;
import edu.cecar.modelos.Empleado;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 *
 * @author 1102886426
 */
public class TestControladorEmpleado {
 
    
    @Test
    public void testConexionBaseDatos(){
        try{
            ControladorEmpleado controladorEmpleado = new ControladorEmpleado();
        }catch(Exception ex){
            fail("Error de conexión");
            Logger.getLogger(TestControladorEmpleado.class.getName()).log(Level.SEVERE,null,ex);
        }
        
    }
    
    @Test
    public void testGuardar(){
        Empleado empleado = new Empleado("9212","Vincenzo","Angelone","1999-02-21");
        try {
            ControladorEmpleado controladorEmpleado = new ControladorEmpleado();
            controladorEmpleado.guardar(empleado);
            Empleado empleadoBaseDatos = controladorEmpleado.consultar(empleado.getCodigo());
            assertEquals("El codigo esperado no coincide con el insertado", empleado.getCodigo(), empleadoBaseDatos.getCodigo());
            assertEquals("El nombre esperado no coincide con el insertado", empleado.getNombres(), empleadoBaseDatos.getNombres());
            assertEquals("El apellido esperado no coincide con el insertado", empleado.getApellidos(), empleadoBaseDatos.getApellidos());
            assertEquals("La fecha de nacimiento esperada no coincide con la insertada", empleado.getFechaNacimiento(), empleadoBaseDatos.getFechaNacimiento());
        } catch (SQLException ex) {
            Logger.getLogger(TestControladorEmpleado.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Test
    public void testActualizar(){
        Empleado empleado = new Empleado("9212","Rafael","Avila","1990-07-15");
        try {
            ControladorEmpleado controladorEmpleado = new ControladorEmpleado();
            controladorEmpleado.actualizar(empleado);
        } catch (SQLException ex) {
            Logger.getLogger(TestControladorEmpleado.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    @Test
    public void testEliminar(){
        Empleado empleado = new Empleado("9212","Rafael","Avila","1990-07-15");
        try {
                ControladorEmpleado controladorEmpleado = new ControladorEmpleado();
                controladorEmpleado.eliminar(empleado);
            } catch (SQLException ex) {
                Logger.getLogger(TestControladorEmpleado.class.getName()).log(Level.SEVERE, null, ex);
            }
    
    }
    
    @Test
    public void testAgregarEliminarActualizar(){
            
            Empleado empleado1 = new Empleado("123","Vincenzo","Angelone","1999-02-21");
            Empleado empleado2 = new Empleado("456","Pepito","Avila","1990-07-15");
            Empleado empleado3 = new Empleado("789","Lionel","Messi","1992-05-13");
            Empleado empleado4 = new Empleado("1011","Gio","Urshela","1995-01-15");
            Empleado empleado5 = new Empleado("1213","Lucas","Alvarez","1993-06-18");
        try {
            ControladorEmpleado controladorEmpleado = new ControladorEmpleado();
            controladorEmpleado.eliminarTodo();
            controladorEmpleado.guardar(empleado1);
            controladorEmpleado.guardar(empleado2);
            controladorEmpleado.guardar(empleado3);
            controladorEmpleado.guardar(empleado4);
            controladorEmpleado.guardar(empleado5);
            empleado1.setNombres("Jhon");
            empleado2.setApellidos("Liqua");
            empleado3.setNombres("Alberto");
            empleado4.setApellidos("Angelone");
            empleado5.setNombres("Salvatore");
            controladorEmpleado.actualizar(empleado1);
            controladorEmpleado.actualizar(empleado2);
            controladorEmpleado.actualizar(empleado3);
            controladorEmpleado.actualizar(empleado4);
            controladorEmpleado.actualizar(empleado5);
            controladorEmpleado.eliminar(empleado1);
            controladorEmpleado.eliminar(empleado2);
            controladorEmpleado.eliminar(empleado3);
            controladorEmpleado.eliminar(empleado4);
            controladorEmpleado.eliminar(empleado5);
        } catch (SQLException ex) {
            Logger.getLogger(TestControladorEmpleado.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }
    
    
    
    
}
