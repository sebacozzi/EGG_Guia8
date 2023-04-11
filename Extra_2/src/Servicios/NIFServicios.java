/*Dígito Verificador. Crear una clase NIF que se usará para mantener DNIs con 
su correspondiente letra (NIF). Los atributos serán el número de DNI (entero largo)
y la letra (String o char) que le corresponde. En NIFService se dispondrá de 
los siguientes métodos:
Métodos getters y setters para el número de DNI y la letra.
Método crearNif(): le pide al usuario el DNI y con ese DNI calcula la letra 
que le corresponderá. Una vez calculado, le asigna la letra que le corresponde 
según
Método mostrar(): que nos permita mostrar el NIF (ocho dígitos, un guion y la
letra en mayúscula; por ejemplo: 00395469-F).
La letra correspondiente al dígito verificador se calculará a traves de un
método que funciona de la siguiente manera: Para calcular la letra se toma 
el resto de dividir el número de DNI por 23 (el resultado debe ser un número 
entre 0 y 22). El método debe buscar en un array (vector) de caracteres la
posición que corresponda al resto de la división para obtener la letra 
correspondiente. La tabla de caracteres es la siguiente:

 */
package Servicios;

import Entidad.NIF;
import java.util.Scanner;

/**
 *
 * @author Sebastián Cozzi
 */
public class NIFServicios {
    private // inicialización de Scanner
            Scanner leer = new Scanner(System.in).useDelimiter("\n");
    
    public NIF CrearNif(){
        NIF nif = new NIF();
        System.out.print("Ingrese el DNI: ");
        nif.setDni(leer.nextLong());
        System.out.println("Calculando NIF.");
        return nif;
    }
     public void mostrar(NIF nif){
         System.out.println("---------------");
         System.out.println(nif.toString());
         
    }
}
