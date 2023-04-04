/** Realizar una clase llamada CuentaBancaria en el paquete Entidades con los
 * siguientes atributos: numeroCuenta(entero), dniCliente(entero largo),
 * saldoActual. Agregar constructor vacío, con parámetros, getters y setters.
 * Agregar la clase CuentaBancariaServicio en el paquete Servicios que contenga:
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

    /**
     * a) Método para crear cuenta pidiéndole los datos al usuario.
     *
     * @return
     */
    public CuentaBancaria crearCuenta() {
        System.out.print("Ingrese el número de cuenta del cliente: ");
        int numeroCuenta = leer.nextInt();

        System.out.print("Ingrese el número de DNI del cliente: ");
        long numeroDNI = leer.nextLong();

        System.out.print("Ingrese el saldo inicial de la cuenta: ");
        double saldoActual = leer.nextDouble();

        return new CuentaBancaria(numeroCuenta, numeroDNI, saldoActual);
    }

    /**
     * b) Método ingresar(double): recibe una cantidad de dinero a ingresar y se
     * le sumará al saldo actual.
     *
     * @param cuenta
     *          Variable del tipo CuentaBancaria
     *              con los datos del cliente 
     * @param monto
     *          Variable del tipo double
     *              con el monto que va a depositar en la cuenta
     */
    public void ingresar(CuentaBancaria cuenta, double monto) {
        cuenta.setSaldoActual(cuenta.getSaldoActual() + monto);
    }

    /**
     * C) Método retirar(double): recibe una cantidad de dinero a retirar y se
     * le restara al saldo actual.Si la cuenta no tiene la cantidad de dinero a
 retirar se retirará el máximo posible hasta dejar la cuenta en 0.
     *
     * @param cuenta 
     *          Variable del tipo CuentaBancaria
     *              con los datos del cliente
     * @param monto 
     *          Variable del tipo double
     *              con el monto a retirar de la cuenta
     */
    public void retirar(CuentaBancaria cuenta, double monto){
        if (cuenta.getSaldoActual()<monto) {
            System.out.println("El cliente solo puede retirar $ "+ cuenta.getSaldoActual()+".");
            cuenta.setSaldoActual(cuenta.getSaldoActual());
        }else {
            cuenta.setSaldoActual(cuenta.getSaldoActual()-monto);
            System.out.println("El cliente retira $ "+ monto+".");
            System.out.println("El saldo en cuents es de $ "+cuenta.getSaldoActual()+".");
        }        
    }
    
    /**
     * d) Método extraccionRapida: le permitirá sacar solo un 20% de su saldo.
     *         Validar que el usuario no saque más del 20%.
     * 
     * @param cuenta
     *          Variable del tipo CuentaBancaria
     *              con los datos del cliente
     * @param monto
     *          Variable del tipo double
     *              con el monto a retirar de la cuenta con el limite
     *              maximo del 20%
     */
    
    public void extraccionRapida(CuentaBancaria cuenta, double monto){
        double maximo=cuenta.getSaldoActual()*0.2;
        if (maximo>=monto) {
            System.out.println("El cliente retira $"+ monto+".");
            cuenta.setSaldoActual(cuenta.getSaldoActual()- monto);
        }else{
            System.out.println("El cliente solo puede retirar $"+ maximo+", correspondiente al 20% del saldo.");
            cuenta.setSaldoActual(cuenta.getSaldoActual()-maximo);
        }
    }
    
    /**
     * e) Método consultarSaldo: permitirá consultar el saldo disponible en la cuenta.
     * 
     * @param cuenta
     *          Variable del tipo CuentaBancaria
     *              con los datos del cliente
     */
    public void consultarSaldo(CuentaBancaria cuenta){
        System.out.println("El saldo del cliente es de $ "+cuenta.getSaldoActual()+".");
    }
    
    /**
     *   f) Método consultarDatos: permitirá mostrar todos los datos de la cuenta.
     * 
     * @param cuenta
     *          Variable del tipo CuentaBancaria
     *              con los datos del cliente 
     */
    public void consultarDatos(CuentaBancaria cuenta){
        System.out.println("Datos del cliente:\n"+
                           "DNI del Cliente: " + cuenta.getDniCliente()+"\n"+
                           "Número de cuenta: "+ cuenta.getNumeroCuenta()+"\n"+
                           "Saldo en cuenta: "+cuenta.getSaldoActual());
    }
}
