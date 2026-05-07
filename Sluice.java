/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.zadatak1;

public class Sluice extends Tool{
    
    public Sluice(){
        super(100);
    }
    
    @Override
    public int useTool(){
        
        int kvar = rnd.nextInt(51); // levak se trosi od 20% do 50%
        if (kvar < 20){
            kvar = 20;
        }
        int trenDur = getDurability();
        setDurability(trenDur - kvar);
        System.out.println("Trenutni kapacitet LEVKA je: " + getDurability() + "%");
        
        int zarada = rnd.nextInt(501); // levak daje zaradu od 0$ do 500$, koristim random
        System.out.println("Zarada za LEVAK iznosi: " + zarada + " $");
        return zarada;   
    }
      
//metoda repair() podize durability ovog alata na 100%
//pozvana je kada igrac odabere nedelju da popravi levak
    public void repair(){
        setDurability(100);
        System.out.println("LEVAK je na 100% kapaciteta!");
    }
}
