package engine.from.game;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Road extends JPanel implements ActionListener, Runnable {

	Timer mainTimer = new Timer(20, this);
	Image img = new ImageIcon("res//Road.jpg").getImage();
	Player p = new Player();
	Thread EF = new Thread(this);
	List<Emeny> enemies = new ArrayList<Emeny>();
	public Road(){
		EF.start();
		mainTimer.start();
		addKeyListener(new MKA());
		setFocusable(true);
		
	}
	private class MKA extends KeyAdapter {
		public void keyPressed(KeyEvent e){
			p.keyPreseed(e);
		}
		public void keyReleased(KeyEvent e){
			p.keyReleased(e);
		}
	}
	public void paint(Graphics g){
		g = (Graphics2D) g;
		g.drawImage(img, 0, p.layer1, null);
		g.drawImage(img, 0, p.layer2, null);
		g.drawImage(p.img, p.x, p.y, null);
		Iterator<Emeny> i = enemies.iterator();
		while(i.hasNext()){
			Emeny e = i.next();
			if(e.y >= 2500 || e.y <= -2500){
				i.remove();
			}else {
				e.move();
				g.drawImage(e.bot, e.x, e.y, null);
			}
		}
	}
	public void actionPerformed(ActionEvent e) {
		p.move();
		repaint();
	}
	@Override
	public void run() {
		Random rand = new Random();
		try {
			Thread.sleep(rand.nextInt(1000));
			enemies.add(new Emeny(rand.nextInt(600),0,rand.nextInt(60),this));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}