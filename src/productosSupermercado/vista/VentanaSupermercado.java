package productosSupermercado.vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import productosSupermercado.controladores.ControladorCategoria;
import productosSupermercado.controladores.ControladorProducto;
import productosSupermercado.entidades.Categoria;
import productosSupermercado.entidades.Producto;

import java.awt.GridBagLayout;
import java.awt.HeadlessException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Font;
import java.awt.Insets;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;

public class VentanaSupermercado extends JFrame {

	private JPanel contentPane;
	private JTextField jtfId;
	private JTextField jtfCodigo;
	private JTextField jtfDescripcion;
	private JTextField jtfFechaCaducidad;
	private JTextField jtfUnidadesStock;
	JComboBox<Categoria> jcbCategoria;
	JComboBox<Producto> jcbProducto;
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	JCheckBox checkPerecedero;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaSupermercado frame = new VentanaSupermercado();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaSupermercado() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 421);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
//		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0};
//		gbl_contentPane.columnWeights = new double[]{1.0, 1.0, 0.0};
//		gbl_contentPane.columnWidths = new int[]{0};
//		gbl_contentPane.rowHeights = new int[]{0};
//		gbl_contentPane.columnWeights = new double[]{Double.MIN_VALUE};
//		gbl_contentPane.rowWeights = new double[]{Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);

		JLabel lblNewLabel = new JLabel("Gestión de Supermercado");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridwidth = 3;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Categoria:");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 1;
		contentPane.add(lblNewLabel_1, gbc_lblNewLabel_1);

		jcbCategoria = new JComboBox();
		GridBagConstraints gbc_jcbCategoria = new GridBagConstraints();
		gbc_jcbCategoria.weightx = 1.0;
		gbc_jcbCategoria.insets = new Insets(0, 0, 5, 5);
		gbc_jcbCategoria.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbCategoria.gridx = 1;
		gbc_jcbCategoria.gridy = 1;
		contentPane.add(jcbCategoria, gbc_jcbCategoria);

		JButton btnCargarProductos = new JButton("Cargar productos");
		btnCargarProductos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargarProductos();
			}
		});
		GridBagConstraints gbc_btnCargarProductos = new GridBagConstraints();
		gbc_btnCargarProductos.insets = new Insets(0, 0, 5, 0);
		gbc_btnCargarProductos.gridx = 2;
		gbc_btnCargarProductos.gridy = 1;
		contentPane.add(btnCargarProductos, gbc_btnCargarProductos);

		JLabel lblNewLabel_2 = new JLabel("Producto:");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 2;
		contentPane.add(lblNewLabel_2, gbc_lblNewLabel_2);

		jcbProducto = new JComboBox();
		GridBagConstraints gbc_jcbProducto = new GridBagConstraints();
		gbc_jcbProducto.insets = new Insets(0, 0, 5, 5);
		gbc_jcbProducto.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbProducto.gridx = 1;
		gbc_jcbProducto.gridy = 2;
		contentPane.add(jcbProducto, gbc_jcbProducto);

		JButton btnVerProductos = new JButton("Ver producto");
		btnVerProductos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargarDatosProducto();
			}
		});
		GridBagConstraints gbc_btnVerProductos = new GridBagConstraints();
		gbc_btnVerProductos.insets = new Insets(0, 0, 5, 0);
		gbc_btnVerProductos.gridx = 2;
		gbc_btnVerProductos.gridy = 2;
		contentPane.add(btnVerProductos, gbc_btnVerProductos);

		JLabel lblNewLabel_4 = new JLabel("Datos del producto:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.gridwidth = 3;
		gbc_lblNewLabel_4.insets = new Insets(10, 0, 5, 0);
		gbc_lblNewLabel_4.gridx = 0;
		gbc_lblNewLabel_4.gridy = 4;
		contentPane.add(lblNewLabel_4, gbc_lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("Id:");
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_5.gridx = 0;
		gbc_lblNewLabel_5.gridy = 5;
		contentPane.add(lblNewLabel_5, gbc_lblNewLabel_5);

		jtfId = new JTextField();
		jtfId.setEnabled(false);
		GridBagConstraints gbc_jtfId = new GridBagConstraints();
		gbc_jtfId.insets = new Insets(0, 0, 5, 0);
		gbc_jtfId.gridwidth = 2;
		gbc_jtfId.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfId.gridx = 1;
		gbc_jtfId.gridy = 5;
		contentPane.add(jtfId, gbc_jtfId);
		jtfId.setColumns(10);

		JLabel lblNewLabel_6 = new JLabel("Código:");
		GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
		gbc_lblNewLabel_6.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_6.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_6.gridx = 0;
		gbc_lblNewLabel_6.gridy = 6;
		contentPane.add(lblNewLabel_6, gbc_lblNewLabel_6);

		jtfCodigo = new JTextField();
		GridBagConstraints gbc_jtfCodigo = new GridBagConstraints();
		gbc_jtfCodigo.insets = new Insets(0, 0, 5, 0);
		gbc_jtfCodigo.gridwidth = 2;
		gbc_jtfCodigo.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfCodigo.gridx = 1;
		gbc_jtfCodigo.gridy = 6;
		contentPane.add(jtfCodigo, gbc_jtfCodigo);
		jtfCodigo.setColumns(10);

		JLabel lblNewLabel_7 = new JLabel("Descripción:");
		GridBagConstraints gbc_lblNewLabel_7 = new GridBagConstraints();
		gbc_lblNewLabel_7.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_7.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_7.gridx = 0;
		gbc_lblNewLabel_7.gridy = 7;
		contentPane.add(lblNewLabel_7, gbc_lblNewLabel_7);

		jtfDescripcion = new JTextField();
		GridBagConstraints gbc_jtfDescripcion = new GridBagConstraints();
		gbc_jtfDescripcion.insets = new Insets(0, 0, 5, 0);
		gbc_jtfDescripcion.gridwidth = 2;
		gbc_jtfDescripcion.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfDescripcion.gridx = 1;
		gbc_jtfDescripcion.gridy = 7;
		contentPane.add(jtfDescripcion, gbc_jtfDescripcion);
		jtfDescripcion.setColumns(10);

		checkPerecedero = new JCheckBox("");
		GridBagConstraints gbc_checkPerecedero = new GridBagConstraints();
		gbc_checkPerecedero.anchor = GridBagConstraints.EAST;
		gbc_checkPerecedero.insets = new Insets(0, 0, 5, 5);
		gbc_checkPerecedero.gridx = 0;
		gbc_checkPerecedero.gridy = 8;
		contentPane.add(checkPerecedero, gbc_checkPerecedero);

		JLabel lblNewLabel_10 = new JLabel("Perecedero");
		GridBagConstraints gbc_lblNewLabel_10 = new GridBagConstraints();
		gbc_lblNewLabel_10.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_10.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_10.gridx = 1;
		gbc_lblNewLabel_10.gridy = 8;
		contentPane.add(lblNewLabel_10, gbc_lblNewLabel_10);

		JLabel lblNewLabel_8 = new JLabel("Fecha de caducidad:");
		GridBagConstraints gbc_lblNewLabel_8 = new GridBagConstraints();
		gbc_lblNewLabel_8.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_8.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_8.gridx = 0;
		gbc_lblNewLabel_8.gridy = 9;
		contentPane.add(lblNewLabel_8, gbc_lblNewLabel_8);

		jtfFechaCaducidad = new JTextField();
		GridBagConstraints gbc_jtfFechaCaducidad = new GridBagConstraints();
		gbc_jtfFechaCaducidad.insets = new Insets(0, 0, 5, 0);
		gbc_jtfFechaCaducidad.gridwidth = 2;
		gbc_jtfFechaCaducidad.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfFechaCaducidad.gridx = 1;
		gbc_jtfFechaCaducidad.gridy = 9;
		contentPane.add(jtfFechaCaducidad, gbc_jtfFechaCaducidad);
		jtfFechaCaducidad.setColumns(10);

		JLabel lblNewLabel_9 = new JLabel("Unidades en stock:");
		GridBagConstraints gbc_lblNewLabel_9 = new GridBagConstraints();
		gbc_lblNewLabel_9.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_9.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_9.gridx = 0;
		gbc_lblNewLabel_9.gridy = 10;
		contentPane.add(lblNewLabel_9, gbc_lblNewLabel_9);

		jtfUnidadesStock = new JTextField();
		GridBagConstraints gbc_jtfUnidadesStock = new GridBagConstraints();
		gbc_jtfUnidadesStock.insets = new Insets(0, 0, 5, 0);
		gbc_jtfUnidadesStock.gridwidth = 2;
		gbc_jtfUnidadesStock.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfUnidadesStock.gridx = 1;
		gbc_jtfUnidadesStock.gridy = 10;
		contentPane.add(jtfUnidadesStock, gbc_jtfUnidadesStock);
		jtfUnidadesStock.setColumns(10);

		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					guardarProducto();
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		GridBagConstraints gbc_btnGuardar = new GridBagConstraints();
		gbc_btnGuardar.insets = new Insets(0, 0, 5, 0);
		gbc_btnGuardar.gridwidth = 3;
		gbc_btnGuardar.gridx = 0;
		gbc_btnGuardar.gridy = 12;
		contentPane.add(btnGuardar, gbc_btnGuardar);

		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.weighty = 1.0;
		gbc_panel.insets = new Insets(0, 0, 0, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 13;
		contentPane.add(panel, gbc_panel);

		cargarCategorias();
	}

	/**
	 * 
	 */
	private void cargarCategorias() {
		List<Categoria> lista = ControladorCategoria.findAll();

		for (Categoria c : lista) {
			this.jcbCategoria.addItem(c);
		}
	}

	/**
	 * 
	 */
	private void cargarProductos() {
		Categoria c = (Categoria) this.jcbCategoria.getSelectedItem();

		this.jcbProducto.removeAllItems();

		List<Producto> productos = ControladorProducto.findAllById(c.getId());
		for (Producto n : productos) {
			this.jcbProducto.addItem(n);
		}
	}

	/**
	 * 
	 */

	private void cargarDatosProducto() {
		Producto p = (Producto) this.jcbProducto.getSelectedItem();

		if (p != null) {
			this.jtfId.setText("" + p.getId());
			this.jtfCodigo.setText(p.getCodigo());
			this.jtfDescripcion.setText(p.getDescripcion());
			this.jtfUnidadesStock.setText("" + p.getUnidadesStock());
			if(p.getFechaCaducidad() != null) this.jtfFechaCaducidad.setText(sdf.format(p.getFechaCaducidad()));
			this.checkPerecedero.setSelected(p.getPerecedero());
		}
	}

	/**
	 * @throws HeadlessException 
	 * @throws ParseException
	 * 
	 */
	private void guardarProducto() throws HeadlessException, ParseException {

		Producto p = new Producto();

		p.setId(Integer.parseInt(this.jtfId.getText()));
		p.setCodigo(this.jtfCodigo.getText());

		// Compruebo codigo valido
		if (isCodigoValido(p.getCodigo()) == false) {
			JOptionPane.showMessageDialog(null, "El código indicado no comienza con tres letras mayúsculas.");
			return;
		}

		p.setDescripcion(this.jtfDescripcion.getText());
		p.setIdCategoria(((Categoria) this.jcbCategoria.getSelectedItem()).getId());
		
		//Compruebo si la fecha es valida

		if (this.jtfFechaCaducidad.getText() != null) {
			if (isFechaValida(sdf.parse(this.jtfFechaCaducidad.getText()))) {
				try {
					p.setFechaCaducidad(sdf.parse(this.jtfFechaCaducidad.getText()));
				} catch (ParseException e) {
					e.printStackTrace();
				}
			} else {
				JOptionPane.showMessageDialog(null, "La fecha de caducidad no es posterior a la fecha actual.");
				return;

			}
		} else {
			p.setFechaCaducidad(null);
		}
		
		//Compruebo si el n de stock es valido

		if(isStockValido(this.jtfUnidadesStock.getText())) {
			if (this.jtfUnidadesStock.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "El número de stock no puede ser vacío.");
				return;
			} else {
				p.setUnidadesStock(Integer.parseInt(this.jtfUnidadesStock.getText()));
			}
		}else {
			JOptionPane.showMessageDialog(null, "El número de stock no es entero.");
			return;
		}

		p.setPerecedero(this.checkPerecedero.isSelected());

		if (ControladorProducto.update(p) == 1) {
			JOptionPane.showMessageDialog(null, "Modificado correctamente");
		} else {
			JOptionPane.showMessageDialog(null, "NO se ha modificado correctamente");
		}
	}

	/**
	 * 
	 * @return
	 */
	private boolean isCodigoValido(String codigo) {

		for (int i = 0; i < 3; i++) {
			if (Character.isLowerCase(codigo.charAt(i)))
				return false;
		}
		return true;
	}

	/**
	 * 
	 * @return
	 * @throws ParseException
	 */

	private boolean isFechaValida(java.util.Date date) {
		Calendar ahoraRoma = Calendar.getInstance(TimeZone.getTimeZone("Europe/Madrid"));
		if (date.after(ahoraRoma.getTime()))
			return true;
		else
			return false;
	}
	
	/**
	 * 
	 */
	
	private boolean isStockValido(String stock) {
		for (int i = 0; i < stock.length(); i++) {
			if(!Character.isDigit(stock.charAt(i))) return false;
		}
		return true;
	}
	
}
