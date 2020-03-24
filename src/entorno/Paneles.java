package entorno;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.JTextPane;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

public class Paneles {
	public JButton jbNuevo,jbAbrir,jbGuardar,jbDeshacer,jbRehacer;
	public JButton jbEscalaGris,jbBrillo,jbSepia,jbRecortar,jbCortar,jbMascaras;
	public JButton jbDimension,jbAplicarD,jbEspejo,jbVoltear,jbAplicarV,jbRotar,
	jbIzquierda,jbDerecha,jbAgregarTexto,jbMarcos,jbAplicarTexto,jbCerrar;
	public JRadioButton jrbEjeX,jrbEjeY;
	public JSpinner jspinnerAlto,jspinnerAncho, valorx,valorx2,valory,valory2;
	public JPanel jpanelSuperior,jpanelIzquierdo,jpanelDerecho,jpanelInferior,jpDerechoRecortar;
	public JPanel jpDerechoDimension,jpDerechoBrilloContraste,jpDerechoVoltear,jpDerechoRotar,jpDerechoTexto;		
	public JToolBar jtbBarraHerramienta; 
	public JSlider jsliderZoom,jsliderBrillo;
	public JProgressBar jpbEstado;
	public JLabel jlZoom,jlTexto;
	public JTextPane jtpCambiarTexto;
		public void PanelSuperior(){
			jpanelSuperior = new JPanel();
			jbAbrir=new JButton("");
			jbAbrir.setToolTipText("Abrir Imagen");
			ImageIcon iiAbrir=new ImageIcon("src/Iconos/imagen.png");
			jbAbrir.setIcon(iiAbrir);
			jbAbrir.setBackground(Color.black);
			jbGuardar=new JButton("");
			jbGuardar.setToolTipText("Guarda Imagen");
			ImageIcon iiGuardar=new ImageIcon("src/Iconos/guardar.png");
			jbGuardar.setIcon(iiGuardar);
			jbGuardar.setBackground(Color.black);
			jbDeshacer=new JButton("");
			ImageIcon iiDeshacer = new ImageIcon("src/Iconos/Deshacer.png");
			jbDeshacer.setIcon(iiDeshacer);
			jbDeshacer.setBackground(Color.black);
			jbDeshacer.setToolTipText("Deshacer Ultima Acción");
			jbRehacer=new JButton("");
			ImageIcon iiRehacer=new ImageIcon("src/Iconos/Rehacer.png");
			jbRehacer.setIcon(iiRehacer);
			jbRehacer.setBackground(Color.black);
			jbRehacer.setToolTipText("Rehacer Ultima Acción");
			jpanelSuperior.setBackground(Color.black);
			
			jbCerrar=new JButton("");
			ImageIcon iiCerrar=new ImageIcon("src/Iconos/cerrar.png");
			jbCerrar.setIcon(iiCerrar);
			jbCerrar.setBackground(Color.white);
			jbCerrar.setToolTipText("Comenzar Nueva Edicion");
			jpanelSuperior.setLayout(new BoxLayout(jpanelSuperior,BoxLayout.X_AXIS));
			JButton e=new JButton("      ");	
			e.setBackground(Color.black);
			jpanelSuperior.add(jbAbrir);
			jpanelSuperior.add(jbGuardar);
			jpanelSuperior.add(jbDeshacer);
			jpanelSuperior.add(jbRehacer);
			jpanelSuperior.add(e);
			jpanelSuperior.add(jbCerrar);
		}
		
