package modelo;

import java.util.ArrayList;

public class Libro implements Legible {

	private String lectura;

	private int actual;

	private int marcar;

	private ArrayList<Pagina> paginas;

	public Libro() {
		super();
		this.lectura = "ruta";
		this.actual = 0;
		this.marcar = 0;
		this.paginas = new ArrayList<>();
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
		if (this.actual == 5) {// TODO mientras el size sea 0, si no el test da
								// rojo -> this.paginas.size()
			return true;
		} else {
			return false;
		}
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
		//TODO
		return true;
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
