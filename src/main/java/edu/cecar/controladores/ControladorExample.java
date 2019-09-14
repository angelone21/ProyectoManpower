/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.cecar.controladores;

import edu.cecar.componentes.singletons.SingletonConexionBD;
import edu.cecar.modelos.Example;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

/**
 * Clase: ControladorExample
 * 
 * @version: 0.1
 *  
 * @since: 2/09/2019
 * 
 * Fecha de Modificación:
 * 
 * @author: 1102886426
 * 
 * Copyrigth: CECAR
 */
public class ControladorExample {
    
    public HashMap<String,Example> consultarEmpleados() throws SQLException{
        
        HashMap<String,Example> resultado = new HashMap<String,Example>();  
        //Se recuperan los registros de la tabla examples
        PreparedStatement preparedStatement = SingletonConexionBD.getinstance().prepareStatement("Select * from examples limit 5000");
        ResultSet result = preparedStatement.executeQuery();
        int i = 1;
        while(result.next()){
            Example example = new Example(result.getString(1),result.getString(2),result.getString(3), result.getString(4));
            resultado.put(i++ +"",example);
        }
        return resultado;
    }

}