		public void PanelInferior() {
			jpanelInferior=new JPanel();
			jpbEstado = new JProgressBar();	
			jsliderZoom=new JSlider(JSlider.HORIZONTAL,0,200,100);
			jsliderZoom.setPaintTicks(false);
			jsliderZoom.setMajorTickSpacing(50);
			jsliderZoom.setMinorTickSpacing(5);
			jsliderZoom.setPaintLabels(true);
			jsliderZoom.setFont(new Font("Tahoma", Font.PLAIN, 7));

			jlZoom=new JLabel("Zoom: ");
			jpanelInferior.setLayout(new GridBagLayout());
			GridBagConstraints c =new GridBagConstraints();	
			c.anchor=GridBagConstraints.LINE_START;
			c.ipadx=0;
			c.ipady=0;
			c.insets=new Insets(5,5,5,5);
			c.weightx=1;
			jpanelInferior.add(jpbEstado, c);
			
			c.ipadx=1;
			c.ipady=0;
			c.insets=new Insets(2,5,0,5);
			c.weightx=0;
			jpanelInferior.add(jlZoom, c);
			
			c.anchor=GridBagConstraints.WEST;
			c.ipadx=2;
			c.ipady=0;
			c.weightx=-1;
			jpanelInferior.add(jsliderZoom,c);
			
		}
		
		public void PanelIzquierdo() {
			jpanelIzquierdo= new JPanel();
			jtbBarraHerramienta = new JToolBar();
			jbEscalaGris =new JButton("");
			jbBrillo =new JButton("");
			jbRecortar=new JButton("");
			jbMascaras=new JButton("");
			jbDimension=new JButton("");
			jbSepia=new JButton("");
			jbEspejo=new JButton("");
			jbVoltear=new JButton("");
			jbRotar=new JButton("");
			jbAgregarTexto=new JButton("");
			jbMarcos=new JButton("");
			
			ImageIcon iiEscalaGris = new ImageIcon("src/Iconos/escalagrises.png");
			jbEscalaGris.setIcon(iiEscalaGris);
			jbEscalaGris.setToolTipText("Escala de Grises");
			ImageIcon iiEspejo=new ImageIcon("src/Iconos/espejo.png");
			jbEspejo.setIcon(iiEspejo);
			jbEspejo.setToolTipText("Efecto Espejo");
			ImageIcon iiVoltear=new ImageIcon("src/Iconos/voltear.png");
			jbVoltear.setIcon(iiVoltear);
			jbVoltear.setToolTipText("VoltearImagen");
			ImageIcon iiRotar = new ImageIcon("src/Iconos/rotar.png");
			jbRotar.setIcon(iiRotar);
			jbRotar.setToolTipText("Rotar Imagen");
			ImageIcon iiSepia=new ImageIcon("src/Iconos/sepia.png");
			jbSepia.setIcon(iiSepia);
			jbSepia.setToolTipText("Efecto Sepia");
			ImageIcon iiBrillo=new ImageIcon("src/Iconos/brillo.png");
			jbBrillo.setIcon(iiBrillo);
			jbBrillo.setToolTipText("Brillo y Contraste");
			ImageIcon iiDimension =new ImageIcon("src/Iconos/Dimension.png");
			jbDimension.setIcon(iiDimension);
			jbDimension.setToolTipText("Dimensiones de Imagen");
			ImageIcon iiRecortar =new ImageIcon("src/Iconos/invierno.png");
			jbAgregarTexto.setIcon(iiRecortar);
			jbAgregarTexto.setToolTipText("Agregar Texto");
			ImageIcon iiCortar= new ImageIcon("src/Iconos/intente.png");  
			jbRecortar.setIcon(iiCortar);
			jbRecortar.setToolTipText("Recortar Imagen");
			ImageIcon iiMarcos= new ImageIcon("src/Iconos/marcos.png");  
			jbMarcos.setIcon(iiMarcos);
			jbMarcos.setToolTipText("Marcos Imagen");
			
			
			jtbBarraHerramienta.addSeparator();
			jtbBarraHerramienta.add(jbDimension);
			jtbBarraHerramienta.add(jbVoltear);
			jtbBarraHerramienta.add(jbEspejo);
			jtbBarraHerramienta.add(jbRotar);
			jtbBarraHerramienta.addSeparator();
			jtbBarraHerramienta.add(jbEscalaGris);
			jtbBarraHerramienta.add(jbSepia);
			jtbBarraHerramienta.add(jbBrillo);
			jtbBarraHerramienta.addSeparator();
			jtbBarraHerramienta.add(jbRecortar);
			jtbBarraHerramienta.addSeparator();
			jtbBarraHerramienta.add(jbAgregarTexto);
			jtbBarraHerramienta.add(jbMarcos);
			jtbBarraHerramienta.setOrientation(SwingConstants.VERTICAL);
			jpanelIzquierdo.add(jtbBarraHerramienta);
			jpanelIzquierdo.setBackground(Color.black);
			jpanelIzquierdo.setLayout(new BoxLayout(jpanelIzquierdo,BoxLayout.Y_AXIS));

		}
		
