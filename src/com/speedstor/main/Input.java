package com.speedstor.main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Input implements KeyListener, MouseListener{
		
	public void keyPressed(KeyEvent e) {
		int k = e.getKeyCode();
		Main.key = e.getKeyCode();
		
		if(k == 87 || k == 38) MapRender.ySpeed = 1;
		if(k == 83 || k == 40) MapRender.ySpeed = -1;
		if(k == 65 || k == 37) MapRender.xSpeed = 1;
		if(k == 68 || k == 39) MapRender.xSpeed = -1;
	}

	
	public void keyReleased(KeyEvent e) {
		int k = e.getKeyCode();
		
		if(k == 87 || k == 38) MapRender.ySpeed = 0;
		if(k == 83 || k == 40) MapRender.ySpeed = 0;
		if(k == 65 || k == 37) MapRender.xSpeed = 0;
		if(k == 68 || k == 39) MapRender.xSpeed = 0;
		
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
