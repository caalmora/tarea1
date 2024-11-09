package com.mycompany.cinemaseat;

public class Administrador extends Usuario {
    public Administrador(String nombre, String correo, String tipoUsuario) {
        super(nombre, correo, tipoUsuario);
    }

    public void gestionarPrecios(TipoAsiento tipoAsiento, double precio) {
        System.out.println("Actualizando el precio para " + tipoAsiento.getClass().getSimpleName() + " a " + precio);
    }

    public void agregarSala(Cine cine, Sala sala) {
        cine.agregarSala(sala);
        System.out.println("Sala " + sala + " agregada al cine " + cine);
    }

    public void agregarFuncion(Sala sala, Funcion funcion) {
        sala.agregarFuncion(funcion);
        System.out.println("Función agregada a la sala " + sala);
    }
}
