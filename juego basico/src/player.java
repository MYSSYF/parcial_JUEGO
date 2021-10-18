
import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PImage;

public class player {
	private int x, y, d, r, g, b;
	PImage playa;

	public player(int x, int y, PImage vv) {
		this.x = x;
		this.y = y;
		this.d = 50;
		this.playa = vv;
		r = (int) (Math.random() * 255);
		g = (int) (Math.random() * 255);
		b = (int) (Math.random() * 255);
	}

	public void pintar(PApplet app) {
		app.image(playa, x, y-30 ,130,120);


	}

	public PImage getPlaya() {
		return playa;
	}

	public void setPlaya(PImage playa) {
		this.playa = playa;
	}

	public void caer(int v) {

		y += v;

	}

	public void subir(int v) {

		y -= v;

	}

	public void col(int px, int py, int dx, int dy) {
		if (x < px + (dx / 2) && x > px - (dx / 2) && y > py - (dy / 2) && y < py + (dy / 2)) {
			y = py - (dy / 2);
		}

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
