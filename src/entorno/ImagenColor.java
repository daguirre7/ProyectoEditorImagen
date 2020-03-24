package entorno;

import java.awt.image.BufferedImage;

public class ImagenColor extends Imagen{
	
	

	public ImagenColor(BufferedImage biI, int alto, int ancho, int altto,
			int antcho) {
		super(biI, alto, ancho);

	}




	public BufferedImage AplicarEscalaGrises() {
		int iPromedio;
        int iPixel,iAlfa,iR,iG,iB;        
        for( int i = 0; i < Alto; i++ ){
            for( int j = 0; j <  Ancho; j++ ){
                iPixel= biI.getRGB(j, i);
                iAlfa=(iPixel>>24)&0xff;
                iR=(iPixel>>16)&0xff;
                iG=(iPixel>>8)&0xff;
                iB=iPixel&0xff;
                                           
                iPromedio=(iR+iG+iB)/3;
                iPixel=(iAlfa<<24 | iPromedio<<16 | iPromedio<<8 | iPromedio);
                  
                biI.setRGB(j, i,iPixel);
            }
        }
        return biI;
	} 

	public BufferedImage AplicarSepia() {
	
		int iPixel,iAlfa,iR,iG,iB;
		for(int i=0;i < Alto;i++) {
			for(int j=0;j < Ancho;j++) {
				iPixel=biI.getRGB(j, i);
				iAlfa=(iPixel>>24)&0xff;
				iR=(iPixel>>16)&0xff;
				iG=(iPixel>>8)&0xff;
				iB=iPixel&0xff;
				
				int iNuevoR = (int)(0.393*iR + 0.769*iG + 0.189*iB);
				int iNuevoG = (int)(0.349*iR + 0.686*iG + 0.168*iB);
				int iNuevoB =(int)(0.272*iR + 0.534*iG + 0.131*iB);
				
				if(iNuevoR>255) {
					iR=255;
				}else {
					iR=iNuevoR;
				}
				
				if(iNuevoG>255) {
					iR=255;
				}else {
					iR=iNuevoG;
				}
				
				if(iNuevoB>255) {
					iR=255;
				}else {
					iR=iNuevoB;
				}

				iPixel=(iAlfa<<24|iR<<16|iG<<8)|iB;
				biI.setRGB(j, i, iPixel);
			}
		}
		return biI;
	}
}
