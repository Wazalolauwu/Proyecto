package negocio;

import modelo.LugarTuristico;
import java.util.ArrayList;

public class GestorLugares {

    private ArrayList<LugarTuristico> lugares;

    public GestorLugares() {
        lugares = new ArrayList<>();
    }

    public void registrarLugar(LugarTuristico lugar) {

        if(lugar.getNombre().isEmpty()) {
            System.out.println("Nombre inválido");
        } else {

            lugares.add(lugar);
            System.out.println("Lugar registrado correctamente");
        }
    }

    public void mostrarLugares() {

        if(lugares.isEmpty()) {
            System.out.println("No existen lugares registrados");
        } else {

            for(LugarTuristico l : lugares) {
                System.out.println(l);
                System.out.println("---------------------");
            }
        }
    }
}