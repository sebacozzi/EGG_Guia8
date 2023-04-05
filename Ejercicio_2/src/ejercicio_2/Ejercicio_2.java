/**
 * Programa Nespresso. Desarrolle una clase Cafetera en el paquete Entidades con
 * los atributos capacidadMáxima (la cantidad máxima de café que puede contener
 * la cafetera) y cantidadActual (la cantidad actual de café que hay en la
 * cafetera). Agregar constructor vacío y con parámetros así como setters y
 * getters. Crear clase CafeteraServicio en el paquete Servicios con los
 * siguiente:
 *      a) Método llenarCafetera(): hace que la cantidad actual sea igual a la
 *          capacidad máxima.
 *      b) Método servirTaza(int): se pide el tamaño de una taza vacía, el
 *          método recibe el tamaño de la taza y simula la acción de servir la
 *          taza con la capacidad indicada. Si la cantidad actual de café
 *          “no alcanza” para llenar la taza, se sirve lo que quede. El método
 *          le informará al usuario si se llenó o no la taza, y de no haberse
 *          llenado en cuanto quedó la taza.
 *      c) Método vaciarCafetera(): pone la cantidad de café actual en cero.
 *      d) Método agregarCafe(int): se le pide al usuario una cantidad de café,
 *          el método lo recibe y se añade a la cafetera la cantidad de café
 *          indicada.
 */
package ejercicio_2;

import Entidad.Cafetera;
import Servicios.CafeteraServicio;
import java.util.Scanner;
import menu.Menu;

/**
 *
 * @author Sebastián Cozzi
 */
public class Ejercicio_2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // inicialización de Scanner
        Scanner leer = new Scanner(System.in);
        String op[] = {"Crear Cafetera", "Llenar cafetera", "Servir Taza",
            "Vaciar Cafetera", "Agregar Cafe"};
        Menu menu = new Menu("Menu Cafeteria", op, "Salir");
        Cafetera cafetera = null;
        CafeteraServicio cs = new CafeteraServicio();
        do {
            if (cafetera != null) {
                menu.setTitulo("Nivel de cafetera: " + cafetera.getCantidadActual() + "\nMenu Cafeteria");
            } else {
                menu.setTitulo("Cafetera no iniciada.\nMenu Cafeteria");
            }
            System.out.println(menu.toString());
            menu.pregunta();
            if (cafetera == null && (menu.getResultado() != 1 && !menu.esSalida())) {
                System.out.println("Primero debe iniciar la cafetera");
                menu.esperaTecla();
            } else {
                switch (menu.getResultado()) {
                    case 1: // crea cafetera
                        System.out.println(" Iniciar Caferera:");
                        System.out.println("-------------------");
                        cafetera = cs.creaCafetera();
                        break;
                    case 2: // llena cafetera
                        System.out.println(" Llenar Cafetera:");
                        System.out.println("------------------");
                        cs.llenarCafetera(cafetera);
                        break;
                    case 3: // Servir taza
                        System.out.println(" Servir Taza:");
                        System.out.println("--------------");
                        if (cafetera.getCantidadActual() == 0) {
                            System.out.println("Cafetera vacia.");
                            System.out.println("Debe recargar o Llenar.");

                        } else {
                            System.out.print("Ingrese la capacidad de la taza: ");
                            cs.servirTaza(cafetera, leer.nextInt());
                        }
                        break;
                    case 4: // vaciar cafetera
                        System.out.println(" Vaciar Cafetera:");
                        System.out.println("------------------");
                        cs.vaciarCafetera(cafetera);
                        break;
                    case 5: // agragar cafe
                        System.out.println(" Rellenar Cafetera:");
                        System.out.println("--------------------");
                        System.out.print("Ingrese la cantidad de cafe a agregar a la cafetera: ");
                        cs.agregarCafe(cafetera, leer.nextInt());
                        break;
                    case 6:
                        menu.salida = false;
                        break;
                    default:
                        System.out.println("Opción incorrecta");
                        ;
                }
                menu.pausaSiOpcion(1, 5);
            }
        } while (menu.salida);
        System.out.println("Gracias!!");

    }

}
