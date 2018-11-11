package gui;

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
import body.Sign;

public class RoadWindow  extends JFrame implements ActionListener{
	
	private static final long serialVersionUID = 1L;
	private JCheckBox voit = new JCheckBox();
	private JButton pause = new JButton();
	private JLabel vitesse = new JLabel();
	private final double CONVERTISSEUR = 3.6;
	
	public RoadWindow(TreeMap<Position, Sign> signs) {
		super();
		this.setSize(1366, 768);
		this.setLayout(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		this.add(pause);
		pause.addActionListener(this);
		pause.setBounds(10, 10, 30, 30);
		
		voit.setIcon(new ImageIcon("img/car.png"));
		this.add(voit);
		voit.setBounds(0, 280, 7, 15);
		
		this.add(vitesse);
		vitesse.setBounds(650, 10, 60, 60);
		
		setSigns(signs);
		this.setVisible(true);
	}
	
	private void setSigns(TreeMap<Position, Sign> signs) {
		for (Entry<Position, Sign> entry : signs.entrySet())
		{
			JCheckBox s = new JCheckBox();
			
			if(entry.getValue().getSpeedLimit()<32 && entry.getValue().getSpeedLimit()>=30)
				s.setIcon(new ImageIcon("img/110.png"));
			else if(entry.getValue().getSpeedLimit()<30 && entry.getValue().getSpeedLimit()>=24)
				s.setIcon(new ImageIcon("img/90.png"));
			else if(entry.getValue().getSpeedLimit()<24 && entry.getValue().getSpeedLimit()>=19)
				s.setIcon(new ImageIcon("img/70.png"));
			else if(entry.getValue().getSpeedLimit()<19 && entry.getValue().getSpeedLimit()>=13)
				s.setIcon(new ImageIcon("img/50.png"));
			else if(entry.getValue().getSpeedLimit()<13 && entry.getValue().getSpeedLimit()>=8)
				s.setIcon(new ImageIcon("img/teleToll30.png"));
			else if(entry.getValue().getSpeedLimit()==0)
				s.setIcon(new ImageIcon("img/Toll.png"));
			
			this.add(s);
			s.setBounds((int)entry.getKey().getX(), 200, 60, 50);
		}
		
	}


	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource()==pause) {
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public Object getVoit() {
		return voit;
	}

	public void actualiseVoit(int x) {
		this.voit.setBounds(x, 280, 7, 15);
		
	}

	public void actualiseVitesse(double speed) {
		this.vitesse.setText(""+(int)speed*CONVERTISSEUR );
		
	}

}
