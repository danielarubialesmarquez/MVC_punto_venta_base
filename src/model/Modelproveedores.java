/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
/**
 *
 * @author Dani
 */
public class Modelproveedores {
     private Connection conexion;
    private Statement st;
    private ResultSet rs;
    private PreparedStatement ps;
    private Integer id_proveedor;
    private String nombre;
    private String apellido_paterno;
    private String apellido_materno;
    private String empresa;
    private String calle;
    private String colonia;
    private String numero_exterior;
    private String telefono;

    public Connection getConexion() {
        return conexion;
    }

    public Integer getId_proveedor() {
        return id_proveedor;
    }

    public void setId_proveedor(Integer id_proveedor) {
        this.id_proveedor = id_proveedor;
    }

    public void setConexion(Connection conexion) {
        this.conexion = conexion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido_paterno() {
        return apellido_paterno;
    }

    public void setApellido_paterno(String apellido_paterno) {
        this.apellido_paterno = apellido_paterno;
    }

    public String getApellido_materno() {
        return apellido_materno;
    }

    public void setApellido_materno(String apellido_materno) {
        this.apellido_materno = apellido_materno;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public String getNumero_exterior() {
        return numero_exterior;
    }

    public void setNumero_exterior(String numero_exterior) {
        this.numero_exterior = numero_exterior;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    //conectar a la BD
    public Connection conectarDB() {
        try {
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/proveedores", "root", "");
            st = conexion.createStatement();
            rs = st.executeQuery("SELECT * FROM proveedor;");
            rs.next();
            id_proveedor = rs.getInt("id_proveedor");
            nombre = rs.getString("nombre");
            apellido_paterno = rs.getString("apellido_paterno");
            apellido_materno = rs.getString("apellido_materno");
            empresa = rs.getString("empresa");
            calle = rs.getString("calle");
            colonia = rs.getString("colonia");
            numero_exterior  = rs.getString("cnumero_exterior");
            telefono = rs.getString("telefono");
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, "Error en el model de conexion: " + err.getMessage());
        }
        return conexion; //retorna la variable conexion

    }
    //Fin de conexion
    
    private void llenarDatos() {
        System.out.print(" llenarDatos");
        try {
            this.setId_proveedor(rs.getInt("id"));
            this.setNombre(rs.getString("nombre"));
            this.setApellido_paterno(rs.getString("apellido_paterno"));
            this.setApellido_materno(rs.getString("apellido_materno"));
            this.setApellido_materno(rs.getString("apellido_materno"));
            this.setEmpresa(rs.getString("empresa"));
            this.setCalle(rs.getString("calle"));
            this.setColonia(rs.getString("colonia"));
            this.setNumero_exterior(rs.getString("numero_exterior"));
            this.setTelefono(rs.getString("telefono"));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error 006" + ex.getMessage());
        }        
    }
    //movimientos
    public void moverPrimerRegistro(){
        System.out.print("Action moverPrimerRegistro");
        try {
            rs.first();
            llenarDatos();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error 004" + ex.getMessage());
        }
    }
     public void moverSiguienteRegistro(){
        System.out.print("Action moverSiguienteRegistro");
        try {
            if (!rs.isLast()) {
                rs.next();
                llenarDatos();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error 003" + ex.getMessage());
        }
    }
      public void moverAnteriorRegistro(){
        System.out.print("Action moverAnteriorRegistro");
        try {
            if (!rs.isFirst()) {
                rs.previous();
                llenarDatos();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error 004" + ex.getMessage());
        }
    }
      public void moverUltimoRegistro(){
        System.out.print("Action moverUltimoRegistro");
        try {
            rs.last();
            llenarDatos();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error 005" + ex.getMessage());
        }
    }
      //fin de movimientos entre registros
      //comienzo crud
    public void insertar(Integer id_proveedor,String nombre,String apellido_paterno,String apellido_materno,String empresa,String calle,String colonia,String numero_exterior,String telefono){
        try {
                System.out.print("El boton insertar funciona");
                conexion = null;
                conexion = conectarDB();
                ps = conexion.prepareStatement("INSERT INTO proveedor(nombre, apellido_paterno, apellido_materno, empresa, calle, colonia, numero_exterior, telefono) VALUES (?,?,?,?,?,?,?,?,?)");//guarda los datos y prepara la consulta
                 ps.setString(1, nombre);//envia los datps a insertar de la consulta en la columna 1
                ps.setString(2, apellido_paterno);
                ps.setString(3, apellido_materno);
                ps.setString(4, empresa);
                ps.setString(5, calle);
                ps.setString(6, colonia);
                ps.setString(7, numero_exterior);
                ps.setString(8, telefono);
                int resultado = ps.executeUpdate();//ejecuta la inserccion dde sql y lo guarda en resultado
                if (resultado != 0) {//si si se actualizo devuelve un numero diferente a 0
                    JOptionPane.showMessageDialog(null, "Registro guardado");
                }else{
                    JOptionPane.showMessageDialog(null, "El registro no se inserto correctamente");
                }     
                this.conectarDB();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"error-insertar"+ e.getMessage());
        }
    }

    public void modificar(String nombre, String ap_proveedores, String am_proveedores, String empresa, String calle, String colonia, String numero_exterior, String telefono) throws SQLException{
        System.out.print("El boton modificar funciona");
        String actualap = this.getApellido_paterno();
        String actualam = this.getApellido_materno();
        String actualem = this.getEmpresa();
        String actualca = this.getCalle();
        String actualco = this.getColonia();
        String actualne = this.getNumero_exterior();
        String actualTelefono = this.getTelefono();
        st.executeUpdate("UPDATE proveedor SET nombre='" + nombre + "',apellido_paterno='" + ap_proveedores + "' , apellido_paterno='" + actualap + "',apellido_materno='" + am_proveedores + "' , apellido_materno='" + actualam + "',empresa='" + empresa + "' , empresa='" + actualem + "',calle='" + calle + "' , calle='" + actualca + "',colonia='" + colonia + "' , colonia='" + actualco + "',numero_exterior='" + numero_exterior + "' , numero_exterior='" + actualne + "',telefono='" + telefono + "' WHERE telefono='" + actualTelefono + "' ;");
        this.conectarDB();
    }
     public void eliminar(String nombre) throws SQLException {
        System.out.print("El boton eliminar ");
        st.executeUpdate("DELETE FROM proveedor WHERE nombre='" + nombre + "';"); 
        this.conectarDB();
    }
     
}
