import java.io.IOException;
import java.net.ServerSocket;
import processing.core.PApplet;
import java.net.Socket;
import java.util.ArrayList;

public class Main extends PApplet {

	private Socket sock;
	private ArrayList<Particula> particles;
	public int vel;

	public static void main(String[] args) {
		PApplet.main("Main");

	}

	public void settings() {
		size(1200, 700);
	}

	public void setup() {
		initServer();
		particles = new ArrayList<Particula>();
		for (int i = 0; i < 15; i++) {
			int posX = (int) random(20, 450);
			int posY = (int) random(20, 450);

			particles.add(new Particula(posX, posY, vel, this));

		}
	}

	public void draw() {
		background(0);
		for (Particula Particulas : particles) {
			Particulas.paint();
			new Thread(Particulas).start();
		}
	}

	public void initServer() {
		new Thread(() -> {
			try {
				@SuppressWarnings("resource")
				ServerSocket server = new ServerSocket(8000);

			} catch (IOException e) {
				e.printStackTrace();
			}
		}).start();
	}

	public Socket getSocket() {
		return sock;
	}

	public void setSocket(Socket socket) {
		this.sock = socket;
	}
}
