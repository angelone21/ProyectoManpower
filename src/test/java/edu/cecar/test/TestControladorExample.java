/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.cecar.test;

import edu.cecar.controladores.ControladorExample;
import edu.cecar.modelos.Example;
import java.sql.SQLException;
import java.util.Comparator;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase: ControladorEmpleado
 * 
 * @version: 0.1
 *  
 * @since: 9/09/2019
 * 
 * Fecha de Modificación:
 * 
 * @author: 1102886426
 * 
 * Copyrigth: CECAR
 */
public class TestControladorExample {
    
    public static void main (String args[]){
        try {
            ControladorExample controladorExample = new ControladorExample();
            HashMap<String,Example> examples = controladorExample.consultarEmpleados();
            examples.entrySet().stream().filter(e -> e.getValue().getGender().equals("M")).sorted(Comparator.comparing(null, null)).forEach(e -> System.out.println("Gender " + e.getValue().getGender() + " Date "+ e.getValue().getDate_of_stop()));
        } catch (SQLException ex) {
            Logger.getLogger(TestControladorExample.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

}
