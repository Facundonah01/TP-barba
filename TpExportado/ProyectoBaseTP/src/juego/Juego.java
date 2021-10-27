package juego;


import java.awt.Color;

import entorno.Entorno;
import entorno.Herramientas;
import entorno.InterfaceJuego;

public class Juego extends InterfaceJuego {
    // El objeto Entorno que controla el tiempo y otros
    private Entorno entorno;
    private Fondo fondo;
    private Computadora computadora;
    private Barbariana barba;
    private Rayo rayo;
    private Veloci veloci;
    private Laser laser;
    //private Fondo[] pisos;
    private Fondo base;
    private Fondo wallpaper;
    private int puntos = 0;
    private boolean r = false;
    private boolean d = true;
    private boolean a = true;
  
    
    // Variables y métodos propios de cada grupo
    // ...

    Juego() {
        // Inicializa el objeto entorno
        this.entorno = new Entorno(this, "Castlevania, Barbarianna Viking Edition - Grupo 7 - v1", 800, 600);

        // Inicializar lo que haga falta para el juego

        //Wallpaper


        //Pisos: 135, 250, 365, 480 (Se puede modificar)

/*
        pisos = new Fondo[4];
        int arranque = 135;
        for (int i = 0; i < pisos.length; i++) {
            if (i % 2 != 0) {
                pisos[i] = new Fondo(entorno.ancho() / 2 + 200, arranque, entorno.ancho(), 15);
                arranque += 115;
            } else {
                pisos[i] = new Fondo(entorno.ancho() / 2 - 200, arranque, entorno.ancho(), 15);
                arranque += 115;
            }
        }

*/
        this.fondo = new Fondo(0,0,entorno.ancho(), 15);
        //Base: 480 + 115 = 595

        //base = new Fondo(entorno.ancho() / 2, 595, entorno.ancho(), 15);

        this.wallpaper = new Fondo(400, 300, 800, 600);

        //Computadora
        this.computadora = new Computadora(70, 80, 80, 80);
        
        //Barbariana
        this.barba = new Barbariana(100, entorno.alto() - 40);
        
        //Velociraptor
        this.veloci = new Veloci(150, 102);
    
        // Inicia el juego!
        this.entorno.iniciar();
    }

    /**
     * Durante el juego, el método tick() será ejecutado en cada instante y
     * por lo tanto es el método más importante de esta clase. Aquí se debe
     * actualizar el estado interno del juego para simular el paso del tiempo
     * (ver el enunciado del TP para mayor detalle).
     */
    public void tick() {
        // Procesamiento de un instante de tiempo
    	
    	//Pisos y fondo

        entorno.dibujarImagen(Herramientas.cargarImagen("imagenes/brick_wall.png"), entorno.ancho()/2, entorno.alto()/2, 0);

        this.fondo.dibujarPisos(entorno, 4);

        //Computadora
        this.computadora.dibujarse(entorno);
        
        //Barbariana
        this.barba.dibujarse(entorno);
        
        //Movimiento Barbariana
        if (barba.getX() < entorno.ancho() - 10) {
        	if(entorno.estaPresionada(entorno.TECLA_DERECHA)) {
            	barba.moverDerecha();
            	this.d = true;
            	
            }
        }
        
        
        
        if (barba.getX() > 0 + 10) {
        	if(entorno.estaPresionada(entorno.TECLA_IZQUIERDA)) {
            	barba.moverIzquierda();
            	this.d = false;
            }
        }
        
      //Rayo
        
        if(entorno.sePresiono(entorno.TECLA_ABAJO)) {
        	this.rayo = new Rayo(barba.getX(), barba.getY());
        	this.a = this.d;
        	this.r = true;
        	
        }
        
        if(this.r) {
        	this.rayo.dibujarse(entorno);
            rayo.mover(a);
        }
        	
        
        
       
       
        
        
        
        

            
        //Velociraptor
        this.veloci.dibujarse(entorno);
        
        veloci.mover();
        	
        
        
        //entorno.escribirTexto("X: " + velociraptor.getX() + " Y: " + velociraptor.getY() , 700, 50);
        
    }

    @SuppressWarnings("unused")
    public static void main(String[] args) {
        Juego juego = new Juego();
    }
}
