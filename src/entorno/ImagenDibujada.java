package entorno;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class ImagenDibujada extends Imagen{
	private int x;
	private int y;
	public ImagenDibujada(BufferedImage biI, int alto, int ancho,int x, int y) {
		super(biI, alto, ancho);
		this.x=x;
		this.y=y;
	}
	
	public BufferedImage CrearImagenTexto(String sCadena,Font f) {

		Graphics2D gi = (Graphics2D) biI.getGraphics();
		

		gi.setColor(Color.red);
		gi.setFont(new Font(f.getFontName(),f.getStyle(),f.getSize()));

		gi.drawString(sCadena, x, y);
		
		gi.dispose();
		
		return biI;
	}
	
	
	

}
