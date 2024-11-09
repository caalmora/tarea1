/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cinemaseat;

/**
 *
 * @author User
 */
public class Notificacion {
    private String tipoNotificacion;
    private String mensaje;
    private Usuario destinatario;

    public Notificacion(String tipoNotificacion, String mensaje, Usuario destinatario) {
        this.tipoNotificacion = tipoNotificacion;
        this.mensaje = mensaje;
        this.destinatario = destinatario;
    }

    public void enviar() {
        System.out.println("Notificación enviada a " + destinatario.getCorreo() + ": " + mensaje);
    }
}

