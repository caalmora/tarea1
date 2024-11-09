package com.mycompany.cinemaseat;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class CinemaSeat {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Usuario usuario1 = new Usuario("Juan Perez", "juan@mail.com", "cliente");
        Usuario usuario2 = new Usuario("Maria Lopez", "maria@mail.com", "cliente");

        Cine cine = new Cine("Cineplex", "Centro Comercial");

        Asiento asiento1 = new Asiento(1, new Asiento_4D(new ArrayList<>(Arrays.asList("Viento", "Agua"))));
        Asiento asiento2 = new Asiento(2, new Asiento_VIP(1.5, "Lujoso"));
        Asiento asiento3 = new Asiento(3, new Asiento_Estandar());
        Asiento asiento4 = new Asiento(4, new Asiento_4D(new ArrayList<>(Arrays.asList("Luz", "Viento"))));

        Sala sala1 = new Sala(1, "Estándar");
        sala1.agregarAsiento(asiento1);
        sala1.agregarAsiento(asiento2);
        sala1.agregarAsiento(asiento3);
        sala1.agregarAsiento(asiento4);

        Funcion funcion1 = new Funcion(LocalDateTime.now().plusHours(1), LocalDateTime.now().plusHours(2));
        sala1.agregarFuncion(funcion1);

        Usuario usuarioSeleccionado = null;
        while (usuarioSeleccionado == null) {
            System.out.println("Ingrese su nombre de usuario:");
            String nombreUsuario = sc.nextLine();
            if (nombreUsuario.equals(usuario1.getNombre())) {
                usuarioSeleccionado = usuario1;
            } else if (nombreUsuario.equals(usuario2.getNombre())) {
                usuarioSeleccionado = usuario2;
            } else {
                System.out.println("Usuario no encontrado. Intente nuevamente.");
            }
        }

        System.out.println("¡Bienvenido " + usuarioSeleccionado.getNombre() + "!");

        Funcion funcionSeleccionada = null;
        while (funcionSeleccionada == null) {
            System.out.println("\nFunciones disponibles:");
            for (int i = 0; i < sala1.getFunciones().size(); i++) {
                System.out.println((i + 1) + ". Función a las " + sala1.getFunciones().get(i).horaInicio);
            }
            System.out.println("Seleccione la función (1-" + sala1.getFunciones().size() + "):");
            int seleccionFuncion = sc.nextInt();
            sc.nextLine(); // Limpiar buffer
            if (seleccionFuncion > 0 && seleccionFuncion <= sala1.getFunciones().size()) {
                funcionSeleccionada = sala1.getFunciones().get(seleccionFuncion - 1);
            } else {
                System.out.println("Selección inválida. Intente nuevamente.");
            }
        }

        System.out.println("\nAsientos disponibles para la función seleccionada:");
        ArrayList<Asiento> asientosLibres = new ArrayList<>();
        for (Asiento asiento : sala1.asientos) {
            if (asiento.getEstado() == EstadoAsiento.DISPONIBLE) {
                asientosLibres.add(asiento);
                System.out.println("Asiento " + asiento.getNumero() + " - $" + asiento.obtenerPrecio() + " (" + asiento.getTipoAsiento().getClass().getSimpleName() + ")");
            }
        }

        Asiento asientoReservado = null;
        while (asientoReservado == null) {
            System.out.println("Seleccione el número del asiento a reservar:");
            int asientoSeleccionado = sc.nextInt();
            sc.nextLine();

            asientoReservado = asientosLibres.stream()
                    .filter(a -> a.getNumero() == asientoSeleccionado)
                    .findFirst()
                    .orElse(null);

            if (asientoReservado == null) {
                System.out.println("Asiento no disponible o inválido. Intente nuevamente.");
            }
        }

        double precioAsiento = asientoReservado.obtenerPrecio();
        System.out.println("El precio del asiento es: $" + precioAsiento);
        System.out.println("Ingrese el monto a pagar:");
        double montoPago = sc.nextDouble();

        if (montoPago < precioAsiento) {
            System.out.println("Pago no exitoso. El monto es insuficiente.");
            return;
        }

        System.out.println("Pago exitoso.");

        ArrayList<Asiento> asientosReservados = new ArrayList<>();
        asientosReservados.add(asientoReservado);
        Reserva reserva = new Reserva(usuarioSeleccionado, asientosReservados);
        usuarioSeleccionado.agregarReserva(reserva);

        reserva.confirmarReserva();
        System.out.println("Reserva confirmada para el asiento " + asientoReservado.getNumero() + ".");

        sc.close();
    }
}
