package juego;

import entorno.Entorno;
import entorno.Herramientas;

import java.awt.*;

public class Fondo {

    private int x, y;
    private double ancho, alto;
    private double vacio = 200;
    
    public Fondo(int x, int y, double ancho, double alto) {
        this.x = x;
        this.y = y;
        this.ancho = ancho;
        this.alto = alto;
    }

    public Fondo() {
    }

    public void dibujarse(Entorno e) {
    	e.dibujarRectangulo(this.x, this.y, this.ancho, this.alto, 0, Color.WHITE);
    }

    public void dibujarWallpaper(Entorno entorno){
        entorno.dibujarImagen(Herramientas.cargarImagen("imagenes/brick_wall.png"), this.x, this.y,0);
    }

    public void dibujarPisos(Entorno entorno, int cantPisos) {

        double alturaArranque = (entorno.alto() / (cantPisos + 1));

       for(int i = 1; i <= cantPisos; i++){
            if(i % 2 != 0){
                entorno.dibujarRectangulo((entorno.ancho() - this.vacio) / 2, alturaArranque * i, this.ancho - this.vacio, this.alto, 0, Color.DARK_GRAY);

            } else {
                entorno.dibujarRectangulo((entorno.ancho() + this.vacio) / 2, alturaArranque * i, this.ancho - this.vacio, this.alto, 0, Color.DARK_GRAY);

            }
        }
        //base
        entorno.dibujarRectangulo(entorno.ancho()/2, entorno.alto() - this.alto / 2, entorno.ancho(), this.alto, 0, Color.DARK_GRAY);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public double getAncho() {
        return ancho;
    }

    public double getAlto() {
        return alto;
    }

    public double getVacio() {
        return vacio;
    }
}
