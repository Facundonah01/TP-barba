package juego;

import entorno.Entorno;
import entorno.Herramientas;

import java.awt.*;

public class Computadora {

    private int x, y;
    private int ancho, alto;

    public Computadora(int x, int y, int ancho, int alto) {
        this.x = x;
        this.y = y;
        this.ancho = ancho;
        this.alto = alto;
    }

    public void dibujarse(Entorno entorno){
        entorno.dibujarImagen(Herramientas.cargarImagen("imagenes/computer.png"), this.x, this.y, 0);
    }
}