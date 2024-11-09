package com.mycompany.cinemaseat;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class Funcion {

    LocalDateTime horaInicio;
    LocalDateTime horaFin;
    private Map<Asiento, EstadoAsiento> disponibilidadAsientos;

    public Funcion(LocalDateTime horaInicio, LocalDateTime horaFin) {
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.disponibilidadAsientos = new HashMap<>();
    }

    public Map<Asiento, EstadoAsiento> consultarDisponibilidad() {
        return disponibilidadAsientos;
    }

    public boolean actualizarDisponibilidad(Asiento asiento, EstadoAsiento estado) {
        if (disponibilidadAsientos.containsKey(asiento)) {
            disponibilidadAsientos.put(asiento, estado);
            return true;
        }
        return false;
    }

    public void setHoraInicio(LocalDateTime horaInicio) {
        this.horaInicio = horaInicio;
    }

    public void setHoraFin(LocalDateTime horaFin) {
        this.horaFin = horaFin;
    }

    public void setDisponibilidadAsientos(Map<Asiento, EstadoAsiento> disponibilidadAsientos) {
        this.disponibilidadAsientos = disponibilidadAsientos;
    }

    public LocalDateTime getHoraInicio() {
        return horaInicio;
    }

    public LocalDateTime getHoraFin() {
        return horaFin;
    }

    public Map<Asiento, EstadoAsiento> getDisponibilidadAsientos() {
        return disponibilidadAsientos;
    }
}