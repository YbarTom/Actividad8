/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package actividad8;

/**
 *
 * @author tomyb
 */
import java.util.Scanner;

public class Actividad8 {

    /**
     * @param args the command line arguments
     */
    public static Scanner scan = new Scanner(System.in);

    public static int Jugada(int Tauler[][], int nColumna, int nJugador) {
        int posicioX;
        boolean bucle = false;
        posicioX = Tauler.length - 1;

        if (Tauler[0][nColumna - 1] == 0 && Tauler[1][nColumna - 1] > 0) {
            Tauler[posicioX][nColumna - 1] = nJugador;
            posicioX = 0;
        } else if (Tauler[0][nColumna - 1] > 0 && Tauler[1][nColumna - 1] > 0) {
            posicioX = -1;
        }

        if (posicioX>=0) {
            do {
                if (Tauler[posicioX][nColumna - 1] == 0 && posicioX>=0) {
                    Tauler[posicioX][nColumna - 1] = nJugador;
                    bucle = true;
                } else {
                    posicioX--;
                }
            } while (bucle == false);
        }
        //miramos la fila 0 y si esta llena desde un principio hacemos que retorne -1

        return posicioX;//creo que esta bien 
    }

    public static boolean EnRatlla(int Tauler[][], int posicioX, int nColumna) {
        int fitxa = Tauler[posicioX][nColumna];
        boolean ratlla = false;
        if (fitxa == 1 || fitxa == 2) {
            int contador = 0;
            //Comprobar vertical
            for (int i = posicioX - 3; i < posicioX + 3 && contador < 4; i++) {
                if (i >= 0 && i < Tauler.length - 1) {
                    if (Tauler[i][nColumna] == fitxa) {
                        contador++;
                    } else {
                        contador = 0;
                    }
                }
            }
            if (contador == 4) {
                ratlla = true;
            } else {
                contador = 0;
                //Comprobar horitzontal
                for (int i = nColumna - 3; i < nColumna + 3 && contador < 4; i++) {
                    if (i >= 0 && i < Tauler.length - 1) {
                        if (Tauler[posicioX][i] == fitxa) {
                            contador++;
                        } else {
                            contador = 0;
                        }
                    }
                    if (contador == 4) {
                        ratlla = true;
                    }
                }
            }

        }
        return ratlla;
    }

    public static void Dibuixa(int Tauler[][]) {
        //bucle imprimir la matriz
        for (int i = 0; i < Tauler.length; i++) {
            for (int j = 0; j < Tauler[0].length; j++) {
                System.out.print(Tauler[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        //demanem el tamany del tauler
        int X, Y, prueba, nColumna, nJugador;
        System.out.print("Introdueix el nombre de files del Tauler: ");
        X = scan.nextInt();
        System.out.print("Introdueix el nombre de columnes del Tauler: ");
        Y = scan.nextInt();
        //creem la matriu amb la longitud introduida per l'usuari
        int Tauler[][] = new int[X][Y];
        //omplim el tauler de 0
        for (int i = 0; i < X; i++) {
            for (int j = 0; j < Y; j++) {
                Tauler[i][j] = 0;
            }
        }

        int jugador = 1;
        int fila = 0;
        int columna = 0;
        do {
            /*
            //demanem el numero d'usuari que esta jugant
            System.out.print("Introdueix el numero de Jugador que ets: ");
            nJugador = scan.nextInt();
            //demanem el numero de columna
            System.out.print("Introdueix el numero de columna on anira la fitxa: ");
            nColumna = scan.nextInt();
             */
            Dibuixa(Tauler);
            System.out.println("Torn del jugador " + jugador);
            System.out.print("Introdueix la columna: ");
            columna = scan.nextInt();
            fila = Jugada(Tauler, scan.nextInt(), jugador);

        } while (!EnRatlla(Tauler, fila, columna));
    }

}
