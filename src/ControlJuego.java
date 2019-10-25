import java.util.ArrayList;
import java.util.Random;

/**
 * Clase gestora del tablero de juego.
 * Guarda una matriz de enteros representado el tablero.
 * Si hay una mina en una posicion guarda el numero -1
 * Si no hay una mina, se guarda cuantas minas hay alrededor.
 * Almacena la puntuacion de la partida
 * @author jesusredondogarcia
 *
 */
public class ControlJuego {
	private final static int MINA = -1;
	final int MINAS_INICIALES = 20;
	final int LADO_TABLERO = 10;

	private int [][] tablero;
	private int puntuacion;
	
	
	public ControlJuego() {
		//Creamos el tablero:
		tablero = new int[LADO_TABLERO][LADO_TABLERO];
		
		//Inicializamos una nueva partida
		inicializarPartida();
	}
	
	
	/**Metodo para generar un nuevo tablero de partida:
	 * @pre: La estructura tablero debe existir. 
	 * @post: Al final el tablero se habra inicializado con tantas minas como marque la variable MINAS_INICIALES. 
	 * 	El resto de posiciones que no son minas guardan en el entero cuantas minas hay alrededor de la celda
	 */
	public void inicializarPartida(){
		int posMinaX;
		int posMinaY;
		int contMina=0;
		//TODO: Repartir minas e inicializar puntacion. Si hubiese un tablero anterior, lo pongo todo a cero para inicializarlo.
		
		//Inicializamos a 0
		puntuacion = 0;
		for(int i=0;i<tablero.length;i++) {
			for(int j=0;j<tablero[i].length;j++) {
				tablero[i][j]=0;
			}
		}
		//Repartimos Minas
		while(contMina<MINAS_INICIALES) {
			
			posMinaX = (int) (Math.random()*LADO_TABLERO);
			posMinaY = (int) (Math.random()*LADO_TABLERO);
			if (tablero[posMinaX][posMinaY] != MINA){
				tablero[posMinaX][posMinaY] = MINA;
				contMina++;
			}
		}
		
		//Al final del metodo hay que guardar el numero de minas para las casillas que no son mina:
		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero[i].length; j++) {
				if (tablero[i][j] != MINA){
					tablero[i][j] = calculoMinasAdjuntas(i,j);
				}
			}
		}
	}
	
	/**Caculo de las minas adjuntas: 
	 * Para calcular el numero de minas tenemos que tener en cuenta que no nos salimos nunca del tablero.
	 * Por lo tanto, como mucho la i y la j valdran LADO_TABLERO-1.
	 * Por lo tanto, como poco la i y la j valdran 0.
	 * @param i: posicion vertical de la casilla a rellenar
	 * @param j: posicion horizontal de la casilla a rellenar
	 * @return : El numero de minas que hay alrededor de la casilla [i][j]
	 **/
	private int calculoMinasAdjuntas(int i, int j){
		int posX = i - 1;
		int posY = i - 1;
		int contMinas = 0;
		
		if(posX<0) {
			posX = 0;
		}
		
		if(posY<0) {
			posY = 0;
		}
		
		for(int n = posX;n < 2; n++) {
			for(int n2 = posY; n<2;n++) {
			}
		}
		return 0;
	} 
	
	/**
	 * Metodo que nos permite 
	 * @pre : La casilla nunca debe haber sido abierta antes, no es controlado por el ControlJuego. Por lo tanto siempre sumaremos puntos
	 * @param i: posicion verticalmente de la casilla a abrir
	 * @param j: posicion horizontalmente de la casilla a abrir
	 * @return : Verdadero si no ha explotado una mina. Falso en caso contrario.
	 */
	public boolean abrirCasilla(int i, int j){
		return false;
	}
	
	
	
	/**
	 * Método que checkea si se ha terminado el juego porque se han abierto todas las casillas.
	 * @return Devuelve verdadero si se han abierto todas las celdas que no son minas.
	 **/
	public boolean esFinJuego(){
		return false;
	}
	
	
	/**
	 * Metodo que pinta por pantalla toda la informacion del tablero, se utiliza para depurar
	 */
	public void depurarTablero(){
		System.out.println("---------TABLERO--------------");
		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero[i].length; j++) {
				System.out.print(tablero[i][j]+"\t");
			}
			System.out.println();
		}
		System.out.println("\nPuntuación: "+puntuacion);
	}

	/**
	 * Metodo que se utiliza para obtener las minas que hay alrededor de una celda
	 * @pre : El tablero tiene que estar ya inicializado, por lo tanto no hace falta calcularlo, simplemente consultarlo
	 * @param i : posicion vertical de la celda.
	 * @param j : posicion horizontal de la cela.
	 * @return Un entero que representa el numero de minas alrededor de la celda
	 */
	public int getMinasAlrededor(int i, int j) {
		return 0;
	}

	/**
	 * Metodo que devuelve la puntuacion actual
	 * @return Un entero con la puntuacion actual
	 */
	public int getPuntuacion() {
		return 0;
	}
	
}
