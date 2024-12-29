package uo.cpm.s4.evt;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;

public class ProcesaMouseHerramienta extends MouseAdapter
{
	@Override
	public void mouseEntered(MouseEvent e)
	{
		JButton fuente = (JButton)e.getSource();
		fuente.setBorderPainted(true);
	}
	
	@Override
	public void mouseExited(MouseEvent e)
	{
		JButton fuente = (JButton)e.getSource();
		fuente.setBorderPainted(false);
	}
}
