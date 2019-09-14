/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.cecar.test;

import edu.cecar.controladores.ControladorExample;
import edu.cecar.modelos.Example;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase: TestControladorExample
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

    public static void main(String args[]) {
        try {
            //limit 5000
            ControladorExample controladorExample = new ControladorExample();
            HashMap<String, Example> examples = controladorExample.consultarEmpleados();
            Scanner linea = new Scanner(System.in);
            String date;
            String gender;
            System.out.println("Buscar por tipo: ");
            System.out.println("1. Date");
            System.out.println("2. Gender");
            System.out.println("3. Gender and Date");
            System.out.println("Mostrar los elementos ordenados por: ");
            System.out.println("4. Date");
            System.out.println("5. Fatal");
            System.out.print("Opcion: ");
            switch (linea.nextLine()) {
                case "1":
                    System.out.print("Ingrese la fecha (MM/DD/YYYY): ");
                    date = linea.nextLine();
                    examples.entrySet().stream().filter(e -> e.getValue().getDate_of_stop().equals(date)).forEach(e -> System.out.println(" Date " + e.getValue().getDate_of_stop() + " Fatal " + e.getValue().getFatal() + " Alcohol " + e.getValue().getAlcohol() + " Gender " + e.getValue().getGender()));
                    break;
                case "2":
                    System.out.print("Ingrese el genero (M/F): ");
                    gender = linea.nextLine();
                    examples.entrySet().stream().filter(e -> e.getValue().getGender().equals(gender)).forEach(e -> System.out.println(" Date " + e.getValue().getDate_of_stop() + " Fatal " + e.getValue().getFatal() + " Alcohol " + e.getValue().getAlcohol() + " Gender " + e.getValue().getGender()));
                    break;
                case "3":
                    System.out.print("Ingrese la fecha (MM/DD/YYYY): ");
                    date = linea.nextLine();
                    System.out.print("Ingrese el genero (M/F): ");
                    gender = linea.nextLine();
                    examples.entrySet().stream().filter(e -> e.getValue().getDate_of_stop().equals(date) && e.getValue().getGender().equals(gender)).forEach(e -> System.out.println(" Date " + e.getValue().getDate_of_stop() + " Fatal " + e.getValue().getFatal() + " Alcohol " + e.getValue().getAlcohol() + " Gender " + e.getValue().getGender()));
                    break;
                case "4":
                    ArrayList<Example> examples1 = new ArrayList<Example>();
                    examples.entrySet().stream().forEach(e -> examples1.add(e.getValue()));
                    examples1.stream().sorted(Comparator.comparing(Example::getDate_of_stop)).forEach(e -> System.out.println("Date: " + e.getDate_of_stop() + " Fatal: " + e.getFatal() + " Alcohol: " + e.getAlcohol() + " Gender: " + e.getGender()));
                    break;
                case "5":
                    ArrayList<Example> examples2 = new ArrayList<Example>(examples.values());
                    examples2.stream().sorted(Comparator.comparing(Example::getFatal)).forEach(e -> System.out.println("Date: " + e.getDate_of_stop() + " Fatal: " + e.getFatal() + " Alcohol: " + e.getAlcohol() + " Gender: " + e.getGender()));
                    break;
            }
        } catch (SQLException ex) {
            Logger.getLogger(TestControladorExample.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
