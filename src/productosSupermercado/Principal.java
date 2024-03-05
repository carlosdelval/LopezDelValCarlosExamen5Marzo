package productosSupermercado;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

import productosSupermercado.vista.VentanaSupermercado;
import utils.Apariencia;

public class Principal extends JFrame {

	static {
		Apariencia.setAparienciasOrdenadas(Apariencia.aparienciasOrdenadas);
	}

	public Principal() {
		super("Gestión de Supermercado");

		this.setBounds(0, 0, 800, 600);

		VentanaSupermercado panelSuper = new VentanaSupermercado();
		
		this.getContentPane().add(panelSuper);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Principal ventana = new Principal();
		ventana.setVisible(true);
	}

}
