package juego;

import entorno.Entorno;
import entorno.Herramientas;

import java.awt.*;

public class Fondo {

    private int x, y;
    private double ancho, alto;
    private double vacio = 200;
    @SuppressWarnings("unused")
	private Image fondo, pisos;
    
    public Fondo(int x, int y, double ancho, double alto) {
        this.x = x;
        this.y = y;
        this.ancho = ancho;
        this.alto = alto;
        this.fondo = Herramientas.cargarImagen("imagenes/brick_wall.png");
        this.pisos = Herramientas.cargarImagen("");
    }

    public void dibujarWallpaper(Entorno entorno){
        entorno.dibujarImagen(fondo, entorno.ancho()/2, entorno.alto()/2, 0);
    }

    public void dibujarPisos(Entorno entorno, int cantPisos) {

       double alturaArranque = (entorno.alto() / (cantPisos + 1));

       for(int i = 1; i <= cantPisos; i++){ //120, 240, 360, 480
            if(i % 2 != 0){
                entorno.dibujarRectangulo((entorno.ancho() - this.vacio) / 2, alturaArranque * i, this.ancho - this.vacio, this.alto, 0, Color.DARK_GRAY);     
            } else {
                entorno.dibujarRectangulo((entorno.ancho() + this.vacio) / 2, alturaArranque * i, this.ancho - this.vacio, this.alto, 0, Color.DARK_GRAY);
            }
        }
        //base: 600
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
