package control.accion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import modelo.Libro;

public class MyActionListener implements ActionListener {

	private Libro libro;

	public MyActionListener(Libro librito) {
		this.libro = librito;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton boton = (JButton) e.getSource();
		if (boton.getName().equals("avanzarPagina")) {

			libro.avanzarPagina();

		} else if (boton.getName().equals("retrocederPagina")) {

			libro.retrocederPagina();

		} else if (boton.getName().equals("marcarPagina")) {

			libro.marcarPagina();

		} else if (boton.getName().equals("irAMarcada")) {

			libro.irAMarca();

		}

	}

}
