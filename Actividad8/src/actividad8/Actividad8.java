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
        posicioX = Tauler.length;

        do {
            if (Tauler[posicioX][nColumna] == 0) {
                Tauler[posicioX][nColumna] = nJugador;
                bucle = true;
            } else {
                posicioX--;
            }
        } while (bucle == false || posicioX == 1);
        //miramos la fila 0 y si esta llena desde un principio hacemos que retorne -1
        if (Tauler[0][nColumna] == 0) {
            Tauler[posicioX][nColumna] = nJugador;
            posicioX = 0;
        } else {
            posicioX = -1;
        }
        return posicioX;//creo que esta bien 
    }

    public static int EnRatlla(int Tauler[][], int posicioX, int nColumna) {
        return -1;//no esta acabado
    }

    public static void Dibuixa(int Tauler[][]) {
        //bucle imprimir la matriz
        for (int i = 0; i < Tauler.length; i++) {
            for (int j = 0; j < Tauler[0].length; j++) {
                System.out.print(Tauler[i][j]+" ");
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

        do {
            //demanem el numero d'usuari que esta jugant
            System.out.print("Introdueix el numero de Jugador que ets: ");
            nJugador = scan.nextInt();
            //demanem el numero de columna
            System.out.print("Introdueix el numero de columna on anira la fitxa: ");
            nColumna = scan.nextInt();

        } while (X == 0/*no esta acabado*/);
    }

}
