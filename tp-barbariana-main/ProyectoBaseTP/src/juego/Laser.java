package juego;

import java.awt.Color;

import entorno.Entorno;

public class Laser {

	private double x, y;
	private double radio, factorMovimiento, angulo;
	
	public Laser(double a, double b) {
		
		this.x = a;	
		this.y = b;	
		this.radio = 15;		
		this.factorMovimiento = 10;	
		
	}
	
	public void dibujarse(Entorno e) {		
		e.dibujarCirculo(this.x, this.y, this.radio, Color.RED);	
	}
	
	public void mover(double angulo) {	
		if (angulo == 0) {
			this.x += 5;
		}else {
			this.x -= 5;
		}	
	}
	
	public boolean chocaConEntorno(Entorno e) {
		return (this.x < this.radio/2 || this.x > e.ancho() - this.radio/2);	
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}
	
	public void set(double a, double b) {
		x = a;
		y = b;
	}	
	
/*	public boolean chocaConBarbarianna(Barbarianna b) { 

		
		...
		
	}
	
	*/
	
	
	
}
