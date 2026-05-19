package modelo;

public class LugarTuristico {

    private String nombre;
    private String ubicacion;
    private String categoria;
    private String horario;

    public LugarTuristico(String nombre, String ubicacion,
                          String categoria, String horario) {

        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.categoria = categoria;
        this.horario = horario;
    }

    public String getNombre() {
        return nombre;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public String getCategoria() {
        return categoria;
    }

    public String getHorario() {
        return horario;
    }

    @Override
    public String toString() {

        return "Lugar: " + nombre +
                "\nUbicación: " + ubicacion +
                "\nCategoría: " + categoria +
                "\nHorario: " + horario;
    }
}