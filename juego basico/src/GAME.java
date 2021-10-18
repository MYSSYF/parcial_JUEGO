import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PImage;

public class GAME extends PApplet {

	public static void main(String[] args) {
		PApplet.main("GAME");
	}

	@Override
	public void settings() {
		size(1200, 700);

	}

	int pantalla;
	int kray, aire, kairi;
	int x, y;
	int kray2, aire2, kairi2;
	int x2, y2;
	int permiso, permiso2;
	int punta, punta2;
	int verf2, cont;
	int verf, cont2, cont3;
	player pepis;
	ArrayList<player> jug;

	plata cf;
	ArrayList<plata> plattop;
	ArrayList<plata> platmid;
	ArrayList<plata> platbot;
	ArrayList<daño> damtop;
	ArrayList<daño> dammid;
	ArrayList<daño> dambot;
	ArrayList<cura> heno;
	boolean bajar;

	PImage titulo;
	PImage fondo;
	PImage b1;
	PImage piso;
	PImage player;
	PImage playerA;
	PImage roca;
	PImage comi;
	PImage conexio;

	@Override
	public void setup() {
		pantalla = 1;
		kray = 0;
		kairi = 0;
		aire = 0;
		permiso = 1;
		permiso2 = 1;
		punta = 0;
		verf2 = 0;
		cont = 0;
		verf = 0;
		cont2 = 0;
		x=700;
		y=-100;
		player = loadImage("img/jugador1.png");
		playerA = loadImage("img/jugador1agachado.png");

		plattop = new ArrayList<plata>();
		platmid = new ArrayList<plata>();
		platbot = new ArrayList<plata>();

		pepis = new player(x, y, player);
		jug = new ArrayList<player>();
		bajar = false;

		damtop = new ArrayList<daño>();
		dammid = new ArrayList<daño>();
		dambot = new ArrayList<daño>();

		heno = new ArrayList<cura>();

		titulo = loadImage("img/fondoPrincipal.png");
		fondo = loadImage("img/fondoJuego.png");
		b1 =loadImage("img/playBtn.png");
		piso = loadImage("img/base.png");
		roca = loadImage("img/piedra.png");
		comi = loadImage("img/premio.png");
		conexio = loadImage("img/conexionPantalla.jpg");
	}

	@Override
	public void draw() {
		background(100);
		System.out.println(mouseX+" "+mouseY);
		switch (pantalla) {

		case 1:

			image(titulo, 600, 350);
			imageMode(CENTER);
			image(b1, 600, 400);
			break;
		case 2:

			image(conexio, 600, 350);
			imageMode(CENTER);
			pepis.setY(-100);
			pepis.setX(700);
		
			break;
		case 3:
			image(fondo, 600, 350);



			for (int i = 0; i < 1; i++) {
				if (permiso2 == 1) {
					come();
				}
			}

			for (int i = 0; i < 2; i++) {
				if (permiso == 1) {

					creplataformasaribadas(i);
					creplataformasmedias(i);
					creplataformasbajas(i);

				}

				for (int j = 0; j < 1; j++) {
					if (permiso == 1) {
						makeithurttop(plattop.get(i).getX());
						makeithurtmid(platmid.get(i).getX());
						makeithurtbot(platbot.get(i).getX());
					}
				}
			}

			for (int i = 0; i < heno.size(); i++) {
				cura fas = heno.get(i);
				fas.pintar(this);
				fas.mover(10);

				if (dist(pepis.getX(), pepis.getY(), fas.getX(), fas.getY()) < 100) {
					System.out.println("pepis");

					punta += 100;
					heno.remove(i);
				}
				if (fas.getX() < -1000) {
					heno.remove(i);

				}
				permiso2 = 0;
			}

			for (int i = 0; i < plattop.size(); i++) {
				plata pin = plattop.get(i);
				pin.pintar(this);
				pin.mover(4);

				if (bajar == false) {
					pepis.col(pin.getX(), pin.getY(), pin.getD1(), pin.getD2() * 2);
				}

				permiso = 0;

				if (pin.getX() == (int) random(1500, 1200)) {
					creplataformasaribadas(i);
					makeithurttop(pin.getX());
				}

				if (pin.getX() < -1000) {
					plattop.remove(i);

				}
			}

			for (int i = 0; i < damtop.size(); i++) {
				daño pan = damtop.get(i);
				pan.pintar(this);
				pan.mover(4);
				if (dist(pepis.getX(), pepis.getY(), pan.getX(), pan.getY()) < 50) {
					punta -= 100;
					damtop.remove(i);
				}
				if (pan.getX() < -1000) {
					damtop.remove(i);
				}
				permiso = 0;
			}

			for (int i = 0; i < platmid.size(); i++) {
				plata pin = platmid.get(i);
				pin.pintar(this);
				pin.mover(4);
				if (bajar == false) {
					pepis.col(pin.getX(), pin.getY(), pin.getD1(), pin.getD2() * 2);
				}
				permiso = 0;
				if (pin.getX() == (int) random(1500, 1200)) {
					creplataformasmedias(i);
					makeithurtmid(pin.getX());
				}
				if (pin.getX() < -1000) {
					platmid.remove(i);
				}
			}

			for (int i = 0; i < dammid.size(); i++) {
				daño pan = dammid.get(i);
				pan.pintar(this);
				pan.mover(4);
				if (dist(pepis.getX(), pepis.getY(), pan.getX(), pan.getY()) < 50) {
					punta -= 100;
					dammid.remove(i);
				}
				if (pan.getX() < -1000) {
					dammid.remove(i);

				}
				permiso = 0;

			}
			for (int i = 0; i < platbot.size(); i++) {
				plata pin = platbot.get(i);
				pin.pintar(this);
				pin.mover(4);
				if (bajar == false) {
					pepis.col(pin.getX(), pin.getY(), pin.getD1(), pin.getD2() * 2);
				}
				if (pin.getX() == (int) random(1500, 1200)) {
					creplataformasbajas(i);
					makeithurtbot(pin.getX());
				}
				if (pin.getX() < -1000) {
					platbot.remove(i);
				}
			}
			for (int i = 0; i < dambot.size(); i++) {
				daño pan = dambot.get(i);
				pan.pintar(this);
				pan.mover(4);
				if (dist(pepis.getX(), pepis.getY(), pan.getX(), pan.getY()) < 50) {
					punta -= 100;
					dambot.remove(i);
				}
				if (pan.getX() < -1000) {
					dambot.remove(i);
				}
				permiso = 0;

			}
			for (int i = 0; i < 1; i++) {
				newplayer1();
			}
			pepis.pintar(this);

			saltar();
			metecho();

			//pepis.col(600, 700, 5000, pepis.getDiam());
			if(pepis.getY()>1000) {
				pantalla=1;
			}
			cont2++;
			if (cont2 >= 60) {
				come();
				cont2 = 0;
			}
			textSize(30);
			text("puntaje P1 : " + punta, 100, 100);
			text("puntaje P2 : " + punta2, 500, 100);
			break;

		default:
			break;
		}

	}

