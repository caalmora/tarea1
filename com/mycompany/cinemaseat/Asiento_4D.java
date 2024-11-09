/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cinemaseat;

import java.util.ArrayList;

/**
 *
 * @author User
 */
public class Asiento_4D implements TipoAsiento {

    private ArrayList<String> efectosEspeciales;

    public Asiento_4D(ArrayList<String> efectosEspeciales) {
        this.efectosEspeciales = efectosEspeciales;
    }

    @Override
    public double calcularPrecio() {
        return 15.0; 
    }
}

