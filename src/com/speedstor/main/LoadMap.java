package com.speedstor.main;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Scanner;

public class LoadMap extends Objects{
	//Variables
		int[][] map;
		Handler handler;
		int row = 0, col;
		LoadImage loadImage;
		BufferedImage temp;
		
	public LoadMap(String location, Handler handler) {
		loadImage = new LoadImage();
		this.handler = handler;
		try {
			File file = new File(location);
			Scanner s = new Scanner(file);
			boolean holder = false;
			for(int i=0; s.hasNextInt(); i++) {
				if(s.nextInt() == 1) {
					row ++;
					if(holder == false) {
						col = i;
						holder = true;
					}
				}
			}
			map = new int[col][row];
			System.out.println("The dimensions of the Map is " + col + " x " + row );
			s.close();
		}catch(Exception e) {
			System.out.println("cannot read file");
		}
		
		try {
			Scanner s2 = new Scanner(new File(location));
			int c = 0, r = 0;
			while(s2.hasNextInt()) {
				int temp = s2.nextInt();
				if(temp != 1) {
					map[c][r] = temp;
					c++;
				}else if(temp == 1) {
					c = 0;
					r++;
				}
			}
			s2.close();
		}catch (Exception e){
			e.printStackTrace();
		}
		
		temp = loadImage.Load("/grassTile.png");
		
		System.out.println("Finished initlize of map files and textures");
	}
	
	public void tick() {
		
	}
	
	public void render(Graphics g) {
		
	}	
	
}
