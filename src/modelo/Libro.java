package modelo;

import java.util.ArrayList;

import javax.print.attribute.standard.PDLOverrideSupported;

import control.accion.ParaUI;

public class Libro implements Legible {

	private String lectura;

	private int actual;

	private int marcar;

	private ArrayList<Pagina> paginas;

	private ParaUI paraUI;

	public Libro(ParaUI paraUI) {
		super();
		this.lectura = "libroEjemplo.txt";
		this.actual = 0;
		this.marcar = 0;
		this.paginas = new ArrayList<>();
		this.paraUI = paraUI;
	}

	@Override
	public void avanzarPagina() {
		if (!comprobarUltimaPagina()) {
			if (cargarSiguientePagina()) {
				this.actual++;
			}
		}
		

	}

	private boolean cargarSiguientePagina() {
		if (cargarPagina(actual + 1)) {
			return true;
		}
		return false;
	}

	private boolean comprobarUltimaPagina() {
		return false;
	}

	@Override
	public void retrocederPagina() {
		if (!comprobarPrimeraPagina()) {
			if (cargarAnteriorPagina()) {
				this.actual--;
			}
		}

	}

	private boolean cargarAnteriorPagina() {
		if (cargarPagina(actual - 1)) {
			return true;
		}
		return false;
	}

	private boolean comprobarPrimeraPagina() {
		if (this.actual == 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public void marcarPagina() {
		this.marcar = this.actual;
	}

	@Override
	public void irAMarca() {
		if (cargarPagina(marcar)) {
			this.actual = this.marcar;
		}

	}

	private boolean cargarPagina(int pagina) {
		if (paraUI.pintarTxt(pagina)) {
			return true;
		}
		return false;
	};

	public String getLectura() {
		return lectura;
	}

	public int getActual() {
		return actual;
	}

	public int getMarcar() {
		return marcar;
	}

	public ArrayList<Pagina> getPaginas() {
		return paginas;
	}

}