	private void newplayer1() {
		player gif = new player(x, y, player);
		jug.add(gif);

	}

	private void creplataformasaribadas(int c) {
		plata pan = new plata(2000 + (c * 300), 200, 440, 10, piso);
		plattop.add(pan);

	}

	private void creplataformasmedias(int c) {
		plata pan = new plata(2200 + (c * 300), 400, 440, 10, piso);
		platmid.add(pan);

	}

	private void creplataformasbajas(int c) {
		plata pan = new plata(1900 + (c * 300), 600, 440, 10, piso);
		platbot.add(pan);

	}

	private void makeithurttop(int v) {
		daño tim = new daño(v, 160, roca);
		damtop.add(tim);
	}

	private void makeithurtmid(int v) {
		daño tim = new daño(v, 360, roca);
		dammid.add(tim);
	}

	private void makeithurtbot(int v) {
		daño tim = new daño(v, 560, roca);
		dambot.add(tim);
	}

	private void come() {
		cura fen = new cura((int) random(1500, 1700), (int) random(100, 600), comi);
		heno.add(fen);
	}

	private void saltar() {
		switch (kray) {
		case 0:

			pepis.caer(4);

			break;
		case 1:
			pepis.subir(8);
			break;

		default:
			break;
		}

	}

	private void metecho() {
		if (kray == 1) {
			aire++;
			kairi++;
			if (aire >= 40) {
				aire = 0;
				kray = 0;

			}
		}

	}

	@Override
	public void keyPressed() {

		if (key == 'd') {
			pepis.setX(x += 20);
		}
		if (key == 'a') {
			pepis.setX(x -= 20);
		}
		if (key == ' ') {
			kray = 1;
		}
		if (key == 's') {
			bajar = true;
			pepis.setPlaya(playerA);
		}
	}

	@Override
	public void keyReleased() {
		if (key == 's') {
			bajar = false;
			pepis.setPlaya(player);

		}
	}
	@Override
	public void mouseClicked() {
if(pantalla==1) {
	if(mouseX>450&&mouseX<750&&mouseY>360&&mouseY<440) {
		pantalla++;
	}
}
if(pantalla==2) {
	if(mouseX>290&&mouseX<590&&mouseY>520&&mouseY<580) {
		pantalla++;
	}
}
	}

}
