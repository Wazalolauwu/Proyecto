package negocio;

import java.util.ArrayList;
import java.util.List;
import modelo.Ruta;
import modelo.Turista;
import modelo.LugarTuristico;

public class GestorRutas {
    private List<Ruta> listaRutas;

    public GestorRutas() {
        this.listaRutas = new ArrayList<>();
    }

    // Regla de Negocio con Validaciones de Existencia Absoluta
    public Ruta generarRutaSegura(String nombre, String tipo, Turista turista, List<LugarTuristico> listaLugares) {
        // Validación 1: Verificar existencia de Turistas
        if (turista == null) {
            System.out.println("[ERROR CRÍTICO]: No se puede generar la ruta. El turista no existe.");
            return null;
        }

        // Validación 2: Verificar existencia de Lugares Turísticos en el Sistema
        if (listaLugares == null || listaLugares.isEmpty()) {
            System.out.println("[ERROR CRÍTICO]: No se pueden generar rutas. No hay lugares turísticos registrados en el sistema.");
            return null;
        }

        // Si pasa las validaciones, procede a construirla dinámicamente
        Ruta nuevaRuta = new Ruta(nombre, tipo);
        nuevaRuta.construirRutaInteligente(turista, listaLugares);

        if (nuevaRuta.getLugaresAsignados().isEmpty()) {
            System.out.println("[ADVERTENCIA]: No se encontraron lugares que coincidan con los intereses del turista.");
        } else {
            listaRutas.add(nuevaRuta);
            System.out.println("[ÉXITO]: Ruta '" + nombre + "' generada y almacenada.");
        }

        return nuevaRuta;
    }

    public void mostrarRutas() {
        System.out.println("\n--- HISTORIAL DE RUTAS GENERADAS ---");
        for (Ruta r : listaRutas) {
            r.consultarRuta();
        }
    }
}