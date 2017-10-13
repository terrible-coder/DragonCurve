import javax.swing.JFrame;

public class DragonSketch {
	public static void main(String args[]){
		JFrame f = new JFrame("Dragon Curve");
		f.setSize(1014, 740);
		f.setLayout(null);
		f.setVisible(true);
		
		f.add(new DragonScreen(1000, 700));
	}
}
