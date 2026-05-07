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
////koristi atribut tools, svaki pojedinačno, tako što poziva metodu useTool() na 
////svakom od alata (prepoznajte ovde polimorfizam). Obratite pažnju da svaka metoda useTool() 
////vraća količinu novca koji je zarađen njegovim korišćenjem, a smanjuje mu kapacitet (durability) 
////uvek na drugačiji način u zavisnosti od alata o kojem se radi (kod Sita se ne smanjuje, kod Levka 
////20%-50% svake sedmice, kod Kolevke odmah na 0% sa verovatnoćom 20%). Poziva se na kraju 
////svake sedmice
    public void useTools(){
        if (endurance <= 0){
            System.out.println("IGRAC je umoran - nema prihoda!");
            return;
        }
            
        int ukupnaSedmicnaZarada = 0;
        for (Tool t : tools){
            ukupnaSedmicnaZarada += t.useTool();
        }
            
        this.money += ukupnaSedmicnaZarada;
        System.out.println("Ukupna sedmicna zarada iznosi: " + ukupnaSedmicnaZarada + " $");
    }

////poziva se na kraju svake sedmice, kao rezultat smanjuje 
////količinu raspoloživog novca koji 49er poseduje
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

////poziva se na kraju svake sedmice, kao rezultat 
////smanjuje izdržljivost (endurance) 49er-a
    public void loseEndurance(){
        
        int endurancePad = rnd.nextInt(26); // endurance opada 10 % do 25 % sedmicno, koristim random
        if (endurancePad < 10){
            endurancePad = 10;
        }
        
        System.out.println("Igracu je opala IZDRZLJIVOST ove nedelje za: " + endurancePad + " %");

        int trenEndurance = getEndurance();
        int noviEndurance = trenEndurance - endurancePad;
        
        if (noviEndurance < 0){
            noviEndurance = 0;
        }
        
        setEndurance(noviEndurance);
        
        System.out.println("Trenutna IZDRZLJIVOST je: " + getEndurance() + " %");
    }
    
//// STA IGRAC RADI NEDELJOM //

//// ponudi izbor 49er-u šta raditi u nedelju u skladu sa opisom iznad: ništa, popraviti Levak ili ići u grad
    public void isItSundayAgain(){
        System.out.println("NEDELJA - Sta igrac zeli da radi?");
        System.out.println("\tOpcija broj 1 - Odmarati");
        System.out.println("\tOpcija broj 2 - Popravljati Levak (cena 100 $)");
        System.out.println("\tOpcija broj 3 - Otici do grada (cena 50-200 $)");
	System.out.print("\tOdaberite opciju: ");
        
        int izbor = Utility.ocitajCeoBroj();
        
        if(izbor == 2){
            System.out.println("\tOdabrana opcija 2");
            fixSluice();
        } else if(izbor == 3){
            System.out.println("\tOdabrana opcija 3");
            goToSaloon();
        } else{
            System.out.println("\tOdabrana opcija 1");
            System.out.println("Igrac se danas odmara!");
        }
    }
//    
//// kao rezultat smanjuje količinu raspoloživog novca, ali povećava izdržljivost 
////(endurance) 49er-a. Pozvana je ukoliko igrač prilikom poziva metode itIsSundayAgain() odabere opciju da pođe u grad
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
//    
////kao rezultat povećava kapacitet Levka na 100% ali smanjuje iznos raspoloživog 
////novca 49er-a za $100. Pozvana je ukoliko igrač prilikom poziva metode itIsSundayAgain() odabere 
////opciju da nedelju provede opravljajući Levak
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

