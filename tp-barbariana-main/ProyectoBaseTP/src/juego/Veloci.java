package juego;

import java.awt.Color;

import entorno.Entorno;

public class Veloci {

    private int x, y;
    private int ancho, alto;
    private boolean caida = false;
    private int aux = 0;
    private char direccion = 'd';
    private boolean pisos = false;

    public Veloci(int x, int y) {
        this.x = x;
        this.y = y;
        this.ancho = 50;
        this.alto = 20;
    }

    public void dibujarse(Entorno entorno) {
        entorno.dibujarRectangulo(this.x, this.y, this.ancho, this.alto, 0, Color.red);
    }

    public void mover() {
        if (pisos == false) {
            if (direccion == 'd') {
                if (x <= 625) {
                    x += 1;
                } else {
                    this.caida = true;
                }

                if (this.caida) {
                    if (y <= 220) {
                        y += 1;
                    } else {
                        if (x <= 775) {
                            x += 1;
                        } else {
                            caida = false;
                            direccion = 'i';
                        }
                    }
                }
            } else {
                if (x >= 150) {
                    x -= 1;
                } else {
                    this.caida = true;
                }

                if (this.caida) {
                    if (y <= 340) {
                        y += 1;
                    } else {
                        if (x >= 25) {
                            x -= 1;
                        } else {
                            direccion = 'd';
                            pisos = true;
                            this.caida = false;
                        }
                    }
                }
            }
        }

        if (pisos == true) {
            if (direccion == 'd') {
                if (x <= 625) {
                    x += 1;
                } else {
                    this.caida = true;
                }

                if (this.caida) {
                    if (y <= 460) {
                        y += 1;
                    } else {
                        if (x <= 775) {
                            x += 1;
                        } else {
                            caida = false;
                            direccion = 'i';
                        }
                    }
                }
            }else {
                if (x >= 150) {
                    x -= 1;
                } else {
                    this.caida = true;
                }


                if (this.caida) {
                    if (y <= 580) {
                        y += 1;
                    } else {
                        if (x >= 25) {
                            x -= 1;
                        }
                    }
                }
            }
        }

    }
}




