/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.zadatak1;

import java.util.ArrayList;
import java.util.Random;

public class FortyNiner {
    
    private int endurance; //izdrzljivost igraca
    private int money = 100; //pocetna vrednost novca koju poseduje igrac
    private ArrayList<Tool> tools; //svi alati koje poseduje igrac (1 Pan, 1 Sluice, N Cradles)
    private Random rnd;
    
    public FortyNiner(){}
    
    public int getEndurance(){
            return endurance;
    }
    
    public void setEndurance(int endurance){
            this.endurance = endurance;
    }
    
    public int getMoney(){
            return money;
    }
    
    public void setMoney(int money){
            this.money = money;
    }
    
    public ArrayList<Tool> getTools(){
            return tools;
    }
    
    public void setTools(ArrayList<Tool> tools){
            this.tools = tools;
    }
////koristi atribut tools, svaki pojedinačno, tako što poziva metodu useTool() na 
////svakom od alata (prepoznajte ovde polimorfizam). Obratite pažnju da svaka metoda useTool() 
////vraća količinu novca koji je zarađen njegovim korišćenjem, a smanjuje mu kapacitet (durability) 
////uvek na drugačiji način u zavisnosti od alata o kojem se radi (kod Sita se ne smanjuje, kod Levka 
////20%-50% svake sedmice, kod Kolevke odmah na 0% sa verovatnoćom 20%). Poziva se na kraju 
////svake sedmice
//    public useTools();
//    
////poziva se na kraju svake sedmice, kao rezultat smanjuje 
////količinu raspoloživog novca koji 49er poseduje
//    public buyFood();
//    
////poziva se na kraju svake sedmice, kao rezultat 
////smanjuje izdržljivost (endurance) 49er-a
//    public loseEndurance();
//    
//    
//// STA IGRAC RADI NEDELJOM //
//    
//// ponudi izbor 49er-u šta raditi u nedelju u skladu sa opisom iznad: ništa, popraviti Levak ili ići u grad
//    public isItSundayAgain();
//    
//// kao rezultat smanjuje količinu raspoloživog novca, ali povećava izdržljivost 
////(endurance) 49er-a. Pozvana je ukoliko igrač prilikom poziva metode itIsSundayAgain() odabere opciju da pođe u grad
//    private goToSaloon();
//    
////kao rezultat povećava kapacitet Levka na 100% ali smanjuje iznos raspoloživog 
////novca 49er-a za $100. Pozvana je ukoliko igrač prilikom poziva metode itIsSundayAgain() odabere 
////opciju da nedelju provede opravljajući Levak
//    private fixSluice();
//    
}
