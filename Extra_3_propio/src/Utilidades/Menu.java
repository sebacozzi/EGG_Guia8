/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utilidades;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Scanner;
import java.util.InputMismatchException;
/**
 *
 * @author Sebastián Cozzi
 */
public class Menu {
    private String[] items;
    private int resultado;
    private String titulo;

    /**
     *      Metodo para crear base para el menu
     * @param items 
     *          Arreglo con los items del menu
     * 
     * @param titulo 
     *          Titulo del menu
     */

    public Menu(String[] items, String titulo) {
        this.items = items;
        this.resultado = -1;
        if (titulo.isBlank()) {
            titulo="Menu";
        }
        this.titulo = titulo;
    }

    public void setItems(String[] items) {
        this.items = items;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getResultado() {
        return resultado;
    }

    public String[] getItems() {
        return items;
    }

    public void setResultado(int resultado) {
        this.resultado = resultado;
    }
    
    
    

    @Override
    public String toString() {
        String temp="";
        temp = temp.concat(" "+ this.titulo+ "\n");
        temp= temp.concat("-".repeat(titulo.length()+2)+"\n");
        for (int i = 0; i < items.length; i++) {
            temp=temp.concat(" %d) %s.".formatted((i+1),items[i])+"\n"); 
        }
        temp = temp.concat("  Ingrese una Opción (1 al %d): ".formatted(items.length));
        return temp;
    }
    
    
     
    
}
