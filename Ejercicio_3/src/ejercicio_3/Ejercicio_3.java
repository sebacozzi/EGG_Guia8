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
package ejercicio_3;

import Entidad.Persona;
import Servicios.PersonaServicio;
import menu.Menu;

/**
 *
 * @author Sebasti�n Cozzi
 */
public class Ejercicio_3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        PersonaServicio sp = new PersonaServicio();
        
        /// Agregar tantos null como personas se quieran crear
        Persona personas[] = {null, null, null, null};
        int[] IMCs = new int[3];
        int mayores = 0;
        Menu.esperaTecla();
        for (Persona persona : personas) {
            persona = sp.crearPersona();
            if (sp.esMayorDeEdad(persona)) {
                mayores++;
            }
            IMCs[sp.calcularIMC(persona) + 1]++;
            Menu.cls();
        }
        int cont = personas.length;
        System.out.println("Estadisticas de Personas: ");
        System.out.println("El %.2f %% son mayores de edad.".formatted(porcentaje(mayores,cont)));
        System.out.println("El %.2f %% son menores de edad.".formatted(porcentaje( cont-mayores,cont)));
        System.out.println("El porcentaje con bajo peso es %.2f %%.".formatted(porcentaje(IMCs[0],cont)));
        System.out.println("El porcentaje con peso ideal es %.2f %%".formatted(porcentaje(IMCs[1],cont)));
        System.out.println("El porcentaje con sobre peso es %.2f %%".formatted(porcentaje(IMCs[2],cont)));
        
        
    }
    private static double porcentaje(double cantidad, double total){
        return (cantidad/total)*100;
    }
}
