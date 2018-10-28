package com.speedstor.main;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

public class LoadImage {
	public BufferedImage Load(String path) {
		BufferedImage image = null;

		try {
			image = ImageIO.read(new File(path));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		//try { this.images.add(ImageIO.read(getClass().getResourceAsStream("/pipe-green.png")));
		//   } catch (IOException e) { e.printStackTrace(); }
		
		return image;
	}
}
