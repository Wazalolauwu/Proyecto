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
}