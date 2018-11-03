/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;
import model.Modelproveedores;
import View_proveedores.view_proveedores;
import controller.Contrallerproveedores;
/**
 *
 * @author Salvador Hernández Mendoza
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
       Modelproveedores modelproveedores = new Modelproveedores();
        view_proveedores view_proveedores = new view_proveedores();
        Contrallerproveedores Contrallerproveedores = new Contrallerproveedores(modelproveedores,view_proveedores);
    }
    }
    
