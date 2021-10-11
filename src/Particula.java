import processing.core.PApplet;

public class Particula implements Runnable {

		private int posX, posY;
		private int vel, speedX, speedY;
		private final float size = 30;
		
		private PApplet app;

		public  Particula (int posX, int posY, int velocity, PApplet app) {
			this.posX = posX;
			this.posY = posY;
			this.app = app;

		}

		public void paint() {
			app.fill(255, 87, 51);
			app.noStroke();
			app.ellipse(posX, posY, size, size);
		}

		public void move() {
			posX = posX + speedX;
			posY = posY + speedY;;

		}

		 void musk() {
			    if (mousePressed == true) {
			      posX = width/2;
			      posY = height/2;
			      speedX = random(-2, 2);
			      speedY = random(-2, 2);
			      println(posX);
			    }
			  }
		

		public void run() {
			move();
		}

		public int getPosX() {
			return posX;
		}

		public void setPosX(int posX) {
			this.posX = posX;
		}

		public int getPosY() {
			return posY;
		}

		public void setPosY(int posY) {
			this.posY = posY;
		}
	
	}
