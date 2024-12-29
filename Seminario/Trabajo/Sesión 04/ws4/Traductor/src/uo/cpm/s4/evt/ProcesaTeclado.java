package uo.cpm.s4.evt;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ProcesaTeclado extends KeyAdapter
{
	@Override
	public void keyTyped(KeyEvent e) {
		compruebaTecla(e);
	}
	
	public void compruebaTecla(KeyEvent e) {
		char teclaPulsada = e.getKeyChar();
		if (Character.isDigit(teclaPulsada))
		{
			e.consume();
		}
	}
}