		public void PanelDerecho() {
			jpanelDerecho=new JPanel();	
			
			
		}
		public void PanelDimension() {
			jpDerechoDimension=new JPanel();
			jspinnerAncho=new JSpinner();
			jspinnerAlto=new JSpinner();
			jpDerechoDimension.setBorder(new TitledBorder(null, "Dimension en Pixeles", TitledBorder.LEFT, TitledBorder.TOP, null, Color.black));
			jpDerechoDimension.setLayout(new GridBagLayout());
			GridBagConstraints c = new GridBagConstraints();
			c.fill=GridBagConstraints.HORIZONTAL;
			c.weightx=1.0;
			
			c.gridx=0;
			c.gridy=0;
		
			JLabel jlAlto=new JLabel("X Alto:");
			JLabel jlAncho=new JLabel("  Ancho: ");
			jpDerechoDimension.add(jlAncho,c);
			c.gridx=1;
			c.gridy=0;			
			c.insets=new Insets(5,0,5,0);//Aspecto en relacion al espacio
			jpDerechoDimension.add(jspinnerAncho,c);
			c.gridx=2;
			c.gridy=0;
			c.insets=new Insets(5,10,5,0);
			jpDerechoDimension.add(jlAlto,c);
			c.gridx=3;
			c.gridy=0;
			jpDerechoDimension.add(jspinnerAlto,c);
			jbAplicarD = new JButton("Aplicar"); 
			c.fill=GridBagConstraints.HORIZONTAL;
			c.gridx=1;
			c.gridy=2;
			c.gridwidth=2;
			c.insets=new Insets(0,0,10,0);
			jpDerechoDimension.add(jbAplicarD,c);


		}
		public void PanelBrilloContraste() {
			jpDerechoBrilloContraste=new JPanel();
			jsliderBrillo=new JSlider(JSlider.HORIZONTAL,0,70,0);
			jsliderBrillo.setPaintTicks(true);
			jsliderBrillo.setMajorTickSpacing(10);
			jsliderBrillo.setMinorTickSpacing(5);
			jsliderBrillo.setPaintLabels(true);
			jsliderBrillo.setFont(new Font("Tahoma", Font.PLAIN, 7));
			
			JLabel jlB=new JLabel("Brillo: ");
			jpDerechoBrilloContraste.setBorder(new TitledBorder(null, "Brillo y Contraste", TitledBorder.CENTER, TitledBorder.TOP, null, Color.black));
			jpDerechoBrilloContraste.setLayout(new GridBagLayout());
			GridBagConstraints c = new GridBagConstraints();
			c.fill=GridBagConstraints.HORIZONTAL;
			c.gridx=0;
			c.gridy=0;
			c.gridwidth=2;
			jpDerechoBrilloContraste.add(jlB,c);
			c.gridx=0;
			c.gridy=1;
			c.insets=new Insets(10,5,0,5);
			jpDerechoBrilloContraste.add(jsliderBrillo,c);
			
		}
		
