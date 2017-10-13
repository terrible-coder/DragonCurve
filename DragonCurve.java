import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;

class DragonCurve{
	PVector start, end;
	boolean left;
	int level;
	DragonCurve f1, f2;
	
	DragonCurve(PVector start, PVector end, boolean left, int level){
		this.start = start;
		this.end = end;
		this.left = left;
		this.level = level;
		f1 = null;
		f2 = null;
	}
	
	PVector getMidpoint(){
		PVector mp = PVector.sub(this.end, this.start);
		double m = mp.mag();
		double angle = (this.left)? -Math.PI/4 : Math.PI/4;
		mp.rotate(angle);
		mp.setMag(m/Math.sqrt(2));
		mp.add(this.start);
		return mp;
	}
	
  //map coordinate space to color space
  //by using the coordinates of mid-point of each segment
	Color getColor(){
		double mx = (start.x + end.x)/2;
    double my= (start.y + end.y)/2;
    double d = Math.sqrt(mx*mx + my*my);
		mx = Math.PI*mx/180;
		my = Math.PI*my/180;
		d = Math.PI*d/180;
    
		float r = (float)(Math.abs(Math.sin(mx)));
    float g = (float)(Math.abs(Math.sin(my)));
    float b = (float)(Math.abs(Math.sin(d)));
		return new Color(r, g, b, 1.0f);
	}
	
	void render(Graphics g){
		Graphics2D g2d = (Graphics2D)g.create();
		if(level == DragonScreen.iterations){
			g2d.setColor(getColor());
			g2d.draw(new Line2D.Double(start.x, start.y, end.x, end.y));
		}
    else{
			if(f1 == null && f2 == null){
				PVector midPt = getMidpoint();
				f1 = new DragonCurve(this.start, midPt, true, this.level+1);
				f2 = new DragonCurve(midPt, this.end, false, this.level+1);
			}
			f1.render(g);
			f2.render(g);
		}
		g2d.dispose();
	}
}
