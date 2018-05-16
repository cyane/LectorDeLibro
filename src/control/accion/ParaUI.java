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

public class ParaUI extends UI {
	private Libro librito;
	private MyActionListener listener;
	private File libro;
	private int longitudPagina = 700;

	public ParaUI() {
		super();
		txtRuta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				preparar();
			}
		});
	}

	public void preparar() {//seria privado esta public para el test
		librito = new Libro(this, txtRuta.getText());
		libro = new File(librito.getLectura());
		pintarTxt(0);
		this.listener = new MyActionListener(librito);
		for (JButton jButton : botones) {
			jButton.addActionListener(listener);
			jButton.setEnabled(true);
		}
	}

	public boolean pintarTxt(int principio) {
		try {

			textArea.setText("");
			FileReader fileR = new FileReader(libro);
			BufferedReader bufferR = new BufferedReader(fileR);

			int pasadas = 0;

			while (pasadas < principio * longitudPagina) {
				pasadas++;
				bufferR.read();
			}
			for (int i = 0; i < longitudPagina; i++) {
				int read = bufferR.read();
				char letra = 0;
				if (read == 111) {
					letra = '\n';
				} else if (read == -1) {
					textArea.setText(textArea.getText() + "\n     FIN");
					bufferR.close();
					return false;
				}
				letra = (char) read;
				textArea.setText(textArea.getText() + letra);
			}
			lblPagina.setText(String.valueOf(principio));
			fileR.close();
			bufferR.close();
		} catch (IOException e) {
			System.out.println("error al leer/pintar el texto");
			return false;
		}
		return true;
	}

}
