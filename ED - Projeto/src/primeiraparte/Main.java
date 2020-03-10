package primeiraparte;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.border.LineBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Window.Type;
import javax.swing.ImageIcon;

public class Main extends JFrame {

	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public Main() {
		
		setType(Type.UTILITY);
		
		try {
		    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
		        if ("Nimbus".equals(info.getName())) {
		            UIManager.setLookAndFeel(info.getClassName());
		            break;
		        }
		    }
		} catch (Exception e) {}

		setBackground(new Color(255, 255, 255));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 970, 580);
		setLocation(250, 50);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(51, 51, 51));
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEstruturasDeDados = new JLabel("ESTRUTURAS DE DADOS");
		lblEstruturasDeDados.setForeground(new Color(255, 255, 204));
		lblEstruturasDeDados.setBackground(new Color(255, 255, 255));
		lblEstruturasDeDados.setFont(new Font("Impact", Font.BOLD, 34));
		lblEstruturasDeDados.setBounds(315, 11, 347, 81);
		contentPane.add(lblEstruturasDeDados);
		
		JLabel lblListas = new JLabel("LISTAS");
		lblListas.setForeground(Color.WHITE);
		lblListas.setBackground(Color.WHITE);
		lblListas.setFont(new Font("Impact", Font.PLAIN, 26));
		lblListas.setBounds(136, 163, 82, 39);
		contentPane.add(lblListas);
		
		JLabel lblPilhas = new JLabel("PILHAS");
		lblPilhas.setForeground(Color.WHITE);
		lblPilhas.setFont(new Font("Impact", Font.PLAIN, 26));
		lblPilhas.setBackground(Color.WHITE);
		lblPilhas.setBounds(478, 163, 75, 39);
		contentPane.add(lblPilhas);
		
		JLabel lblFilas = new JLabel("FILAS");
		lblFilas.setForeground(Color.WHITE);
		lblFilas.setFont(new Font("Impact", Font.PLAIN, 26));
		lblFilas.setBackground(Color.WHITE);
		lblFilas.setBounds(780, 163, 60, 39);
		contentPane.add(lblFilas);
		
		JButton btnNewButton = new JButton("LISTA SEQUENCIAL");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListaSeqGUI l = new ListaSeqGUI();
				l.setVisible(true);
			}
		});
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setFont(new Font("Impact", Font.PLAIN, 18));
		btnNewButton.setBounds(48, 226, 252, 31);
		contentPane.add(btnNewButton);
		
		JButton button = new JButton("LISTA ENCADEADA");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListaEnc2GUI le = new ListaEnc2GUI();
				le.setVisible(true);
			}
		});
		button.setForeground(Color.BLACK);
		button.setFont(new Font("Impact", Font.PLAIN, 18));
		button.setBackground(Color.WHITE);
		button.setBounds(48, 276, 252, 31);
		contentPane.add(button);
		
		JButton btnPilhaSequencial = new JButton("PILHA SEQUENCIAL");
		btnPilhaSequencial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PilhaSeqGUI p = new PilhaSeqGUI();
				p.setVisible(true);
			}
		});
		btnPilhaSequencial.setForeground(Color.BLACK);
		btnPilhaSequencial.setFont(new Font("Impact", Font.PLAIN, 18));
		btnPilhaSequencial.setBackground(Color.WHITE);
		btnPilhaSequencial.setBounds(424, 226, 185, 31);
		contentPane.add(btnPilhaSequencial);
		
		JButton btnPilhaEncadeada = new JButton("PILHA ENCADEADA");
		btnPilhaEncadeada.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PilhaEncGUI pe = new PilhaEncGUI();
				pe.setVisible(true);
			}
		});
		btnPilhaEncadeada.setForeground(Color.BLACK);
		btnPilhaEncadeada.setFont(new Font("Impact", Font.PLAIN, 18));
		btnPilhaEncadeada.setBackground(Color.WHITE);
		btnPilhaEncadeada.setBounds(424, 276, 185, 31);
		contentPane.add(btnPilhaEncadeada);
		
		JButton btnFilaSequencial = new JButton("FILA SEQUENCIAL");
		btnFilaSequencial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FilaSeqGUI f = new FilaSeqGUI();
				f.setVisible(true);
			}
		});
		btnFilaSequencial.setForeground(Color.BLACK);
		btnFilaSequencial.setFont(new Font("Impact", Font.PLAIN, 18));
		btnFilaSequencial.setBackground(Color.WHITE);
		btnFilaSequencial.setBounds(720, 226, 185, 31);
		contentPane.add(btnFilaSequencial);
		
		JButton btnFilaEncadeada = new JButton("FILA ENCADEADA");
		btnFilaEncadeada.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FIlaEncGUI fe = new FIlaEncGUI();
				fe.setVisible(true);
			}
		});
		btnFilaEncadeada.setForeground(Color.BLACK);
		btnFilaEncadeada.setFont(new Font("Impact", Font.PLAIN, 18));
		btnFilaEncadeada.setBackground(Color.WHITE);
		btnFilaEncadeada.setBounds(720, 276, 185, 31);
		contentPane.add(btnFilaEncadeada);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(Main.class.getResource("/images/datastruct2 - R.png")));
		label.setBounds(704, 11, 100, 94);
		contentPane.add(label);
		
		JButton btnInfo = new JButton("INFO");
		btnInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Info i = new Info();
				i.setVisible(true);
			}
		});
		btnInfo.setForeground(Color.WHITE);
		btnInfo.setFont(new Font("Impact", Font.PLAIN, 18));
		btnInfo.setBackground(new Color(51, 0, 0));
		btnInfo.setBounds(303, 462, 126, 31);
		contentPane.add(btnInfo);
		
		JButton btnCredits = new JButton("CR\u00C9DITOS");
		btnCredits.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Credits c = new Credits();
				c.setVisible(true);
			}
		});
		btnCredits.setForeground(Color.WHITE);
		btnCredits.setFont(new Font("Impact", Font.PLAIN, 18));
		btnCredits.setBackground(new Color(51, 0, 0));
		btnCredits.setBounds(553, 462, 126, 31);
		contentPane.add(btnCredits);
	}
}
