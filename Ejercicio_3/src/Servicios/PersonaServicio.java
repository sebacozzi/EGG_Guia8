/** Realizar una clase llamada Persona en el paquete de entidades que tengan los
 * siguientes atributos: nombre, edad, sexo (?H? para hombre, ?M? para mujer,
 * ?O? para otro), peso y altura. Si desea añadir algún otro atributo, puede
 * hacerlo. Agregar constructores, getters y setters.
 * En el paquete Servicios crear PersonaServicio con los siguientes 3 métodos:
 * a) Método esMayorDeEdad(): indica si la persona es mayor de edad. La función
 *          devuelve un booleano.
 * b) Metodo crearPersona(): el método crear persona, le pide los valores de los
 *          atributos al usuario y después se le asignan a sus respectivos
 *          atributos para llenar el objeto Persona. Además, comprueba que el
 *          sexo introducido sea correcto, es decir, H, M o O. Si no es correcto
 *          se deberá mostrar un mensaje
 * c) Método calcularIMC(): calculara si la persona está en su peso ideal
 * (peso en kg/(altura^2 en mt2)). Si esta fórmula da por resultado un valor
 * menor que 20, significa que la persona está por debajo de su peso ideal y la
 * función devuelve un -1. Si la fórmula da por resultado un número entre 20 y
 * 25 (incluidos), significa que la persona está en su peso ideal y la función
 * devuelve un 0. Finalmente, si el resultado de la fórmula es un valor mayor
 * que 25 significa que la persona tiene sobrepeso, y la función devuelve un 1.
 * A continuación, en la clase main hacer lo siguiente:
 *    Crear 4 objetos de tipo Persona con distintos valores, a continuación,
 * llamaremos todos los métodos para cada objeto, deberá comprobar si la persona
 * está en su peso ideal, tiene sobrepeso o está por debajo de su peso ideal e
 * indicar para cada objeto si la persona es mayor de edad.
 * Por último, guardaremos los resultados de los métodos calcularIMC y
 * esMayorDeEdad en distintas variables(arrays), para después calcular un
 * porcentaje de esas 4 personas cuantas están por debajo de su peso, cuantas en
 * su peso ideal y cuantos, por encima, y también calcularemos un porcentaje de
 * cuantos son mayores de edad y cuantos menores. Para esto, podemos crear unos
 * métodos adicionales.
 *
 */
package Servicios;

import Entidad.Persona;
import java.util.Scanner;

/**
 *
 * @author Sebastián Cozzi
 */
public class PersonaServicio {

    private Scanner leer = new Scanner(System.in).useDelimiter("\n");

    /**
     * indica si la persona es mayor de edad. La función devuelve un booleano.
     *
     * @param persona Clase de tipo Persona para verificar si es mayor de edad
     * @return boolean true si es mayor, false si es menor de 18
     */
    public boolean esMayorDeEdad(Persona persona) {
        return persona.getEdad() > 17;
    }

    /**
     * el método crear persona, le pide los valores de los atributos al usuario
     * y después se le asignan a sus respectivos atributos para llenar el objeto
     * Persona. Además, comprueba que el sexo introducido sea correcto, es
     * decir, H, M o O. Si no es correcto se deberá mostrar un mensaje
     *
     * @return Clase tipo Persona
     */
    public Persona crearPersona() {
        String nombre;
        int edad;
        char sexo;
        double peso;
        double altura;
        boolean salida;
        System.out.println("Estamos creando una persona...");
        System.out.print("Ingrese el nombre de la persona: ");
        nombre = leer.next();
        System.out.print("Ingrese la edad: ");
        edad = leer.nextInt();
        do {
            salida = false;
            System.out.print("Ingrese el sexo (H,M,O): ");
            sexo = leer.next().toUpperCase().toCharArray()[0];
            switch (sexo) {
                case 'H', 'M', 'O':

                    break;
                default:
                    System.out.println("Valores validos (H,M,O)");
                    salida = true;
            }

        } while (salida);

        System.out.print("Ingrese el peso: ");
        peso = leer.nextDouble();

        System.out.print("Ingrese la altura: ");
        altura = leer.nextDouble();

        return new Persona(nombre, edad, sexo, peso, altura);
    }

    /**
     *  Método calcularIMC(): calculara si la persona está en su peso ideal
 * (peso en kg/(altura^2 en mt2)).Si esta fórmula da por resultado un valor
 menor que 20, significa que la persona está por debajo de su peso ideal y la
 función devuelve un -1.Si la fórmula da por resultado un número entre 20 y
 25 (incluidos), significa que la persona está en su peso ideal y la función
 devuelve un 0. Finalmente, si el resultado de la fórmula es un valor mayor
 que 25 significa que la persona tiene sobrepeso, y la función devuelve un 1.
 * 
     * @param persona
     *  datos de la persona
     * @return 
     * devuelve -1 si la persona esta en bajo peso
     * devuelve 0 si esta en su peso ideal
     * devuelve 1 si esta en con sobre peso
     */
    public int calcularIMC(Persona persona){
        double IMC=persona.getPeso()/ (Math.pow(persona.getAltura(), 2));
        if (IMC<20) {
            return -1;
        } else if (IMC>25) {
            return 1;
        }
        return 0;
    }
            
}
