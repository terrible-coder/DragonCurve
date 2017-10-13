public class PVector {
	public double x, y;
	
  public PVector(){
		this(0, 0);
	}
  
	public PVector(double x){
		this(x, 0);
	}
  
	public PVector(double x, double y){
		this.x = x;
		this.y = y;
	}
  
	public void set(double x, double y){
		this.x = x;
		this.y = y;
	}
	
	public double mag(){
		return Math.sqrt(x*x + y*y);
	}
  
	public double angle(){
		return Math.atan2(y, x);
	}
	
	public void add(PVector b){
		this.x+=b.x;
		this.y+=b.y;
	}
  
	public void sub(PVector b){
		this.x-=b.x;
		this.y-=b.y;
	}
  
	public void rotate(double angle){
		double m = mag();
		double a = angle();
		set(Math.cos(a+angle), Math.sin(a+angle));
		mult(m);
	}
  
	public void mult(double scalar){
		this.x*=scalar;
		this.y*=scalar;
	}
  
	public void setMag(double m){
		normalise();
		mult(m);
	}
  
	public void normalise(){
		double a = angle();
		set(Math.cos(a), Math.sin(a));
	}
  
	public static PVector random2D(){
		double angle = Math.random()*Math.PI*2;
		return new PVector(Math.cos(angle), Math.sin(angle));
	}
  
	public static PVector fromAngle(double angle){
		return new PVector(Math.cos(angle), Math.sin(angle));
	}
  
	public static PVector sub(PVector a, PVector b){
		return new PVector(a.x - b.x, a.y - b.y);
	}
}
