package actividad8;

import java.util.Scanner;

public class ControlTauler {
	public static Scanner scan = new Scanner(System.in);
	
	/**
	 * Situa la fitxa del jugador corresponent en la fila disponible
	 * @param Tauler
	 * @param nColumna
	 * @param nJugador
	 * @return posicioX fila on anirà la fitxa
	 */
	public static int Jugada(int Tauler[][], int nColumna, int nJugador) {
		int posicioX;
		boolean bucle = false;
		posicioX = Tauler.length - 1;

		if (Tauler[0][nColumna - 1] == 0 && Tauler[1][nColumna - 1] > 0) {
			posicioX = 0;
			Tauler[posicioX][nColumna - 1] = nJugador;
		} else if (Tauler[0][nColumna - 1] > 0 && Tauler[1][nColumna - 1] > 0) {
			posicioX = -1;
		}

		if (posicioX >= 0) {
			do {
				if (Tauler[posicioX][nColumna - 1] == 0 && posicioX >= 0) {
					Tauler[posicioX][nColumna - 1] = nJugador;
					bucle = true;
				}else if(posicioX==0) {
					bucle=true;
				}else {
					posicioX--;
				}
			} while (bucle == false);
		}
		// miramos la fila 0 y si esta llena desde un principio hacemos que retorne -1

		return posicioX;
	}

	/**
	 * Comprova que la fitxa introduida formi ratlla amb les caselles veines, sense diagonals
	 * @param Tauler
	 * @param posicioX
	 * @param nColumna
	 * @return true si forma ratlla, false si no
	 */
	public static boolean EnRatlla(int Tauler[][], int posicioX, int nColumna) {
		boolean ratlla = false;
		if (posicioX >= 0) {
			int fitxa = Tauler[posicioX][nColumna];

			if (fitxa == 1 || fitxa == 2) {
				int contador = 0;
				// Comprobar vertical
				for (int i = posicioX - 3; i <= posicioX + 3 && contador < 4; i++) {
					if (i >= 0 && i <= Tauler.length - 1) {
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
					// Comprobar horitzontal
					for (int i = nColumna - 3; i <= nColumna + 3 && contador < 4; i++) {
						if (i >= 0 && i <= Tauler[0].length - 1) {
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
		}
		return ratlla;
	}

	/**
	 * Mostra el tauler per pantalla
	 * @param Tauler
	 */
	public static void Dibuixa(int Tauler[][]) {
		// bucle imprimir la matriz
		for (int i = 0; i < Tauler.length; i++) {
			for (int j = 0; j < Tauler[0].length; j++) {
				System.out.print(Tauler[i][j] + " ");
			}
			System.out.println();
		}
	}
}
