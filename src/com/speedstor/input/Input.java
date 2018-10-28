package com.speedstor.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import com.speedstor.main.Main;
import com.speedstor.map.MapRender;

public class Input implements KeyListener, MouseListener{
		
	public void keyPressed(KeyEvent e) {
		int k = e.getKeyCode();
		Main.key = e.getKeyCode();
		
		if(k == 87 && k == 38) MapRender.up = true;
		//if(k == )
		
	}

	
	public void keyReleased(KeyEvent e) {
		
		
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
