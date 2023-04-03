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
package Servicios;

import Entidad.CuentaBancaria;
import java.util.Scanner;

/**
 *
 * @author Sebastián Cozzi
 */
public class CuentaBancariaServicio {
    
    // inicialización de Scanner
    private final Scanner leer = new Scanner(System.in).useDelimiter("\n");
    
    
    public CuentaBancaria crearCuenta(){
        System.out.print("Ingrese el número de cuenta del cliente: ");
        int numeroCuenta=leer.nextInt();
        
        System.out.print("Ingrese el número de DNI del cliente: ");
        long numeroDNI=leer.nextLong();
        
        System.out.print("Ingrese el saldo inicial de la cuenta: ");
        double saldoActual=leer.nextDouble();
        
        return new CuentaBancaria(numeroCuenta,numeroDNI,saldoActual);
    }
    
}
