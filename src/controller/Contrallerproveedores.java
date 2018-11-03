/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import model.Modelproveedores;
import View_proveedores.view_proveedores;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Dani
 */
public class Contrallerproveedores {
    Modelproveedores modelproveedores;
    view_proveedores view_proveedores;
 
         
        ActionListener actionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == view_proveedores.primero_proveedores_jb) {
                try {
                    jbtn_primero_actionPerformed();
                } catch (SQLException ex) {
                    Logger.getLogger(Contrallerproveedores.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if (e.getSource() == view_proveedores.anterior_proveedores_jbtn) {
                try {
                    jbtn_anterior_actionPerformed();
                } catch (SQLException ex) {
                    Logger.getLogger(Contrallerproveedores.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if (e.getSource() == view_proveedores.siguiente_proveedores_jb) {
                try {
                    jbtn_siguiente_actionPerformed();
                } catch (SQLException ex) {
                    Logger.getLogger(Contrallerproveedores.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if (e.getSource() == view_proveedores.ultimo_proveedores_jb) {
                try {
                    jbtn_ultimo_actionPerformed();
                } catch (SQLException ex) {
                    Logger.getLogger(Contrallerproveedores.class.getName()).log(Level.SEVERE, null, ex);
                }
            }else if (e.getSource() == view_proveedores.buscar_proveedores_jb){
                try{
                    jb_nuevo_actionPerformed();
                } catch (SQLException ex){
                    Logger.getLogger(Contrallerproveedores.class.getName()).log(Level.SEVERE, null, ex);
                }
            }else if (e.getSource() == view_proveedores.insertar_proveedores_jb){
                jb_insertar_actionPerformed();
            }else if (e.getSource() == view_proveedores.modificar_proveedores_jb){
                try{
                    jb_modificar_actionPerformed();
                } catch (SQLException ex){
                    Logger.getLogger(Contrallerproveedores.class.getName()).log(Level.SEVERE, null, ex);
                }  
            
            }else if (e.getSource() == view_proveedores.borrar_proveedores_jb){
                try{
                    jb_eliminar_actionPerformed();
                } catch (SQLException ex){
                    Logger.getLogger(Contrallerproveedores.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
            }

        

    };
//4
   
    /**
     * Constructor de Controlador para unir el ModelAgenda y ViewAgenda
     *
     * @param model objeto de tipo Model
     * @param view objeto de tipo View
     */
    public Contrallerproveedores(  Modelproveedores modelproveedores, view_proveedores view_proveedores) {
        this.modelproveedores = modelproveedores;
        this.view_proveedores = view_proveedores;
        initComponents();
        setActionListener();
        initDB();
    }

    /**
     * Método que llama al método conectarBD del modelo y muestra el nombre y
     * email del primer registro en las cajas de texto de ViewAgenda.
     */
    public void initDB(){
        modelproveedores.conectarDB();
        view_proveedores.nombre_proveedores_jtf.setText(modelproveedores.getNombre());
        view_proveedores.ap_proveedores_jtf.setText(modelproveedores.getApellido_paterno());
        view_proveedores.am_proveedores_jtf.setText(modelproveedores.getApellido_materno());
        view_proveedores.empresa_proveedores_jtf.setText(modelproveedores.getEmpresa());
        view_proveedores.calle_proveedores_jtf.setText(modelproveedores.getCalle());
        view_proveedores.colonia_proveedores_jtf.setText(modelproveedores.getColonia());
        view_proveedores.numeroe_proveedores_jtf.setText(modelproveedores.getNumero_exterior());
       view_proveedores.telefono_proveedores_jtf.setText(modelproveedores.getTelefono());
    }
    /**
     * Metodo para inicializar la ViewAgenda
     */
    public void initComponents() {
        view_proveedores.setLocationRelativeTo(null);
        view_proveedores.setTitle("Agenda que conecta a la base de datos MVC");
       view_proveedores.setVisible(true);
    }

    /**
     * Método para agregar el actionListener a cada boton de la vista
     */
    public void setActionListener() {
       view_proveedores.primero_proveedores_jb.addActionListener(actionListener);
        view_proveedores.anterior_proveedores_jbtn.addActionListener(actionListener);
        view_proveedores.siguiente_proveedores_jb.addActionListener(actionListener);
        view_proveedores.ultimo_proveedores_jb.addActionListener(actionListener);
        view_proveedores.buscar_proveedores_jb.addActionListener(actionListener);
        view_proveedores.modificar_proveedores_jb.addActionListener(actionListener);
        view_proveedores.borrar_proveedores_jb.addActionListener(actionListener);
        view_proveedores.insertar_proveedores_jb.addActionListener(actionListener);
        
    }

    /**
     * Método para ver el primer registro de la tabla contactos
     */
    private void jbtn_primero_actionPerformed() throws SQLException {
        System.out.println("Action del boton jbtn_primero");
        modelproveedores.moverPrimerRegistro();//invocar al metodo moverPrimerRegistro
        view_proveedores.nombre_proveedores_jtf.setText(modelproveedores.getNombre());
        view_proveedores.ap_proveedores_jtf.setText(modelproveedores.getApellido_paterno());
        view_proveedores.am_proveedores_jtf.setText(modelproveedores.getApellido_materno());
        view_proveedores.empresa_proveedores_jtf.setText(modelproveedores.getEmpresa());
        view_proveedores.calle_proveedores_jtf.setText(modelproveedores.getCalle());
        view_proveedores.colonia_proveedores_jtf.setText(modelproveedores.getColonia());
        view_proveedores.numeroe_proveedores_jtf.setText(modelproveedores.getNumero_exterior());
        view_proveedores.telefono_proveedores_jtf.setText(modelproveedores.getTelefono());
    }

    /**
     * Método para ver el registro anterior de la tabla contactos
     */
    private void jbtn_anterior_actionPerformed() throws SQLException {
        System.out.println("Action del boton jbtn_anterior");
         modelproveedores.moverAnteriorRegistro();//invocar al metodo moverPrimerRegistro
        view_proveedores.nombre_proveedores_jtf.setText(modelproveedores.getNombre());
        view_proveedores.ap_proveedores_jtf.setText(modelproveedores.getApellido_paterno());
        view_proveedores.am_proveedores_jtf.setText(modelproveedores.getApellido_materno());
        view_proveedores.empresa_proveedores_jtf.setText(modelproveedores.getEmpresa());
        view_proveedores.calle_proveedores_jtf.setText(modelproveedores.getCalle());
        view_proveedores.colonia_proveedores_jtf.setText(modelproveedores.getColonia());
        view_proveedores.numeroe_proveedores_jtf.setText(modelproveedores.getNumero_exterior());
         view_proveedores.telefono_proveedores_jtf.setText(modelproveedores.getTelefono());
    }

    /**
     * Método para ver el último registro de la tabla contactos
     */
    private void jbtn_ultimo_actionPerformed() throws SQLException {
        System.out.println("Action del boton jbtn_ultimo");
        modelproveedores.moverUltimoRegistro();//invocar al metodo moverPrimerRegistro
        view_proveedores.nombre_proveedores_jtf.setText(modelproveedores.getNombre());
        view_proveedores.ap_proveedores_jtf.setText(modelproveedores.getApellido_paterno());
        view_proveedores.am_proveedores_jtf.setText(modelproveedores.getApellido_materno());
        view_proveedores.empresa_proveedores_jtf.setText(modelproveedores.getEmpresa());
        view_proveedores.calle_proveedores_jtf.setText(modelproveedores.getCalle());
        view_proveedores.colonia_proveedores_jtf.setText(modelproveedores.getColonia());
        view_proveedores.numeroe_proveedores_jtf.setText(modelproveedores.getNumero_exterior());
        view_proveedores.telefono_proveedores_jtf.setText(modelproveedores.getTelefono());
    }

    /**
     * Método para ver el siguiente registro de la tabla contactos
     */
    private void jbtn_siguiente_actionPerformed() throws SQLException {
        System.out.println("Action del boton jbtn_siguiente");
         modelproveedores.moverSiguienteRegistro();//invocar al metodo moverPrimerRegistro
        view_proveedores.nombre_proveedores_jtf.setText(modelproveedores.getNombre());
        view_proveedores.ap_proveedores_jtf.setText(modelproveedores.getApellido_paterno());
        view_proveedores.am_proveedores_jtf.setText(modelproveedores.getApellido_materno());
        view_proveedores.empresa_proveedores_jtf.setText(modelproveedores.getEmpresa());
        view_proveedores.calle_proveedores_jtf.setText(modelproveedores.getCalle());
        view_proveedores.colonia_proveedores_jtf.setText(modelproveedores.getColonia());
        view_proveedores.numeroe_proveedores_jtf.setText(modelproveedores.getNumero_exterior());
       view_proveedores.telefono_proveedores_jtf.setText(modelproveedores.getTelefono());
    }
    /**
     * 
     * metodo de botones de nuvo, insertar,modificar y eliminar
     */
   private void jb_nuevo_actionPerformed() throws SQLException{
       
   }
   private void jb_insertar_actionPerformed(){
       System.out.println("Action del boton insertar");
       modelproveedores.setNombre(view_proveedores.nombre_proveedores_jtf.getText());//llena el campo de nombre
       modelproveedores.setApellido_paterno(view_proveedores.ap_proveedores_jtf.getText());//llena el campo de apellido paterno
       modelproveedores.setApellido_materno(view_proveedores.am_proveedores_jtf.getText());//llena el campo de apellido materno
       modelproveedores.setEmpresa(view_proveedores.empresa_proveedores_jtf.getText());//llena el campo de apellido materno
       modelproveedores.setCalle(view_proveedores.calle_proveedores_jtf.getText());
       modelproveedores.setColonia(view_proveedores.colonia_proveedores_jtf.getText());
       modelproveedores.setNumero_exterior(view_proveedores.numeroe_proveedores_jtf.getText());
       modelproveedores.setTelefono(view_proveedores.telefono_proveedores_jtf.getText());
       modelproveedores.insertar(modelproveedores.getId_proveedor(),modelproveedores.getNombre(),modelproveedores.getApellido_paterno(),modelproveedores.getApellido_materno(),modelproveedores.getEmpresa(),modelproveedores.getCalle(),modelproveedores.getColonia(),modelproveedores.getNumero_exterior(), modelproveedores.getTelefono());//Guarda el registro
       
   }
   private void jb_modificar_actionPerformed() throws SQLException{
       
       modelproveedores.modificar(view_proveedores.nombre_proveedores_jtf.getText(), view_proveedores.ap_proveedores_jtf.getText(), view_proveedores.am_proveedores_jtf.getText(), view_proveedores.empresa_proveedores_jtf.getText(), view_proveedores.calle_proveedores_jtf.getText(), view_proveedores.colonia_proveedores_jtf.getText(), view_proveedores.numeroe_proveedores_jtf.getText(), view_proveedores.telefono_proveedores_jtf.getText());
       JOptionPane.showMessageDialog(view_proveedores," Tu registro ha sido modificado ");
   }
   private void jb_eliminar_actionPerformed() throws SQLException{
       System.out.println("Action del boton eliminar");
            System.out.println(modelproveedores.getNombre());
            modelproveedores.eliminar(modelproveedores.getNombre());
            JOptionPane.showMessageDialog(view_proveedores, "Advertencia tu registro se ha eliminado "); 
            
   }
}
         
         

