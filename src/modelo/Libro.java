package modelo;

import control.accion.ParaUI;

public class Libro implements Legible {

	private String lectura;

	private int actual;

	private int marcar;

	private ParaUI paraUI;

	public Libro(ParaUI paraUI, String string) {
		super();
		this.lectura = string;
		this.actual = 0;
		this.marcar = 0;
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

}
