package juego;

import java.awt.Color;
import java.awt.Font;
import entorno.Entorno;
import entorno.InterfaceJuego;

public class Juego extends InterfaceJuego {
    // El objeto Entorno que controla el tiempo y otros
    private Entorno entorno;
    private Fondo fondo;
    private Computadora computadora;
    private Velociraptor[] velociraptor;
    private Barbariana barba;
    private Rayo rayo;
    private Laser[] laser;
    private int puntos = 0;
    private boolean r = false;
    private boolean d = true;
    private boolean a = true;
    private int cont = 0, num = 1;
    private int contL = 0;
    private int con = 0;
    private boolean l = false;
    private boolean mov = false;


    // Variables y métodos propios de cada grupo
    // ...

    
    
    
    public Velociraptor[] quitar(Velociraptor[] a, int pos) {
    	Velociraptor[] aux = new Velociraptor[a.length-1];
		int j = 0;
		
		for (int i = 0; i < pos; i++) {
			aux[j] = a[i];
			j++;
		}
		for (int i = pos+1; i < a.length; i++) {
			aux[j] = a[i];
			j++;
		}
		return aux;
    }
    
    
    Juego() {
    	
    	
        // Inicializa el objeto entorno
        this.entorno = new Entorno(this, "Castlevania, Barbarianna Viking Edition - Grupo 7 - v1", 800, 600);

        // Inicializar lo que haga falta para el juego

        this.fondo = new Fondo(0,0,entorno.ancho(), 15);

        //Computadora
        this.computadora = new Computadora(70, 80);

        //Barbariana
        this.barba = new Barbariana(100, entorno.alto() - 40);

        //Velociraptor
        this.velociraptor = new Velociraptor[5];
        for (int i = 0; i < velociraptor.length; i++) {
        	this.velociraptor[i] = new Velociraptor(); 	
        }
        
        
        
      //Laser
        this.laser = new Laser[5];
        
        
        

        // Inicia el juego!
        this.entorno.iniciar();
    }

