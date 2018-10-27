package com.speedstor.main;

import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Window extends Canvas{
	private static final long serialVersionUID = -8461636171743760893L;

	public Window(int width, int height, String title, Main main) {
		JFrame frame = new JFrame();
		
		Dimension dimension = new Dimension(width, height);
		frame.setMaximumSize(dimension);
		frame.setMinimumSize(dimension);
		frame.setPreferredSize(dimension);
		
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(3);
		frame.add(main);
		frame.setTitle(title);
		frame.setResizable(false);
		
		main.start();
	}
}
