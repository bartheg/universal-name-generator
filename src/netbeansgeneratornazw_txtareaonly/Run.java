package netbeansgeneratornazw_txtareaonly;

import java.io.IOException;
import javax.swing.text.BadLocationException;

/* KOMENTARZ DLA KLASY
To jest klasa glowna zawierajaca main. Nie ma tu byc zadnych luznych
zmiennych czy funkcji. Tylko obietkty.
Na poczatku wszystkie obiekty sa tworzone, pozniej sa uzywane.
Na razie sa tu luzne funkcje println.
*/


public class Run {

    
    
	public static void main(String[] args) throws IOException, BadLocationException
	{
		
        Okno okno = new Okno();
//        System.out.println(okno.toString());
        
	

        User user = new User(1, 1, 1, okno.getKonsola());
		Katalog katalog = new Katalog(".", "-baza.txt");
        
        Otwieracz otwieracz = new Otwieracz();
		Zmniejszacz zmniejszacz = new Zmniejszacz();
		Rozdzielacz rozdzielacz = new Rozdzielacz();
		Mieszacz mieszacz = new Mieszacz(rozdzielacz.getZNAKI(),rozdzielacz.getDL_ZNAKOW());
        Zapisywacz zapisywacz = new Zapisywacz();
        
        okno.getKonsola().append("OTWIERANIE\n");
		System.out.println("OTWIERANIE");
		user.setKtoryPlikChce(katalog);
		Tablica tablica = otwieracz.otworz(katalog, user.getKtoryPlikChce());
//		System.out.println("TABLICA OTWARTA:::");
//		tablica.wypluj();
        okno.getKonsola().append("\n");
		System.out.println();
		
        okno.getKonsola().append("ZMNIEJSZANIE\n");
		System.out.println("ZMNIEJSZANIE");
		Tablica tabZmniejszona = zmniejszacz.zmniejsz(tablica);
//		tabZmniejszona.wypluj();
        okno.getKonsola().append("\n");
        System.out.println();
		
        okno.getKonsola().append("ROZDZIELANIE\n");
		System.out.println("ROZDZIELANIE");
		user.setJakaMetodeChce();
		Tablica tabRozdzielona = rozdzielacz.rozdziel(tabZmniejszona, user.getJakaMetodeChce());
//		tabRozdzielona.wypluj();
        okno.getKonsola().append("\n");
        System.out.println();
        
        okno.getKonsola().append("MIESZANIE\n");
        System.out.println("MIESZANIE");
        user.setIleNazwChce(tabRozdzielona);
		Tablica tabNoweNazwy = mieszacz.mieszaj(rozdzielacz.getZNAKI(), rozdzielacz.getDL_ZNAKOW(), tabRozdzielona, user.getIleNazwChce(), 1);
//      tabNoweNazwy.wypluj();
        okno.getKonsola().append("\n");
        System.out.println();

        okno.getKonsola().append("ZWIEKSZANIE\n");
		System.out.println("ZWIEKSZANIE");
		Tablica tabZwiekszona = zmniejszacz.zwieksz(tabNoweNazwy);
//		tabZwiekszona.wypluj();
        okno.getKonsola().append("\n");
        System.out.println();
        
        okno.getKonsola().append("ZAPIS DO PLIKU\n");
        System.out.println("ZAPIS DO PLIKU");
 		zapisywacz.zapisz(katalog, user.getKtoryPlikChce(), tabZwiekszona);       
	
	}
}
