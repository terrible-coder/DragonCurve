import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;

class DragonScreen extends JPanel {
	static int iterations = 1;
	
	DragonCurve f;
	int frameCount;
  
	DragonScreen(int width, int height){
		super();
		setSize(width, height);
		setLayout(null);
		setVisible(true);
		setFocusable(true);
		frameCount = 0;
		
		PVector start = new PVector(0.2*width, 0.5*height),
				end = new PVector(0.7*width, 0.5*height);
		f = new DragonCurve(start, end, true, 1);
	}
	
	@Override
	public void paintComponent(Graphics g){
		frameCount = (frameCount + 1)%200;
		if(frameCount == 0){
			iterations = (iterations + 1)%24;
			iterations = (iterations==0)? 1 : iterations;
			System.out.println(iterations);
		}
    
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, getWidth(), getHeight());
		f.render(g);
		repaint();
	}
}
