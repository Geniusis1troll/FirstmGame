package engine.from.game;

import javax.swing.JFrame;

public class Engine {

	public static void main(String[] args) {
		
		JFrame f = new JFrame("First Game");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(640, 480);
		f.setResizable(false);
		f.add(new Road());
		
		
		f.setVisible(true);
		
	}

}
