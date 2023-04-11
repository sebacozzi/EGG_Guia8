/**ejercicio 2, se te pide que crees una clase de entidad para representar una 
 * cuenta bancaria y una clase de servicio para manejar la lógica empresarial
 * de la gestión de cuentas bancarias. Aquí hay una explicación general de cómo
 * podrías hacerlo:

    Clase de entidad:
        La clase de entidad "CuentaBancaria" tendría las siguientes propiedades:
    Número de cuenta: un número único que identifica la cuenta bancaria.
    Nombre del titular de la cuenta: el nombre completo de la persona que posee la cuenta.
    Saldo actual: el saldo disponible en la cuenta bancaria.

*   Clase de servicio:
    La clase de servicio "GestorCuentasBancarias" tendría métodos para crear una
    * nueva cuenta bancaria, realizar una transferencia de fondos entre dos 
    * cuentas y obtener el saldo actual de una cuenta bancaria. 
    * Aquí hay un ejemplo básico:
        Crear cuenta bancaria: Este método recibiría el nombre del titular de 
        * la cuenta y un saldo inicial opcional. La implementación de este 
        * método crearía una nueva cuenta bancaria con un número de cuenta único
        * y agregaría la cuenta a una lista de cuentas bancarias mantenida por
        * la clase "GestorCuentasBancarias".
        Transferir fondos: Este método recibiría el número de cuenta de la 
        * cuenta de origen, el número de cuenta de la cuenta de destino y el 
        * monto de la transferencia. La implementación de este método buscaría
        * ambas cuentas en la lista de cuentas bancarias y transferiría el 
        * monto especificado de la cuenta de origen a la cuenta de destino,
        * actualizando los saldos de ambas cuentas.
        Obtener saldo: Este método recibiría el número de cuenta de la cuenta
        * bancaria y devolvería el saldo actual de la cuenta.
    Implementación en el método principal:
        En el método principal, podrías crear una instancia de la clase 
        * "GestorCuentasBancarias" y luego llamar a los métodos de la clase 
        * para crear cuentas bancarias, transferir fondos y obtener saldos de
        * cuenta. Por ejemplo, podrías crear dos cuentas bancarias y transferir
        * fondos entre ellas:
    Crear una cuenta bancaria para "Juan Pérez" con un saldo inicial de $1000.
    Crear una cuenta bancaria para "María Gómez" con un saldo inicial de $500.
    Transferir $500 de la cuenta bancaria de "Juan Pérez" a la cuenta bancaria de "María Gómez".
    Obtener el saldo actual de la cuenta bancaria de "Juan Pérez" y mostrarlo en la pantalla.
 */
package extra_3_propio;

/**
 *
 * @author Sebastián Cozzi
 */
public class Extra_3_propio {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
