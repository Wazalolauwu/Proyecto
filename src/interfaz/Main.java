package interfaz;

import modelo.*;
import negocio.GestorLugares;
import negocio.GestorRecomendaciones;
import negocio.GestorRutas;
import negocio.GestorTuristas;
import negocio.GestorGuias;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        GestorTuristas gestorTuristas = new GestorTuristas();
        GestorLugares gestorLugares = new GestorLugares();
        GestorRutas gestorRutas = new GestorRutas();
        GestorRecomendaciones gestorRecomendaciones = new GestorRecomendaciones();
        GestorGuias gestorGuias = new GestorGuias();

        int opcion;

        do {

            System.out.println("\n==== SISTEMA TURISTICO ====");
            System.out.println("1. Registrar turista");
            System.out.println("2. Mostrar turistas");
            System.out.println("3. Registrar lugar turístico");
            System.out.println("4. Mostrar lugares turísticos");
            System.out.println("5. Generar ruta");
            System.out.println("6. Mostrar rutas");
            System.out.println("7. Agregar recomendación");
            System.out.println("8. Mostrar recomendaciones");
            System.out.println("9. Registrar guía de turismo");
            System.out.println("10. Mostrar guías de turismo");
            System.out.println("11. Salir");

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

                    System.out.print("Intereses: ");
                    String intereses = sc.nextLine();

                    System.out.print("Tiempo disponible: ");
                    int tiempo = sc.nextInt();
                    sc.nextLine();

                    Turista turista = new Turista(nombre, edad, intereses, tiempo);
                    gestorTuristas.registrarTurista(turista);
                    break;

                case 2:

                    gestorTuristas.mostrarTuristas();
                    break;

                case 3:

                    System.out.print("Nombre del lugar: ");
                    String lugar = sc.nextLine();

                    System.out.print("Ubicación: ");
                    String ubicacion = sc.nextLine();

                    System.out.print("Categoría: ");
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

                    System.out.print("Nombre de la ruta: ");
                    String nombreRuta = sc.nextLine();

                    System.out.print("Tipo de ruta: ");
                    String tipo = sc.nextLine();

                    System.out.print("Duración: ");
                    int duracion = sc.nextInt();
                    sc.nextLine();

                    Ruta ruta = new Ruta(nombreRuta, tipo, duracion);
                    gestorRutas.generarRuta(ruta);
                    break;

                case 6:

                    gestorRutas.mostrarRutas();
                    break;

                case 7:

                    System.out.print("Nombre del guía: ");
                    String guia = sc.nextLine();

                    System.out.print("Descripción: ");
                    String descripcion = sc.nextLine();

                    Recomendacion recomendacion = new Recomendacion(guia, descripcion);
                    gestorRecomendaciones.agregarRecomendacion(recomendacion);
                    break;

                case 8:

                    gestorRecomendaciones.mostrarRecomendaciones();
                    break;

                case 9:
                    System.out.print("ID del Guía (número entero): ");
                    int idGuia = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Nombre del Guía: ");
                    String nombreGuia = sc.nextLine();

                    System.out.print("Especialidad turística: ");
                    String especialidad = sc.nextLine();

                    System.out.print("Años de experiencia: ");
                    int experiencia = sc.nextInt();
                    sc.nextLine();

                    GuiasTurismo nuevoGuia = new GuiasTurismo(idGuia, nombreGuia, especialidad, experiencia);
                    gestorGuias.agregarGuia(nuevoGuia);
                    break;

                case 10:
                    gestorGuias.mostrarGuias();
                    break;

                case 11:

                    System.out.println("Fin del sistema");
                    break;

                default:

                    System.out.println("Opción inválida");
            }

        } while(opcion != 11);
    }
}