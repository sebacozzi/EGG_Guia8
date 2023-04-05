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
package Servicios;

import Entidad.Cafetera;
import java.util.Scanner;

/**
 *
 * @author Sebastián Cozzi
 */
public class CafeteraServicio {

    // inicialización de Scanner
    Scanner leer = new Scanner(System.in).useDelimiter("\n");

    /**
     * Metodo que permite cargar los datos iniciales de cafetera
     *
     * @return Retorna un nuevo objeto de tipo Cafetera
     */
    public Cafetera creaCafetera() {

        int capacidad, cantidad;
        System.out.print("Ingresar la capacidad maxima de la cafetera: ");
        capacidad = leer.nextInt();
        System.out.print("Ingresar la cantidad de cafe en la cafetera, "
                + "debe ser menor o igual a %d: ".formatted(capacidad));
        cantidad = leer.nextInt();
        System.out.println("");
        System.out.println("Cafetera iniciada.");
        return new Entidad.Cafetera(capacidad, cantidad);
    }

    /**
     * a) Método llenarCafetera(): hace que la cantidad actual sea igual a la
     * capacidad máxima.
     *
     * @param cafetera Se pasa como argumento la cafetera a rellenar
     */
    public void llenarCafetera(Cafetera cafetera) {
        cafetera.setCantidadActual(cafetera.getCapacidadMaxima());
        System.out.println("");
        System.out.println("Cafetera llena.");
    }

    /**
     * b) Método servirTaza(int): se pide el tamaño de una taza vacía, el método
     * recibe el tamaño de la taza y simula la acción de servir la taza con la
     * capacidad indicada. Si la cantidad actual de café “no alcanza” para
     * llenar la taza, se sirve lo que quede. El método le informará al usuario
     * si se llenó o no la taza, y de no haberse llenado en cuanto quedó la
     * taza.
     *
     * @param cafetera Parametro de tipo Cafetera desde donde se van a servir la
     * taza
     * @param taza Variable de tipo int con la capacidad de la taza a servir
     */
    public void servirTaza(Cafetera cafetera, int taza) {
        
        if (taza > cafetera.getCantidadActual()) {
            System.out.println("La cantidad de cafe no alcanza para llenar la taza.");
            System.out.println("La taza se cargo con " + cafetera.getCantidadActual());
            cafetera.setCantidadActual(0);
        } else {
            cafetera.setCantidadActual(cafetera.getCantidadActual() - taza);
            System.out.println("La taza se lleno.");
        }
        System.out.println("");
        System.out.println("Cafe servido.");
    }

    /**
     * c) Método vaciarCafetera(): pone la cantidad de café actual en cero.
     *
     * @param cafetera Parametro de tipo Cafetera donde se va a vaciar la
     * capacidad
     */
    public void vaciarCafetera(Cafetera cafetera) {
        cafetera.setCantidadActual(0);
        System.out.println("");
        System.out.println("Cafetera vacia.");
    }

    /**
     * d) Método agregarCafe(int): se le pide al usuario una cantidad de café,
     * el método lo recibe y se añade a la cafetera la cantidad de café
     * indicada.
     *
     * @param cafetera Parametro de tipo Cafetera desde donde se van a agregar
     * cafe
     * @param cantidad variable de tipo int con la cantidad a agregar
     */
    public void agregarCafe(Cafetera cafetera, int cantidad) {
        cafetera.setCantidadActual(cantidad + cafetera.getCantidadActual());
        System.out.println("Se le cargo %d a la cafetera.".formatted(cantidad));
        System.out.println("La cantidad actual es de " + cafetera.getCantidadActual());
        System.out.println("");
        System.out.println("Cafetera recargada.");
    }
}
