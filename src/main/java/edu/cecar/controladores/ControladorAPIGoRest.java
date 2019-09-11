/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.cecar.controladores;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import us.monoid.json.JSONArray;
import us.monoid.json.JSONObject;
import us.monoid.web.Resty;

/**
 * Clase: ControladorAPIGoRest
 * 
 * @version: 0.1
 *  
 * @since: 11/09/2019
 * 
 * Fecha de Modificación:
 * 
 * @author: 1102886426
 * 
 * Copyrigth: CECAR
 */
public class ControladorAPIGoRest {
    public static void main(String[] args) {
        try {
            JSONObject jsonRoot = new Resty().json("https://gorest.co.in/public-api/users?_format=json&access-token=hLBPkVEjnOoZCtSr8qsTiNm2HYCeZyyRBXu9").object();
            JSONObject jsonMeta = jsonRoot.getJSONObject("_meta");
            System.out.println(jsonMeta.get("success"));
            JSONArray jsonArrayResult = jsonRoot.getJSONArray("result");
            for (int i = 0; i < jsonArrayResult.length(); i++) {
                System.out.println(jsonArrayResult.getJSONObject(i).get("first_name") + " " + jsonArrayResult.getJSONObject(i).get("last_name"));
            }
        } catch (Exception ex) {
            Logger.getLogger(ControladorAPIGoRest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
