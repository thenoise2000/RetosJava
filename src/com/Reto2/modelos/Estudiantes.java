package com.Reto2.modelos;

public class Estudiantes {
    public String nombre;
    public String sede;
    public String email;

    public Estudiantes(String nombre, String sede, String email) {
        this.nombre = nombre;
        this.sede = sede;
        this.email = email;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Estudiantes that = (Estudiantes) obj;
        return nombre.equals(that.nombre) && sede.equals(that.sede);
    }

    @Override
    public int hashCode() {
        int result = nombre.hashCode();
        result = 31 * result + sede.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + ", Sede: " + sede + ", Email: " + email;
    }
}

