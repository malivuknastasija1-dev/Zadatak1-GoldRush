-------------------------------------------------------------------------------------------------------------------------------------------------
5.5.2026. 
Kreirane sve potrebne klase koje bi posluzile kao kostur tokom izrade zadatka. 
Za pocetak su sredjene **apstraktna klasa Tool**, kao i njene **klase naslednice Pan, Cradle i Sluice**.
Naredni korak je osmisljavanje logike za klasu FortyNiner.

* AI alat je koriscen za proveru funkcionalnosti pojedinih linija koda, zbog same Java sintakse.
* Kod je napisan u skladu sa primerima sa vezbi i predavanja. :)

-------------------------------------------------------------------------------------------------------------------------------------------------
6.5.2026.
Kreirani atributi, getter-i i setter-i i metode u **klasi FortyNiner**, ostvaren polimorfizam u **metodi useTools()** sa for-each petljom.

-------------------------------------------------------------------------------------------------------------------------------------------------
7.5.2026.
Kreirane preostale metode u **klasi FortyNiner**, napravljena logika u **metodama itIsSundayAgain(), gotToSaloon() i fixSluice()**, kao i uvezivanje klase Utility (sa vezbi) radi lakseg rukovanja podacima.

* AI alat je koriscen za proveru funkcionalnosti pojedinih linija koda, zbog same Java sintakse.
* Kod je napisan u skladu sa primerima sa vezbi i predavanja. :)

-------------------------------------------------------------------------------------------------------------------------------------------------
8.5.2026.
Doradjene **klase FortyNiner, GoldRush i Zadatak1 (Play)**.

* AI alat je koriscen za proveru funkcionalnosti pojedinih linija koda, zbog same Java sintakse.
* Kod je napisan u skladu sa primerima sa vezbi i predavanja. :)

-------------------------------------------------------------------------------------------------------------------------------------------------
**REDOSLED .java FAJLOVA I NJIHOV KRATAK OPIS**
**Apstraktna klasa Tool** - u njoj se definise kapaciteta alata (durability) i sluzi kao roditeljska klasa svim klasama koje se ticu alata (Pan, Sluice, Cradle).
**Klasa Pan (sito)** - predstavlja klasu naslednicu klase Tool, daje sedmicnu zaradu, ne trosi se (durability je 100%).
**Klasa Cradle (kolevka)** - predstavlja klasu naslednicu klase Tool, daje sedmicnu zaradu, ali verovatnocom od 20% moze da dodje do toga da je alat neupotrebljiv (durability je 0%).
**Klasa Sluice (levak)** - predstavlja klasu naslednicu klase Tool, daje sedmicnu zaradu, ali dolazi do smanjenja kapciteta (durability) za 20-50% prilikom svakog koriscenja.
**Klasa Utility** - sluzi za rad sa korisnickim unosom preko konzole.
**Klasa FortyNiner** - predstavlja igraca (49-era) i sadrzi atribute poput izdrzljivosti (endurance), novca (money) i alata (ArrayList<Tool> tools). U okviru ove klase javljaju se razlicite metode koje uticu na kolicinu raspolozivog novca, kapacitet alata, izdrzljivost samog igraca, itd. Dok u metodi useTools() je prisutan i polimorfizam.
**Klasa GoldRush** - predstavlja centar igrice, jer se u njoj instancira igrac i upravlja se cuvanjem i ucitavanjem podataka iz .txt fajla. U metodi survive() se nalazi glavna petlja koja prolazi kroz svih 20 nedelja zivota jednog igraca.
**Klasa Zadatak1 (main)** - mesto gde se pokrece izvrsavanje programa, tako sto se instancira objekat klase GoldRush(), pa se poziva metoda loadGame() (ako igrac zeli da nastavi igru od proslog puta), i nakon toga se poziva survive() - metoda u kojoj se sve odvija.

Pokretanjem klase Zadatak1 dobija se ispis *** GAME: GOLD RUSH ***.
