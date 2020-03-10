package primeiraparte;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Window.Type;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Info extends JDialog {

	private final JPanel contentPanel = new JPanel();

	public static void main(String[] args) {
		try {
			Info dialog = new Info();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Info() {
		
		setType(Type.UTILITY);
		setModal(true);
		
		setBounds(100, 100, 800, 483);
		setLocation(250, 50);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(51, 0, 0));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblComoUsarEsse = new JLabel("COMO USAR ESSE PROGRAMA ?");
		lblComoUsarEsse.setForeground(Color.WHITE);
		lblComoUsarEsse.setFont(new Font("Impact", Font.PLAIN, 24));
		lblComoUsarEsse.setBounds(180, 11, 292, 46);
		contentPanel.add(lblComoUsarEsse);
		
		/* TEXTO */
		
		JLabel lblEssaApenas = new JLabel("Essa \u00E9 apenas a primeira parte de um projeto dividido em duas partes da");
		lblEssaApenas.setForeground(Color.WHITE);
		lblEssaApenas.setFont(new Font("Impact", Font.PLAIN, 17));
		lblEssaApenas.setBounds(53, 84, 536, 32);
		contentPanel.add(lblEssaApenas);
		
		JLabel lblDisciplinaDeEstruta = new JLabel("disciplina de Estruta de Dados (2019.2). O programa proporciona 3 tipos");
		lblDisciplinaDeEstruta.setForeground(Color.WHITE);
		lblDisciplinaDeEstruta.setFont(new Font("Impact", Font.PLAIN, 17));
		lblDisciplinaDeEstruta.setBounds(53, 116, 536, 32);
		contentPanel.add(lblDisciplinaDeEstruta);
		
		JLabel lblQuePorSua = new JLabel("que por sua vez, s\u00E3o subdivididas em sequenciais e encadeadas.");
		lblQuePorSua.setForeground(Color.WHITE);
		lblQuePorSua.setFont(new Font("Impact", Font.PLAIN, 17));
		lblQuePorSua.setBounds(53, 178, 536, 32);
		contentPanel.add(lblQuePorSua);
		
		JLabel lblDeEstrutasDisponveis = new JLabel("de estrutas dispon\u00EDveis para o consumo do usu\u00E1rio: Listas, Pilhas e Filas,");
		lblDeEstrutasDisponveis.setForeground(Color.WHITE);
		lblDeEstrutasDisponveis.setFont(new Font("Impact", Font.PLAIN, 17));
		lblDeEstrutasDisponveis.setBounds(53, 146, 536, 32);
		contentPanel.add(lblDeEstrutasDisponveis);
		
		JLabel lblCadaUmaDas = new JLabel("Cada uma das op\u00E7\u00F5es simula o comportamento do tipo escolhido, al\u00E9m\r\n");
		lblCadaUmaDas.setForeground(Color.WHITE);
		lblCadaUmaDas.setFont(new Font("Impact", Font.PLAIN, 17));
		lblCadaUmaDas.setBounds(53, 213, 536, 32);
		contentPanel.add(lblCadaUmaDas);
		
		JLabel lblDeConterUma = new JLabel("de conter uma intera\u00E7\u00E3o com o usu\u00E1rio onde o mesmo poder\u00E1 inserir");
		lblDeConterUma.setForeground(Color.WHITE);
		lblDeConterUma.setFont(new Font("Impact", Font.PLAIN, 17));
		lblDeConterUma.setBounds(53, 245, 536, 32);
		contentPanel.add(lblDeConterUma);
		
		JLabel lblElementosDoTipo = new JLabel("elementos do tipo inteiro, fazer buscas ou remover elementos observando");
		lblElementosDoTipo.setForeground(Color.WHITE);
		lblElementosDoTipo.setFont(new Font("Impact", Font.PLAIN, 17));
		lblElementosDoTipo.setBounds(53, 275, 536, 32);
		contentPanel.add(lblElementosDoTipo);
		
		JLabel lblCadaMudanaNa = new JLabel("cada mudan\u00E7a na estrutura. Vale salientar que este programa trabalha");
		lblCadaMudanaNa.setForeground(Color.WHITE);
		lblCadaMudanaNa.setFont(new Font("Impact", Font.PLAIN, 17));
		lblCadaMudanaNa.setBounds(53, 307, 536, 32);
		contentPanel.add(lblCadaMudanaNa);
		
		JLabel lblNoDesvalidaSua = new JLabel("n\u00E3o desvalida sua funcionalidade.");
		lblNoDesvalidaSua.setForeground(Color.WHITE);
		lblNoDesvalidaSua.setFont(new Font("Impact", Font.PLAIN, 17));
		lblNoDesvalidaSua.setBounds(53, 367, 536, 32);
		contentPanel.add(lblNoDesvalidaSua);
		
		JLabel lblApenasComDados = new JLabel("apenas com dados do tipo inteiro, que apesar dessa limita\u00E7\u00E3o,");
		lblApenasComDados.setForeground(Color.WHITE);
		lblApenasComDados.setFont(new Font("Impact", Font.PLAIN, 17));
		lblApenasComDados.setBounds(53, 335, 536, 32);
		contentPanel.add(lblApenasComDados);
		
		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnOk.setFont(new Font("Impact", Font.PLAIN, 18));
		btnOk.setBackground(new Color(255, 255, 255));
		btnOk.setForeground(Color.BLACK);
		btnOk.setBounds(663, 366, 89, 32);
		contentPanel.add(btnOk);
	}

}
