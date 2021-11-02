package juego;

import java.awt.Color;
import java.awt.Image;

import entorno.*;

public class Velociraptor {

    private double x, y;
    private int radio;
    private double angulo, factorMovimiento;
    private char trayectoria, direccionMovimiento;
    private Laser laser;/* trayectoria = h (horizontal), v: (vertical);
													  direccionMovimiento = v: s (sur); direccionMovimiento = h: i (izquierda) /d (derecha) */
    private Image im;
    
    public Velociraptor() {
        this.x = 140.0;
        this.y = 92.5;

        this.radio = 40;

        this.factorMovimiento = 1;
        this.angulo = 0;

        this.trayectoria = 'h';
        this.direccionMovimiento = 'd';
        
        im = Herramientas.cargarImagen("imagenes/dino.png");
    }

    public void setTrayectoria(char trayectoria) {
        if (trayectoria != 'v' && trayectoria != 'h') {
            throw new RuntimeException("La trayectoria no es valida");
        } else {
            this.trayectoria = trayectoria;
            if (trayectoria == 'h') {
                this.angulo = Math.toRadians(0);	//Predeterminado: se mueve en horizontal hacia derecha, angulo 0�
            } else {
                this.angulo = Math.toRadians(90);	//Si se cambia la trayectoria se mueve en vertical hacia el sur en angulo 90�
            }
        }
    }

    public void setDireccionMovimiento(char c) {
        if (c != 'i' && c != 'd' && c != 's') {
            throw new RuntimeException("La direccion especificada es incorrecta");
        }
        if (this.trayectoria == 'v') {				//Vertical puede ir hacia el sur
            if (c == 's') {
                this.direccionMovimiento = c;
                Math.toRadians(90);
            }
        } else if (this.trayectoria == 'h') {
            if (c == 'i' || c == 'd') {				//Los horizontales pueden ir hacia la izquierda o la derecha
                if (c == 'd') {
                	this.direccionMovimiento = c;
                    this.angulo = Math.toRadians(0);
                }
                if (c == 'i') {						//El caso distinto al predeterminado cambia el angulo        
                	this.angulo = Math.toRadians(180);
                }
            } else {
                throw new RuntimeException("La trayectoria y la direccion de movimiento no coinciden");
            }
        }
    }

	public static int posicionVelociraptorNulo(Velociraptor[] velociraptors) { // Recorreria un arreglo de velociraptors 
        int i = 0;															   // y retornaria la posicion en la que encuentra un null, caso contrario retorna -1
        while (i < velociraptors.length) {
            if (velociraptors[i] == null) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public void cambiarDireccionMovimiento() {
        if (this.direccionMovimiento == 'd') {	     //Cambia la direccion de movimiento del velociraptor por su opuesta       
        	this.setDireccionMovimiento('i');
            return;     	
        } else if (this.direccionMovimiento == 'i') {
            this.setDireccionMovimiento('d');
            return;
        }
    }
    
    // USO CONTINUO
    public void dibujarse(Entorno e) {
        e.dibujarCirculo(this.x, this.y, this.radio, Color.cyan);
    }
    
    public void dibujarImagen(Entorno e) {		
    	e.dibujarImagen(this.im, this.x, this.y, 0, 1.2);
    }

    public void mover() {
        if (this.trayectoria == 'v') {
            this.y += Math.sin(this.angulo) * this.factorMovimiento;	//Modifica las coordenadas x e y dependiendo de la trayectoria
        } else {														//Si la trayectoria es vertical modifica la coordenada Y (Ya que la x es la misma)
            this.x += Math.cos(this.angulo) * this.factorMovimiento;	//Si la trayectoria es horizontal modifica la coordenada X (Ya que Y va a ser la misma)
        }
    }
    
    public boolean chocaConEntorno(Entorno e) {
    	return (this.x < this.radio/2 || this.x > e.ancho() - this.radio/2 || this.y > e.alto() - this.radio/2); 	
    }
    
    
    public void eliLaser() {
    	this.laser = null;
    }
 
    public void creaLaser() {
    	this.laser = new Laser(x, y);
    }
    

    public Laser getLaser() {
		return laser;
	}

	public void setLaser(Laser laser) {
		this.laser = laser;
	}

	public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

	public char getTrayectoria() {
		return trayectoria;
	}

	public char getDireccionMovimiento() {
		return direccionMovimiento;
	}
	
    public double getAngulo() {
		return angulo;
	}
    
    public int getRadio() {
    	return radio;
    }

}
