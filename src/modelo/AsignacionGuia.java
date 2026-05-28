package modelo;

public class AsignacionGuia {
    private GuiasTurismo guia;
    private Ruta ruta;
    private Turista turista;

    public AsignacionGuia(GuiasTurismo guia, Ruta ruta, Turista turista) {
        this.guia = guia;
        this.ruta = ruta;
        this.turista = turista;
    }

    public boolean validarEspecialidadConRuta() {
        // Valida que la especialidad del guía coincida con el tipo o categoría de la ruta
        return guia.getEspecialidad().toLowerCase().contains(ruta.getLugaresAsignados().get(0).getCategoria().toLowerCase());
    }

    public void mostrarAsignacion() {
        System.out.println("Asignación Exitosa -> Guía: " + guia.getNombre() +
                " asignado al Turista: " + turista.getNombre() +
                " para la Ruta: " + ruta.getNombreRuta());
    }
}