package com.gestioncitas.interfaces;

import com.gestioncitas.entidad.Cita;
import com.gestioncitas.entidad.Paciente;
import javax.swing.JTable;

public interface DAOCita {
    
    public void registrar(Paciente p, Cita c) throws Exception;
    public void mostrar(JTable vista) throws Exception;
    public String numcodigo() throws Exception;
    public void eliminar() throws Exception;
    public void buscar() throws Exception;
    public void actualizar(Paciente p) throws Exception;
    
}
