package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import modelo.Legible;
import modelo.Libro;

public class LegibleTest {
	Libro inst;
	
	@Before
	public void setUp(){
		inst= new Libro();
	}
	
	@Test
	public void testAvanzarPagina() {
		int paginaActual=inst.getActual();
		inst.avanzarPagina();
		assertEquals(paginaActual+1, inst.getActual());
	}

	@Test
	public void testRetrocederPagina() {
		inst.avanzarPagina();
		int paginaActual=inst.getActual();
		inst.retrocederPagina();
		assertEquals(paginaActual-1, inst.getActual());
	}

	@Test
	public void testMarcarPagina() {
		int actual = inst.getActual();
		inst.marcarPagina();
		assertEquals(inst.getMarcar(), actual);
	}

	@Test
	public void testIrAMarca() {
		
	}

}
