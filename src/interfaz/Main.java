package interfaz;

import modelo.*;
import negocio.*;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Inicialización de Controladores (Capa de Negocio)
        GestorTuristas gestorTuristas = new GestorTuristas();
        GestorLugares gestorLugares = new GestorLugares();
        GestorRutas gestorRutas = new GestorRutas();
        GestorRecomendaciones gestorRecomendaciones = new GestorRecomendaciones();
        GestorGuias gestorGuias = new GestorGuias();

        // Listas auxiliares de persistencia en memoria local para las búsquedas del Main
        ArrayList<Turista> dbTuristas = new ArrayList<>();
        ArrayList<Ruta> dbRutas = new ArrayList<>();
        ArrayList<GuiasTurismo> dbGuias = new ArrayList<>();

        int opcion;

        do {
            System.out.println("\n==== SISTEMA TURÍSTICO EVOLUCIONADO ====");
            System.out.println("1. Registrar turista");
            System.out.println("2. Mostrar turistas");
            System.out.println("3. Registrar lugar turístico");
            System.out.println("4. Mostrar lugares turísticos");
            System.out.println("5. Generar ruta (Algoritmo + Validación)");
            System.out.println("6. Mostrar rutas");
            System.out.println("7. Registrar guía de turismo");
            System.out.println("8. Asignar guía a una Ruta");
            System.out.println("9. Registrar turista en una Ruta (Ticket)");
            System.out.println("10. Agregar recomendación cruzada");
            System.out.println("11. Mostrar recomendaciones");
            System.out.println("12. Salir");

            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch(opcion) {
                case 1:
                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();
                    System.out.print("Edad: ");
                    int edad = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Intereses (ej: Cultural, Aventura, Gastronomía): ");
                    String intereses = sc.nextLine();
                    System.out.print("Tiempo disponible (en horas): ");
                    int tiempo = sc.nextInt();
                    sc.nextLine();

                    Turista t = new Turista(nombre, edad, intereses, tiempo);
                    gestorTuristas.registrarTurista(t);
                    dbTuristas.add(t);
                    break;

                case 2:
                    gestorTuristas.mostrarTuristas();
                    break;

                case 3:
                    System.out.print("Nombre del lugar: ");
                    String lugar = sc.nextLine();
                    System.out.print("Ubicación: ");
                    String ubicacion = sc.nextLine();
                    System.out.print("Categoría (Debe coincidir con interés del Turista): ");
                    String categoria = sc.nextLine();
                    System.out.print("Horario: ");
                    String horario = sc.nextLine();

                    LugarTuristico lt = new LugarTuristico(lugar, ubicacion, categoria, horario);
                    gestorLugares.registrarLugar(lt);
                    break;

                case 4:
                    gestorLugares.mostrarLugares();
                    break;

                case 5:
                    System.out.println("\n--- Ejecución del Generador Validado de Rutas ---");
                    if (dbTuristas.isEmpty()) {
                        System.out.println("[ERROR]: Acción denegada. No existe ningún turista registrado en el sistema.");
                        break;
                    }
                    if (gestorLugares.obtenerTodosLosLugares() == null || gestorLugares.obtenerTodosLosLugares().isEmpty()) {
                        System.out.println("[ERROR]: Acción denegada. El catálogo de lugares turísticos está vacío.");
                        break;
                    }

                    System.out.print("Nombre identificador para la Ruta: ");
                    String nombreRuta = sc.nextLine();
                    System.out.print("Tipo de ruta: ");
                    String tipo = sc.nextLine();

                    // Se toma el último turista registrado para la demo automática
                    Turista turistaSeleccionado = dbTuristas.get(dbTuristas.size() - 1);

                    Ruta rGenerada = gestorRutas.generarRutaSegura(nombreRuta, tipo, turistaSeleccionado, gestorLugares.obtenerTodosLosLugares());
                    if (rGenerada != null) {
                        dbRutas.add(rGenerada);
                    }
                    break;

                case 6:
                    gestorRutas.mostrarRutas();
                    break;

                case 7:
                    System.out.print("ID único del Guía: ");
                    int idG = sc.nextInt(); sc.nextLine();
                    System.out.print("Nombre Completo: ");
                    String nomG = sc.nextLine();
                    System.out.print("Especialidad (ej: Cultural, Aventura): ");
                    String espG = sc.nextLine();
                    System.out.print("Años de Experiencia: ");
                    int expG = sc.nextInt(); sc.nextLine();

                    GuiasTurismo g = new GuiasTurismo(idG, nomG, espG, expG);
                    gestorGuias.agregarGuia(g);
                    dbGuias.add(g);
                    break;

                case 8:
                    if (dbGuias.isEmpty() || dbRutas.isEmpty() || dbTuristas.isEmpty()) {
                        System.out.println("[ERROR]: Datos insuficientes. Asegúrese de tener Guías, Rutas y Turistas creados.");
                        break;
                    }
                    System.out.println("[Procesando Asignación de Guía por Especialidad]");
                    AsignacionGuia asignacion = new AsignacionGuia(dbGuias.get(0), dbRutas.get(0), dbTuristas.get(0));
                    asignacion.mostrarAsignacion();
                    break;

                case 9:
                    if (dbTuristas.isEmpty() || dbRutas.isEmpty()) {
                        System.out.println("[ERROR]: No se puede registrar. Falta crear el turista o la ruta.");
                        break;
                    }
                    System.out.print("Ingrese la fecha de hoy (DD/MM/AAAA): ");
                    String fecha = sc.nextLine();
                    RegistroTuristaRuta ticket = new RegistroTuristaRuta(dbTuristas.get(0), dbRutas.get(0), fecha);
                    ticket.emitirTicket();
                    break;

                case 10:
                    if (dbRutas.isEmpty() || dbGuias.isEmpty() || dbTuristas.isEmpty()) {
                        System.out.println("[ERROR]: Faltan entidades para estructurar la recomendación completa.");
                        break;
                    }
                    System.out.print("Escriba la recomendación del Guía: ");
                    String recoDesc = sc.nextLine();

                    Recomendacion rec = new Recomendacion(dbRutas.get(0), dbGuias.get(0), dbTuristas.get(0), recoDesc);
                    gestorRecomendaciones.agregarRecomendacion(rec);
                    break;

                case 11:
                    gestorRecomendaciones.mostrarRecomendaciones();
                    break;

                case 12:
                    System.out.println("Fin del sistema.");
                    break;

                default:
                    System.out.println("Opción inválida");
            }
        } while(opcion != 12);
    }
}