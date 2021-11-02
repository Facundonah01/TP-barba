package juego;

import entorno.Entorno;

public class Rayo {

    private double x, y;
    private int ancho, alto;

    public Rayo(double x, double y) {
        this.x = x;
        this.y = y;
        this.ancho = 25;
        this.alto = 15;
    }

    public void dibujarse(Entorno entorno) {
    	if (x > 30 && x < 770)
        entorno.dibujarRectangulo(this.x, this.y, this.ancho, this.alto, 0, null);
    }



    public double getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void mover(boolean d) {
        if (d) {
            x += 2;
        }else {
            x -= 2;
        }


    }

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}
}

