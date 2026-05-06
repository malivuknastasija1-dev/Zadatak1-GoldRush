/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.zadatak1;

import java.util.Random;

public abstract class Tool {
    
    private int durability; //kapacitet alata
    protected Random rnd; //slučajno generisane brojeve potrebne za objekte klase Tool, vide ga klase naslednice
    
    public Tool(int durability){      //ovde definisem konstruktor sa jednim parametrom i pravim objekat rnd
            this.durability = durability;
            this.rnd = new Random();
    }
    
    public int getDurability(){
            return durability; //omogućava da se dobije informacija koliki je trenutni kapacitet alata
    }
    
    public void setDurability(int durability){
            if (durability < 0){
                this.durability = 0; //provera da ne bude manji od 0
            } else {
                this.durability = durability; //da setujem durability kod metode repair() u klasi Sluice
            }
    }
    
    abstract public int useTool(); //ova metoda se override-uje u naslednicama za svaki alat
}
