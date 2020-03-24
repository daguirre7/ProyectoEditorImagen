/*
 * Copyright (c) 2019, David Aguirre/Scarlet Aleman . All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is not free software; you can not redistribute it and/or modify it.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.
 *
 * Please contact us, daaguirre777@gmail.com/scarletalmed@yahoo.es if you need additional information or have any
 * questions.
 */
package entorno;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
public class Interfaz extends JFrame{
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel jlContenedor;
	public JLabel jlTexto2=new JLabel("Doble Click Modificar Texto");
	private JPanel jpanelCentral=null;
	private ArrayList<BufferedImage> alImagen = new ArrayList<BufferedImage>(); 
	private int Indic,Tamanio;
	private BufferedImage biCargaImagen,bImage;
	private Paneles PanelesDivisores= new Paneles();
	private float ibrillo=1.0f,ivabrillo=0;
	public boolean bCalculoDif;
	
	
	public Interfaz(){
		setTitle("Editor de Imágenes Kamtion");
		
		this.setSize(500,500);
		this.setExtendedState(MAXIMIZED_BOTH);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		//Menus
		JMenu menuArchivo = new JMenu(" Archivo ");
		menuArchivo.setMnemonic('A');
		JMenu menuAyuda = new JMenu("Ayuda");
		menuArchivo.setMnemonic('y');	
		JMenu menuEditar = new JMenu("Editar");
		menuArchivo.setMnemonic('E');
		//MenuItem
		JMenuItem menuitemAbrir= new JMenuItem(" Abrir...");
		menuArchivo.add(menuitemAbrir);
		menuArchivo.addSeparator();
		menuArchivo.addSeparator();
		JMenuItem menuitemSalir = new JMenuItem("Salir");
		menuArchivo.add(menuitemSalir);
		//Barra Menu		
		JMenuBar barraMenu=new JMenuBar();
		setJMenuBar(barraMenu);
		barraMenu.setOpaque(true);
		barraMenu.setBackground(Color.white);
		barraMenu.add(menuArchivo);
		barraMenu.add(menuEditar);
		barraMenu.add(menuAyuda);
		

		//Paneles

		PanelesDivisores.PanelSuperior();
		PanelesDivisores.PanelIzquierdo();
		PanelesDivisores.PanelDimension();
		PanelesDivisores.PanelVoltear();
		PanelesDivisores.PanelRotar();
		PanelesDivisores.PanelBrilloContraste();
		PanelesDivisores.PanelInferior();
		PanelesDivisores.PanelCortar();
		PanelesDivisores.ModificarTexto();
		
		Container contenedor = this.getContentPane();
		
		contenedor.setBackground(Color.DARK_GRAY);
		contenedor.add(PanelesDivisores.jpanelSuperior, BorderLayout.NORTH);
		contenedor.add(PanelesDivisores.jpanelIzquierdo,BorderLayout.WEST);
		contenedor.add(PanelesDivisores.jpanelInferior,BorderLayout.SOUTH);
				
		jlContenedor = new JLabel();
		jpanelCentral=new JPanel();			
		jpanelCentral.setBackground(Color.white);
			
			menuitemSalir.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) 
				{					
						System.exit(0);	
				} /*Salir del programa*/ 				
			});

			menuitemAbrir.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent Arg0) 
				{                                            
					if (jlContenedor.getIcon()==null) {
						alImagen.add(abrirImagen());
						Ubicacion(0);
						PanelCentral();
					}
					else JOptionPane.showMessageDialog(null, "Imagen ya Cargada");
				} 
			});
			
			PanelesDivisores.jbAbrir.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent Arg0) {
					if (jlContenedor.getIcon()==null) {
						alImagen.add(abrirImagen());
						Ubicacion(0);
						PanelCentral();	
					}
					else JOptionPane.showMessageDialog(null, "Imagen ya Cargada");
				}
			});
			
			PanelesDivisores.jbGuardar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					GuardarComo();
				}
			});
			
			PanelesDivisores.jbDimension.addActionListener(new ActionListener() {
				 public void actionPerformed(ActionEvent Arg0) {
					 contenedor.add(PanelesDivisores.jpDerechoDimension, BorderLayout.EAST);
					 PanelesDivisores.jpDerechoDimension.setVisible(true);
					 PanelesDivisores.jspinnerAlto.setValue(new Integer(bImage.getHeight()));
					 PanelesDivisores.jspinnerAncho.setValue(new Integer(bImage.getWidth()));
					 PanelesDivisores.jtbBarraHerramienta.setVisible(false);
				 }
			});

			PanelesDivisores.jsliderBrillo.addMouseListener(new MouseAdapter() {
				public void mouseReleased(MouseEvent arg0) {
					float fBrillo =PanelesDivisores.jsliderBrillo.getValue();
					 biCargaImagen=alImagen.get(Indic);
					 ImagenTransformada oITransformada = new ImagenTransformada(biCargaImagen,
							 biCargaImagen.getHeight(), biCargaImagen.getWidth(), 0,0);
					 if (fBrillo<ivabrillo)
						 fBrillo=-(ivabrillo-fBrillo);
					 else
						 fBrillo=fBrillo-ivabrillo; 
					 JOptionPane.showMessageDialog(null, fBrillo);
					 alImagen.add(oITransformada.Brillo(fBrillo, ibrillo));
					 Ubicacion(0);
					 PanelCentral();
					 PanelesDivisores.jpDerechoDimension.setVisible(false);
					 PanelesDivisores.jtbBarraHerramienta.setVisible(true);
					 contenedor.remove(PanelesDivisores.jpDerechoDimension); 
					 ivabrillo=PanelesDivisores.jsliderBrillo.getValue();
					 contenedor.remove(PanelesDivisores.jpDerechoBrilloContraste); 
				}
			});
			
			
			PanelesDivisores.jbAplicarD.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent Arg0) {
					 biCargaImagen=alImagen.get(Indic);
					 int A=(Integer)PanelesDivisores.jspinnerAlto.getValue();
					 int B=(Integer)PanelesDivisores.jspinnerAncho.getValue();
					 ImagenTransformada oITransformada = new ImagenTransformada(biCargaImagen,
							 biCargaImagen.getHeight(), biCargaImagen.getWidth(), A,B);
					 alImagen.add(oITransformada.EscalarImagen());
					 Ubicacion(0);
					 PanelCentral();
					 PanelesDivisores.jpDerechoDimension.setVisible(false);
					 PanelesDivisores.jtbBarraHerramienta.setVisible(true);
					 contenedor.remove(PanelesDivisores.jpDerechoDimension); 
				}
			});	
			
			PanelesDivisores.jbEspejo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent Arg0) {
					 biCargaImagen=alImagen.get(Indic);
					 ImagenTransformada oITransformada = new ImagenTransformada(biCargaImagen,
							 biCargaImagen.getHeight(), biCargaImagen.getWidth(), 0,0);
					 alImagen.add(oITransformada.GenerarEspejo());
					 Ubicacion(0);
					 PanelCentral(); 
				}
			});
			
			PanelesDivisores.jbVoltear.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					contenedor.add(PanelesDivisores.jpDerechoVoltear, BorderLayout.EAST);
					PanelesDivisores.jpDerechoVoltear.setVisible(true);	
					PanelesDivisores.jtbBarraHerramienta.setVisible(false);
				}
			});
			
			PanelesDivisores.jbAplicarV.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					if (PanelesDivisores.jrbEjeX.isSelected() || PanelesDivisores.jrbEjeY.isSelected()) {
					 biCargaImagen=alImagen.get(Indic);
					 ImagenTransformada oITransformada = new ImagenTransformada(biCargaImagen,
							 biCargaImagen.getHeight(), biCargaImagen.getWidth(), 0,0);
					 alImagen.add(oITransformada.VoltearImagen(PanelesDivisores.jrbEjeX.isSelected()));
					 Ubicacion(0);
					 PanelCentral();
					}
					 PanelesDivisores.jpDerechoVoltear.setVisible(false);
					 PanelesDivisores.jtbBarraHerramienta.setVisible(true);
					 contenedor.remove(PanelesDivisores.jpDerechoVoltear);
				}
			});
			
			PanelesDivisores.jbRotar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					contenedor.add(PanelesDivisores.jpDerechoRotar, BorderLayout.EAST);				
					PanelesDivisores.jpDerechoRotar.setVisible(true);
					PanelesDivisores.jtbBarraHerramienta.setVisible(false); 				
				}	
			});
			
			PanelesDivisores.jbIzquierda .addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					 biCargaImagen=alImagen.get(Indic);
					 ImagenTransformada oITransformada = new ImagenTransformada(biCargaImagen,
							 biCargaImagen.getHeight(), biCargaImagen.getWidth(), 0,0);
					 double o=-(Math.PI/2.0);
					 alImagen.add(oITransformada.RotarImagen(o));
					 Ubicacion(0);
					 PanelCentral();			
					 PanelesDivisores.jpDerechoRotar.setVisible(false);
					 PanelesDivisores.jtbBarraHerramienta.setVisible(true);			
				}
			});
			
			PanelesDivisores.jbDerecha .addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					 biCargaImagen=alImagen.get(Indic);
					 ImagenTransformada oITransformada = new ImagenTransformada(biCargaImagen,
							 biCargaImagen.getHeight(), biCargaImagen.getWidth(), 0,0);
					 double o=(Math.PI/2.0);
					 alImagen.add(oITransformada.RotarImagen(o));
					 Ubicacion(0);	
					 PanelCentral();			
					 PanelesDivisores.jpDerechoRotar.setVisible(false);
					 PanelesDivisores.jtbBarraHerramienta.setVisible(true);				 				
				}
			});
			
			PanelesDivisores.jbEscalaGris.addActionListener(new ActionListener() {
				 public void actionPerformed(ActionEvent Arg0) {
					 biCargaImagen=alImagen.get(Indic);
					 ImagenColor oColores =new ImagenColor(biCargaImagen, biCargaImagen.getHeight(),
							 biCargaImagen.getWidth(),0,0);
					 alImagen.add(oColores.AplicarEscalaGrises());
					 Ubicacion(0);
					 PanelCentral();
					 PanelesDivisores.jpDerechoDimension.setVisible(false);
				}
			});
			
			PanelesDivisores.jbSepia.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					 biCargaImagen=alImagen.get(Indic);
					 ImagenColor oColores =new ImagenColor(biCargaImagen, biCargaImagen.getHeight(),
							 biCargaImagen.getWidth(),0,0);
					 alImagen.add(oColores.AplicarSepia());
					 Ubicacion(0);
					 PanelCentral();
					 PanelesDivisores.jpDerechoDimension.setVisible(false);
				}
			});
			
			PanelesDivisores.jbBrillo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					contenedor.add(PanelesDivisores.jpDerechoBrilloContraste, BorderLayout.EAST);				
					PanelesDivisores.jpDerechoBrilloContraste.setVisible(true);
					PanelesDivisores.jtbBarraHerramienta.setVisible(false);	
				}
			});
			
			PanelesDivisores.jbDeshacer.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					Ubicacion(1);
					PanelCentral();
				}
			});
			PanelesDivisores.jbRehacer.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					Ubicacion(2);
					PanelCentral();
				}
			});			
	
			PanelesDivisores.jbRecortar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent Arg0) {
					contenedor.add(PanelesDivisores.jpDerechoRecortar, BorderLayout.EAST);
					biCargaImagen = alImagen.get(Indic);
					PanelesDivisores.valorx.setValue(new Integer(biCargaImagen.getMinX()));
					PanelesDivisores.valorx2.setValue(new Integer(biCargaImagen.getMinY()));
					PanelesDivisores.valory.setValue(new Integer(biCargaImagen.getHeight()));
					PanelesDivisores.valory2.setValue(new Integer(biCargaImagen.getWidth()));
					PanelesDivisores.jpDerechoRecortar.setVisible(true);
					PanelesDivisores.jtbBarraHerramienta.setVisible(false);
				}
			});
			
			PanelesDivisores.jbCortar.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent Arg0) {
					biCargaImagen = alImagen.get(Indic);
					System.out.println("ok2");
					int X = (Integer) PanelesDivisores.valorx.getValue();
					int X2 = (Integer) PanelesDivisores.valorx2.getValue();
					int Y = (Integer) PanelesDivisores.valory.getValue(); 
					int Y2 = (Integer) PanelesDivisores.valory2.getValue();
					System.out.println(X + X2 + Y + Y2);
					ImagenRecortada recorte = new ImagenRecortada(biCargaImagen, biCargaImagen.getHeight(), 
							biCargaImagen.getWidth(), X,X2, Y, Y2);
					alImagen.add(recorte.CortarImagen());
					Ubicacion(0);
					PanelCentral();
					contenedor.remove(PanelesDivisores.jpDerechoRecortar);
					PanelesDivisores.jtbBarraHerramienta.setVisible(true);
				}
			});
			
			PanelesDivisores.jbAgregarTexto.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					jlTexto2.setVisible(true);
					jlTexto2.setForeground(Color.red);
					Tamanio=25;
					jlTexto2.setFont(new Font("Tahoma",Font.BOLD,Tamanio));
					jlContenedor.setLayout(null);
					jlTexto2.setBounds(0,1,600,25);
					jlContenedor.add(jlTexto2);
					PanelCentral();	
				}
				
			});
			
			
			jlTexto2.addMouseMotionListener(new MouseAdapter() {
				public void mouseDragged(MouseEvent ee) {
					ee.translatePoint(ee.getComponent().getLocation().x, ee.getComponent().getLocation().y );
					jlTexto2.setLocation(ee.getX(),ee.getY());
					repaint();
				}
			});
			
			jlTexto2.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent ex) {
					if (ex.getClickCount()==2 && !ex.isConsumed()) {
						ex.consume();
						contenedor.add(PanelesDivisores.jpDerechoTexto,BorderLayout.EAST);
						PanelesDivisores.jpDerechoTexto.setVisible(true);
						PanelesDivisores.jtbBarraHerramienta.setVisible(false);
					}
				}
			});
			
			PanelesDivisores.jbAplicarTexto.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					jlTexto2.setText(PanelesDivisores.jtpCambiarTexto.getText());
					biCargaImagen=alImagen.get(Indic);
					ImagenDibujada oiDibujada=new ImagenDibujada(biCargaImagen, biCargaImagen.getWidth(),
							biCargaImagen.getHeight(), jlTexto2.getX(), jlTexto2.getY()+Tamanio);
					String c=jlTexto2.getText();
					Font f=jlTexto2.getFont();
	
					System.out.println(c);
					alImagen.add(oiDibujada.CrearImagenTexto(c,f));
					Ubicacion(0);
					PanelCentral();
					PanelesDivisores.jpDerechoTexto.setVisible(false);
					PanelesDivisores.jtbBarraHerramienta.setVisible(true);
					jlTexto2.setVisible(false);
					contenedor.remove(PanelesDivisores.jpDerechoTexto);
				}
			});
			
			PanelesDivisores.jbCerrar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					Indic=0;
					alImagen.clear();
					jlContenedor.setIcon(null);
				}
			});

			this.setVisible(true);		
	}//Fin Constructor
	
	public void PanelCentral() {
		Border bBorde = LineBorder.createGrayLineBorder();
        bImage = alImagen.get(Indic);
		jlContenedor.setIcon(new ImageIcon(bImage));
		jlContenedor.setPreferredSize(new Dimension(bImage.getTileWidth(),bImage.getHeight()));
		jlContenedor.setBorder(bBorde);
		jpanelCentral.add(jlContenedor);
		this.getContentPane().add(jpanelCentral,BorderLayout.CENTER);
		setVisible(true);
	}
	
