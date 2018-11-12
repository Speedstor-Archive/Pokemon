package com.speedstor.map;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Random;
import java.util.Scanner;

import com.speedstor.main.Handler;
import com.speedstor.main.LoadImage;
import com.speedstor.main.Main;
import com.speedstor.main.Objects;
import com.speedstor.players.Player1;

public class LoadMap extends Objects{
	//Variables
		static int[][] map;
		Handler handler;
		static int row = 0;
		static int col;
		static int buff;
		LoadImage loadImage;
		BufferedImage temp;
		static Random r;
		public static boolean upBlock = false, downBlock = false, rightBlock = false, leftBlock = false;
		static Main main;
		
	public LoadMap(String location, Handler handler, Main main) {
		LoadMap.main = main;
		r = new Random();
		loadImage = new LoadImage();
		this.handler = handler;
		loadFile(location);
		temp = loadImage.Load("/grassTile.png");
		
		System.out.println("Finished initlize of map files and textures");
	}
	

	public void tick() {
		
	}
	
	public static void barrier() {
		if(map[Player1.xLocation][Player1.yLocation] == 44) Monsters(30);
		
		buff = map[Player1.xLocation][Player1.yLocation - 1];
		if(buff == 2) upBlock = false;
		else if(buff == 77 || buff == 88) {upBlock = true;}

		buff = map[Player1.xLocation][Player1.yLocation+1];
		if(buff == 2) downBlock = false;
		else if(buff == 77 || buff == 88) downBlock = true;

		buff = map[Player1.xLocation - 1][Player1.yLocation];
		if(buff == 2) leftBlock = false;
		else if(buff == 77 || buff == 88) leftBlock = true;

		buff = map[Player1.xLocation+1][Player1.yLocation];
		if(buff == 2) rightBlock = false;
		else if(buff == 77 || buff == 88) rightBlock = true;
	}
	
	public static void Monsters(int chance){
		if(r.nextInt(chance) == 1) {
			System.out.println("yay");
			main.changeScene("hi");
		}
	}
	
	public void render(Graphics g) {
		
	}	
	
	private void loadFile(String location) {
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
	}
	
}
