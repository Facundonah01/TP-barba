package juego;

import entorno.Entorno;
import entorno.Herramientas;

public class Computadora {

    private int x, y;
    @SuppressWarnings("unused")
	private int ancho, alto;

    public Computadora(int x, int y) {
        this.x = x;
        this.y = y;
        this.ancho = 80;
        this.alto = 80;
    }

    public void dibujarse(Entorno entorno){
        entorno.dibujarImagen(Herramientas.cargarImagen("imagenes/computer.png"), this.x, this.y, 0);
    }
}