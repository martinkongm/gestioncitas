package com.gestioncitas.interfaces;

import com.gestioncitas.db.ConexionOracle;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class DAOHorarioMetodos implements DAOHorario{

    @Override
    public void mostrar(JTable vista) throws Exception {
       String sql = "SELECT \n" +
                    "    M.DNI_MEDICO AS DNI,\n" +
                    "    M.NOMBRES AS Nombres,\n" +
                    "    M.APEL_PATERNO || ' ' || M.APEL_MATERNO AS Apellidos,\n" +
                    "    D.DIA AS Día,\n" +
                    "    TO_CHAR(H.HORA_INICIO, 'HH24:MI AM') || ' - ' || TO_CHAR(H.HORA_FIN, 'HH24:MI AM') AS \"Horario\",\n" +
                    "    H.CUPOS AS \"Cupos límite\"\n" +
                    "FROM DIA D \n" +
                    "JOIN MEDICO M ON D.ID_MEDICO = M.ID_MEDICO\n" +
                    "JOIN HORARIO H ON D.ID_HORARIO = H.ID_HORARIO\n" +
                    "ORDER BY M.ID_MEDICO";
        Statement st;
        ConexionOracle con = new ConexionOracle();
        Connection conexion = con.conectar();
        
        //Generar modelo de la JTable
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("DNI");
        modelo.addColumn("Nombres");
        modelo.addColumn("Apellidos");
        modelo.addColumn("Día");
        modelo.addColumn("Horario");
        modelo.addColumn("Cupos límite");
        vista.setModel(modelo);
        
        String[] dato = new String[6];
        
        st = conexion.createStatement();
        ResultSet rs = st.executeQuery(sql);
        
        while(rs.next()){
            dato[0] = rs.getString(1);
            dato[1] = rs.getString(2);
            dato[2] = rs.getString(3);
            dato[3] = rs.getString(4);
            dato[4] = rs.getString(5);
            dato[5] = rs.getString(6);
            modelo.addRow(dato);
        }
    }
    
}
