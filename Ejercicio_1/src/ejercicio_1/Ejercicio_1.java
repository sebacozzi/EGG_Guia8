/**Realizar una clase llamada CuentaBancaria en el paquete Entidades con los 
 * siguientes atributos: numeroCuenta(entero), dniCliente(entero largo), 
 * saldoActual. Agregar constructor vacío, con parámetros, getters y setters.
    Agregar la clase CuentaBancariaServicio en el paquete Servicios que contenga:
 *  a) Método para crear cuenta pidiéndole los datos al usuario.
 *  b) Método ingresar(double): recibe una cantidad de dinero a ingresar y se 
 *      le sumará al saldo actual.
 *  C) Método retirar(double): recibe una cantidad de dinero a retirar y se le
 *      restara al saldo actual. Si la cuenta no tiene la cantidad de dinero
 *      a retirar se retirará el máximo posible hasta dejar la cuenta en 0.
 *  d) Método extraccionRapida: le permitirá sacar solo un 20% de su saldo.
 *      Validar que el usuario no saque más del 20%.
 *  e) Método consultarSaldo: permitirá consultar el saldo disponible en la cuenta.
 *  f) Método consultarDatos: permitirá mostrar todos los datos de la cuenta.
 */
package ejercicio_1;

import Entidad.CuentaBancaria;
import Servicios.CuentaBancariaServicio;
import java.util.Scanner;
import menu.Menu;

/**
 *
 * @author Sebastián Cozzi
 */
public class Ejercicio_1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // inicialización de Scanner
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        CuentaBancariaServicio scb=new CuentaBancariaServicio();
        CuentaBancaria cuenta = null;
        
        String op1[]={"Cargar Cuenta(a)","Ingresar dinero(b)","Extracción(c)", "Extracción Rapida(d)", "Consultar Saldo(e)","Datos del cliente(f)"};
        boolean salida =true;
        
        Menu menu =new Menu("Menu Principal:",op1, "Salir");
        
        do {
            System.out.println( menu.toString());
            if (menu.pregunta()!=1 && cuenta == null) {
                System.out.println("Primero debe crear la cuenta.");
            } else {
            switch (menu.getResultado()) {
                case 1:// Cargar Cuenta
                    cuenta= scb.crearCuenta();
                    break;
                case 2:// Ingresar Dinero
                    System.out.print("Ingrese el monto a depositar: ");
                    scb.ingresar(cuenta, leer.nextDouble());
                    break;
                case 3: // Extracción
                    System.out.print("Ingrese el monto a retirar: ");
                    scb.retirar(cuenta, leer.nextDouble());
                    break;
                case 4:// Extracción Rapida
                    System.out.print("Ingrese el monto a depositar: ");
                    scb.extraccionRapida(cuenta, leer.nextDouble());
                    break;
                case 5: // Consultar Saldo
                    scb.consultarSaldo(cuenta);
                    break;
                case 6:
                    scb.consultarDatos(cuenta);
                    break;
                case 7:
                    salida= false;
                    System.out.println("Gracias por usar nuestros servicios!!");
                    break;
                default:
                    System.out.println("opcion invalida - es de 1 a 6.");
            }
                if (menu.getResultado()>0 && menu.getResultado()<=6) {
                    menu.esperaTecla();
                }
            }
        } while (salida);
        
    }
    
}
