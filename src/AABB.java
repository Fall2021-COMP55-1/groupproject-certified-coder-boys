
public class AABB {
	public double x;
	public double y;
	public double height;
	
	public double getX() {
		return x;
	}
	public void setX(double x) {
		this.x = x;
	}
	public double getY() {
		return y;
	}
	public void setY(double y) {
		this.y = y;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	public double getWidth() {
		return width;
	}
	public void setWidth(double width) {
		this.width = width;
	}
	public double width;
	
	
	public AABB(double x, double y, double height, double width) { // starts at the top left of the object
		// TODO Auto-generated constructor stub
		this.x = x;
		this.y = y;
		this.height = height;
		this.width = width;
	}
	public AABB() {
		// TODO Auto-generated constructor stub
	}
	public boolean collisionAABBB(AABB box) {
		if(box.getX() > (box.getX()+box.getWidth()) || x >(box.getX()+box.getWidth())) {
			
			return false;
		}
		// add for y
		return true;
	}
	
}
