package modelo;

public class Turista {

    private String nombre;
    private int edad;
    private String intereses;
    private int tiempoDisponible;

    public Turista(String nombre, int edad, String intereses, int tiempoDisponible) {
        this.nombre = nombre;
        this.edad = edad;
        this.intereses = intereses;
        this.tiempoDisponible = tiempoDisponible;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public String getIntereses() {
        return intereses;
    }

    public int getTiempoDisponible() {
        return tiempoDisponible;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre +
                "\nEdad: " + edad +
                "\nIntereses: " + intereses +
                "\nTiempo disponible: " + tiempoDisponible + " horas";
    }
}