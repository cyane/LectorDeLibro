package modelo;

import java.awt.Color;

public enum Colores {
	black(Color.BLACK),rojo(Color.red), amarillo(Color.YELLOW), azul(Color.BLUE), verde(Color.GREEN), naranja(Color.orange), cyan(Color.CYAN),  gray(Color.GRAY), magenta(Color.MAGENTA), darkGray(Color.LIGHT_GRAY), white(Color.WHITE), pink(Color.PINK);
	private Color color;

	private Colores(Color color) {
		this.color = color;
	}

	public Color getColor() {
		return color;
	}

}
