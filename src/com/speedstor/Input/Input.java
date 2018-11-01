package com.speedstor.Input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import com.speedstor.main.Main;
import com.speedstor.map.MapRender;
import com.speedstor.players.Player1;

public class Input implements KeyListener, MouseListener{
		
	
	public int speedInit, speedFinal, direction;
	
	public void keyPressed(KeyEvent e) {
		int k = e.getKeyCode();
		Main.key = e.getKeyCode();
		
		if(k == 16) Player1.speed = 1.5;
		
			if(k == 87 || k == 38) { //up
				if(!MapRender.down) {
					MapRender.up = true;  
					MapRender.direction = 1;
				}
			}else if(k == 83 || k == 40) { //down
				if(!MapRender.up) {
					MapRender.down = true;  
					MapRender.direction = 2;
				}
			}else if(k == 65 || k == 37) { //left
				if(!MapRender.right) {
					MapRender.left = true; 
					MapRender.direction = 3;
				}
			}else if(k == 68 || k == 39) { //right
				if(!MapRender.left) {
					MapRender.right = true; 
					MapRender.direction = 4;
				}
			}
		
	}


	public void keyReleased(KeyEvent e) {
		int k = e.getKeyCode();
		
		if(k == 16) Player1.speed = 0.5;
		
		//for redirecting after interruptions
		if(k == 87 || k == 38) {
			MapRender.up = false; 
			if(MapRender.right) {MapRender.direction = 4;}
			else if(MapRender.left) {MapRender.direction = 3;}
		}else if(k == 83 || k == 40) {
			MapRender.down = false;
			if(MapRender.right) {MapRender.direction = 4;} 
			else if(MapRender.left) {MapRender.direction = 3;} 
		}else if(k == 65 || k == 37) {
			MapRender.left = false; 
			if(MapRender.up) {MapRender.direction = 1;}
			else if(MapRender.down) {MapRender.direction = 2;} 
			
		}else if(k == 68 || k == 39) {
			MapRender.right = false; 
			if(MapRender.up) {MapRender.direction = 1;}
			else if(MapRender.down) {MapRender.direction = 2;}
		}
		
	}

	
	public void keyTyped(KeyEvent e) {
		
		
	}


	
	public void mouseClicked(MouseEvent arg0) {
		
		
	}


	
	public void mouseEntered(MouseEvent arg0) {
		
		
	}


	
	public void mouseExited(MouseEvent arg0) {
		
		
	}


	
	public void mousePressed(MouseEvent arg0) {
		
		
	}


	
	public void mouseReleased(MouseEvent arg0) {
		
		
	}
	
}
