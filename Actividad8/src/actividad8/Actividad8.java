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
            //comprobamos que el numero introducido sea un entero, si no lo es se vuelve a pedir
		numero = 0;
		boolean correcte = false;

		do {
			if (scan.hasNextInt()) {
				numero = scan.nextInt();
				correcte = true;
			} else {
				scan.next();
				System.out.print("El caracter introduit no es un numero,si us plau introduiu un numero: ");

			}
		} while (correcte == false);

		return numero;
	}
	
	/**
	 * Agafa un int entre un rang de valors
	 * @param max int més gran
	 * @param min int més petit
	 * @return int que es trobi en el rang especificat
	 */
	static int escollirOpcio(int max, int min) {
		int opcio = 0;
		boolean valid = false;
		do {
			opcio = Entero(opcio);
			if (opcio <= max && opcio >= min) {
				valid = true;
			} else {
				System.out.println("Opcio incorrecta");
			}
		} while (!valid);
		return opcio;
	}

	public static void main(String[] args) {
		boolean repetir = true;
                //bucle para pedir si se quiere repetir la partida
		while (repetir) {
			// demanem el tamany del tauler
			int X=0, Y=0;
			System.out.print("Introdueix el nombre de files del Tauler: ");
			X = escollirOpcio(100000,4);
			System.out.print("Introdueix el nombre de columnes del Tauler: ");
			Y = escollirOpcio(100000,4);
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
                        //bucle para ir pidiendo las jugadas hasta que un jugador gane o se llene el tablero
			do {
				// Alternar jugador
				if (jugador == 1) {
					jugador = 2;
				} else {
					jugador = 1;
				}

				ControlTauler.Dibuixa(Tauler);
                                //indiquem el torn del jugador
				System.out.println("Torn del jugador " + jugador);
                                //demanem la columna a la qual es vol posar la fixa
				System.out.print("Introdueix la columna: ");
				columna = escollirOpcio(Y,1);
                                //cridem a la funcio jugada
				fila = ControlTauler.Jugada(Tauler, columna, jugador);
                                //indiquem en quina fila s'ha colocat la fitxa i si no s'ha pogut es torna a demanar
				if (fila >= 0) {
					System.out.println("La fixa esta situada en la fila: " + (fila + 1));
				} else if (fila == -1) {
					System.out.println(
							"La fixa no es pot posar a la columna introduida, Introduzca una columna diferente");
					// Alternar jugador
					if (jugador == 1) {
						jugador = 2;
					} else {
						jugador = 1;
					}
				}

			} while (!ControlTauler.EnRatlla(Tauler, fila, columna - 1));
			ControlTauler.Dibuixa(Tauler);
			System.out.println("Tornar a jugar? (S/N)");
			String resposta = scan.next();
			if (resposta.equals("N")) {
				repetir = false;
			}
		}
		System.out.println("Fins aviat!");
	}

}
