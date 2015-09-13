package netbeansgeneratornazw_txtareaonly;

// Serce generatora

import java.util.Arrays;
import java.util.Random;

// pobiera:
// String oznaczajacy podzial - ze stalej
// ilosc nazw do wygenerowania - od usera
// Tablice - ta rozdzielona od maina
// oddaje:
// Tablice (nie usuwa znakow podzialu ani nie zwieksza pierwszej litery, tym zajmuja sie inne klasy

public class Mieszacz {

    private Random random;
    private final String ZNAKI;
    private final int DL_ZNAKOW;
    
    public Mieszacz(String znaki, int dlZnakow){
        random = new Random();
        this.ZNAKI = znaki;
        this.DL_ZNAKOW = dlZnakow;
    }
    
    /* NIEPOTRZEBNE
    private int liczZnaki(String a, String znaki){
        int ile = 0;
        int i = 0;
        while ((i = a.indexOf(znaki, i)) != -1){
            i++;
            ile++;
        }
        return ile;
    }
    */
    private int losuj(int zakres, int metoda){
        int los1, los2, los3;
        switch (metoda){
            case 0: return random.nextInt(zakres);
            case 1: los1 = random.nextInt(zakres);
                    los2 = random.nextInt(zakres);
                    if (los1<los2){
                        return los1;
                    }else{
                        return los2;
                    }
            case 2: los1 = random.nextInt(zakres);
                    los2 = random.nextInt(zakres);
                    los3 = random.nextInt(zakres);
                         
                    
                    if (((los1<=los2)&&(los2<=los3))||((los1>=los2)&&(los2>=los3))){
                        return los2;
                    }
                    if (((los2<=los1)&&(los1<=los3))||((los2>=los1)&&(los1>=los3))){
                        return los1;
                    }
                    if (((los1<=los3)&&(los3<=los2))||((los1>=los3)&&(los3>=los2))){
                        return los3;
                    }
                    
            default: return 99;
        }
     //   return 9999;
    }

    
    
    private String wytnijPoczatek(String string, int metoda){
        String[] pociete = string.split(ZNAKI);
        int doIndeksu = losuj((pociete.length), metoda);
        String wyciety = "";
        for (int i =0; i<=doIndeksu; i++){
            wyciety+=pociete[i];
        }
   //test.okno.textArea.append(wyciety + " + ");
        System.out.print(wyciety + " + "); // testowanie
        return wyciety;
    }
    
    private String wytnijSrodek(String string, int metoda){
        String[] pociete = string.split(ZNAKI);
        int indeks1 = losuj((pociete.length), 2);
        int indeks2 = losuj((pociete.length), 2);
        String wyciety ="";
        if (indeks1==indeks2){
            wyciety+=pociete[indeks1];
            System.out.print(wyciety); // testowanie
            return wyciety;
        }
        if (indeks1<indeks2){
            wyciety+=pociete[indeks1];
            wyciety+=pociete[indeks2];
            System.out.print(wyciety); // testowanie            
            return wyciety;
        }
        if (indeks1>indeks2){
            wyciety+=pociete[indeks2];
            wyciety+=pociete[indeks1];
            System.out.print(wyciety); // testowanie            
            return wyciety;
        }
        return "BŁĄDWLOSUJŚRODEK";
    }
    
    private String wytnijKoniec(String string, int metoda){
        String[] pociete = string.split(ZNAKI);
        int odIndeksu = pociete.length - losuj((pociete.length), metoda) -1;
        String wyciety = "";
        for (int i=odIndeksu; i<pociete.length; i++){
            wyciety+=pociete[i];
        }
        System.out.println(" + " + wyciety); // testowanie
        return wyciety;
    }
    
    private boolean czyByloWBazie(String string, Tablica a){
        for (int i=0; i<a.getNazwy().length; i++){
            if (a.getNazwy()[i].replaceAll(ZNAKI, "").equals(string)){
                System.out.println(string + " To samo co w bazie! "); // testowanie
                return true;
            }
        }
        return false;
    }

    
    private boolean czyByloWyzej(Tablica a, int ostIndex){
        if (ostIndex==0){
            return false;
        }else{
            for (int i=0; i<ostIndex;i++){
                if (a.getNazwy()[ostIndex].equals(a.getNazwy()[i])){
                    System.out.println(a.getNazwy()[i] + " Juz bylo wyzej! "); // testowanie
                    return true;
                }
            }
            return false;
        }
    }
    
    public Tablica mieszaj(String znakiPodzialu, int dlugoscPodzialu, Tablica a, int ileNazwChce, int metodaWycinania){
        Tablica tabNoweNazwy = new Tablica(ileNazwChce);
        Arrays.fill(tabNoweNazwy.getNazwy(), "");
  //      String tempString = "123456789_123456789_123456789_123456789_";
        int wylosowany = 0;
        String kawalek = "";
        
        for (int i = 0; i< ileNazwChce; ){
            wylosowany = random.nextInt(a.getNazwy().length);
            kawalek = wytnijPoczatek(a.getNazwy()[wylosowany], metodaWycinania);
            tabNoweNazwy.getNazwy()[i] = kawalek;
            
            wylosowany = random.nextInt(a.getNazwy().length);
            kawalek = wytnijSrodek(a.getNazwy()[wylosowany], metodaWycinania);
            tabNoweNazwy.getNazwy()[i] += kawalek;
            
            wylosowany = random.nextInt(a.getNazwy().length);
            kawalek = wytnijKoniec(a.getNazwy()[wylosowany], metodaWycinania);
            tabNoweNazwy.getNazwy()[i] += kawalek;
            
            // sprawdzenie czy nowa nazwa nie powtarza sie z jakas nazwa wyzej
            // nie ma sensu sprawdzać dla pierwszego indeksu
            if ((czyByloWyzej(tabNoweNazwy, i)) || czyByloWBazie(tabNoweNazwy.getNazwy()[i], a)){
                //tabNoweNazwy.getNazwy()[i] = "";
//              continue;
            }else{
                
                i++;
            }    
        }
        tabNoweNazwy.setJakaMetoda(a.getJakaMetoda());
        return tabNoweNazwy;
    }
}



/*
najpierw mozna zrobic tablice tabNoweNazwy, bo jest podana wielkosc (ile zrobic nazw



*/