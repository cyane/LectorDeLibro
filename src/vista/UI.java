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
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

public class UI extends JFrame {

	private JPanel contentPane;
	protected JButton btnRetrocederPagina;
	protected JButton btnAvanzarPagina;
	protected JButton btnMarcarPagina;
	protected JButton btnIrAPagina;
	private JComboBox<Colores> comboBoxColores;
	private JComboBox comboBoxFuentes;
	private JButton btnDisminuirTama�o;
	private JButton btnAumentarTama�o;
	private int tama�oTexto = Constantes.TAMA�O_PREFEDINIDO_LETRA;
	private String fuenteTexto = Constantes.FUENTE_LETRA_PREFEFINIDA;
	private Font fuente = new Font(fuenteTexto , Font.PLAIN, tama�oTexto);
	private int height = Constantes.TAMA�O_VENTANA_HEIGHT;
	private int width = Constantes.TAMA�O_VENTANA_WIDTH;
	private JTextArea textArea;

	/**
	 * Create the frame.
	 */
	public UI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		cambiarTama�o();
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 50, 43, 108, 53, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{67, 235, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, 1.0, 1.0, 1.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{1.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblNewLabel = new JLabel("LECTOR DE LIBRO");
		lblNewLabel.setFont(new Font("Comic Sans MS", Font.PLAIN, 32));
		lblNewLabel.setForeground(Color.ORANGE);
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.fill = GridBagConstraints.VERTICAL;
		gbc_lblNewLabel.gridwidth = 5;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 0;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);
		
		textArea = new JTextArea();
		textArea.setWrapStyleWord(true);
		textArea.setLineWrap(true);
		textArea.setBackground(Color.LIGHT_GRAY);
		GridBagConstraints gbc_textArea = new GridBagConstraints();
		gbc_textArea.gridwidth = 5;
		gbc_textArea.insets = new Insets(0, 0, 5, 5);
		gbc_textArea.fill = GridBagConstraints.BOTH;
		gbc_textArea.gridx = 1;
		gbc_textArea.gridy = 1;
		contentPane.add(textArea, gbc_textArea);
		
		btnRetrocederPagina = new JButton("<");
		GridBagConstraints gbc_btnRetrocederPagina = new GridBagConstraints();
		gbc_btnRetrocederPagina.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnRetrocederPagina.insets = new Insets(0, 0, 5, 5);
		gbc_btnRetrocederPagina.gridx = 1;
		gbc_btnRetrocederPagina.gridy = 2;
		contentPane.add(btnRetrocederPagina, gbc_btnRetrocederPagina);
		
		btnAvanzarPagina = new JButton(">");
		GridBagConstraints gbc_btnAvanzarPagina = new GridBagConstraints();
		gbc_btnAvanzarPagina.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnAvanzarPagina.insets = new Insets(0, 0, 5, 5);
		gbc_btnAvanzarPagina.gridx = 2;
		gbc_btnAvanzarPagina.gridy = 2;
		contentPane.add(btnAvanzarPagina, gbc_btnAvanzarPagina);
		
		btnMarcarPagina = new JButton("Marcar");
		GridBagConstraints gbc_btnMarcarPagina = new GridBagConstraints();
		gbc_btnMarcarPagina.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnMarcarPagina.insets = new Insets(0, 0, 5, 5);
		gbc_btnMarcarPagina.gridx = 3;
		gbc_btnMarcarPagina.gridy = 2;
		contentPane.add(btnMarcarPagina, gbc_btnMarcarPagina);
		
		btnIrAPagina = new JButton("Ir a marca");
		GridBagConstraints gbc_btnIrAPagina = new GridBagConstraints();
		gbc_btnIrAPagina.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnIrAPagina.gridwidth = 2;
		gbc_btnIrAPagina.insets = new Insets(0, 0, 5, 5);
		gbc_btnIrAPagina.gridx = 4;
		gbc_btnIrAPagina.gridy = 2;
		contentPane.add(btnIrAPagina, gbc_btnIrAPagina);
		
		comboBoxColores = new JComboBox<Colores>();
		comboBoxColores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object item = comboBoxColores.getSelectedItem();
				Color color= (((Colores) item).getColor());
				textArea.setForeground(color);
			}
		});
		GridBagConstraints gbc_comboBoxColores = new GridBagConstraints();
		gbc_comboBoxColores.insets = new Insets(0, 0, 0, 5);
		gbc_comboBoxColores.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxColores.gridx = 1;
		gbc_comboBoxColores.gridy = 3;
		contentPane.add(comboBoxColores, gbc_comboBoxColores);
		comboBoxColores.setModel(new DefaultComboBoxModel<Colores>(Colores.values()));
	
		comboBoxFuentes = new JComboBox<Object>();
		comboBoxFuentes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object item = comboBoxFuentes.getSelectedItem();
			
				fuente =new Font(fuenteTexto,Font.PLAIN,tama�oTexto);
				textArea.setFont(fuente);
			}
		});
		GridBagConstraints gbc_comboBoxFuentes = new GridBagConstraints();
		gbc_comboBoxFuentes.gridwidth = 2;
		gbc_comboBoxFuentes.insets = new Insets(0, 0, 0, 5);
		gbc_comboBoxFuentes.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxFuentes.gridx = 2;
		gbc_comboBoxFuentes.gridy = 3;
		contentPane.add(comboBoxFuentes, gbc_comboBoxFuentes);
		
		btnDisminuirTama�o = new JButton("-");
		btnDisminuirTama�o.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tama�oTexto>Constantes.TAMA�O_MINIMO_LETRA) {
					cambiarTama�oLetra(-10);
				}
			}
		});
		GridBagConstraints gbc_btnDisminuirTama�o = new GridBagConstraints();
		gbc_btnDisminuirTama�o.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnDisminuirTama�o.insets = new Insets(0, 0, 0, 5);
		gbc_btnDisminuirTama�o.gridx = 4;
		gbc_btnDisminuirTama�o.gridy = 3;
		contentPane.add(btnDisminuirTama�o, gbc_btnDisminuirTama�o);
		
		btnAumentarTama�o = new JButton("+");
		btnAumentarTama�o.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tama�oTexto<Constantes.TAMA�O_MAXIMO_LETRA) {
					cambiarTama�oLetra(10);
				}
			
			}
		});
		GridBagConstraints gbc_btnAumentarTama�o = new GridBagConstraints();
		gbc_btnAumentarTama�o.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnAumentarTama�o.insets = new Insets(0, 0, 0, 5);
		gbc_btnAumentarTama�o.gridx = 5;
		gbc_btnAumentarTama�o.gridy = 3;
		contentPane.add(btnAumentarTama�o, gbc_btnAumentarTama�o);
	}

	private void cambiarTama�o() {
		setBounds(100, 100,width,height);
	}

	private void cambiarTama�oLetra(int cambio) {
		tama�oTexto+=cambio/10;
		fuente=new Font(fuenteTexto, Font.PLAIN, tama�oTexto);
		textArea.setFont(fuente);
		width+=cambio;
		height+=cambio;
		cambiarTama�o();
	}



}
