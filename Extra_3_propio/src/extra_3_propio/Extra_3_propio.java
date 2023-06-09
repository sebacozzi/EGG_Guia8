/** ejercicio 2, se te pide que crees una clase de entidad para representar una
 * cuenta bancaria y una clase de servicio para manejar la l�gica empresarial
 * de la gesti�n de cuentas bancarias. Aqu� hay una explicaci�n general de c�mo
 * podr�as hacerlo:
 *
 * Clase de entidad:
 * La clase de entidad "CuentaBancaria" tendr�a las siguientes propiedades:
 * N�mero de cuenta: un n�mero �nico que identifica la cuenta bancaria.
 * Nombre del titular de la cuenta: el nombre completo de la persona que posee la cuenta.
 * Saldo actual: el saldo disponible en la cuenta bancaria.
 *
 *   Clase de servicio:
 * La clase de servicio "GestorCuentasBancarias" tendr�a m�todos para crear una
 * nueva cuenta bancaria, realizar una transferencia de fondos entre dos
 * cuentas y obtener el saldo actual de una cuenta bancaria.
 * Aqu� hay un ejemplo b�sico:
 * Crear cuenta bancaria: Este m�todo recibir�a el nombre del titular de
 * la cuenta y un saldo inicial opcional. La implementaci�n de este
 * m�todo crear�a una nueva cuenta bancaria con un n�mero de cuenta �nico
 * y agregar�a la cuenta a una lista de cuentas bancarias mantenida por
 * la clase "GestorCuentasBancarias".
 * Transferir fondos: Este m�todo recibir�a el n�mero de cuenta de la
 * cuenta de origen, el n�mero de cuenta de la cuenta de destino y el
 * monto de la transferencia. La implementaci�n de este m�todo buscar�a
 * ambas cuentas en la lista de cuentas bancarias y transferir�a el
 * monto especificado de la cuenta de origen a la cuenta de destino,
 * actualizando los saldos de ambas cuentas.
 * Obtener saldo: Este m�todo recibir�a el n�mero de cuenta de la cuenta
 * bancaria y devolver�a el saldo actual de la cuenta.
 * Implementaci�n en el m�todo principal:
 * En el m�todo principal, podr�as crear una instancia de la clase
 * "GestorCuentasBancarias" y luego llamar a los m�todos de la clase
 * para crear cuentas bancarias, transferir fondos y obtener saldos de
 * cuenta. Por ejemplo, podr�as crear dos cuentas bancarias y transferir
 * fondos entre ellas:
 * Crear una cuenta bancaria para "Juan P�rez" con un saldo inicial de $1000.
 * Crear una cuenta bancaria para "Mar�a G�mez" con un saldo inicial de $500.
 * Transferir $500 de la cuenta bancaria de "Juan P�rez" a la cuenta bancaria de "Mar�a G�mez".
 * Obtener el saldo actual de la cuenta bancaria de "Juan P�rez" y mostrarlo en la pantalla.
 */
package extra_3_propio;

import menuDeOpciones;

/**
 *
 * @author Sebasti�n Cozzi
 */
public class Extra_3_propio {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String[] op1 = {"Opcion 1", "Opcion 2", "Opcion 3", "Opcion 4", "Opcion 5", "Volver"};
        String[] op0 = {"Opcion 1", "Opcion 2", "Salir"};
        String[] op2 = {"Opcion 4", "Opcion 5", "Volver"};
        ServiciosMenu sm = new ServiciosMenu();
        boolean salida;
        do {
            salida = true;
            sm.show(new Menu(op0, "menu Principal"));
            switch (sm.getResultado()) {
                case 1:
                    do {
                        sm.show(new Menu(op1, "Menu Opci�n 1"));
                        switch (sm.getResultado()) {
                            case 1:
                                System.out.println("Opci�n 1 elejida.");
                                break;
                            case 2:
                                System.out.println("Opci�n 2 elejida.");
                                break;
                            case 3:
                                System.out.println("Opci�n 3 elejida.");
                                break;
                            case 4:
                                System.out.println("Opci�n 4 elejida.");
                                break;
                            case 5:
                                System.out.println("Opci�n 5 elejida.");
                                break;
                            case 6:
                                System.out.println("Volver al menu principal");
                        }
                        sm.esperaTecla();
                        if (sm.getResultado() == 6) {
                            break;
                        }
                    } while (true);
                    break;
                case 2:
                    sm.show(new Menu(op2, "Menu Opci�n 2"));
                    System.out.println("Los resultados de las opciones no estan controladas... vuelve al menu principal.");
                    sm.esperaTecla();
                    break;
                case 3:
                    salida = false;
            }
        } while (salida);

    }

}
