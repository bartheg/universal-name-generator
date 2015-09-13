
package netbeansgeneratornazw_txtareaonly;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.text.DefaultCaret;




public class Okno extends JFrame {
 
// POLA    
    private JTextArea konsola;

// AKCESORY    
    public JTextArea getKonsola(){  // referencja do konsoli
        return this.konsola;
    }
    

// KONSTRUKTOR
    public Okno(){
        
        // ustawienia okna
        //setLayout(null);
        setTitle("Uniwersalny Generator Imion i Nazw");
        setLocation(370, 80);
        setSize(510, 580);
        setResizable(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
               
        
        // ustawienia textArea
        konsola = new JTextArea();
        DefaultCaret caret = (DefaultCaret)konsola.getCaret();
        caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE); 
        JScrollPane scrollPane = new JScrollPane(konsola);
        //scrollPane.setBounds(5, 5, 295, 545);
        add(scrollPane);
        scrollPane.setVisible(true);
        
         setVisible(false);
    }
    
    
    
    
}
    