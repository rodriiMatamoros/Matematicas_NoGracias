package org.example;
import java.util.Scanner;
public class mostrarMain {

    //Instancio la clase dentro del método aux para luego llamarla en la clase Main
    public static void aux(){
        mostrarMain mostrarMain = new mostrarMain();
        mostrarMain.mostrar();
    }
    public static void mostrar() {
        Scanner scanner = new Scanner(System.in);
        Polinomio polinomio = new Polinomio(0, null);

        while (true) {
            System.out.println("\nElija una opción:");
            System.out.println("1. Agregar un término");
            System.out.println("2. Eliminar un término");
            System.out.println("3. Obtener el valor de un término");
            System.out.println("4. Verificar si existe un término");
            System.out.println("5. Sumar dos polinomios");
            System.out.println("6. Multiplicar dos polinomios");
            System.out.println("7. Mostrar el contenido del polinomio");
            System.out.println("8. Salir");

            int opcion = scanner.nextInt();
            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el valor del término: ");
                    double valor = scanner.nextDouble();
                    System.out.print("Ingrese el grado del término: ");
                    int grado = scanner.nextInt();
                    polinomio.agregarTermino(new datoPolinomio(valor, grado));
                    System.out.println("Término agregado.");
                    break;
                case 2:
                    System.out.print("Ingrese el grado del término a eliminar: ");
                    grado = scanner.nextInt();
                    if (polinomio.existeTermino(grado)) {
                        polinomio.eliminarTermino(grado);
                        System.out.println("Término eliminado.");
                    } else {
                        System.out.println("El término no existe.");
                    }
                    break;
                case 3:
                    System.out.print("Ingrese el grado del término a obtener: ");
                    grado = scanner.nextInt();
                    if (polinomio.existeTermino(grado)) {
                        System.out.println("El valor del término es: " + polinomio.obtenerValor(grado));
                    } else {
                        System.out.println("El término no existe.");
                    }
                    break;
                case 4:
                    System.out.print("Ingrese el grado del término a verificar: ");
                    grado = scanner.nextInt();
                    if (polinomio.existeTermino(grado)) {
                        System.out.println("El término existe.");
                    } else {
                        System.out.println("El término no existe.");
                    }
                    break;
                case 5:
                    System.out.println("Ingrese los datos del primer polinomio:");
                    Polinomio polinomio1 = new Polinomio(0, null);
                    while (true) {
                        System.out.print("Ingrese el valor del término: ");
                        valor = scanner.nextDouble();
                        System.out.print("Ingrese el grado del término: ");
                        grado = scanner.nextInt();
                        polinomio1.agregarTermino(new datoPolinomio(valor, grado));
                        System.out.print("¿Desea agregar otro término? (s/n): ");
                        String respuesta = scanner.next();
                        if (respuesta.equals("n")) {
                            break;
                        }
                    }
                    System.out.println("Ingrese los datos del segundo polinomio:");
                    Polinomio polinomio2 = new Polinomio(0, null);
                    while (true) {
                        System.out.print("Ingrese el valor del término: ");
                        valor = scanner.nextDouble();
                        System.out.print("Ingrese el grado del término: ");
                        grado = scanner.nextInt();
                        polinomio2.agregarTermino(new datoPolinomio(valor, grado));
                        System.out.print("¿Desea agregar otro término? (s/n): ");
                        String respuesta = scanner.next();
                        if (respuesta.equals("n")) {
                            break;
                        }
                    }
                    Polinomio suma = polinomio1.sumar(polinomio2);
                    System.out.println("El resultado de la suma es:");
                    suma.mostrarPolinomio();
                    break;
                case 6:
                    System.out.println("Ingrese los datos del primer polinomio:");
                    polinomio1 = new Polinomio(0, null);
                    while (true) {
                        System.out.print("Ingrese el valor del término: ");
                        valor = scanner.nextDouble();
                        System.out.print("Ingrese el grado del término: ");
                        grado = scanner.nextInt();
                        polinomio1.agregarTermino(new datoPolinomio(valor, grado));
                        System.out.print("¿Desea agregar otro término? (s/n): ");
                        String respuesta = scanner.next();
                        if (respuesta.equals("n")) {
                            break;
                        }
                    }
                    System.out.println("Ingrese los datos del segundo polinomio:");
                    polinomio2 = new Polinomio(0, null);
                    while (true) {
                        System.out.print("Ingrese el valor del término: ");
                        valor = scanner.nextDouble();
                        System.out.print("Ingrese el grado del término: ");
                        grado = scanner.nextInt();
                        polinomio2.agregarTermino(new datoPolinomio(valor, grado));
                        System.out.print("¿Desea agregar otro término? (s/n): ");
                        String respuesta = scanner.next();
                        if (respuesta.equals("n")) {
                            break;
                        }
                    }
                    Polinomio producto = polinomio1.multiplicar(polinomio2);
                    System.out.println("El resultado de la multiplicación es:");
                    producto.mostrarPolinomio();
                    break;
                case 7:
                    polinomio.mostrarPolinomio();
                    break;
                case 8:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opción inválida.");
                    break;
            }
        }
    }
}

