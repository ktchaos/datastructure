package primeiraparte;

import java.awt.BorderLayout;
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

public class FilaSeqGUI extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private static FilaSequencial fila = new FilaSequencial();
	private JButton positions[] = new JButton[9];

	
	public static void main(String[] args) {
		try {
			FilaSeqGUI dialog = new FilaSeqGUI();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public FilaSeqGUI() {
		
		try {
		    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
		        if ("Nimbus".equals(info.getName())) {
		            UIManager.setLookAndFeel(info.getClassName());
		            break;
		        }
		    }
		} catch (Exception e) {}
		
		setType(Type.UTILITY);
		setModal(true);
		setBounds(300, 100, 861, 481);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(51, 102, 153));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblFilaSequencial = new JLabel("FILA SEQUENCIAL");
		lblFilaSequencial.setForeground(new Color(0, 0, 0));
		lblFilaSequencial.setFont(new Font("Impact", Font.PLAIN, 28));
		lblFilaSequencial.setBounds(308, 22, 205, 45);
		contentPanel.add(lblFilaSequencial);
		
		JButton btnInserir = new JButton("INSERIR");
		btnInserir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!fila.cheia()) {
					JOptionPane input = new JOptionPane();
					String conteudo = input.showInputDialog("NOVO ELEMENTO:");
					if(conteudo != null && (conteudo.length()) > 0) {
						try {
							int fim = fila.getFim();
							fim = (fim+1) % 9;
							positions[fim].setText(conteudo);
							positions[fim].setFont(new Font("Impact", Font.PLAIN, 18));
							
							int valor = Integer.parseInt(conteudo);
							fila.insere(valor);
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
		btnInserir.setBackground(new Color(0, 0, 0));
		btnInserir.setForeground(Color.WHITE);
		btnInserir.setFont(new Font("Impact", Font.PLAIN, 20));
		btnInserir.setBounds(176, 84, 114, 29);
		contentPanel.add(btnInserir);
		
		JButton btnRemover = new JButton("REMOVER");
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!fila.vazia()) {
					int inicio = fila.getInicio();
					String removido = positions[inicio].getText();
					try {
						positions[inicio].setText("");
						inicio = (inicio+1) % 9;
						
						fila.remove();
						JOptionPane.showMessageDialog(null, "Item removido: " + removido, "REMOVED",
								JOptionPane.INFORMATION_MESSAGE);
					}
					catch(Exception e2) {
						JOptionPane.showMessageDialog(null, "Último elemento retirado: " +
					removido, "EMPTY!", JOptionPane.WARNING_MESSAGE);
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "A fila está vazia !", "ERRO", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnRemover.setForeground(Color.WHITE);
		btnRemover.setFont(new Font("Impact", Font.PLAIN, 20));
		btnRemover.setBackground(Color.BLACK);
		btnRemover.setBounds(497, 84, 114, 29);
		contentPanel.add(btnRemover);
		
		
		
		
		/* POSIÇÕES */
		
		positions[0] = new JButton("");
		positions[0].setBackground(Color.WHITE);
		positions[0].setBounds(83, 219, 78, 90);
		contentPanel.add(positions[0]);
	
		positions[1] = new JButton("");
		positions[1].setBackground(Color.WHITE);
		positions[1].setBounds(158, 219, 78, 90);
		contentPanel.add(positions[1]);
	
		positions[2] = new JButton("");
		positions[2].setBackground(Color.WHITE);
		positions[2].setBounds(233, 219, 78, 90);
		contentPanel.add(positions[2]);
	
		positions[3] = new JButton("");
		positions[3].setBackground(Color.WHITE);
		positions[3].setBounds(308, 219, 78, 90);
		contentPanel.add(positions[3]);
		
		positions[4] = new JButton("");
		positions[4].setBackground(Color.WHITE);
		positions[4].setBounds(383, 219, 78, 90);
		contentPanel.add(positions[4]);
		
		positions[5] = new JButton("");
		positions[5].setBackground(Color.WHITE);
		positions[5].setBounds(458, 219, 78, 90);
		contentPanel.add(positions[5]);
		
		positions[6] = new JButton("");
		positions[6].setBackground(Color.WHITE);
		positions[6].setBounds(533, 219, 78, 90);
		contentPanel.add(positions[6]);
		
		positions[7] = new JButton("");
		positions[7].setBackground(Color.WHITE);
		positions[7].setBounds(608, 219, 78, 90);
		contentPanel.add(positions[7]);
		
		positions[8] = new JButton("");
		positions[8].setBackground(Color.WHITE);
		positions[8].setBounds(683, 219, 78, 90);
		contentPanel.add(positions[8]);		
	}
}