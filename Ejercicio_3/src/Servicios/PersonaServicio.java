/** Realizar una clase llamada Persona en el paquete de entidades que tengan los
 * siguientes atributos: nombre, edad, sexo (?H? para hombre, ?M? para mujer,
 * ?O? para otro), peso y altura. Si desea a�adir alg�n otro atributo, puede
 * hacerlo. Agregar constructores, getters y setters.
 * En el paquete Servicios crear PersonaServicio con los siguientes 3 m�todos:
 * a) M�todo esMayorDeEdad(): indica si la persona es mayor de edad. La funci�n
 *          devuelve un booleano.
 * b) Metodo crearPersona(): el m�todo crear persona, le pide los valores de los
 *          atributos al usuario y despu�s se le asignan a sus respectivos
 *          atributos para llenar el objeto Persona. Adem�s, comprueba que el
 *          sexo introducido sea correcto, es decir, H, M o O. Si no es correcto
 *          se deber� mostrar un mensaje
 * c) M�todo calcularIMC(): calculara si la persona est� en su peso ideal
 * (peso en kg/(altura^2 en mt2)). Si esta f�rmula da por resultado un valor
 * menor que 20, significa que la persona est� por debajo de su peso ideal y la
 * funci�n devuelve un -1. Si la f�rmula da por resultado un n�mero entre 20 y
 * 25 (incluidos), significa que la persona est� en su peso ideal y la funci�n
 * devuelve un 0. Finalmente, si el resultado de la f�rmula es un valor mayor
 * que 25 significa que la persona tiene sobrepeso, y la funci�n devuelve un 1.
 * A continuaci�n, en la clase main hacer lo siguiente:
 *    Crear 4 objetos de tipo Persona con distintos valores, a continuaci�n,
 * llamaremos todos los m�todos para cada objeto, deber� comprobar si la persona
 * est� en su peso ideal, tiene sobrepeso o est� por debajo de su peso ideal e
 * indicar para cada objeto si la persona es mayor de edad.
 * Por �ltimo, guardaremos los resultados de los m�todos calcularIMC y
 * esMayorDeEdad en distintas variables(arrays), para despu�s calcular un
 * porcentaje de esas 4 personas cuantas est�n por debajo de su peso, cuantas en
 * su peso ideal y cuantos, por encima, y tambi�n calcularemos un porcentaje de
 * cuantos son mayores de edad y cuantos menores. Para esto, podemos crear unos
 * m�todos adicionales.
 *
 */
package Servicios;

import Entidad.Persona;
import java.util.Scanner;

/**
 *
 * @author Sebasti�n Cozzi
 */
public class PersonaServicio {

    private Scanner leer = new Scanner(System.in).useDelimiter("\n");

    /**
     * indica si la persona es mayor de edad. La funci�n devuelve un booleano.
     *
     * @param persona Clase de tipo Persona para verificar si es mayor de edad
     * @return boolean true si es mayor, false si es menor de 18
     */
    public boolean esMayorDeEdad(Persona persona) {
        return persona.getEdad() > 17;
    }

    /**
     * el m�todo crear persona, le pide los valores de los atributos al usuario
     * y despu�s se le asignan a sus respectivos atributos para llenar el objeto
     * Persona. Adem�s, comprueba que el sexo introducido sea correcto, es
     * decir, H, M o O. Si no es correcto se deber� mostrar un mensaje
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
     *  M�todo calcularIMC(): calculara si la persona est� en su peso ideal
 * (peso en kg/(altura^2 en mt2)).Si esta f�rmula da por resultado un valor
 menor que 20, significa que la persona est� por debajo de su peso ideal y la
 funci�n devuelve un -1.Si la f�rmula da por resultado un n�mero entre 20 y
 25 (incluidos), significa que la persona est� en su peso ideal y la funci�n
 devuelve un 0. Finalmente, si el resultado de la f�rmula es un valor mayor
 que 25 significa que la persona tiene sobrepeso, y la funci�n devuelve un 1.
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
