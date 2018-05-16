package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modelo.Colores;
import modelo.Constantes;

import java.awt.GridBagLayout;
import javax.swing.JTextPane;
import java.awt.GridBagConstraints;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.Insets;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class UI extends JFrame {

	private JPanel contentPane;
	private JButton btnRetrocederPagina;
	private JButton btnAvanzarPagina;
	private JButton btnMarcarPagina;
	private JButton btnIrAPagina;
	protected ArrayList<JButton> botones;
	private JComboBox<Colores> comboBoxColores;
	private JButton btnDisminuirTamanio;
	private JButton btnAumentarTamanio;
	private int tamanioTexto = Constantes.TAMANIO_PREFEDINIDO_LETRA;
	private String fuenteTexto = Constantes.FUENTE_LETRA_PREFEFINIDA;
	private Font fuente = new Font(fuenteTexto, Font.PLAIN, tamanioTexto);
	protected JTextArea textArea;
	protected JTextField txtRuta;
	protected JLabel lblPagina;

	/**
	 * Create the frame.
	 */
	public UI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		cambiarTamanio(170);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] {30, 70, 70, 70, 70, 70, 70, 70, 70, 30, 0};
		gbl_contentPane.rowHeights = new int[]{6, 296, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{1.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblNewLabel = new JLabel("LECTOR DE LIBRO");
		lblNewLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 32));
		lblNewLabel.setForeground(Color.ORANGE);
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.fill = GridBagConstraints.VERTICAL;
		gbc_lblNewLabel.gridwidth = 8;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 0;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);
		
		textArea = new JTextArea();
		textArea.setWrapStyleWord(true);
		textArea.setLineWrap(true);
		textArea.setBackground(Color.LIGHT_GRAY);
		GridBagConstraints gbc_textArea = new GridBagConstraints();
		gbc_textArea.gridwidth = 8;
		gbc_textArea.insets = new Insets(0, 0, 5, 5);
		gbc_textArea.fill = GridBagConstraints.BOTH;
		gbc_textArea.gridx = 1;
		gbc_textArea.gridy = 1;
		contentPane.add(textArea, gbc_textArea);
		
		txtRuta = new JTextField();
		txtRuta.setText("libroEjemplo.txt");

		txtRuta.setName("txtRuta");
		GridBagConstraints gbc_txtRuta = new GridBagConstraints();
		gbc_txtRuta.gridwidth = 6;
		gbc_txtRuta.insets = new Insets(0, 0, 5, 5);
		gbc_txtRuta.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtRuta.gridx = 2;
		gbc_txtRuta.gridy = 2;
		contentPane.add(txtRuta, gbc_txtRuta);
		txtRuta.setColumns(10);
		
		lblPagina = new JLabel("");
		lblPagina.setForeground(Color.ORANGE);
		lblPagina.setFont(new Font("Tahoma", Font.BOLD, 22));
		GridBagConstraints gbc_lblPagina = new GridBagConstraints();
		gbc_lblPagina.insets = new Insets(0, 0, 5, 5);
		gbc_lblPagina.gridx = 8;
		gbc_lblPagina.gridy = 2;
		contentPane.add(lblPagina, gbc_lblPagina);
		
		btnRetrocederPagina = new JButton("<");
		btnRetrocederPagina.setEnabled(false);
		btnRetrocederPagina.setName("retrocederPagina");
		GridBagConstraints gbc_btnRetrocederPagina = new GridBagConstraints();
		gbc_btnRetrocederPagina.gridwidth = 2;
		gbc_btnRetrocederPagina.fill = GridBagConstraints.BOTH;
		gbc_btnRetrocederPagina.insets = new Insets(0, 0, 5, 5);
		gbc_btnRetrocederPagina.gridx = 1;
		gbc_btnRetrocederPagina.gridy = 3;
		contentPane.add(btnRetrocederPagina, gbc_btnRetrocederPagina);
		
		btnDisminuirTamanio = new JButton("-");
		btnDisminuirTamanio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tamanioTexto>Constantes.TAMANIO_MINIMO_LETRA) {
					cambiarTamanioLetra(-10);
					btnAumentarTamanio.setEnabled(true);
				}else{
					btnDisminuirTamanio.setEnabled(false);
				}

			}
		});
		GridBagConstraints gbc_btnDisminuirTamanio = new GridBagConstraints();
		gbc_btnDisminuirTamanio.gridwidth = 2;
		gbc_btnDisminuirTamanio.fill = GridBagConstraints.BOTH;
		gbc_btnDisminuirTamanio.insets = new Insets(0, 0, 5, 5);
		gbc_btnDisminuirTamanio.gridx = 3;
		gbc_btnDisminuirTamanio.gridy = 3;
		contentPane.add(btnDisminuirTamanio, gbc_btnDisminuirTamanio);
		botones = new ArrayList<JButton>();
		botones.add(btnRetrocederPagina);
		
		btnAumentarTamanio = new JButton("+");
		btnAumentarTamanio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tamanioTexto<Constantes.TAMANIO_MAXIMO_LETRA) {
					cambiarTamanioLetra(10);
					btnDisminuirTamanio.setEnabled(true);
				}else{
					btnAumentarTamanio.setEnabled(false);
				}
			}
		});
		GridBagConstraints gbc_btnAumentarTamanio = new GridBagConstraints();
		gbc_btnAumentarTamanio.gridwidth = 2;
		gbc_btnAumentarTamanio.fill = GridBagConstraints.BOTH;
		gbc_btnAumentarTamanio.insets = new Insets(0, 0, 5, 5);
		gbc_btnAumentarTamanio.gridx = 5;
		gbc_btnAumentarTamanio.gridy = 3;
		contentPane.add(btnAumentarTamanio, gbc_btnAumentarTamanio);
		
		btnAvanzarPagina = new JButton(">");
		btnAvanzarPagina.setEnabled(false);
		btnAvanzarPagina.setName("avanzarPagina");
		GridBagConstraints gbc_btnAvanzarPagina = new GridBagConstraints();
		gbc_btnAvanzarPagina.gridwidth = 2;
		gbc_btnAvanzarPagina.fill = GridBagConstraints.BOTH;
		gbc_btnAvanzarPagina.insets = new Insets(0, 0, 5, 5);
		gbc_btnAvanzarPagina.gridx = 7;
		gbc_btnAvanzarPagina.gridy = 3;
		contentPane.add(btnAvanzarPagina, gbc_btnAvanzarPagina);
		botones.add(btnAvanzarPagina);
		
		btnMarcarPagina = new JButton("Marcar");
		btnMarcarPagina.setEnabled(false);
		btnMarcarPagina.setName("marcarPagina");
		GridBagConstraints gbc_btnMarcarPagina = new GridBagConstraints();
		gbc_btnMarcarPagina.gridwidth = 3;
		gbc_btnMarcarPagina.fill = GridBagConstraints.BOTH;
		gbc_btnMarcarPagina.insets = new Insets(0, 0, 0, 5);
		gbc_btnMarcarPagina.gridx = 1;
		gbc_btnMarcarPagina.gridy = 4;
		contentPane.add(btnMarcarPagina, gbc_btnMarcarPagina);
		botones.add(btnMarcarPagina);
		
		comboBoxColores = new JComboBox<Colores>();
		comboBoxColores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object item = comboBoxColores.getSelectedItem();
				Color color= (((Colores) item).getColor());
				textArea.setForeground(color);
			}
		});
		GridBagConstraints gbc_comboBoxColores = new GridBagConstraints();
		gbc_comboBoxColores.gridwidth = 2;
		gbc_comboBoxColores.insets = new Insets(0, 0, 0, 5);
		gbc_comboBoxColores.fill = GridBagConstraints.BOTH;
		gbc_comboBoxColores.gridx = 4;
		gbc_comboBoxColores.gridy = 4;
		contentPane.add(comboBoxColores, gbc_comboBoxColores);
		comboBoxColores.setModel(new DefaultComboBoxModel<Colores>(Colores.values()));
		
		btnIrAPagina = new JButton("Ir a marca");
		btnIrAPagina.setEnabled(false);
		btnIrAPagina.setName("irAMarcada");
		GridBagConstraints gbc_btnIrAPagina = new GridBagConstraints();
		gbc_btnIrAPagina.gridwidth = 3;
		gbc_btnIrAPagina.fill = GridBagConstraints.BOTH;
		gbc_btnIrAPagina.insets = new Insets(0, 0, 0, 5);
		gbc_btnIrAPagina.gridx = 6;
		gbc_btnIrAPagina.gridy = 4;
		contentPane.add(btnIrAPagina, gbc_btnIrAPagina);
		botones.add(btnIrAPagina);
		}

	private void cambiarTamanio(int cambio) {
		setBounds(100, 100, getWidth()+cambio*3, getHeight()+cambio*3);
	}

	private void cambiarTamanioLetra(int cambio) {
		tamanioTexto += cambio / 10;
		fuente = new Font(fuenteTexto, Font.PLAIN, tamanioTexto);
		textArea.setFont(fuente);
		cambiarTamanio(cambio);
	}



}
