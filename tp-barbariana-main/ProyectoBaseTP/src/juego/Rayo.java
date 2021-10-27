package juego;

import entorno.Entorno;

public class Rayo {
	
	private int x, y;
	private int ancho, alto;
	
	public Rayo(int x, int y) {
		this.x = x;
		this.y = y;
		this.ancho = 25;
		this.alto = 15;
	}
	
	public void dibujarse(Entorno entorno) {
		entorno.dibujarRectangulo(this.x, this.y, this.ancho, this.alto, 0, null);
		}
	


	public void mover(boolean d) {
		if (d) {
			x += 8;
		}else {
			x -= 8;
		}
		
		
	}
}

