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

    public static int Jugada(int Tauler[][], int X, int Y) {
        int nColumna, nJugador, posicioY;
        boolean bucle = false;
        posicioY = Y;
        //demanem el numero d'usuari que esta jugant
        System.out.print("Introdueix el numero de Jugador que ets: ");
        nJugador = scan.nextInt();
        //demanem el numero de columna
        System.out.print("Introdueix el numero de columna on anira la fitxa: ");
        nColumna = scan.nextInt();

        do {
            if (Tauler[nColumna][posicioY] == 0) {
                Tauler[nColumna][posicioY] = nJugador;
                bucle = true;
            } else {
                posicioY--;
            }
        } while (bucle == false || posicioY == 1);
        //miramos la fila 0 y si esta llena desde un principio hacemos que retorne -1
        if (Tauler[nColumna][0] == 0) {
            Tauler[nColumna][posicioY] = nJugador;
            posicioY = 0;
        } else {
            posicioY=-1;
        }
        return posicioY;//creo que esta bien 
    }

    public static void main(String[] args) {
        //demanem el tamany del tauler
        int X, Y,prueba;
        System.out.print("Introdueix la longitud X del Tauler: ");
        X = scan.nextInt();
        System.out.print("Introdueix la longitud Y del Tauler: ");
        Y = scan.nextInt();
        //creem la matriu amb la longitud introduida per l'usuari
        int Tauler[][] = new int[X][Y];
        //omplim el tauler de 0
        for (int i = 0; i < X; i++) {
            for (int j = 0; j < Y; j++) {
                Tauler[i][j] = 0;
            }
        }

        
    }

}
