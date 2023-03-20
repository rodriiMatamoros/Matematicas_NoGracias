package org.example;

public class Polinomio {
    private int grado;
    private datoPolinomio terminoMayor;

    public Polinomio(int grado, datoPolinomio terminoMayor) {
        this.grado = grado;
        this.terminoMayor = terminoMayor;
    }

    public int getGrado() {
        return grado;
    }

    public void setGrado(int grado) {
        this.grado = grado;
    }

    public datoPolinomio getTerminoMayor() {
        return terminoMayor;
    }

    public void setTerminoMayor(datoPolinomio terminoMayor) {
        this.terminoMayor = terminoMayor;
    }

    public void mostrarPolinomio() {
        datoPolinomio actual = this.terminoMayor;
        while (actual != null) {
            System.out.println(actual);
            actual = actual.getSiguiente();
        }
    }

    public double obtenerValor(int termino) {
        datoPolinomio actual = this.terminoMayor;
        while (actual != null) {
            if (actual.getTermino() == termino) {
                return actual.getValor();
            }
            actual = actual.getSiguiente();
        }
        return 0;
    }

    public boolean existeTermino(int termino) {
        datoPolinomio actual = this.terminoMayor;
        while (actual != null) {
            if (actual.getTermino() == termino) {
                return true;
            }
            actual = actual.getSiguiente();
        }
        return false;
    }

    public void agregarTermino(datoPolinomio nuevoTermino) {
        if (nuevoTermino.getTermino() > this.grado) {
            this.grado = nuevoTermino.getTermino();
            nuevoTermino.setSiguiente(this.terminoMayor);
            this.terminoMayor = nuevoTermino;
            return;
        }
        datoPolinomio actual = this.terminoMayor;
        while (actual.getSiguiente() != null) {
            if (nuevoTermino.getTermino() == actual.getSiguiente().getTermino()) {
                actual.getSiguiente().setValor(nuevoTermino.getValor());
                return;
            }
            if (nuevoTermino.getTermino() > actual.getSiguiente().getTermino()) {
                nuevoTermino.setSiguiente(actual.getSiguiente());
                actual.setSiguiente(nuevoTermino);
                return;
            }
            actual = actual.getSiguiente();
        }
        actual.setSiguiente(nuevoTermino);
    }

    public void eliminarTermino(int termino) {
        if (this.terminoMayor.getTermino() == termino) {
            this.terminoMayor = this.terminoMayor.getSiguiente();
            this.grado = this.terminoMayor == null ? 0 : this.terminoMayor.getTermino();
            return;
        }
        datoPolinomio actual = this.terminoMayor;
        while (actual.getSiguiente() != null) {
            if (actual.getSiguiente().getTermino() == termino) {
                actual.setSiguiente(actual.getSiguiente().getSiguiente());
                return;
            }
            actual = actual.getSiguiente();
        }
    }

    public Polinomio sumar(Polinomio polinomio) {
        Polinomio resultado = new Polinomio(0, null);
        datoPolinomio actual = this.terminoMayor;
        while (actual != null) {
            resultado.agregarTermino(new datoPolinomio(actual.getValor(), actual.getTermino()));
            actual = actual.getSiguiente();
        }
        actual = polinomio.terminoMayor;
        while (actual != null) {
            resultado.agregarTermino(new datoPolinomio(actual.getValor(), actual.getTermino()));
            actual = actual.getSiguiente();
        }
        return resultado;
    }

    public Polinomio restar(Polinomio polinomio) {
        Polinomio resultado = new Polinomio(0, null);
        datoPolinomio actual = this.terminoMayor;
        while (actual != null) {
            resultado.agregarTermino(new datoPolinomio(actual.getValor(), actual.getTermino()));
            actual = actual.getSiguiente();
        }
        actual = polinomio.terminoMayor;
        while (actual != null) {
            resultado.agregarTermino(new datoPolinomio(-actual.getValor(), actual.getTermino()));
            actual = actual.getSiguiente();
        }
        return resultado;
    }

    public Polinomio multiplicar(Polinomio polinomio) {
        Polinomio resultado = new Polinomio(0, null);
        datoPolinomio actual = this.terminoMayor;
        while (actual != null) {
            datoPolinomio actual2 = polinomio.terminoMayor;
            while (actual2 != null) {
                resultado.agregarTermino(new datoPolinomio(actual.getValor() * actual2.getValor(), actual.getTermino() + actual2.getTermino()));
                actual2 = actual2.getSiguiente();
            }
            actual = actual.getSiguiente();
        }
        return resultado;
    }

    public Polinomio dividir(Polinomio polinomio) {
        Polinomio resultado = new Polinomio(0, null);
        datoPolinomio actual = this.terminoMayor;
        while (actual != null) {
            datoPolinomio actual2 = polinomio.terminoMayor;
            while (actual2 != null) {
                resultado.agregarTermino(new datoPolinomio(actual.getValor() / actual2.getValor(), actual.getTermino() - actual2.getTermino()));
                actual2 = actual2.getSiguiente();
            }
            actual = actual.getSiguiente();
        }
        return resultado;
    }

    public Polinomio derivar() {
        Polinomio resultado = new Polinomio(0, null);
        datoPolinomio actual = this.terminoMayor;
        while (actual != null) {
            resultado.agregarTermino(new datoPolinomio(actual.getValor() * actual.getTermino(), actual.getTermino() - 1));
            actual = actual.getSiguiente();
        }
        return resultado;
    }

    public Polinomio integrar() {
        Polinomio resultado = new Polinomio(0, null);
        datoPolinomio actual = this.terminoMayor;
        while (actual != null) {
            resultado.agregarTermino(new datoPolinomio(actual.getValor() / (actual.getTermino() + 1), actual.getTermino() + 1));
            actual = actual.getSiguiente();
        }
        return resultado;
    }

    public Polinomio simplificar() {
        Polinomio resultado = new Polinomio(0, null);
        datoPolinomio actual = this.terminoMayor;
        while (actual != null) {
            resultado.agregarTermino(new datoPolinomio(actual.getValor(), actual.getTermino()));
            actual = actual.getSiguiente();
        }
        return resultado;
    }

    public Polinomio resolver() {
        Polinomio resultado = new Polinomio(0, null);
        datoPolinomio actual = this.terminoMayor;
        while (actual != null) {
            resultado.agregarTermino(new datoPolinomio(actual.getValor(), actual.getTermino()));
            actual = actual.getSiguiente();
        }
        return resultado;
    }

    public String toString() {
        String resultado = "";
        datoPolinomio actual = this.terminoMayor;
        while (actual != null) {
            if (actual.getValor() > 0) {
                resultado += " + " + actual.getValor() + "x^" + actual.getTermino();
            } else {
                resultado += " " + actual.getValor() + "x^" + actual.getTermino();
            }
            actual = actual.getSiguiente();
        }
        return resultado;
    }
}
