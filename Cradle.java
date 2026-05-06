/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.zadatak1;
//
public class Cradle extends Tool{
    
    public Cradle(){
        super(100);
    }

    @Override
    public int useTool(){
       
//        if (getDurability() == 0) { \\ako je kolevka vec pokvarena, nista ne radim
//            System.out.println("KOLEVKA pokvarena - nema zarade!");
//            return 0;
//        }
        
        int kvar = 20;
        if (rnd.nextInt(100) < kvar){
            setDurability(0);
            System.out.println("KOLEVKA je neupotrebljiva!");
            return 0;
        }
        
        int zarada = rnd.nextInt(31); // kolevka daje zaradu od 0$ do 30$, koristim random
        System.out.println("Zarada za KOLEVKU iznosi: " + zarada + " $");
        return zarada;
    }
}