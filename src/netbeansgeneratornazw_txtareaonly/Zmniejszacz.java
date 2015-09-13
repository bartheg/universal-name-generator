package netbeansgeneratornazw_txtareaonly;




public class Zmniejszacz {

	public Tablica zmniejsz(Tablica a){ // TESTOWANE DZIALA
		Tablica tabZmniejszona = new Tablica(a.getNazwy().length);
		System.arraycopy(a.getNazwy(), 0, tabZmniejszona.getNazwy(), 0, tabZmniejszona.getNazwy().length);
		for (int i=0; i< tabZmniejszona.getNazwy().length; i++){
			tabZmniejszona.getNazwy()[i] = tabZmniejszona.getNazwy()[i].toLowerCase();
		}
		return tabZmniejszona; 
	}
	
	public Tablica zwieksz(Tablica a){ // TESTOWANE DZIALA
		Tablica tabZwiekszona = new Tablica(a.getNazwy().length);
		System.arraycopy(a.getNazwy(), 0, tabZwiekszona.getNazwy(), 0, tabZwiekszona.getNazwy().length);
		for (int i=0; i< tabZwiekszona.getNazwy().length; i++){
			tabZwiekszona.getNazwy()[i] = tabZwiekszona.getNazwy()[i].substring(0, 1).toUpperCase() + tabZwiekszona.getNazwy()[i].substring(1);
		}
        tabZwiekszona.setJakaMetoda(a.getJakaMetoda());
		return tabZwiekszona; 
	}
	
}
