package com.gestioncitas.entidad;

public class Paciente {
    
    private String dni;
    private String nombres;
    private String apel_paterno;
    private String apel_materno;
    private String direccion;
    private String telefono;

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApel_paterno() {
        return apel_paterno;
    }

    public void setApel_paterno(String apel_paterno) {
        this.apel_paterno = apel_paterno;
    }

    public String getApel_materno() {
        return apel_materno;
    }

    public void setApel_materno(String apel_materno) {
        this.apel_materno = apel_materno;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    
}
