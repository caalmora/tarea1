/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cinemaseat;

/**
 *
 * @author User
 */
public class Asiento {
    private int numero;
    private TipoAsiento tipoAsiento;
    private EstadoAsiento estado;

    public Asiento(int numero, TipoAsiento tipoAsiento) {
        this.numero = numero;
        this.tipoAsiento = tipoAsiento;
        this.estado = EstadoAsiento.DISPONIBLE;
    }

    public int getNumero() {
        return numero;
    }

    public TipoAsiento getTipoAsiento() {
        return tipoAsiento;
    }

    public EstadoAsiento getEstado() {
        return estado;
    }

    public void cambiarEstado(EstadoAsiento nuevoEstado) {
        this.estado = nuevoEstado;
    }
    public double obtenerPrecio() {
        return tipoAsiento.calcularPrecio();
    }
}

