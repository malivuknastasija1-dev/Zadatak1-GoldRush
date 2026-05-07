/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.zadatak1;

public class Zadatak1 {

    public static void main(String[] args) {
        System.out.println("*** GAME: GOLD RUSH ***");
        
        GoldRush gd = new GoldRush();
        
        char izbor = Utility.ocitajOdlukuOPotvrdi("da ucitate prethodnu igru?");
        if (izbor == 'Y'){
            gd.loadGame();
        } else{
            System.out.println("START NEW GAME");
        }
        
        gd.survive();
    }
}
