import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;

/**
 * Clase que implementa el listener de los botones del Buscaminas.
 * De alguna manera tendra que poder acceder a la ventana principal.
 * Se puede lograr pasando en el constructor la referencia a la ventana.
 * Recuerda que desde la ventana, se puede acceder a la variable de tipo ControlJuego
 * @author jesusredondogarcia
 **
 */
public class ActionBoton implements ActionListener{
	int i;
	int j;
	VentanaPrincipal marco;
	

	public ActionBoton(int i,int j,VentanaPrincipal marco) {
		this.i = i;
		this.j = j;
		this.marco = marco;
	}
	
	/**
	 *Accion que ocurrira cuando pulsamos uno de los botones.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if(marco.getJuego().getTablero()[i][j] != -1) {
			marco.cambiarBotones(i,j);
		}else {
			JOptionPane.showMessageDialog(null, "Has explotado una mina! Vuelve a empezar");
		}
	}

}
