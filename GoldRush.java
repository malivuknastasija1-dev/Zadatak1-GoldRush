/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.zadatak1;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.List;
import java.util.Scanner;

public class GoldRush{
    
    private FortyNiner fortyNiner;
    private File savedGame;
    private int brojNedelje = 1;

    
    public GoldRush(){
        this.fortyNiner = new FortyNiner();
        this.savedGame = new File("savedGame.txt");
    }

    public void survive(){
        
        if (fortyNiner.getTools().isEmpty()){
            fortyNiner.getTools().add(new Pan());
            fortyNiner.getTools().add(new Sluice());
        }
        
        for (int i = brojNedelje; i <= 20; i++){
            System.out.println("*** NEDELJA broj " + i + ". ***");
            if (fortyNiner.getEndurance() > 0){
                fortyNiner.useTools();
            }else{
                System.out.println("Igrac umoran - nema prihoda!");
            }
          
            fortyNiner.buyFood();
            fortyNiner.loseEndurance();
       
            int pokvareno = 0;
            List<Tool> alati = fortyNiner.getTools();
            for(int a = alati.size() - 1; a >= 0; a--){
                Tool t = alati.get(a);
                if(!(t instanceof Pan) && t.getDurability() <= 0){
                    if(t instanceof Cradle){
                        System.out.println("Pokvarena KOLEVKA je izbacena iz liste!");
                    }
                    alati.remove(a);
                    pokvareno++;
                }
            }
            
            if (pokvareno > 0){
                System.out.println("Izbacenih alata je " + pokvareno);
            }
            
            char odlukaPrekid = Utility.ocitajOdlukuOPotvrdi("da PREKINETE igru? - ");
            if (odlukaPrekid == 'Y'){
                System.out.println("Igra je prekinuta!");
                saveGame(i);
                return;
            }
            
            fortyNiner.isItSundayAgain();
            
            System.out.println("Koliko KOLEVKI zelite da kupite (cena 30 $)?");
            int brojCradle = Utility.ocitajCeoBroj();
            if (brojCradle > 0){
                int kolevkaCena = brojCradle * 30;
                if (kolevkaCena <= fortyNiner.getMoney()){
                    for (int c = 0; c < brojCradle; c++){
                        fortyNiner.getTools().add(new Cradle());
                    }
                    fortyNiner.setMoney(fortyNiner.getMoney() - kolevkaCena);
                    System.out.println("Igrac je kupio " + brojCradle + " i potrosio je: " + kolevkaCena + " $");
                }else {
                    System.out.println("Igrac trenutno nema dovoljno novca za kupovinu kolevki!");
                }
            }else if (brojCradle < 0){
                System.out.println("Ne mozete kupiti negativan broj kolevki!");
            } else{
                System.out.println("Igrac nije kupio kolevku!");
            }
        }
    }

    public void loadGame(){
        
        if (!savedGame.exists()){
            System.out.println("Nista nije sacuvano!");
            return;
        }
        
        Scanner fajlSc = null;
        
        try{
            Scanner sc = new Scanner(savedGame, "UTF-8");
            fortyNiner.getTools().clear();
            fortyNiner.getTools().add(new Pan());
            
            while (sc.hasNextLine()){
                String line = sc.nextLine();
                if (line.contains("Week no.")) {
                    String [] tokeni = line.split("\\.");
                    String broj = tokeni[1].trim(); 
                    this.brojNedelje = Integer.parseInt(broj) + 1; 
                }else if (line.contains("49er endurance:")){
                    String [] tokeni = line.split(":");
                    String broj = tokeni[1].trim();
                    broj = broj.replace("%", "");
                    fortyNiner.setEndurance(Integer.parseInt(broj));
                }else if (line.contains("49er money:")){
                    String [] tokeni = line.split(":");
                    String broj = tokeni[1].trim();
                    broj = broj.replace(" $", "");
                    fortyNiner.setMoney(Integer.parseInt(broj));
                }else if(line.contains("Sluice durability:")){
                    String [] tokeni = line.split(":");
                    String broj = tokeni[1].trim();
                    broj = broj.replace("%", "");
                    Sluice levak = new Sluice();
                    levak.setDurability(Integer.parseInt(broj));
                    fortyNiner.getTools().add(levak);
                }else if(line.contains("Cradle durability:")){
                    String [] tokeni = line.split(":");
                    String broj = tokeni[1].trim();
                    broj = broj.replace("%", "");
                    Cradle kolevka = new Cradle();
                    kolevka.setDurability(Integer.parseInt(broj));
                    fortyNiner.getTools().add(kolevka);
                }
                
            }
            System.out.println("Igra je ucitana iz fajla savedGame.txt!");
            System.out.println("Igra se nastavlja od " + this.brojNedelje + ". nedelje!");
        }catch (IOException problem){
            System.out.print("Greska - igra nije sacuvana!");
            System.out.println("Greska: " + problem.getMessage());
        }finally {
        if (fajlSc != null) {
            fajlSc.close();
        }
        }
    }
    
    private void saveGame(int trenNedelja){
        
        try{
            PrintWriter out = new PrintWriter(new OutputStreamWriter(new FileOutputStream(savedGame), "UTF8"));
            out.println("Week no. " + trenNedelja);
            out.println("49er endurance: " + fortyNiner.getEndurance() + "%");
            out.println("49er money: " + fortyNiner.getMoney() + " $");
            
            for(Tool t : fortyNiner.getTools()){
                if (t instanceof Sluice){
                    out.println("Sluice durability: " + t.getDurability()+ "%");
                } else if (t instanceof Cradle){
                    out.println("Cradle durability: " + t.getDurability()+ "%");
                }
            }
            out.close();
            System.out.println("Igra je sacuvana u fajlu savedGame.txt!");
        }catch (IOException problem){
            System.out.print("Greska - igra nije sacuvana!");
            System.out.println("Greska: " + problem.getMessage());
        }
        
    }
    
}

