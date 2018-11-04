package com.speedstor.Input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import com.speedstor.debug.DebugScreen;
import com.speedstor.main.Handler;
import com.speedstor.map.MapRender;
import com.speedstor.players.Player1;

public class Input implements KeyListener, MouseListener{
		
	public static boolean keyChange;
	public int speedInit, speedFinal, direction;
	Handler handler;
	
	public Input(Handler handler) {
		this.handler = handler;
		toggleDebug();
	}
	
	public void keyPressed(KeyEvent e) {
		int k = e.getKeyCode();
		
		
		if(k == 16) Player1.speed = 1.5;
		
			if(k == 87 || k == 38) { //up
				if(!MapRender.down) {
					MapRender.up = true;  
					MapRender.direction = 1;
				}
				if(MapRender.left || MapRender.right) {Player1.facing = 1; keyChange = true;}
			}else if(k == 83 || k == 40) { //down
				if(!MapRender.up) {
					MapRender.down = true;  
					MapRender.direction = 2;
				}
				if(MapRender.left || MapRender.right) {Player1.facing = 2; keyChange = true;}
			}else if(k == 65 || k == 37) { //left
				if(!MapRender.right) {
					MapRender.left = true; 
					MapRender.direction = 3;
				}
				if(MapRender.up || MapRender.down) {Player1.facing = 3; keyChange = true;}
			}else if(k == 68 || k == 39) { //right
				if(!MapRender.left) {
					MapRender.right = true; 
					MapRender.direction = 4;
				}
				if(MapRender.up || MapRender.down) {Player1.facing = 4; keyChange = true;}
			}
		

			//if(k == 84) Trees.ySpeed = -0.5;
			//else if(k == 71) Trees.ySpeed = 0.5;
			//else if(k == 70) Trees.xSpeed = -0.5;
			//else if(k == 72) Trees.xSpeed = 0.5;
			
	}


	public void keyReleased(KeyEvent e) {
		int k = e.getKeyCode();
		
		if(k == 16) Player1.speed = 0.5;
		
		//for redirecting after interruptions
		if(k == 87 || k == 38) {
			MapRender.up = false; 
			if(MapRender.right) {MapRender.direction = 4; Player1.facing = 4; keyChange = true;}
			else if(MapRender.left) {MapRender.direction = 3; Player1.facing = 3; keyChange = true;}
		}else if(k == 83 || k == 40) {
			MapRender.down = false;
			if(MapRender.right) {MapRender.direction = 4; Player1.facing = 4; keyChange = true;} 
			else if(MapRender.left) {MapRender.direction = 3; Player1.facing = 3; keyChange = true;} 
		}else if(k == 65 || k == 37) {
			MapRender.left = false; 
			if(MapRender.up) {MapRender.direction = 1; Player1.facing = 1; keyChange = true;}
			else if(MapRender.down) {MapRender.direction = 2; Player1.facing = 2; keyChange = true;} 
			
		}else if(k == 68 || k == 39) {
			MapRender.right = false; 
			if(MapRender.up) {MapRender.direction = 1; Player1.facing = 1; keyChange = true;}
			else if(MapRender.down) {MapRender.direction = 2; Player1.facing = 2; keyChange = true;}
		}
		
		if(k == 50) toggleDebug();
		
		//if(k == 84) Trees.ySpeed = 0;
		//else if(k == 71) Trees.ySpeed = 0;
		//else if(k == 70) Trees.xSpeed = 0;
		//else if(k == 72) Trees.xSpeed = 0;
		
		
		//System.out.println(k);
		
	}
	
	
	//toggle debug screen
	private boolean debug = false;
	DebugScreen debugScreen = new DebugScreen(handler);
	public void toggleDebug() {
		if(!debug) {handler.addObject(debugScreen); debug = true;}
		else if(debug) {handler.removeObject(debugScreen); debug = false;}
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
