package modelo;

public class Recomendacion {
    private Ruta ruta;
    private GuiasTurismo guia;
    private Turista turista;
    private String descripcionAuditoria;

    public Recomendacion(Ruta ruta, GuiasTurismo guia, Turista turista, String descripcionAuditoria) {
        this.ruta = ruta;
        this.guia = guia;
        this.turista = turista;
        this.descripcionAuditoria = descripcionAuditoria;
    }

    public void mostrarRecomendacion() {
        System.out.println("Recomendación de " + guia.getNombre() + " para " + turista.getNombre() +
                " en Ruta '" + ruta.getNombreRuta() + "': " + descripcionAuditoria);
    }
    // Getter para obtener el objeto Turista asignado a la recomendación
    public modelo.Turista getTurista() {
        return this.turista; // O el nombre exacto de la variable Turista en esta clase
    }

    // Aprovecha para agregar el Getter de la descripción por si lo necesitas después
    public String getDescripcionAuditoria() {
        return this.descripcionAuditoria; // O la variable String de tu descripción
    }
}