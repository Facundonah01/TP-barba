package juego;

import entorno.Entorno;

public class Barbariana {

    private double x, y;
    private int ancho, alto;
    private Rayo rayo;

    public Barbariana(double x, double y) {
        this.x = x;
        this.y = y;
        this.ancho = 20;
        this.alto = 50;
    }
    

    public void dibujarse(Entorno entorno) {
        entorno.dibujarRectangulo(this.x, this.y, this.ancho, this.alto, 0, null);
    }

    public void saltarDerecha(){
        this.y -= 115;
        this.x += 50;
    }

    public void saltarIzquierda(){
        this.y -= 115;
        this.x -= 50;
    }

    public void caer(){
        this.y += 115;
    }

    public void moverIzquierda() {
        this.x -= 5;
    }


    public void moverDerecha() {
        this.x += 5;
    }
    
    public void creaRayo() {
    	this.rayo = new Rayo(x, y);
    }

    public Rayo getRayo() {
		return rayo;
	}

	public void setRayo(Rayo rayo) {
		this.rayo = rayo;
	}

	public double getX() {
        return x;
    }
    


    public void setY(int y) {
        this.y = y;
    }

    public double getY() {
        return y;
    }

    public int getAlto() {
        return alto;
    }
}
