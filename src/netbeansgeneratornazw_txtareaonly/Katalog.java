package netbeansgeneratornazw_txtareaonly;


import java.io.File;
import javax.swing.JTextArea;

public class Katalog {
//	private String tabWszystkichPlikow[][];
	private String tabPrzefiltrowanychPlikow[];
//	final int SZER_TAB = 3;
	private File katalogBiezacy;
    //private JTextArea area;
    
	public File getFile(){
		return this.katalogBiezacy;
	}
	
	public Katalog(String sciezka, String rozszerzenie ){ // TESTOWANY, DZIALA
       // this.area=a;
		this.katalogBiezacy = new File(sciezka);
		int ilePlikow=0;
		for (int i=0; i<this.katalogBiezacy.listFiles().length; i++){
			if (this.katalogBiezacy.listFiles()[i].getPath().endsWith(rozszerzenie)){
				ilePlikow++;
			}
		}	
		this.tabPrzefiltrowanychPlikow = new String[ilePlikow];
		for(int i=0, j=0; i<this.katalogBiezacy.listFiles().length; i++){
			if (this.katalogBiezacy.listFiles()[i].getPath().endsWith(rozszerzenie)){
				tabPrzefiltrowanychPlikow[j] = this.katalogBiezacy.listFiles()[i].getPath();
  
	//test		System.out.println(tabPrzefiltrowanychPlikow[j]);
				j++;
			}
		}
	}

	public String[] getTabPrzefiltrowanychPlikow(){ //dla Usera
		return tabPrzefiltrowanychPlikow;
	}
	
	public String[][] wypisz(String a){
		String tablicaDoWypisania[][];
		tablicaDoWypisania = new String[1][1];
		return tablicaDoWypisania;
	}
	
	
	
//		private String wpiszWKomorke(int kolumna){
//		if (kolumna==0){
//			if ()
//		}
//			String string = "a";
//		return string;
//	}
	
}
