package modelo;

import java.util.ArrayList;
import java.util.List;

public class Ruta {
    private String nombreRuta;
    private String tipo;
    private int duracionTotal;
    private List<LugarTuristico> lugaresAsignados;

    public Ruta(String nombreRuta, String tipo) {
        this.nombreRuta = nombreRuta;
        this.tipo = tipo;
        this.duracionTotal = 0;
        this.lugaresAsignados = new ArrayList<>();
    }

    // Algoritmo de emparejamiento inteligente (Matching)
    public void construirRutaInteligente(Turista turista, List<LugarTuristico> todosLosLugares) {
        System.out.println("\n[Procesando algoritmo de emparejamiento para " + turista.getNombre() + "...]");
        int tiempoRestante = turista.getTiempoDisponible();

        for (LugarTuristico lugar : todosLosLugares) {
            // El interés del turista debe coincidir con la categoría del lugar
            if (turista.getInterenses().equalsIgnoreCase(lugar.getCategoria())) {
                // Simulación de costo de tiempo por visitar cada lugar (ej: 2 horas por lugar)
                if (tiempoRestante >= 2) {
                    this.lugaresAsignados.add(lugar);
                    tiempoRestante -= 2;
                    this.duracionTotal += 2;
                }
            }
        }
    }

    // Getters y Setters
    public String getNombreRuta() { return nombreRuta; }
    public int getDuracionTotal() { return duracionTotal; }
    public List<LugarTuristico> getLugaresAsignados() { return lugaresAsignados; }

    public void consultarRuta() {
        System.out.println("Ruta: " + nombreRuta + " | Tipo: " + tipo + " | Duración Total: " + duracionTotal + "h");
        System.out.println("  -> Lugares a visitar:");
        for (LugarTuristico lt : lugaresAsignados) {
            System.out.println("     * " + lt.getNombre() + " (" + lt.getUbicacion() + " - Horario: " + lt.getHorario() + ")");
        }
    }
}