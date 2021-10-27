package juego;

import java.awt.Color;

import entorno.Entorno;

public class Laser {

	private int x, y, ancho, alto;
	private double factorMovimiento, angulo;
	
	public Laser(int x, int y, double angulo) {
		
		this.x = x;	
		this.y = y;	
		this.ancho = 15;		
		this.alto = 10;		
		this.factorMovimiento = 10;	
		this.angulo = angulo;
	}
	
	public void dibujarse(Entorno e) {		
		e.dibujarRectangulo(this.x, this.y, this.ancho, this.alto, this.angulo, Color.RED);	
	}
	
	public void mover() {	
		this.x += this.factorMovimiento * Math.cos(this.angulo);	
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getAncho() {
		return ancho;
	}

	public int getAlto() {
		return alto;
	}
	
	
/*	public boolean chocaConBarbarianna(Barbarianna b) { 

		
		...
		
	}
	
	*/
	
	
	
}
