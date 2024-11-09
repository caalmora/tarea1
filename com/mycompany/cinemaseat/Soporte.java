package com.mycompany.cinemaseat;

import java.util.ArrayList;

public class Soporte {

    private ArrayList<Usuario> usuariosReportes;
    
    public Soporte() {
        this.usuariosReportes = new ArrayList<>();
    }

    public void atenderReporte(Usuario usuario) {
        System.out.println("Atendiendo reporte de: " + usuario.getNombre());
    }

    public void escalarProblema(Usuario usuario) {
        System.out.println("Escalando problema para: " + usuario.getNombre());
    }
}

