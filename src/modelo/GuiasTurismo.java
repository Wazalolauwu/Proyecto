package modelo;

public class GuiasTurismo {
    // Atributos privados
    private int idGuia;
    private String nombre;
    private String especialidad;
    private int añosExperiencia;

    // Constructor vació y con parámetros
    public GuiasTurismo() {
    }

    public GuiasTurismo(int idGuia, String nombre, String especialidad, int añosExperiencia) {
        this.idGuia = idGuia;
        this.nombre = nombre;
        this.especialidad = especialidad;
        this.añosExperiencia = añosExperiencia;
    }

    // Métodos Getter y Setter
    public int getIdGuia() { return idGuia; }
    public void setIdGuia(int idGuia) { this.idGuia = idGuia; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getEspecialidad() { return especialidad; }
    public void setEspecialidad(String especialidad) { this.especialidad = especialidad; }

    public int getAñosExperiencia() { return añosExperiencia; }
    public void setAñosExperiencia(int añosExperiencia) { this.añosExperiencia = añosExperiencia; }

    // Métodos principales de comportamiento
    public void registrarGuia() {
        // Lógica de simulación para persistencia
        System.out.println("Guía " + this.nombre + " registrado exitosamente en el modelo.");
    }

    public void consultarGuia() {
        System.out.println("Datos del Guía -> ID: " + idGuia + " | Nombre: " + nombre + " | Especialidad: " + especialidad);
    }
}