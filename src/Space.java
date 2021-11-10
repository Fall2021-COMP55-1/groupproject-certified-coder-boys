class Space{
  double x;
  double y;

  public Space(double x, double y){
    this.x = x;
    this.y = y;
  }
  
  public Space() {
	  x = 0;
	  y = 0;
  }
  
  public void setX(double x) {
	  this.x = x;
  }
  
  public void setY(double y) {
	  this.y = y;
  }
  
  public double getX() {
	  return x;
  }
  
  public double getY() {
	  return y;
  }
}