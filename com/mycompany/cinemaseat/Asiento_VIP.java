/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cinemaseat;

/**
 *
 * @author User
 */
class Asiento_VIP implements TipoAsiento {
    private double espacioExtra;
    private String comodidad;

    public Asiento_VIP(double espacioExtra, String comodidad) {
        this.espacioExtra = espacioExtra;
        this.comodidad = comodidad;
    }

    @Override
    public double calcularPrecio() {
        return 20.0; 
    }
}
