package entorno;

import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.awt.image.RescaleOp;

public class ImagenTransformada extends Imagen{
	private int iEstableceAlto,iEstableceAncho;


	public ImagenTransformada(BufferedImage biI, int alto, int ancho,
			int iEstableceAlto, int iEstableceAncho) {
		super(biI, alto, ancho);
		this.iEstableceAlto = iEstableceAlto;
		this.iEstableceAncho = iEstableceAncho;
	}




	public BufferedImage EscalarImagen(){
		BufferedImage biredimensionada = new BufferedImage(iEstableceAncho, iEstableceAlto, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2 = biredimensionada.createGraphics();
		g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		g2.drawImage(biI, 0, 0, iEstableceAncho, iEstableceAlto, null);
		g2.dispose();
	return biredimensionada;
	}
	
	public BufferedImage GenerarEspejo() {
		BufferedImage biEspejo=new BufferedImage(Ancho*2,Alto,BufferedImage.TYPE_INT_ARGB);
		int iPixel;
		for(int i=0;i<Alto;i++) {
			for(int lx=0, rx = Ancho*2-1 ; lx<Ancho; lx++ , rx--) {
					iPixel=biI.getRGB(lx, i);
					biEspejo.setRGB(lx, i, iPixel);
					biEspejo.setRGB(rx, i, iPixel);
			}
		}
		
		return biEspejo;
	}
	
	public BufferedImage VoltearImagen(boolean opx) {
		BufferedImage biVolteada=new BufferedImage(Ancho,Alto,BufferedImage.TYPE_INT_ARGB);
		int iPixel;
		for(int i=0;i<Alto;i++) {
			for(int j=0 ; j<Ancho; j++ ) {
					iPixel=biI.getRGB(j, i);
					if (opx==true){
						biVolteada.setRGB((Ancho-1)-j, i, iPixel); //Con respecto a X
					}else {
						biVolteada.setRGB(j, (Alto-1)-i, iPixel);  //Con respecto a Y
					}
			}
		}
		return biVolteada;
	}
	

    public BufferedImage RotarImagen(double dAnguloRotacion) {
        
        int transparency = biI.getColorModel().getTransparency();
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice gd = ge.getDefaultScreenDevice();
        GraphicsConfiguration gc = gd.getDefaultConfiguration();
    	BufferedImage biRotada= gc.createCompatibleImage(Alto,Ancho,transparency);
        AffineTransform at = AffineTransform.getRotateInstance(dAnguloRotacion, 
                Ancho/2, Alto/2);
        double dPuntoTraslacion = (Ancho-Alto)/2;
        if (dAnguloRotacion<0)
        	at.translate(-dPuntoTraslacion,-dPuntoTraslacion); 	
        else 
        	at.translate(dPuntoTraslacion,dPuntoTraslacion);
        Graphics2D gImagen = biRotada.createGraphics();
        gImagen.drawRenderedImage(biI, at);
        gImagen.dispose();
        return biRotada;
    }



    public BufferedImage Brillo(float reescala, float target) {
        BufferedImage bi = new BufferedImage(Ancho, Alto, BufferedImage.TYPE_INT_ARGB);
//        Graphics2D g = bi.createGraphics();
//        g.drawImage(biI, 0, 0, null);

        RescaleOp rescaleOp = new RescaleOp(1.0f, reescala, null);
       bi= rescaleOp.filter(biI, null);
        

        return bi;
    }

    
}
