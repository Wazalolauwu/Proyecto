package negocio;

import modelo.Turista;
import java.util.ArrayList;

public class GestorTuristas {

    private ArrayList<Turista> turistas;

    public GestorTuristas() {
        turistas = new ArrayList<>();
    }

    public void registrarTurista(Turista turista) {

        if(turista.getNombre().isEmpty()) {
            System.out.println("Nombre inválido");
        } else {
            turistas.add(turista);
            System.out.println("Turista registrado correctamente");
        }
    }

    public void mostrarTuristas() {

        if(turistas.isEmpty()) {
            System.out.println("No existen turistas registrados");
        } else {

            for(Turista t : turistas) {
                System.out.println(t);
                System.out.println("---------------------");
            }
        }
    }
}