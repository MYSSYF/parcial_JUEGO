

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class comis extends Thread {
	BufferedWriter brezzit;
	BufferedReader cholistrin;
	GAME app;

	private String namin;
	private int cuant;
	private int permiso;

	private int sx;
	private int sy;
	private int r, g, b;

	public comis(GAME app) {
		this.app = app;

	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		inici();
	}

	public void inici() {

		try {
			System.out.println("wayando");
			ServerSocket fribo = new ServerSocket(1140);
			System.out.println("tu ri turi qui");
			Socket conexio = fribo.accept();
			System.out.println("*sonidos inenteligibles*");

			InputStream CHOLO = conexio.getInputStream();
			InputStreamReader cholent = new InputStreamReader(CHOLO);
			cholistrin = new BufferedReader(cholent);

			OutputStream bassi = conexio.getOutputStream();
			OutputStreamWriter brasson = new OutputStreamWriter(bassi);
			brezzit = new BufferedWriter(brasson);

			System.out.println("el man no ha dicho nada");
			String saje = cholistrin.readLine();
			System.out.println("el dice " + saje);
			recibir();
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	private void recibir() {
		new Thread(() -> {
			while (true) {
				String saje;
				try {
					System.out.println("el man no ha dicho nada");
					saje = cholistrin.readLine();
					System.out.println("el dice " + saje);

					System.out.println(sy);

				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		}).start();

	}

	public String getNamin() {
		return namin;
	}

	public void setNamin(String namin) {
		this.namin = namin;
	}

	public int getCuant() {
		return cuant;
	}

	public void setCuant(int cuant) {
		this.cuant = cuant;
	}

	public int getSx() {
		return sx;
	}

	public void setSx(int sx) {
		this.sx = sx;
	}

	public int getSy() {
		return sy;
	}

	public void setSy(int sy) {
		this.sy = sy;
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

	public int getPermiso() {
		return permiso;
	}

	public void setPermiso(int permiso) {
		this.permiso = permiso;
	}

}
