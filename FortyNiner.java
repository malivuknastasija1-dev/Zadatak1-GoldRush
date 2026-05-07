/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.zadatak1;

import java.util.ArrayList;
import java.util.Random;

public class FortyNiner {
    
    private int endurance; //izdrzljivost igraca
    private int money; //pocetna vrednost novca koju poseduje igrac
    private ArrayList<Tool> tools; //svi alati koje poseduje igrac (1 Pan, 1 Sluice, N Cradles)
    private Random rnd;
    
    public FortyNiner(){
        this.money = 100; //pocetna suma novca koju poseduje igrac
        this.endurance = 100; //pocetna izdrzljivost igraca
        this.tools = new ArrayList<>(); //prazan prostor za tools
        this.rnd = new Random();
    }
    
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

    public void useTools(){
        if (endurance <= 0){
            System.out.println("IGRAC je umoran - nema prihoda!");
            return;
        }
            
        int ukupnaSedmicnaZarada = 0;
        for (Tool t : tools){
            if (t.getDurability() > 0 || t instanceof Pan){
                ukupnaSedmicnaZarada += t.useTool();
            }
        }
        this.money += ukupnaSedmicnaZarada;
        System.out.println("Ukupna sedmicna zarada iznosi: " + ukupnaSedmicnaZarada + " $");
    }

    public void buyFood(){
        
        int hranaCena = rnd.nextInt(51); // cena hrane je izmedju 30 $ i 50 $ sedmicno, koristim random
        if (hranaCena < 30){
            hranaCena = 30;
        }
        
        System.out.println("HRANA ove nedelje kosta: " + hranaCena + " $");

        int trenNovac = getMoney();
        setMoney(trenNovac - hranaCena);
        System.out.println("Trenutno posedujes: " + getMoney() + " $");
    }

    public void loseEndurance(){
        
        int endurancePad = rnd.nextInt(26); // endurance opada 10 % do 25 % sedmicno, koristim random
        if (endurancePad < 10){
            endurancePad = 10;
        }
        
        System.out.println("Igracu je opala IZDRZLJIVOST ove nedelje za: " + endurancePad + " %");

        int trenEndurance = getEndurance();
        int noviEndurance = trenEndurance - endurancePad;
        setEndurance(noviEndurance);
        
        System.out.println("Trenutna IZDRZLJIVOST je: " + getEndurance() + " %");
    }
    
// STA IGRAC RADI NEDELJOM //

    public void isItSundayAgain(){
        
        int izbor = 0;
        do{
            System.out.println("NEDELJA - Sta igrac zeli da radi?");
            System.out.println("\tOpcija broj 1 - Odmarati");
            System.out.println("\tOpcija broj 2 - Popravljati Levak (cena 100 $)");
            System.out.println("\tOpcija broj 3 - Otici do grada (cena 50-200 $)");
            System.out.print("\tOdaberite opciju: ");
            
            izbor = Utility.ocitajCeoBroj();
            
            if (izbor < 1 || izbor > 3){
                System.out.println("Uneli ste pogresnu opciju!");
            } 
        }while(izbor < 1 || izbor > 3);
        
        switch(izbor){
            case 1:
                System.out.println("\tOdabrana opcija 1");
                System.out.println("Igrac se danas odmara!");
                break;
            case 2:
                System.out.println("\tOdabrana opcija 2");
                fixSluice();
                break;
            case 3:
                System.out.println("\tOdabrana opcija 3");
                goToSaloon();
                break;
        }
    }

    private void goToSaloon(){
        
        int saloonCena = rnd.nextInt(50,201);
        int novaEndurance = rnd.nextInt(5,51);
        if (this.money >= saloonCena){
            this.money -= saloonCena;
            this.endurance += novaEndurance;
            
            if (this.endurance > 100){
                this.endurance = 100;
            }
            System.out.println("Igrac je otisao do grada i potrosio je: " + saloonCena + " $ -> preostalo je: " + this.money + " $");
            System.out.println("Igrac je dobio: " + novaEndurance + " % IZDRZLJIVOSTI -> trenutna IZDRZLJIVOST je: " + this.endurance + " %");
        } else{
            System.out.println("Igrac trenutno nema dovoljno novca za odlazak u grad!");
        }
    }

    private void fixSluice(){
        if (this.money >= 100){
            this.money -= 100;
        
            for(Tool t : tools){
                if (t instanceof Sluice){
                    Sluice tSluice = (Sluice) t;
                    tSluice.repair();
                }
            }
            System.out.println("LEVAK popravljen - preostalo je: " + this.money + " $");
        } else {
            System.out.println("Igrac trenutno nema dovoljno novca za popravak LEVKA!");
        }   
    }   
}


