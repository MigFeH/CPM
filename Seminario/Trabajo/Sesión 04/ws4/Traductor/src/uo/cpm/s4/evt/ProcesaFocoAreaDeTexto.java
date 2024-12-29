package uo.cpm.s4.evt;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JTextArea;

public class ProcesaFocoAreaDeTexto implements FocusListener
{

	@Override
	public void focusGained(FocusEvent e) {
		JTextArea fuente = (JTextArea)e.getSource();
		fuente.setBackground(Color.white);
	}

	@Override
	public void focusLost(FocusEvent e) {
		JTextArea fuente = (JTextArea)e.getSource();
		fuente.setBackground(Color.LIGHT_GRAY);
	}
	
}
