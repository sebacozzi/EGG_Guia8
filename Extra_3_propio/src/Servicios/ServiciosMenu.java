/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servicios;

import java.util.InputMismatchException;
import java.util.Scanner;
import Utilidades.Menu;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

/**
 *
 * @author Sebastián Cozzi
 */
public class ServiciosMenu {
    private int resultado;

    public int getResultado() {
        return resultado;
    }
    
    
    
    public void show(Menu menu) {
        // inicialización de Scanner
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        boolean salida, error;
        
        do{
            cls();
            System.out.print(menu.toString());
            salida= true;
            error = true;
            try{
                menu.setResultado( leer.nextInt());
            }catch (InputMismatchException e){
                System.out.println("Debe ingresar un número.");
                leer.next();
                error=false;
                esperaTecla();
            }
                if (menu.getResultado()>0 && menu.getResultado() <= menu.getItems().length) {
                    salida=false;
                }else if (error){ 
                    System.out.println("ingrese un numero del 1 al "+ menu.getItems().length+".");
                    esperaTecla();
                }
            } while (salida);
        this.resultado=menu.getResultado();
        }
    
    
    public void esperaTecla(){
        Scanner leer = new Scanner(System.in);
        System.out.println("Precione Enter/Intro para continuar.");
        leer.nextLine();
    }
    private static void cls() {
        try {
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_L);
            robot.keyRelease(KeyEvent.VK_L);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.delay(100);
        } catch (AWTException e) {
        }
    }
}
