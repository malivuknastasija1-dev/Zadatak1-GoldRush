/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.zadatak1;

import java.io.File;

public class GoldRush{
    
    private FortyNiner fortyNiner;
    private File savedGame;
    
    public GoldRush(){}
    
//u njoj se instancira objekat klase FortyNiner ukoliko nije prethodno instanciran 
//kao rezultat nastavljene igre, nakon čega se u petlji simulira 20 sedmica njegovog života tokom 
//Zlatne groznice (ili manje ako je igra nastavljena). Na kraju svake sedmice najpre se pozivaju 
//redom metode FortyNiner.useTools(), FortyNiner.buyFood() i FortyNiner.loseEndurance(), nakon 
//čega se igraču nudi opcija da prekine igru. Ako odgovori potvrdno, trenutno stanje se čuva u 
//tekstualnoj datoteci. Ako, ipak, igrač odabere da nastavi igru, ili nakon što je nastavio prethodno 
//prekinutu igru, pošto nova sedmica počinje nedeljom, nudi mu se izbor šta želi da radi tog dana 
//(itIsSundayAgain()). Na kraju se igraču nudi izbor da li i koliko Kolevki želi da kupi te sedmice - 
//svaka kupljena Kolevka dodaje se na listu tools objekta fortyNiner klase FortyNiner, a tokom igre, 
//one koje se pokvare, uklanjaju se iz liste jer su svakako neupotrebljive
//    public survive();
    
    
//ako postoji datoteka savedGame, učitava podatke iz nje i nastavlja igru od 
//mesta gde je prethodno bila prekinuta. Poziva se iz klase Play pre poziva metode survive(), ako je 
//bilo prethodno sačuvanih podataka učitava ih i instancira objekat klase FortyNiner na osnovu 
//pročitanih podataka iz datoteke
//    public loadGame();
    
    
//omogućava igraču da na kraju svake sedmice zapamti trenutno stanje u igri 
//u datoteci savedGame
//    public saveGame();
    
}