		public void PanelVoltear() {
			jpDerechoVoltear=new JPanel();
			jrbEjeX=new JRadioButton(" Eje X");
			jrbEjeY=new JRadioButton(" Eje Y");
			ButtonGroup bgGrupo =new ButtonGroup();
			bgGrupo.add(jrbEjeX);
			bgGrupo.add(jrbEjeY);
			jpDerechoVoltear.setBorder(new TitledBorder(null, "Voltear Respecto Al Eje...", TitledBorder.LEFT, TitledBorder.TOP, null, Color.black));
			jpDerechoVoltear.setLayout(new GridBagLayout());
			GridBagConstraints c = new GridBagConstraints();
			c.fill=GridBagConstraints.HORIZONTAL;
			c.gridx=0;
			c.gridy=0;
			c.gridwidth=2;
			c.insets=new Insets(0,5,15,5);
			JLabel jlEjes=new JLabel("Elija Un Eje Para Voltear La Imagen:");
			jpDerechoVoltear.add(jlEjes,c);
			c.gridx=0;
			c.gridy=1;			
			c.gridwidth=1;
			c.insets=new Insets(5,10,5,0);//Aspecto en relacion al espacio
			jpDerechoVoltear.add(jrbEjeX,c);
			c.gridx=1;
			c.gridy=1;
			c.insets=new Insets(5,10,5,0);
			jpDerechoVoltear.add(jrbEjeY,c);
			jbAplicarV = new JButton("Aplicar"); 
			c.fill=GridBagConstraints.HORIZONTAL;
			c.gridx=0;
			c.gridy=2;
			c.gridwidth=2;
			c.insets=new Insets(30,0,0,0);
			jpDerechoVoltear.add(jbAplicarV,c);
			


		}
		public void PanelRotar() {
			jpDerechoRotar=new JPanel();
			jbIzquierda=new JButton("Izquierda");
			jbDerecha=new JButton("Derecha");
			
			jpDerechoRotar.setBorder(new TitledBorder(null, "Rotar Imagen", TitledBorder.LEFT,
					TitledBorder.TOP, null, Color.black));
			jpDerechoRotar.setLayout(new GridBagLayout());
			GridBagConstraints c = new GridBagConstraints();
			c.fill=GridBagConstraints.HORIZONTAL;
			c.gridx=0;
			c.gridy=0;
			c.gridwidth=2;
			c.insets=new Insets(0,5,15,5);
			JLabel jlEjes=new JLabel("Elija Direccion de Rotacion:");
			jpDerechoRotar.add(jlEjes,c);
			c.gridx=0;
			c.gridy=1;			
			c.gridwidth=1;
			c.insets=new Insets(5,5,5,5);
			jpDerechoRotar.add(jbIzquierda,c);
			c.gridx=1;
			c.gridy=1;
			c.insets=new Insets(5,10,5,5);
			jpDerechoRotar.add(jbDerecha,c);

		}
		
