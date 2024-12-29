// Trabajado por Miguel

package uo.cpm.s4.ui;

import java.awt.*;
import javax.swing.*;

import uo.cpm.s4.evt.ProcesaFocoAreaDeTexto;
import uo.cpm.s4.evt.ProcesaMouseHerramienta;
import uo.cpm.s4.evt.ProcesaTeclado;

import java.awt.event.*;

public class VentanaPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JMenuBar barraMenu;
	private JToolBar barraHerramientas;
	private JButton btNuevo;
	private JButton btGuardar;
	private JButton btAbrir;
	private JButton btImprimir;
	private JPanel barraEstado;
	private JPanel pnTextos;
	private JScrollPane scOriginal;
	private JScrollPane scTraducido;
	private JTextArea arOriginal;
	private JTextArea arTraducido;
	private JButton btEspañol;
	private JButton btFrances;
	private JButton btIngles;
	private JLabel etDocOriginal;
	private JLabel etIdOriginal;
	private JLabel etDocTraducido;
	private JLabel etIdTraducido;
	private JMenu menuArchivo;
	private JMenu menuEditar;
	private JMenu menuTraducir;
	private JMenu menuHerramientas;
	private JMenu menuAyuda;
	private JMenuItem itGuardarComo;
	private JMenuItem itNuevo;
	private JMenuItem itSalir;
	private JCheckBox chckbxSoloLetras;
	private ProcesaFocoAreaDeTexto pFAT = new ProcesaFocoAreaDeTexto();
	private ProcesaMouseHerramienta pMH = new ProcesaMouseHerramienta();
	private ProcesaAccionGuardar pAG = new ProcesaAccionGuardar();
	private ProcesaAccionBotonSoloLetras pACBL = new ProcesaAccionBotonSoloLetras();
	private ProcesaTeclado pT = new ProcesaTeclado();
	private ProcesaAccionSalir pAS = new ProcesaAccionSalir();
	private ProcesaVentana pV = new ProcesaVentana();

	
	private JMenuBar getBarraMenu() {
		if (barraMenu == null) {
			barraMenu = new JMenuBar();
			barraMenu.add(getMenuArchivo());
			barraMenu.add(getMenuEditar());
			barraMenu.add(getMenuTraducir());
			barraMenu.add(getMenuHerramientas());
			barraMenu.add(getMenuAyuda());
		}
		return barraMenu;
	}

	private JToolBar getBarraHerramientas() {
		if (barraHerramientas == null) {
			barraHerramientas = new JToolBar();
			barraHerramientas.setBackground(new java.awt.Color(208,204,204));
			barraHerramientas.add(getBtNuevo());
			barraHerramientas.add(getBtAbrir());
			barraHerramientas.add(getBtGuardar());
			barraHerramientas.add(getBtImprimir());
			barraHerramientas.add(getBtIngles());
			barraHerramientas.add(getBtEspañol());
			barraHerramientas.add(getBtFrances());
			barraHerramientas.add(getChckbxSoloLetras());
		}
		return barraHerramientas;
	}

	private JButton getBtNuevo() {
		if (btNuevo == null) {
			btNuevo = new JButton();
			btNuevo.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/Nuevo.png")));
			btNuevo.setBorderPainted(false);
			btNuevo.setContentAreaFilled(false);
			btNuevo.setFocusPainted(false);
			btNuevo.setPreferredSize(new java.awt.Dimension(24,24));
			btNuevo.setMaximumSize(new java.awt.Dimension(24,24));
			btNuevo.setMinimumSize(new java.awt.Dimension(24,24));
			btNuevo.setMargin(new java.awt.Insets(0,0,0,0));
			btNuevo.addMouseListener(pMH);
		}
		return btNuevo;
	}

	private JButton getBtGuardar() {
		if (btGuardar == null) {
			btGuardar = new JButton();
			btGuardar.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/Guardar.png")));
			btGuardar.setBorderPainted(false);
			btGuardar.setContentAreaFilled(false);
			btGuardar.setPreferredSize(new java.awt.Dimension(24,24));
			btGuardar.setMaximumSize(new java.awt.Dimension(24,24));
			btGuardar.setMinimumSize(new java.awt.Dimension(24,24));
			btGuardar.setMargin(new java.awt.Insets(0,0,0,0));
			btGuardar.addMouseListener(pMH);
			btGuardar.addActionListener(pAG);
		}
		return btGuardar;
	}

	private JButton getBtAbrir() {
		if (btAbrir == null) {
			btAbrir = new JButton();
			btAbrir.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/Abrir.png")));
			btAbrir.setBorderPainted(false);
			btAbrir.setContentAreaFilled(false);
			btAbrir.setMaximumSize(new java.awt.Dimension(24,24));
			btAbrir.setMinimumSize(new java.awt.Dimension(24,24));
			btAbrir.setPreferredSize(new java.awt.Dimension(24,24));
			btAbrir.setMargin(new java.awt.Insets(0,0,0,0));
			btAbrir.addMouseListener(pMH);
		}
		return btAbrir;
	}

	private JButton getBtImprimir() {
		if (btImprimir == null) {
			btImprimir = new JButton();
			btImprimir.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/Imprimir.png")));
			btImprimir.setBorderPainted(false);
			btImprimir.setContentAreaFilled(false);
			btImprimir.setMaximumSize(new java.awt.Dimension(24,24));
			btImprimir.setMinimumSize(new java.awt.Dimension(24,24));
			btImprimir.setMargin(new java.awt.Insets(0,0,0,0));
			btImprimir.addMouseListener(pMH);
		}
		return btImprimir;
	}

	private JPanel getBarraEstado() {
		if (barraEstado == null) {
			barraEstado = new JPanel();
			barraEstado.setLayout(new GridLayout(1, 4, 0, 0));
			barraEstado.add(getEtDocOriginal());
			barraEstado.add(getEtIdOriginal());
			barraEstado.add(getEtDocTraducido());
			barraEstado.add(getEtIdTraducido());
		}
		return barraEstado;
	}

	private JLabel getEtDocOriginal() {
		if (etDocOriginal == null){
			etDocOriginal = new JLabel();
			etDocOriginal.setText("Documento Original");
			etDocOriginal.setFont(new java.awt.Font("Dialog", java.awt.Font.PLAIN, 12));
			etDocOriginal.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
		}
		return etDocOriginal;
	}

	private JLabel getEtIdOriginal() {
		if (etIdOriginal == null){
			etIdOriginal = new JLabel();
			etIdOriginal.setText("Español");
			etIdOriginal.setFont(new java.awt.Font("Dialog", java.awt.Font.PLAIN, 12));
			etIdOriginal.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
		}
		return etIdOriginal;
	}

	private JLabel getEtDocTraducido() {
		if (etDocTraducido == null){
			etDocTraducido = new JLabel();
			etDocTraducido.setText("Documento traducido");
			etDocTraducido.setFont(new java.awt.Font("Dialog", java.awt.Font.PLAIN, 12));
			etDocTraducido.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
		}
		return etDocTraducido;
	}

	private JLabel getEtIdTraducido() {
		if (etIdTraducido == null){
			etIdTraducido = new JLabel();
			etIdTraducido.setText("Inglñs");
			etIdTraducido.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
			etIdTraducido.setFont(new java.awt.Font("Dialog", java.awt.Font.PLAIN, 12));
		}
		return etIdTraducido;
	}

	private JPanel getPnTextos() {
		if (pnTextos == null) {
			GridLayout gridLayout = new GridLayout();
			gridLayout.setRows(2);
			gridLayout.setColumns(1);
			pnTextos = new JPanel();
			pnTextos.setLayout(gridLayout);
			pnTextos.add(getScOriginal(), null);
			pnTextos.add(getScTraducido(), null);
		}
		return pnTextos;
	}

	private JScrollPane getScOriginal() {
		if (scOriginal == null) {
			scOriginal = new JScrollPane();
			scOriginal.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Documento Original", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", java.awt.Font.PLAIN, 12), new java.awt.Color(51,51,51)));
			scOriginal.setViewportView(getArOriginal());
		}
		return scOriginal;
	}

	private JScrollPane getScTraducido() {
		if (scTraducido == null) {
			scTraducido = new JScrollPane();
			scTraducido.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Documento Traducido", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", java.awt.Font.PLAIN, 12), new java.awt.Color(51,51,51)));
			scTraducido.setViewportView(getArTraducido());
		}
		return scTraducido;
	}

	private JTextArea getArOriginal() {
		if (arOriginal == null) {
			arOriginal = new JTextArea();
			arOriginal.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
			arOriginal.setWrapStyleWord(true);
			arOriginal.setBackground(java.awt.Color.lightGray);
			arOriginal.setLineWrap(true);
			arOriginal.addFocusListener(pFAT);
		}
		return arOriginal;
	}

	private JTextArea getArTraducido() {
		if (arTraducido == null) {
			arTraducido = new JTextArea();
			arTraducido.setWrapStyleWord(true);
			arTraducido.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
			arTraducido.setBackground(java.awt.Color.lightGray);
			arTraducido.setLineWrap(true);
			arTraducido.addFocusListener(pFAT);
		}
		return arTraducido;
	}

	private JButton getBtEspañol() {
		if (btEspañol == null) {
			btEspañol = new JButton();
			btEspañol.setText("ES");
			btEspañol.setFont(new Font("Dialog", Font.PLAIN, 12));
			btEspañol.setBorderPainted(false);
			btEspañol.setPreferredSize(new java.awt.Dimension(24,24));
			btEspañol.setMargin(new java.awt.Insets(0,0,0,0));
			btEspañol.setMaximumSize(new java.awt.Dimension(24,24));
			btEspañol.setMinimumSize(new java.awt.Dimension(24,24));
			btEspañol.setContentAreaFilled(false);
			btEspañol.addMouseListener(pMH);
			
		}
		return btEspañol;
	}

	private JButton getBtFrances() {
		if (btFrances == null) {
			btFrances = new JButton();
			btFrances.setBorderPainted(false);
			btFrances.setText("FR");
			btFrances.setFont(new Font("Dialog", Font.PLAIN, 12));
			btFrances.setPreferredSize(new java.awt.Dimension(25,24));
			btFrances.setMargin(new java.awt.Insets(0,0,0,0));
			btFrances.setMaximumSize(new java.awt.Dimension(25,24));
			btFrances.setMinimumSize(new java.awt.Dimension(25,24));
			btFrances.setContentAreaFilled(false);
			btFrances.addMouseListener(pMH);
		}
		return btFrances;
	}

	private JButton getBtIngles() {
		if (btIngles == null) {
			btIngles = new JButton();
			btIngles.setBorderPainted(false);
			btIngles.setText("EN");
			btIngles.setFont(new Font("Dialog", Font.PLAIN, 12));
			btIngles.setPreferredSize(new java.awt.Dimension(24,24));
			btIngles.setMargin(new java.awt.Insets(0,0,0,0));
			btIngles.setMaximumSize(new java.awt.Dimension(24,24));
			btIngles.setMinimumSize(new java.awt.Dimension(24,24));
			btIngles.setContentAreaFilled(false);
			btIngles.addMouseListener(pMH);
		}
		return btIngles;
	}

	private JMenu getMenuArchivo() {
		if (menuArchivo == null) {
			menuArchivo = new JMenu();
			menuArchivo.setMnemonic('A');
			menuArchivo.setText("Archivo");
			menuArchivo.add(getItNuevo());
			menuArchivo.addSeparator();
			menuArchivo.add(getItGuardarComo());
			menuArchivo.addSeparator();
			menuArchivo.add(getItSalir());
		}
		return menuArchivo;
	}

	private JMenu getMenuEditar() {
		if (menuEditar == null) {
			menuEditar = new JMenu();
			menuEditar.setMnemonic('E');
			menuEditar.setText("Editar");
		}
		return menuEditar;
	}

	private JMenu getMenuTraducir() {
		if (menuTraducir == null) {
			menuTraducir = new JMenu();
			menuTraducir.setMnemonic('T');
			menuTraducir.setText("Traducir");
		}
		return menuTraducir;
	}

	private JMenu getMenuHerramientas() {
		if (menuHerramientas == null) {
			menuHerramientas = new JMenu();
			menuHerramientas.setMnemonic('H');
			menuHerramientas.setText("Herramientas");
		}
		return menuHerramientas;
	}

	private JMenu getMenuAyuda() {
		if (menuAyuda == null) {
			menuAyuda = new JMenu();
			menuAyuda.setMnemonic('d');
			menuAyuda.setText("Ayuda");
		}
		return menuAyuda;
	}

	private JMenuItem getItGuardarComo() {
		if (itGuardarComo == null) {
			itGuardarComo = new JMenuItem();
			itGuardarComo.setMnemonic('G');
			itGuardarComo.setText("Guardar como...");
		}
		return itGuardarComo;
	}

	private JMenuItem getItNuevo() {
		if (itNuevo == null) {
			itNuevo = new JMenuItem();
			itNuevo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_DOWN_MASK));
			itNuevo.setMnemonic('N');
			itNuevo.setText("Nuevo");
		}
		return itNuevo;
	}

	private JMenuItem getItSalir() {
		if (itSalir == null) {
			itSalir = new JMenuItem();
			itSalir.setMnemonic('S');
			itSalir.setText("Salir");
			itSalir.addActionListener(pAS);
		}
		return itSalir;
	}

	public VentanaPrincipal() {
		addWindowListener(pV);
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaPrincipal.class.getResource("/img/icono.png")));
		setSize(981, 586);
		setJMenuBar(getBarraMenu());
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setTitle("Traductor de Textos");
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setLayout(new BorderLayout());
		contentPane.add(getBarraHerramientas(), java.awt.BorderLayout.NORTH);
		contentPane.add(getBarraEstado(), java.awt.BorderLayout.SOUTH);
		contentPane.add(getPnTextos(), java.awt.BorderLayout.CENTER);
		setContentPane(contentPane);
		
	}
	
	private void confirmarGuardadoAntesDeSalir() {
		int option = JOptionPane.showConfirmDialog(getContentPane(),"¿Desea guardar los cambios antes de salir?");
		if(option == JOptionPane.YES_OPTION)
		{
			guardar();
			System.exit(0);
		}
		else if(option == JOptionPane.NO_OPTION)
		{
			System.exit(0);
		}
	}
	
	private JCheckBox getChckbxSoloLetras() {
		if (chckbxSoloLetras == null) {
			chckbxSoloLetras = new JCheckBox("Permitir solo texto");
			chckbxSoloLetras.setBackground(Color.LIGHT_GRAY);
			chckbxSoloLetras.setForeground(Color.BLACK);
			chckbxSoloLetras.addActionListener(pACBL);
		}
		return chckbxSoloLetras;
	}
	
	private void guardar()
	{
		String titulo = JOptionPane.showInputDialog(getContentPane(),"Nombre del documento original: ", "Guardar", JOptionPane.INFORMATION_MESSAGE);
		getEtDocOriginal().setText(titulo);
	}
	
	class ProcesaAccionGuardar implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) {
			guardar();
		}
	}
	
	class ProcesaAccionBotonSoloLetras implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(getChckbxSoloLetras().isSelected())
			{
				getArOriginal().addKeyListener(pT);
				getArOriginal().grabFocus();
			}
			else {
				getArOriginal().removeKeyListener(pT);
				getArOriginal().grabFocus();
			}
		}
	}
	
	
	class ProcesaAccionSalir implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) {
			confirmarGuardadoAntesDeSalir();
		}
		
	}
	
	class ProcesaVentana extends WindowAdapter
	{
		@Override
		public void windowOpened(WindowEvent e) {
			getArOriginal().grabFocus();
		}
		@Override
		public void windowClosing(WindowEvent e) {
			confirmarGuardadoAntesDeSalir();
		}
	}
}
