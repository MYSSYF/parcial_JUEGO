import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PImage;

public class plata {
	private int x, y, d1, d2, r, g, b;
	PImage piso;

	public plata(int x, int y, int d1, int d2, PImage vv) {
		this.x = x;
		this.y = y;
		this.d1 = d1;
		this.d2 = d2;
		this.piso = vv;
		r = (int) (Math.random() * 255);
		g = (int) (Math.random() * 255);
		b = (int) (Math.random() * 255);
	}

	public void pintar(PApplet app) {
		app.image(piso, x, y+30,500,80);

		
	}

	public void mover(int v) {

		x -= v;

	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getD1() {
		return d1;
	}

	public void setD1(int d1) {
		this.d1 = d1;
	}

	public int getD2() {
		return d2;
	}

	public void setD2(int d2) {
		this.d2 = d2;
	}

}
