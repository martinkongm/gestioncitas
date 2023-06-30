package com.gestioncitas.interfaces;

import com.gestioncitas.db.ConexionOracle;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class DAOMedicoMetodos implements DAOMedico{

    @Override
    public void mostrar(JTable vista) throws Exception {
         String sql = "SELECT M.DNI_MEDICO AS \"DNI\", M.NOMBRES, M.APEL_PATERNO || ' ' || M.APEL_MATERNO AS APELLIDOS, E.NOMBRE_ESPEC FROM MEDICO M JOIN ESPECIALIDAD E ON M.ID_ESPECIALIDAD = E.ID_ESPECIALIDAD";
        Statement st;
        ConexionOracle con = new ConexionOracle();
        Connection conexion = con.conectar();
        
        //Generar modelo de la JTable
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("DNI");
        modelo.addColumn("Nombres");
        modelo.addColumn("Apellidos");
        modelo.addColumn("Especialidad");
        vista.setModel(modelo);
        
        String[] dato = new String[4];
        
        st = conexion.createStatement();
        ResultSet rs = st.executeQuery(sql);
        
        while(rs.next()){
            dato[0] = rs.getString(1);
            dato[1] = rs.getString(2);
            dato[2] = rs.getString(3);
            dato[3] = rs.getString(4);
            modelo.addRow(dato);
        }
    }
    
}
