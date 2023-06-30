package com.gestioncitas.interfaces;

import com.gestioncitas.db.ConexionOracle;
import com.gestioncitas.entidad.Cita;
import com.gestioncitas.entidad.Paciente;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class DAOPacienteMetodos implements DAOCita{

    @Override
    public void registrar(Paciente p, Cita c) throws Exception {
        ConexionOracle con = new ConexionOracle();
        Connection con1 = con.conectar();
        
        CallableStatement proce = con1.prepareCall(" CALL SP_REGISTRAR_CITA(?,?,?,?,?,?,?,?,?,?,?,?)");
        
        proce.setString(1, p.getDni());
        proce.setString(2, p.getNombres());
        proce.setString(3, p.getApel_paterno());
        proce.setString(4, p.getApel_materno());
        proce.setString(5, p.getDireccion());
        proce.setString(6, p.getTelefono());
        proce.setInt(7, c.getId_cita());
        proce.setInt(8, c.getId_medico());
        proce.setString(9, c.getUrgencia());
        proce.setString(10, c.getFecha_programada());
        proce.setString(11, c.getFecha_registro());
        proce.setInt(12, c.getNum_orden());

        
        // Ejecuto los elementos del procedure
        proce.execute();
    }

    @Override
    public void mostrar(JTable vista) throws Exception {
        String sql = "SELECT DNI_PACIENTE, NOMBRES, APEL_PATERNO || ' ' || APEL_MATERNO, DIRECCION, TELEFONO FROM PACIENTE ORDER BY APEL_PATERNO";
        Statement st;
        ConexionOracle con = new ConexionOracle();
        Connection conexion = con.conectar();
        
        //Generar modelo de la JTable
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("DNI");
        modelo.addColumn("Nombres");
        modelo.addColumn("Apellidos");
        modelo.addColumn("Dirección");
        modelo.addColumn("Teléfono");
        vista.setModel(modelo);
        
        String[] dato = new String[5];
        
        st = conexion.createStatement();
        ResultSet rs = st.executeQuery(sql);
        
        while(rs.next()){
            dato[0] = rs.getString(1);
            dato[1] = rs.getString(2);
            dato[2] = rs.getString(3);
            dato[3] = rs.getString(4);
            dato[4] = rs.getString(5);
            modelo.addRow(dato);
        }
    }

    @Override
    public String numcodigo() throws Exception {
        return null;
    }

    @Override
    public void eliminar() throws Exception {
    }

    @Override
    public void buscar() throws Exception {
    }

    @Override
    public void actualizar(Paciente p) throws Exception {
    }
    
}
