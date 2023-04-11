/** Vamos a realizar una clase llamada Raices, donde representaremos los valores
 * de una ecuación de 2º grado. Tendremos los 3 coeficientes como atributos,
 * llamémosles a, b y c. Hay que insertar estos 3 valores para construir el
 * objeto a través de un método constructor. Luego, en RaicesServicio las
 * operaciones que se podrán realizar son las siguientes:
 *  a) Método getDiscriminante(): devuelve el valor del discriminante (double).
 * El discriminante tiene la siguiente fórmula: (b^2)-4*a*c
 *  b) Método tieneRaices(): devuelve un booleano indicando si tiene dos
 * soluciones, para que esto ocurra, el discriminante debe ser mayor o igual
 * que 0.
 *  c) Método tieneRaiz(): devuelve un booleano indicando si tiene una única
 * solución, para que esto ocurra, el discriminante debe ser igual que 0.
 *  d) Método obtenerRaices(): llama a tieneRaíces() y si devolvió́ true,
 * imprime las 2 posibles soluciones.
 *  e) Método obtenerRaiz(): llama a tieneRaiz() y si devolvió́ true imprime una
 * única raíz. Es en el caso en que se tenga una única solución posible.
 *  f) Método calcular(): esté método llamará tieneRaices() y a tieneRaíz(), y
 * mostrará por pantalla las posibles soluciones que tiene nuestra ecuación con
 * los métodos obtenerRaices() o obtenerRaiz(), según lo que devuelvan nuestros
 * métodos y en caso de no existir solución, se mostrará un mensaje.
 * Nota: Fórmula ecuación 2o grado: (-b±√((b^2)-(4*a*c)))/(2*a) Solo varía el
 * signo delante de -b
 */
package Servicios;

import Entidad.Raices;
import java.util.Scanner;

/**
 *
 * @author Sebastián Cozzi
 */
public class RaicesServicio {
    Scanner leer = new Scanner(System.in);
    
    /**
     * a) Método getDiscriminante(): devuelve el valor del discriminante
     * (double).El discriminante tiene la siguiente fórmula: (b^2)-4*a*c
     *
     * @param raices
     * @return
     */
    public double getDiscriminante(Raices raices) {
        return Math.pow(raices.getB(), 2) - 4 * raices.getA() * raices.getC();
    }

    /**
     * b) Método tieneRaices(): devuelve un booleano indicando si tiene dos
     * soluciones, para que esto ocurra, el discriminante debe ser mayor o igual
     * que 0.
     *
     * @param raices
     * @return
     */
    public boolean tieneRaices(Raices raices) {
        return (getDiscriminante(raices) >= 0);
    }

    /**
     * c) Método tieneRaiz(): devuelve un booleano indicando si tiene una única
     * solución, para que esto ocurra, el discriminante debe ser igual que 0.
     *
     * @param raices
     * @return
     */
    public boolean tieneRaiz(Raices raices) {
        return (getDiscriminante(raices) == 0);
    }

    /**
     * d) Método obtenerRaices(): llama a tieneRaíces() y si devolvió́ true,
     * imprime las 2 posibles soluciones.
     *
     * @param raices
     */
    public void obtenerRaices(Raices raices) {
        if (tieneRaices(raices)) {
            int a = raices.getA();
            int b = raices.getB();
            int c = raices.getC();
            System.out.println("Raiz 1: " + (-b + Math.sqrt((Math.pow(b, 2)) - (4 * a * c))) / (2 * a));
            System.out.println("Raiz 2: " + (-b - Math.sqrt((Math.pow(b, 2)) - (4 * a * c))) / (2 * a));
        }
    }

    /**
     * e) Método obtenerRaiz(): llama a tieneRaiz() y si devolvió́ true imprime
     * una única raíz.Es en el caso en que se tenga una única solución posible.
     *
     * @param raices
     */
    public void obtenerRaiz(Raices raices) {
        if (tieneRaiz(raices)) {
            int a = raices.getA();
            int b = raices.getB();
            int c = raices.getC();
            System.out.println("Raiz unica: " + (-b + Math.sqrt((Math.pow(b, 2)) - (4 * a * c))) / (2 * a));
        }
    }

    /**
     * f) Método calcular(): esté método llamará tieneRaices() y a
     * tieneRaíz(), y mostrará por pantalla las posibles soluciones que tiene
     * nuestra ecuación con los métodos obtenerRaices() o obtenerRaiz(), según
     * lo que devuelvan nuestros métodos y en caso de no existir solución, se
     * mostrará un mensaje.
     *
     * @param raices
     */
    public void calcular(Raices raices) {
        if (tieneRaiz(raices)) {
            obtenerRaiz(raices);
        } else if (tieneRaices(raices)) {
            obtenerRaices(raices);
        } else {
            System.out.println("No tiene raices.");
        }

    }
    public void iniciaRaices(Raices raices){
        
        System.out.print("Ingrese el valor de a: ");
        raices.setA(leer.nextInt());
        System.out.print("Ingrese el valor de b: ");
        raices.setB(leer.nextInt());
        System.out.print("Ingrese el valor de c: ");
        raices.setC(leer.nextInt());
        
    }
}
