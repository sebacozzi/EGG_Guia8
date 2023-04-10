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
package Entidad;

/**
 *
 * @author Sebastián Cozzi
 */
public class NIF {
    private long dni;
    private char letra;
    private char[] letras;
    public NIF() {
        this.dni=0;
        this.letra=' ';
        this.letras = new char[]{'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'};
    }

    public NIF(long dni, char letra) {
        this.letras = new char[]{'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'};
        this.dni = dni;
        this.letra = letra;
    }

    public long getDni() {
        return dni;
    }

    public void setDni(long dni) {
        this.dni = dni;
        this.letra=letras[(int) (this.dni % 23)];
    }

    public char getLetra() {
        return letra;
    }

    public char getLetras(int index) {
        return letras[index];
    }

    @Override
    public String toString() {
        return "NIF= " + dni + "-" + letra;
    }
    
}