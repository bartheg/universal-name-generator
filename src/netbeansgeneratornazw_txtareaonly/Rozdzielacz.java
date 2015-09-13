package netbeansgeneratornazw_txtareaonly;

import javax.swing.JTextArea;




public class Rozdzielacz {

	private final String ZNAKI = "=";
	private final int DL_ZNAKOW = 1;
//	private JTextArea area;

    public Rozdzielacz() {
   //     this.area = area;
    }
    
    
    
    
	public String getZNAKI(){
        return this.ZNAKI;
    }
    public int getDL_ZNAKOW(){
        return this.DL_ZNAKOW;
    }
    
    
    
    
    
	public Tablica rozdziel(Tablica a, int metoda){ // TESTOWANE DZIALA
		Tablica tabRozdzielona = new Tablica(a.getNazwy().length);
		System.arraycopy(a.getNazwy(), 0, tabRozdzielona.getNazwy(), 0, tabRozdzielona.getNazwy().length);
		switch (metoda){
		case 1:
            tabRozdzielona.setJakaMetoda("-a");
			System.out.println("Zamierzasz uzyc sposobu " + tabRozdzielona.getJakaMetoda());
			for (int i = 0; i < tabRozdzielona.getNazwy().length; i++) {
				tabRozdzielona.getNazwy()[i] = tabRozdzielona.getNazwy()[i].replace("a", ZNAKI+"a");
				tabRozdzielona.getNazwy()[i] = tabRozdzielona.getNazwy()[i].replace("o", ZNAKI+"o");
				tabRozdzielona.getNazwy()[i] = tabRozdzielona.getNazwy()[i].replace("e", ZNAKI+"e");
				tabRozdzielona.getNazwy()[i] = tabRozdzielona.getNazwy()[i].replace("i", ZNAKI+"i");
				tabRozdzielona.getNazwy()[i] = tabRozdzielona.getNazwy()[i].replace("y", ZNAKI+"y");
				tabRozdzielona.getNazwy()[i] = tabRozdzielona.getNazwy()[i].replace("u", ZNAKI+"u");
				if (tabRozdzielona.getNazwy()[i].startsWith(ZNAKI)){
					tabRozdzielona.getNazwy()[i]=tabRozdzielona.getNazwy()[i].substring(DL_ZNAKOW, tabRozdzielona.getNazwy()[i].length());
				}
			}
			break;
		case 2:
            tabRozdzielona.setJakaMetoda("a-");
			System.out.println("Zamierzasz uzyc sposobu " + tabRozdzielona.getJakaMetoda());
            for (int i = 0; i < tabRozdzielona.getNazwy().length; i++) {
				tabRozdzielona.getNazwy()[i] = tabRozdzielona.getNazwy()[i].replace("a", "a"+ZNAKI);
				tabRozdzielona.getNazwy()[i] = tabRozdzielona.getNazwy()[i].replace("o", "o"+ZNAKI);
				tabRozdzielona.getNazwy()[i] = tabRozdzielona.getNazwy()[i].replace("e", "e"+ZNAKI);
				tabRozdzielona.getNazwy()[i] = tabRozdzielona.getNazwy()[i].replace("i", "i"+ZNAKI);
				tabRozdzielona.getNazwy()[i] = tabRozdzielona.getNazwy()[i].replace("y", "y"+ZNAKI);
				tabRozdzielona.getNazwy()[i] = tabRozdzielona.getNazwy()[i].replace("u", "u"+ZNAKI);
				if (tabRozdzielona.getNazwy()[i].endsWith(ZNAKI)){
					tabRozdzielona.getNazwy()[i]=tabRozdzielona.getNazwy()[i].substring(0, tabRozdzielona.getNazwy()[i].length() - DL_ZNAKOW);
				}
			}
			break;
		case 3:
			tabRozdzielona.setJakaMetoda("-a-");
			System.out.println("Zamierzasz uzyc sposobu " + tabRozdzielona.getJakaMetoda());
			for (int i = 0; i < tabRozdzielona.getNazwy().length; i++) {
				tabRozdzielona.getNazwy()[i] = tabRozdzielona.getNazwy()[i].replace("a", ZNAKI+"a"+ZNAKI);
				tabRozdzielona.getNazwy()[i] = tabRozdzielona.getNazwy()[i].replace("o", ZNAKI+"o"+ZNAKI);
				tabRozdzielona.getNazwy()[i] = tabRozdzielona.getNazwy()[i].replace("e", ZNAKI+"e"+ZNAKI);
				tabRozdzielona.getNazwy()[i] = tabRozdzielona.getNazwy()[i].replace("i", ZNAKI+"i"+ZNAKI);
				tabRozdzielona.getNazwy()[i] = tabRozdzielona.getNazwy()[i].replace("y", ZNAKI+"y"+ZNAKI);
				tabRozdzielona.getNazwy()[i] = tabRozdzielona.getNazwy()[i].replace("u", ZNAKI+"u"+ZNAKI);
				if (tabRozdzielona.getNazwy()[i].startsWith(ZNAKI)){
					tabRozdzielona.getNazwy()[i]=tabRozdzielona.getNazwy()[i].substring(DL_ZNAKOW, tabRozdzielona.getNazwy()[i].length());
				}
                if (tabRozdzielona.getNazwy()[i].endsWith(ZNAKI)){
					tabRozdzielona.getNazwy()[i]=tabRozdzielona.getNazwy()[i].substring(0, tabRozdzielona.getNazwy()[i].length() - DL_ZNAKOW);
				}
			}
			break;
		case 4:
			tabRozdzielona.setJakaMetoda("x-");
			System.out.println("Zamierzasz uzyc sposobu " + tabRozdzielona.getJakaMetoda());
			for (int i = 0; i < tabRozdzielona.getNazwy().length; i++) {
				tabRozdzielona.getNazwy()[i] = tabRozdzielona.getNazwy()[i].replaceAll("\\B", ZNAKI);
                if (tabRozdzielona.getNazwy()[i].endsWith(ZNAKI)){
					tabRozdzielona.getNazwy()[i]=tabRozdzielona.getNazwy()[i].substring(0, tabRozdzielona.getNazwy()[i].length() - DL_ZNAKOW);
				}
			}
			break;
		case 5:
			tabRozdzielona.setJakaMetoda(" -");
			System.out.println("Zamierzasz uzyc sposobu " + tabRozdzielona.getJakaMetoda());
			for (int i = 0; i < tabRozdzielona.getNazwy().length; i++) {
				tabRozdzielona.getNazwy()[i] = tabRozdzielona.getNazwy()[i].replace(" ", " "+ZNAKI);
                if (tabRozdzielona.getNazwy()[i].endsWith(ZNAKI)){
					tabRozdzielona.getNazwy()[i]=tabRozdzielona.getNazwy()[i].substring(0, tabRozdzielona.getNazwy()[i].length() - DL_ZNAKOW);
				}
			}
			break;
        default:
			System.out.println("Zla liczba.");
		}
		return tabRozdzielona; 
	}
	
	public Tablica zlep(Tablica a){ // TESTOWANE DZIALA
		Tablica tabZlepiona = new Tablica(a.getNazwy().length);
		System.arraycopy(a.getNazwy(), 0, tabZlepiona.getNazwy(), 0, tabZlepiona.getNazwy().length);
		System.out.println("Zlepiam.");
		for (int i = 0; i < tabZlepiona.getNazwy().length; i++) {
			tabZlepiona.getNazwy()[i] = tabZlepiona.getNazwy()[i].replace(ZNAKI, "");
			tabZlepiona.getNazwy()[i] = tabZlepiona.getNazwy()[i].replace(ZNAKI, "");
			tabZlepiona.getNazwy()[i] = tabZlepiona.getNazwy()[i].replace(ZNAKI, "");
			tabZlepiona.getNazwy()[i] = tabZlepiona.getNazwy()[i].replace(ZNAKI, "");
			tabZlepiona.getNazwy()[i] = tabZlepiona.getNazwy()[i].replace(ZNAKI, "");
			tabZlepiona.getNazwy()[i] = tabZlepiona.getNazwy()[i].replace(ZNAKI, "");
		}
		return tabZlepiona;
	}
}
	