package modelo;

public class Ruta {

    private String nombreRuta;
    private String tipo;
    private int duracion;

    public Ruta(String nombreRuta, String tipo, int duracion) {
        this.nombreRuta = nombreRuta;
        this.tipo = tipo;
        this.duracion = duracion;
    }

    public String getNombreRuta() {
        return nombreRuta;
    }

    public String getTipo() {
        return tipo;
    }

    public int getDuracion() {
        return duracion;
    }

    @Override
    public String toString() {

        return "Ruta: " + nombreRuta +
                "\nTipo: " + tipo +
                "\nDuración: " + duracion + " horas";
    }
}