package com.Reto1;

import java.util.HashMap;
import java.util.Scanner;
public class NotasRevista {
    public static boolean unirRecortes(String nota, String revista) {
        
        nota = nota.toLowerCase();
        revista = revista.toLowerCase();       
        HashMap<Character, Integer> frecuenciaRevista = new HashMap<>();        
        for (char c : revista.toCharArray()) {
            frecuenciaRevista.put(c, frecuenciaRevista.getOrDefault(c, 0) + 1);
        }        
        for (char c : nota.toCharArray()) {
            if (!frecuenciaRevista.containsKey(c) || frecuenciaRevista.get(c) <= 0) {
                return false; 
            }            
            frecuenciaRevista.put(c, frecuenciaRevista.get(c) - 1);
        }
        return true; 
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Solicitamos al usuario que ingrese la nota
        System.out.print("Ingrese la nota: ");
        String nota = scanner.nextLine();
        // Solicitamos al usuario que ingrese la revista
        System.out.print("Ingrese el texto de la revista: ");
        String revista = scanner.nextLine();
        
        boolean resultado = unirRecortes(nota, revista);
        System.out.println("¿Se puede escribir la nota? " + resultado);         
        scanner.close();
    }
}