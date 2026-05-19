package negocio;

import modelo.Ruta;
import java.util.ArrayList;

public class GestorRutas {

    private ArrayList<Ruta> rutas;

    public GestorRutas() {
        rutas = new ArrayList<>();
    }

    public void generarRuta(Ruta ruta) {

        if(ruta.getDuracion() <= 0) {

            System.out.println("Duración inválida");

        } else {

            rutas.add(ruta);
            System.out.println("Ruta generada correctamente");
        }
    }

    public void mostrarRutas() {

        if(rutas.isEmpty()) {

            System.out.println("No existen rutas");

        } else {

            for(Ruta r : rutas) {
                System.out.println(r);
                System.out.println("---------------------");
            }
        }
    }
}