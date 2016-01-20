package engine.from.game;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Emeny {
	
	int x,y,v;
	Image bot = new ImageIcon("res/Car_bot.png").getImage();
	Road road;
	
	
	public Emeny(int x,int y,int v,Road road ){
		this.x = x;
		this.y = y;
		this.v = v;
		this.road = road;
	}
	
	public void move() {
		y = y - road.p.v - y;
	}
	
}
