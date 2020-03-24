package entorno;
import java.awt.image.BufferedImage;

 public class ImagenRecortada extends Imagen{
	 private  int coordenadaX;
		private int coordenadaY;
		private int coordenadax1;
		private int coordenaday1;
		private int anchuraRect;
		private int alturaRect;
        
		public BufferedImage poo;
	
	 
	 public ImagenRecortada(BufferedImage biI, int alto, int ancho, int x,int y, int x2,int y2) {
		super(biI, alto, ancho);
		this.coordenadaX = x;
	    this.coordenadaY= y;
		this.coordenadax1 =x2;		
		this.coordenaday1=y2;

		}

	public  BufferedImage CortarImagen() {
		anchuraRect= Math.abs(coordenadaX-coordenadax1);
		alturaRect=Math.abs(coordenadaY-coordenaday1);
		BufferedImage croppedImage =biI.getSubimage(coordenadaX, coordenadaY, anchuraRect, alturaRect);
		
		return croppedImage;
		
	}
}
		