import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PImage;

public class daño {
	private int x, y, d, r, g, b;
	PImage roca;

	public daño(int x, int y, PImage vv) {
		this.x = x;
		this.y = y;
		this.d = 50;
		this.roca = vv;
		r = 0;
		g = 0;
		b = 0;
	}

	public void pintar(PApplet app) {
	
		app.image(roca, x, y+20,80,90);
	}

	public int getR() {
		return r;
	}

	public void setR(int r) {
		this.r = r;
	}

	public int getG() {
		return g;
	}

	public void setG(int g) {
		this.g = g;
	}

	public int getB() {
		return b;
	}

	public void setB(int b) {
		this.b = b;
	}

	public void mover(int v) {

		x -= v;

	}

	public int getDiam() {
		return d;
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

}
