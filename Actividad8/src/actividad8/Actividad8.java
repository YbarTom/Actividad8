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
	
	public static int Entero(int numero) {
		numero = 0;
		boolean correcte = false;

		do {
			if (scan.hasNextInt()) {
				numero = scan.nextInt();
				correcte = true;
			} else {
				scan.next();
				System.out.println("El caracter introduit no es un numero,si us plau introduiu un numero: ");

			}
		} while (correcte == false);

		return numero;
	}

	public static void main(String[] args) {
		boolean repetir = true;
		while (repetir) {
			// demanem el tamany del tauler
			int X=0, Y=0, nColumna, nJugador;
			System.out.print("Introdueix el nombre de files del Tauler: ");
			X = Entero(X);
			System.out.print("Introdueix el nombre de columnes del Tauler: ");
			Y = Entero(Y);
			// creem la matriu amb la longitud introduida per l'usuari
			int Tauler[][] = new int[X][Y];
			// omplim el tauler de 0
			for (int i = 0; i < X; i++) {
				for (int j = 0; j < Y; j++) {
					Tauler[i][j] = 0;
				}
			}

			int jugador = 2;
			int fila = 0;
			int columna = 0;
			do {
				// Alternar jugador
				if (jugador == 1) {
					jugador = 2;
				} else {
					jugador = 1;
				}

				ControlTauler.Dibuixa(Tauler);

				System.out.println("Torn del jugador " + jugador);
				System.out.print("Introdueix la columna: ");
				columna = Entero(columna);
				fila = ControlTauler.Jugada(Tauler, columna, jugador);
				if (fila >= 0) {
					System.out.println("La ficha esta situada en la fila: " + (fila + 1));
				} else if (fila == -1) {
					System.out.println(
							"La ficha no es pot posar a la columna introduida, Introduzca una columna diferente");
					// Alternar jugador
					if (jugador == 1) {
						jugador = 2;
					} else {
						jugador = 1;
					}
				}

			} while (!ControlTauler.EnRatlla(Tauler, fila, columna - 1));
			System.out.println("Tornar a jugar? (S/N)");
			String resposta = scan.next();
			if (resposta.equals("N")) {
				repetir = false;
			}
		}
	}

}