    /**
     * Durante el juego, el método tick() será ejecutado en cada instante y
     * por lo tanto es el método más importante de esta clase. Aquí se debe
     * actualizar el estado interno del juego para simular el paso del tiempo
     * (ver el enunciado del TP para mayor detalle).
     */
    /**
     *
     */
    public void tick() {



        // Procesamiento de un instante de tiempo

        //Pisos y fondo
        this.fondo.dibujarWallpaper(entorno);
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



        if (barba.getX() > 10) {
            if(entorno.estaPresionada(entorno.TECLA_IZQUIERDA)) {
                barba.moverIzquierda();
                this.d = false;
            }
        }

        //Salto Barbariana
        if(barba.getX() > 110 && barba.getX() < 210 && (barba.getY() == 560 || barba.getY() == 330)){
            if(entorno.sePresiono(entorno.TECLA_ARRIBA)){
                barba.saltarDerecha();
            }
        }

        if(barba.getX() > 600 && barba.getX() < 700 && (barba.getY() == 445 || barba.getY() == 215)){
            if(entorno.sePresiono(entorno.TECLA_ARRIBA)){
                barba.saltarIzquierda();
            }
        }

        //Caida en el vacio

        if(barba.getX() < 200 && (barba.getY() == 445 || barba.getY() == 215)){
            barba.caer();
        }
        if(barba.getX() > 600 && (barba.getY() == 100 || barba.getY() == 330)){
            barba.caer();
        }


        //Rayo

        if(entorno.sePresiono(entorno.TECLA_ABAJO)) {
            barba.creaRayo();
            this.a = this.d;
            this.r = true;

        }
        
        if(this.r) {
            barba.getRayo().dibujarse(entorno);
            barba.getRayo().mover(a);
        }
        
        
        
        
        
        
        
        
      
        

        if (contL >= 300) {
        	l = true;
        	contL = 0;
        }else {
        	contL++;
        }
        

        if (l) {
        	for (int i = 0; i < velociraptor.length; i++) {
            	velociraptor[i].creaLaser();
            }
        	mov = true;
        	l = false;
        }
        
        
        
        if (mov) {
        	for (int i = 0; i < velociraptor.length; i++) {
            	velociraptor[i].getLaser().dibujarse(entorno);
                velociraptor[i].getLaser().mover(velociraptor[i].getAngulo());
                if(this.r) {
                if (barba.getRayo().getX() >= velociraptor[i].getX() - 20 && barba.getRayo().getX() <= velociraptor[i].getX() + 20 && barba.getRayo().getY() <= velociraptor[i].getY() + 20  && barba.getRayo().getY() >= velociraptor[i].getY() - 20){
                	velociraptor = this.quitar(velociraptor, i);
                	
                }
                }
            }   
        	
        	
        }
        
        
        
          
        
        	
            
        
        //Velociraptor

        if (num < 5) {
        	if (cont >= 1000) {
        		num++;
        		cont = 0;	
        	} else {
        		cont++;
        	}   	
        }
 
        //Movimiento de los velociraptor
        for (int i = 0; i < num; i++) {
        	if (this.velociraptor[i] != null) {
        		//Pisos: (4) 92.5, (3) 212.5, (2) 332.5, (1) 452.5 (La mitad de la altura del velociraptor se suma la mitad del alto del piso, y eso se resta a la posicion "Y" del piso actual)               
                if (velociraptor[i].getX() < 600 && (velociraptor[i].getY() >= 92.5 || velociraptor[i].getY() >= 332.5)) {
                	velociraptor[i].mover(); //Por predeterminado se mueve a la derecha, por eso no le asigno direccion
                } else if(velociraptor[i].getY() < 212.5) {// Al piso actual se le resta 35, 15 del ancho del piso y 20 de la mitad del alto del velociraptor		
                	velociraptor[i].setTrayectoria('v');   		  	 	
                	velociraptor[i].mover();   	
                	velociraptor[i].setTrayectoria('h');		
                	velociraptor[i].mover();      	
                } else if (velociraptor[i].getY() < 452.5 && velociraptor[i].getY() >= 332.5) {
                	velociraptor[i].setTrayectoria('v');   		  	 	
                	velociraptor[i].mover();   	
                	velociraptor[i].setTrayectoria('h');		
                	velociraptor[i].mover();              		
                } else if (!velociraptor[i].chocaConEntorno(entorno)) {
                	velociraptor[i].mover();
        		} else {
        			velociraptor[i].cambiarDireccionMovimiento();	
        			velociraptor[i].mover();
        		}
                if ((velociraptor[i].getY() >= 212.5 || velociraptor[i].getY() >= 572.5) && velociraptor[i].getX() <= 200) {        
                	if (velociraptor[i].getY() < 332.5){
                		velociraptor[i].setTrayectoria('v');       		                 	
                		velociraptor[i].mover();
                		velociraptor[i].setTrayectoria('h');
                		velociraptor[i].cambiarDireccionMovimiento();
                	} else if (velociraptor[i].getY() < 563.5 && velociraptor[i].getY() >= 452.5) {
                		velociraptor[i].setTrayectoria('v');       		                 	
                		velociraptor[i].mover();
                		velociraptor[i].setTrayectoria('h');
                		velociraptor[i].cambiarDireccionMovimiento();
                	} else if (velociraptor[i].chocaConEntorno(entorno)) {               			
                		velociraptor[i].setTrayectoria('h');             			 		  	 	     	                   	
                	} 
                } 
        	} 		
        	 	
        }
        //Dibujar dino 
        for (int i = 0; i < velociraptor.length; i++) {
        	velociraptor[i].dibujarse(entorno);
        }   
        
        
       
        
       
        
        
        
        
        entorno.cambiarFont(Font.SANS_SERIF, 20, Color.orange);     
        entorno.escribirTexto("X: " + velociraptor[0].getX() + " Y: " + velociraptor[0].getY(), 400, 50);
//>>>>>>> dbd9613b47982ccc3b10341b4cc4403fe1582bde
    }
         
    private void quitar(Class<Velociraptor[]> class1, int i) {
		// TODO Auto-generated method stub
		
	}


	@SuppressWarnings("unused")
    public static void main(String[] args) {
        Juego juego = new Juego();
    }
    
    
    
    
    
    
    
}