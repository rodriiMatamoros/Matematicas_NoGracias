package org.example;

public class datoPolinomio {
    private double valor;
    private int termino;
    private datoPolinomio siguiente;

    public datoPolinomio(double valor, int termino) {
        this.valor = valor;
        this.termino = termino;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getTermino() {
        return termino;
    }

    public void setTermino(int termino) {
        this.termino = termino;
    }

    public datoPolinomio getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(datoPolinomio siguiente) {
        this.siguiente = siguiente;
    }

    public String toString() {
        return "Termino: " + this.termino + " Valor: " + this.valor;
    }

    public boolean equals(datoPolinomio otro) {
        return this.termino == otro.getTermino();
    }

    public boolean equals(int termino) {
        return this.termino == termino;
    }

    public boolean equals(double valor) {
        return this.valor == valor;
    }
}
