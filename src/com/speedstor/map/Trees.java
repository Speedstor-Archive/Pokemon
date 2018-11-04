package com.speedstor.map;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import com.speedstor.main.LoadImage;
import com.speedstor.main.Main;
import com.speedstor.main.Objects;

public class Trees extends Objects{
	
	public static double x, y, xSpeed, ySpeed;
	LoadImage loader;
	BufferedImage img;
	private static double shx;
	
	public Trees(String path, LoadImage loader) {
		this.loader = loader;
		
		img = loader.Load(path);
		
	}

	private double temp;
	
	@Override
	public void render(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		shx = (x + 145 - (Main.width/2)) / 6500;
		temp = 220 + y / 20;
		g2.shear(shx, 0);
		g.drawImage(img, (int) x,(int)( y - temp/2), 255, (int)temp , null);

		//g.fillRect( (int) x,(int)( y - temp/2), 290, (int)temp );
		g2.shear(-shx, 0);
		
		System.out.println(temp);
		
	}

	@Override
	public void tick() {
		x += xSpeed;
		y += ySpeed;
	}

}
