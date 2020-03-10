package primeiraparte;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Window.Type;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PilhaSeqGUI extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private static PilhaSequencial pilha = new PilhaSequencial();;
	private JButton[] position = new JButton[8];
	private int cont = 0;

	public static void main(String[] args) {
		try {
			PilhaSeqGUI dialog = new PilhaSeqGUI();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	public PilhaSeqGUI() {
		setType(Type.UTILITY);
		try {
		    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
		        if ("Nimbus".equals(info.getName())) {
		            UIManager.setLookAndFeel(info.getClassName());
		            break;
		        }
		    }
		} catch (Exception e) {}

		getContentPane().setBackground(new Color(102, 51, 51));
		getContentPane().setLayout(null);
		
		JLabel lblPilha = new JLabel("PILHA SEQUENCIAL");
		lblPilha.setForeground(new Color(255, 255, 204));
		lblPilha.setFont(new Font("Impact", Font.BOLD, 24));
		lblPilha.setBounds(188, 11, 197, 58);
		getContentPane().add(lblPilha);
		
		JButton btnPush = new JButton("PUSH");
		btnPush.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/* AÇÃO DO BOTÃO PUSH */
				if(!pilha.cheia() ) {
					JOptionPane input = new JOptionPane();
					String conteudo = input.showInputDialog("NOVO ELEMENTO:");
					if(conteudo != null && (conteudo.length()) > 0) {
						try {
							position[cont].setText(conteudo);
							position[cont].setFont(new Font("Impact", Font.PLAIN, 18));
							cont++;
							/* Empilhando o dado na pilha */
							int dado = Integer.parseInt(conteudo);
							pilha.push(dado);
						}
						catch(Exception e1) {
							JOptionPane.showMessageDialog(null, "Digite um elemento válido", "ERRO", JOptionPane.WARNING_MESSAGE);
						}
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "A pilha está cheia !", "ERRO", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnPush.setForeground(new Color(51, 51, 51));
		btnPush.setBackground(new Color(255, 255, 255));
		btnPush.setFont(new Font("Impact", Font.PLAIN, 16));
		btnPush.setBounds(115, 94, 89, 23);
		getContentPane().add(btnPush);
		
		JButton btnPop = new JButton("POP");
		btnPop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/* AÇÃO DO BOTÃO POP*/
				if(!pilha.vazia()) {
					String removido = position[cont-1].getText();
					try {
						position[cont-1].setText("");
						cont--;
						/* Desempilhando o dado da pilha */
						pilha.pop();
						JOptionPane.showMessageDialog(null, "Item desempilhado: " + removido, "POP!",
								JOptionPane.INFORMATION_MESSAGE);
					}
					catch(Exception e2) {
						JOptionPane.showMessageDialog(null, "Último elemento desempilhado: " +
					removido , "Pilha vazia!", JOptionPane.WARNING_MESSAGE);
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "A pilha está vazia !", "ERRO", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnPop.setForeground(new Color(51, 51, 51));
		btnPop.setFont(new Font("Impact", Font.PLAIN, 16));
		btnPop.setBackground(new Color(255, 255, 255));
		btnPop.setBounds(235, 94, 89, 23);
		getContentPane().add(btnPop);
		
		JButton btnTop = new JButton("TOP");
		btnTop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/* AÇÃO DO BOTÃO TOP */
				if(!pilha.vazia()) {
					int top = pilha.top();
					JOptionPane.showMessageDialog(null, "Topo atual da pilha: " + top, "TOP!", JOptionPane.INFORMATION_MESSAGE);
				}
				else {
					JOptionPane.showMessageDialog(null, "A pilha está vazia", "NO TOP!", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnTop.setForeground(new Color(51, 51, 51));
		btnTop.setFont(new Font("Impact", Font.PLAIN, 16));
		btnTop.setBackground(new Color(255, 255, 255));
		btnTop.setBounds(355, 94, 89, 23);
		getContentPane().add(btnTop);
		
		
		/*	POSIÇOES DA PILHA */
		
		position[7] = new JButton("");
		position[7].setBackground(Color.WHITE);
		position[7].setBounds(164, 236, 233, 43);
		getContentPane().add(position[7]);
		
		position[6] = new JButton("");
		position[6].setBackground(Color.WHITE);
		position[6].setBounds(164, 279, 233, 43);
		getContentPane().add(position[6]);
		
		position[5] = new JButton("");
		position[5].setBackground(Color.WHITE);
		position[5].setBounds(164, 322, 233, 43);
		getContentPane().add(position[5]);
		
		position[4] = new JButton("");
		position[4].setBackground(Color.WHITE);
		position[4].setBounds(164, 365, 233, 43);
		getContentPane().add(position[4]);
		
		position[3] = new JButton("");
		position[3].setBackground(Color.WHITE);
		position[3].setBounds(164, 408, 233, 43);
		getContentPane().add(position[3]);
		
		position[2] = new JButton("");
		position[2].setBackground(Color.WHITE);
		position[2].setBounds(164, 451, 233, 43);
		getContentPane().add(position[2]);
		
		position[1] = new JButton("");
		position[1].setBackground(Color.WHITE);
		position[1].setBounds(164, 494, 233, 43);
		getContentPane().add(position[1]);
		
		position[0] = new JButton("");
		position[0].setBackground(Color.WHITE);
		position[0].setBounds(164, 537, 233, 43);
		getContentPane().add(position[0]);
		
		setModal(true);
		setBounds(400, 20, 586, 690);
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
	}

}
