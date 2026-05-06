/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.zadatak1;

public class Pan extends Tool{
    
    public Pan(){
        super(100);
    }

    @Override
    public int useTool(){ // sito daje zaradu od 0$ do 60$, koristim random
        
        int zarada = rnd.nextInt(61);
        System.out.println("Zarada za SITO iznosi: " + zarada + " $");
        return zarada;
    }
}
