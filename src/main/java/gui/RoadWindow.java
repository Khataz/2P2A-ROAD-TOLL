package gui;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map.Entry;
import java.util.TreeMap;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

import body.Position;
import body.SpeedLimiter;

public class RoadWindow extends JFrame implements ActionListener{
	
	private static final long serialVersionUID = 1L;
	public JCheckBox voit = new JCheckBox();
	public JLabel vitesse = new JLabel();
	public final double CONVERTISSEUR = 3.6;
	public Image icon;
	public TreeMap<Position, SpeedLimiter> signs;
	
	public RoadWindow(TreeMap<Position, SpeedLimiter> signs) {
		super();
		this.setTitle("Projet 2P2A-ROAD-TOLL");
		this.setSize(1366, 768);
		this.setLayout(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		this.signs = signs;
		this.setVisible(true);
	}
	
	protected void setSigns(TreeMap<Position, SpeedLimiter> signs) {
		for (Entry<Position, SpeedLimiter> entry : signs.entrySet())
		{
			JCheckBox s = new JCheckBox();
			
			this.add(s);
			s.setBounds((int)entry.getKey().getX(), 200, 0, 0);
		}
		
	}

	public Object getVoit() {
		return voit;
	}

	public void actualiseVoit(int x) {
		this.voit.setBounds(x, 299, 45, 12);
		this.voit.setOpaque(false);
		
	}

	public void actualiseVitesse(double speed) {
		this.vitesse.setText(""+(int)speed*CONVERTISSEUR );
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
