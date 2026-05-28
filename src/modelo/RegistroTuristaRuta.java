package modelo;

public class RegistroTuristaRuta {
    private Turista turista;
    private Ruta ruta;
    private String fechaRegistro;

    public RegistroTuristaRuta(Turista turista, Ruta ruta, String fechaRegistro) {
        this.turista = turista;
        this.ruta = ruta;
        this.fechaRegistro = fechaRegistro;
    }

    public void emitirTicket() {
        System.out.println("\n================ TICKET DE REGISTRO ================");
        System.out.println("Fecha de Emisión: " + fechaRegistro);
        System.out.println("Turista: " + turista.getNombre() + " (Edad: " + turista.getEdad() + ")");
        System.out.println("Ruta Inscrita: " + ruta.getNombreRuta());
        System.out.println("Duración de la Actividad: " + ruta.getDuracionTotal() + " horas");
        System.out.println("====================================================");
    }
}