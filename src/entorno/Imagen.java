package entorno;

import java.awt.image.BufferedImage;

public abstract class Imagen {
	protected BufferedImage biI;
	protected int Alto,Ancho;

	
	public Imagen(BufferedImage biI, int alto, int ancho) {
		super();
		this.biI = biI;
		Alto = alto;
		Ancho = ancho;
	}


	public BufferedImage getBiI() {
		return biI;
	}


	public void setBiI(BufferedImage biI) {
		this.biI = biI;
	}



	public int getAlto() {
		return Alto;
	}



	public void setAlto(int alto) {
		Alto = alto;
	}



	public int getAncho() {
		return Ancho;
	}



	public void setAncho(int ancho) {
		Ancho = ancho;
	}


	
	
}
