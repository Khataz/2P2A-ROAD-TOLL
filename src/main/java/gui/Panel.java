package gui;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.TreeMap;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import body.Position;
import body.SpeedLimiter;

public class Panel extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8671216388865004808L;
	
	private RoadWindow window;
	private JCheckBox voit;
	private JLabel vitesse;
	private TreeMap<Position, SpeedLimiter> signs;

	public Panel(RoadWindow window, JCheckBox voit, JLabel vitesse, TreeMap<Position, SpeedLimiter> signs) {
		this.window = window;
		this.voit = voit;
		this.vitesse = vitesse;
		this.signs = signs;
	}
	
	@Override
	public void paintComponent(Graphics g) {
		try {
			Image background = ImageIO.read(new File("img/bg.png"));

			g.drawImage(background, 0, 0, null);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		this.setSigns();
	}
	
	public void setSigns() {
		this.voit.setIcon(new ImageIcon("img/car.png"));
		this.window.add(this.voit);
		this.voit.setBounds(0, 299, 45, 12);
		this.voit.setOpaque(false);
		
		this.window.add(this.vitesse);
		this.vitesse.setBounds(650, 10, 60, 60);
		
		this.window.setSigns(this.signs);
	}
}
