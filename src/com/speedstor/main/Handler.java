package com.speedstor.main;

import java.awt.Graphics;
import java.util.LinkedList;

public class Handler {
	LinkedList<Objects> objects = new LinkedList<Objects>();
	
	public void tick() {
		for(int i = 0; i < objects.size(); i++){
			Objects tempObject = (Objects)objects.get(i);
			tempObject.tick();
		}
	}
	
	public void render(Graphics g) {
		for(int i = 0; i < objects.size(); i++){
			Objects tempObject = (Objects)objects.get(i);
			tempObject.render(g);
		}
	}
	
	public void addObject(Objects object) {
		objects.add(object);
	}
	
	public void removeObject(Objects object) {
		objects.remove(object);
	}
}