//=====================================
	
	private int Ubicacion(int x) {
		switch(x){
			case 0:{
				Indic=alImagen.size();
				Indic=Indic-1;
				System.out.println(Indic);
			break;	
			}
			case 1:{
				Indic=Indic-1;
				System.out.println(Indic);
			break;	
			}
			case 2:{
					Indic=Indic+1;
					System.out.println(Indic);
			}break;
		}
		
		if (Indic<0) {
			Indic=0;
			System.out.println(Indic);
		}
		
		if(Indic>alImagen.size()-1) {
			Indic=alImagen.size()-1;
			System.out.println(Indic);
		}
		
		return Indic;
	}

	private BufferedImage abrirImagen(){
	       
        BufferedImage biContenedorImg=null;
        JFileChooser jfcSelecImagen=new JFileChooser();
        jfcSelecImagen.setDialogTitle(" Abrir imagen ...");
        FileNameExtensionFilter fnefExtension = new FileNameExtensionFilter("JPG  GIF  BMP", "jpeg","jpg", "gif", "bmp");
        jfcSelecImagen.setFileFilter(fnefExtension);
        jfcSelecImagen.setMultiSelectionEnabled(false);
        int RespuestaA=jfcSelecImagen.showOpenDialog(null);
        if(RespuestaA==JFileChooser.APPROVE_OPTION){
           try {
                File ImagenSeleccionada=jfcSelecImagen.getSelectedFile();
                biContenedorImg = ImageIO.read(ImagenSeleccionada);
                } catch (Exception e) {
           }      
        }
        return biContenedorImg;
    }
	
	private void GuardarComo(){
	      
        String sExtension="jpg";
        JFileChooser jfcGuardar=new JFileChooser();
        File fRutaArchivo;
        
        jfcGuardar.setDialogTitle(" Guardar Imagen ...");
        FileFilter ffFiltro=new FileNameExtensionFilter("*.jpg","jpg");
        FileFilter ffFiltro2=new FileNameExtensionFilter("*.gif","gif");
        FileFilter ffFiltro3=new FileNameExtensionFilter("*.bmp","bmp");
        FileFilter ffFiltro4=new FileNameExtensionFilter("*.png","png");
        jfcGuardar.addChoosableFileFilter(ffFiltro);
        jfcGuardar.addChoosableFileFilter(ffFiltro2);
        jfcGuardar.addChoosableFileFilter(ffFiltro3);
        jfcGuardar.addChoosableFileFilter(ffFiltro4);
       
        jfcGuardar.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        
        int Respuesta=jfcGuardar.showSaveDialog(null);
        if (Respuesta==JFileChooser.APPROVE_OPTION) {
           try {
        	   String c= jfcGuardar.getFileFilter().getDescription().toLowerCase();
        	   System.out.println(c);
        	   if (c.equals("*.jpg")){ 
        	   			sExtension="jpg";
        	   }
        	   if (c.equals("*.gif")){
        	   			sExtension="gif";
        	   }	
        	   if (c.equals("*.bmp")){
        		   sExtension="bmp";
        	   }
        	   if (c.equals("*.png")){
        		   sExtension="png";
        	   }
        	   fRutaArchivo=jfcGuardar.getSelectedFile();
                ImageIO.write(alImagen.get(Indic),sExtension,fRutaArchivo);
            
            } catch (Exception e) {
//            	JOptionPane.showMessageDialog(null, "Error en Elegir Extensión");
            }
        }
                 
    }
}



