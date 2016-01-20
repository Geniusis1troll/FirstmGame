package engine.from.game;

import java.awt.Image;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Player {
	
	public static final int MAX_V = 50;
	public static final int MIN_V = 0;
	public static final int MAX_TOP = 0;
	public static final int MIN_TOP = 532;
	
	Image img = new ImageIcon("res/Car_up.png").getImage();
	Image img_LEFT = new ImageIcon("res/Car_left.png").getImage();
	Image img_RIGHT = new ImageIcon("res/Car_right.png").getImage();
	
	int v = 0;
	int dv = 0;
	int s = 0;
	
	int x = 370;
	int y = 240;
	int dx = 0;
	
	int layer1 = -480;
	int layer2 = -960;
	
	public void move(){
		s += v;
		v += dv;
		x += dx;
		if(v >= MAX_V) v = MAX_V;
		if(v <= MIN_V) v = MIN_V;
		if(x <= MAX_TOP) x = MAX_TOP;
		if(x >= MIN_TOP) x = MIN_TOP;
		if(layer2 - v >= 0){
			layer1 = -480;
			layer2 = -960;
		}else{
			layer1 += v;
			layer2 += v;
		}
	}
	
	public void keyPreseed(KeyEvent e){
		int key = e.getKeyCode();
		if (key == KeyEvent.VK_UP){
			dv = 1;
		}
		if (key == KeyEvent.VK_DOWN){
			dv = -1;
		}
		if (key == KeyEvent.VK_LEFT){
			if(v > MIN_V){
				dx = -12;
			}
		}
		if (key == KeyEvent.VK_RIGHT){
			if(v > MIN_V){
				dx = 12;
			}
		}
	}
	
	public void keyReleased(KeyEvent e){
		int key = e.getKeyCode();
		if (key == KeyEvent.VK_UP){
			dv = 0;
		}
		if (key == KeyEvent.VK_DOWN){
			dv = 0;
		}
		if (key == KeyEvent.VK_LEFT){
			dx = 0;
		}
		if (key == KeyEvent.VK_RIGHT){
			dx = 0;
		}
	}
	
}
