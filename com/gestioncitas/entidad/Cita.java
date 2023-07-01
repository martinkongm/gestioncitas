package com.gestioncitas.entidad;

public class Cita {
    private int id_cita;
    private int id_medico;
    private String urgencia;
    private String fecha_programada;
    private String fecha_registro;
    private int num_orden;

    public int getId_cita() {
        return id_cita;
    }

    public void setId_cita(int id_cita) {
        this.id_cita = id_cita;
    }

    public int getId_medico() {
        return id_medico;
    }

    public void setId_medico(int id_medico) {
        this.id_medico = id_medico;
    }

    public String getUrgencia() {
        return urgencia;
    }

    public void setUrgencia(String urgencia) {
        this.urgencia = urgencia;
    }

    public String getFecha_programada() {
        return fecha_programada;
    }

    public void setFecha_programada(String fecha_programada) {
        this.fecha_programada = fecha_programada;
    }

    public String getFecha_registro() {
        return fecha_registro;
    }

    public void setFecha_registro(String fecha_registro) {
        this.fecha_registro = fecha_registro;
    }

    public int getNum_orden() {
        return num_orden;
    }

    public void setNum_orden(int num_orden) {
        this.num_orden = num_orden;
    }
    
    
}