		public void PanelCortar() {
			jpDerechoRecortar = new JPanel();
			jpDerechoRecortar.setBorder(new TitledBorder(null, "Recorte de Imagenes", TitledBorder.LEFT, 
					TitledBorder.TOP, null, Color.black));
//			jpDerechoRecortar.setBounds(420, 70, 8000, 500);
			jbCortar= new JButton();
			jbCortar.setText("Cortar");
			jpDerechoRecortar.setLayout(new GridBagLayout());
			GridBagConstraints c = new GridBagConstraints();
			c.fill = GridBagConstraints.HORIZONTAL;
			c.weightx = 1.0;

			JLabel puntox = new JLabel("Posicion X1");
			c.gridx = 0;
			c.gridy = 0;
			c.gridwidth = 1;
			c.gridheight = 1;
			c.insets=new Insets(5,10,5,5);
			jpDerechoRecortar.add(puntox, c);
			JLabel puntox2 = new JLabel("PosicionX2");
			c.fill = GridBagConstraints.BOTH;
			c.gridx = 0;
			c.gridy = 1;
			c.gridwidth = 1;
			c.gridheight = 1;
			c.insets=new Insets(5,10,5,5);
			jpDerechoRecortar.add(puntox2, c);
			JLabel puntoy = new JLabel("Posicion Y1");
			c.weightx = 0.5;
			c.weighty = 0.5;
			c.fill = GridBagConstraints.BOTH;
			c.gridx = 0;
			c.gridy = 2;
			c.gridwidth = 1;
			c.gridheight = 1;
			c.insets=new Insets(5,10,5,5);
			jpDerechoRecortar.add(puntoy, c);
			JLabel puntoy2 = new JLabel("Posicion Y2");
			c.weightx = 0.5;
			c.weighty = 0.5;
			c.fill = GridBagConstraints.BOTH;
			c.gridx = 0;
			c.gridy = 3;
			c.gridwidth = 1;
			c.gridheight = 1;
			c.insets=new Insets(5,10,5,5);
			jpDerechoRecortar.add(puntoy2, c);
			valorx = new JSpinner();
			c.weightx = 0.5;
			c.weighty = 0.5;
			c.fill = GridBagConstraints.CENTER;
			c.gridx = 1;
			c.gridy = 0;
			c.gridwidth = 1;
			c.gridheight = 1;
			c.insets=new Insets(5,10,5,5);
			jpDerechoRecortar.add(valorx, c);
			valorx2 = new JSpinner();

			c.weightx = 0.5;
			c.weighty = 0.5;
			c.fill = GridBagConstraints.CENTER;
			c.gridx = 1;
			c.gridy = 1;
			c.gridwidth = 1;
			c.gridheight = 1;
			c.insets=new Insets(5,10,5,5);
			jpDerechoRecortar.add(valorx2, c);
			valory = new JSpinner();
			c.weightx = 0.5;
			c.weighty = 0.5;
			c.fill = GridBagConstraints.CENTER;
			c.gridx = 1;
			c.gridy = 2;
			c.gridwidth = 1;
			c.gridheight = 1;
			c.insets=new Insets(5,10,5,5);
			jpDerechoRecortar.add(valory, c);
			valory2 = new JSpinner();
			c.weightx = 0.5;
			c.weighty = 0.5;
			c.fill = GridBagConstraints.CENTER;
			c.gridx = 1;
			c.gridy = 3;
			c.gridwidth = 1;
			c.gridheight = 1;
			c.insets=new Insets(5,10,5,5);
			jpDerechoRecortar.add(valory2, c);
			c.weightx = 0.5;
			c.weighty = 0.5;
			c.fill = GridBagConstraints.CENTER;
			c.gridx = 0;
			c.gridy = 4;
			c.gridwidth = 2;
			c.gridheight = 1;
			c.insets=new Insets(5,10,5,5);
			jpDerechoRecortar.add(jbCortar, c);
		}
		
		public void ModificarTexto() {
			jpDerechoTexto=new JPanel();
			jpDerechoTexto.setBorder(new TitledBorder(null, "Modificar Texto",TitledBorder.LEFT, 
					TitledBorder.TOP, null, Color.black));
			jtpCambiarTexto=new JTextPane();
			jtpCambiarTexto.setBounds(0, 0, 300, 100);
			jtpCambiarTexto.setText("Agregar Texto Aquí");
			jbAplicarTexto=new JButton("Aplicar Texto");
			GridBagConstraints c=new GridBagConstraints();
			jpDerechoTexto.setLayout(new GridBagLayout());
			c.fill = GridBagConstraints.BOTH;
			c.ipadx=100;
			c.ipady=100;
			c.gridx = 0;
			c.gridy = 0;
			c.insets=new Insets(5,10,5,5);
			jpDerechoTexto.add(jtpCambiarTexto,c);
			c.fill = GridBagConstraints.CENTER;
			c.ipady=0;
			c.ipadx=30;
			c.gridx = 0;
			c.gridy = 1;
			c.insets=new Insets(5,10,5,5);
			jpDerechoTexto.add(jbAplicarTexto,c);
						
		}
}

