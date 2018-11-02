package com.speedstor.main;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class LoadImage {
	BufferedImage image = null;
	
	public BufferedImage Load(String path) {
		
		try {
			image = ImageIO.read(getClass().getResource(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return image;
	}
	
	
	public ArrayList<BufferedImage> parImageAcross(BufferedImage imageInit, int x, int y, int width, int height, int cutWidth, int numOf) {
		ArrayList<BufferedImage> imageClip = new ArrayList<BufferedImage>();
		
		for(int i=1; i < numOf ; i++) {
			imageClip.add(imageInit.getSubimage(x, y, width, height));
			imageClip.add(imageInit.getSubimage(x + (cutWidth * i), y, width, height));
		}
		
		return imageClip;
	}
	
}
	

