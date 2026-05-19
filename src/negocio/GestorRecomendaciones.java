package negocio;

import modelo.Recomendacion;
import java.util.ArrayList;

public class GestorRecomendaciones {

    private ArrayList<Recomendacion> recomendaciones;

    public GestorRecomendaciones() {
        recomendaciones = new ArrayList<>();
    }

    public void agregarRecomendacion(Recomendacion recomendacion) {

        if(recomendacion.getDescripcion().isEmpty()) {

            System.out.println("Descripción inválida");

        } else {

            recomendaciones.add(recomendacion);
            System.out.println("Recomendación agregada");
        }
    }

    public void mostrarRecomendaciones() {

        if(recomendaciones.isEmpty()) {

            System.out.println("No existen recomendaciones");

        } else {

            for(Recomendacion r : recomendaciones) {
                System.out.println(r);
                System.out.println("---------------------");
            }
        }
    }
}