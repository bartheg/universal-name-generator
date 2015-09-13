package netbeansgeneratornazw_txtareaonly;


import java.io.IOException;
import java.util.Scanner;
import javax.swing.JTextArea;
import javax.swing.text.BadLocationException;

public class User {
	private int ileNazwChce;
	private int jakaMetodeChce;
	private int ktoryPlikChce;
	private Scanner scanner;
    private JTextArea konsola;
    
	public int getIleNazwChce() {
		return ileNazwChce;
	}
	public int getJakaMetodeChce() {
		return jakaMetodeChce;
	}
	public int getKtoryPlikChce() {
		return ktoryPlikChce;
	}

// KONSTRUKTOR
	public User(int ileNazwChce, int jakaMetodeChce, int ktoryPlikChce, JTextArea k){
        this.konsola=k;
		this.ileNazwChce = ileNazwChce;
		this.jakaMetodeChce = jakaMetodeChce;
		this.ktoryPlikChce = ktoryPlikChce;
		this.scanner = new Scanner(System.in);
	}
	
	public void setKtoryPlikChce(Katalog a) throws IOException, BadLocationException { //TESTOWANE DZIALA
		for (int wiersz = 0; wiersz < a.getTabPrzefiltrowanychPlikow().length; wiersz++){
            konsola.append((int)(wiersz+1) + " " + a.getTabPrzefiltrowanychPlikow()[wiersz]);
			System.out.print((int)(wiersz+1) + " " + a.getTabPrzefiltrowanychPlikow()[wiersz]);
            konsola.append("\n");
            System.out.println();
		}
        konsola.append("Ktory plik? Wymierz numer... \n");
		System.out.println("Ktory plik? Wymierz numer... ");
		this.ktoryPlikChce = scanner.nextInt();
        
		this.ktoryPlikChce--;
        konsola.append("\nWybrales numer " + (int)(ktoryPlikChce+1) +
					" czyli " + a.getTabPrzefiltrowanychPlikow()[ktoryPlikChce] +
					" o rzeczywistym indeksie "
					+ "" + this.ktoryPlikChce + "\n");        
		System.out.println("\nWybrales numer " + (int)(ktoryPlikChce+1) +
					" czyli " + a.getTabPrzefiltrowanychPlikow()[ktoryPlikChce] +
					" o rzeczywistym indeksie "
					+ "" + this.ktoryPlikChce);
	}
	
	public void setIleNazwChce(Tablica a) throws IOException {
		konsola.append("Ile nazw zrobic? Podaj liczbe wieksza od zera. Dla tego pliku nie zaleca"
                + " sie podawac liczby wiekszej niz " + (a.getNazwy().length)*(a.getNazwy().length)/2 +"\n");

        System.out.println("Ile nazw zrobic? Podaj liczbe wieksza od zera. Dla tego pliku nie zaleca"
                + " sie podawac liczby wiekszej niz " + (a.getNazwy().length)*(a.getNazwy().length)/2    );
		this.ileNazwChce = scanner.nextInt();
	}
	
	public void setJakaMetodeChce() throws IOException {
        konsola.append("Jaka metoda podzialu? Oto mozliwosci:\n");
		konsola.append("1 - \"-samogloska\", dzielenie przed samogloska.\n");
		konsola.append("2 - \"samogloska-\", dzielenie po samoglosce.\n");
		konsola.append("3 - \"-samogloska-\", dzielenie przed i po samoglosce.\n");
        konsola.append("4 - \"litera-\", dzielenie po kazdej literze.\n"); 
        konsola.append("5 - \" -\", dzielenie po kazdej spacji.\n"); 
        
		System.out.println("Jaka metoda podzialu? Oto mozliwosci:");
		System.out.println("1 - \"-samogloska\", dzielenie przed samogloska.");
		System.out.println("2 - \"samogloska-\", dzielenie po samoglosce.");
		System.out.println("3 - \"-samogloska-\", dzielenie przed i po samoglosce.");
        System.out.println("4 - \"litera-\", dzielenie po kazdej literze."); 
        System.out.println("5 - \" -\", dzielenie po kazdej spacji."); 
        String coWpisal;
        do{
            coWpisal = scanner.nextLine();
        }while(!(coWpisal.matches("[1-5]")));
        
        this.jakaMetodeChce=Integer.parseInt(coWpisal);
        konsola.append("Wybrales metode " + coWpisal+"\n");
        System.out.println("Wybrales metode " + coWpisal);
    }
}
