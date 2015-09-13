package netbeansgeneratornazw_txtareaonly;


import java.io.BufferedWriter;
//import java.io.File;
//import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
//import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.JTextArea;

public class Zapisywacz {

   // private JTextArea area;

    public Zapisywacz() {
       // this.area = area;
    }
    
    
    
	public void zapisz(Katalog kat, int zKtoregoPliku, Tablica a ) throws IOException{
     //   this.area=area;
	//			File plikDocelowy = kat.getFile();
		String nazwaPliku = kat.getTabPrzefiltrowanychPlikow()[zKtoregoPliku];
		
        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("yyMMdd-HHmmss");
        
        
        nazwaPliku = nazwaPliku.replace("baza.txt",
                "("+
                dateFormat.format(date)+
                        
                ")(" + a.getJakaMetoda() + ")-wynik.txt");
		
		Writer bufferedWriter = new BufferedWriter(new OutputStreamWriter(
				new FileOutputStream(nazwaPliku), "UTF8"));
		for (int i = 0; i < a.getNazwy().length; i++) {
			bufferedWriter.append(a.getNazwy()[i]).append("\r\n");
			
//			bufferedWriter.write(a.getNazwy()[i]);
//			bufferedWriter.write("\n");
		}
        System.out.println("Zapisane pod nazwa: " + nazwaPliku);

		bufferedWriter.close();
//		 
		
	}
}
