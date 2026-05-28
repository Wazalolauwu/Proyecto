package negocio;

import java.util.ArrayList;
import java.util.List;
import modelo.GuiasTurismo;

public class GestorGuias {
    // Lista para simular la base de datos de guías
    private List<GuiasTurismo> listaGuias;

    public GestorGuias() {
        this.listaGuias = new ArrayList<>();
    }

    // Método para agregar un guía al sistema
    public void agregarGuia(GuiasTurismo guia) {
        if (guia != null) {
            listaGuias.add(guia);
            guia.registrarGuia();
        }
    }

    // Método para listar todos los guías disponibles
    public void mostrarGuias() {
        System.out.println("\n--- LISTA DE GUÍAS DE TURISMO ---");
        if (listaGuias.isEmpty()) {
            System.out.println("No hay guías registrados en el sistema.");
        } else {
            for (GuiasTurismo g : listaGuias) {
                g.consultarGuia();
            }
        }
    }
}