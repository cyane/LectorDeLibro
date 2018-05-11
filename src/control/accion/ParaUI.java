package control.accion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;

import modelo.Libro;
import vista.UI;

public class ParaUI extends UI{
	private Libro librito;
	private MyActionListener listener;
	private File libro;
	
	public ParaUI() {
		super();
		this.librito= new Libro(this);
		this.listener = new MyActionListener(librito);
		for (JButton jButton : botones) {
			jButton.addActionListener(listener);
		}
		libro = new File(librito.getLectura());
		pintarTxt(0);

	}
	
	public boolean pintarTxt(int principio) {
		
		try {
			
			textArea.setText("");
			FileReader fileR = new FileReader(libro);
			BufferedReader bufferR = new BufferedReader(fileR);
			
			int lineas = 0;
			
			while( lineas<principio*15){
				lineas++;
				bufferR.readLine();
			}
			if (bufferR.readLine()==null) {
				bufferR.close();
				return false;
			}
			for (int i = 0; i < 15; i++) {
				textArea.setText(textArea.getText()+bufferR.readLine()+"\n");
			}

			
			
			fileR.close();
			bufferR.close();
		} catch (IOException e) {
			return false;
		}
		return true;
	}

}
