package com.speedstor.main;

import java.awt.Graphics;
import java.util.LinkedList;

public class Handler {
	public static LinkedList<Objects> objects = new LinkedList<Objects>();
	
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
		int x = objects.size() - 1;
		objects.add( x , object);
	}
	
	public void addObjectUnder(Objects object) {
		objects.add(1, object);
	}
	
	public void addObjectCustom(int u, Objects object) {
		objects.add(u, object);
	}
	
	public void addObject2(Objects object) {
		int u = objects.size() - 2;
		objects.add(u, object);
	}
	
	public void addObjectUnderMost(Objects object) {
		objects.add(0, object);
	}
	
	public void addObjectTopMost(Objects object) {
		objects.add(object);
	}
	
	public void removeObject(Objects object) {
		objects.remove(object);
	}
	
	public void removeAllObjects() {
		addObject(new ChangeScene(255, 255 ,255, this));	
	}
	
	public static void HaHaHardCodingWhatYouGonnaDo() {
		int wa = objects.size();
		for(int i = wa - 3; i >= 0; i--) {
			objects.remove(objects.get(i));
			System.out.println("hi");
		}
	}
}
