package netbeansgeneratornazw_txtareaonly;



import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import javax.swing.JTextArea;

public class Otwieracz {
	
    int ileLinii;
    private JTextArea area;
    
    
    public void Otwieracz( JTextArea a ){
        this.area=a;
        this.ileLinii=0;
    }
    
	public Tablica otworz(Katalog a, int ktoryPlikChce) throws IOException{
		System.out.println("Trzeba otworzyc plik " + a.getTabPrzefiltrowanychPlikow()[ktoryPlikChce]);
		
                BufferedReader bufferedReader = new BufferedReader(
					new InputStreamReader(new FileInputStream(a.getTabPrzefiltrowanychPlikow()[ktoryPlikChce]), "UTF8"));
                
                RandomAccessFile raf = new RandomAccessFile(a.getTabPrzefiltrowanychPlikow()[ktoryPlikChce], "r");

// trzeba policzyc linie
// bufferedReader.readLine()			
		while (true){
			String s = raf.readLine();
			if (s==null){
				break;
			}else{
				this.ileLinii++;
			}
		}
		System.out.println("UWAGA, bufferedReader czytal plik: " + a.getTabPrzefiltrowanychPlikow()[ktoryPlikChce] +
				" i policzyl, ze jest " + this.ileLinii + " linii.");


		Tablica tablica = new Tablica(ileLinii);		
		
//		raf.seek(0);
		for (int i=0; i<ileLinii; i++){
			tablica.getNazwy()[i] = bufferedReader.readLine();
		}
		// usuwanie chujowego znaku
		tablica.getNazwy()[0]=tablica.getNazwy()[0].replace("\uFEFF", ""); 
		
		bufferedReader.close();
		raf.close();
		return tablica;
	}
}
