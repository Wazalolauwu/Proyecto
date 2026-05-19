package modelo;

public class Recomendacion {

    private String guia;
    private String descripcion;

    public Recomendacion(String guia, String descripcion) {
        this.guia = guia;
        this.descripcion = descripcion;
    }

    public String getGuia() {
        return guia;
    }

    public String getDescripcion() {
        return descripcion;
    }

    @Override
    public String toString() {

        return "Guía: " + guia +
                "\nRecomendación: " + descripcion;
    }
}