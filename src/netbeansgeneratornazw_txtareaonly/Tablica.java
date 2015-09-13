package netbeansgeneratornazw_txtareaonly;

import javax.swing.JTextArea;



public class Tablica {
	private String nazwy[];
	private String jakaMetoda;

    
    
//    public Tablica(JTextArea area) {
//        this.area = area;
//    }
    
    
    
    
    public String getJakaMetoda(){
        return this.jakaMetoda;
    }
    
    public void setJakaMetoda(String a){
        this.jakaMetoda=a;
    }
    
	public String[] getNazwy(){	//TESTOWANE DZIALA
		return nazwy;
	}
	
	public Tablica(int a){ //TESTOWANE DZIALA
		nazwy = new String[a];
	}
	
	public void wypluj(){ // TESTOWANE DZIALA (TO JEST METODA TYLKO DLA TESTOW PROGRAMU)
		for (int i=0; i<this.nazwy.length; i++){
            
            System.out.println(i + "\t" + nazwy[i]);
		}
	}
}
