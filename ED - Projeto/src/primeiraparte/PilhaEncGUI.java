package primeiraparte;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Window.Type;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class PilhaEncGUI extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private static PilhaEncadeada pilhaEnc = new PilhaEncadeada();
	private ArrayList<JButton> position = new ArrayList<JButton>();
	private JButton[] setas = new JButton[9];
	private int cont = 0;
	private boolean memoriacheia = false;
	
	public static void main(String[] args) {
		try {
			PilhaEncGUI dialog = new PilhaEncGUI();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	public PilhaEncGUI() {
		setType(Type.UTILITY);
		/* SETANDO O LOOKANDFEEL */
		try {
		    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
		        if ("Nimbus".equals(info.getName())) {
		            UIManager.setLookAndFeel(info.getClassName());
		            break;
		        }
		    }
		} catch (Exception e) {}
		
		setModal(true);
		getContentPane().setBackground(new Color(102, 51, 51));
		getContentPane().setLayout(null);
		getContentPane().setLayout(null);
		setBounds(400, 20, 586, 690);
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		JLabel lblPilhaEnc = new JLabel("PILHA ENCADEADA");
		lblPilhaEnc.setForeground(new Color(255, 255, 204));
		lblPilhaEnc.setFont(new Font("Impact", Font.BOLD, 25));
		lblPilhaEnc.setBounds(189, 17, 206, 58);
		getContentPane().add(lblPilhaEnc);
		
		JButton btnPush = new JButton("PUSH");
		
		btnPush.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!memoriacheia) {
					String conteudo = JOptionPane.showInputDialog("NOVO ELEMENTO:");
					if(conteudo != null && (conteudo.length()) > 0) {
						try {
							JButton no = position.get(cont);
							no.setText(conteudo);
							no.setFont(new Font("Impact", Font.PLAIN, 18));
							getContentPane().add(no);
							no.setVisible(true);
							no.doClick();
							/* Adição das setas (proximo nó) */
							if(cont >= 1) {
								getContentPane().add(setas[cont-1]);
								setas[cont-1].setVisible(true);
								setas[cont-1].doClick();
							}
							cont++;
							/* Empilhando o dado na pilha */
							int dado = Integer.parseInt(conteudo);
							pilhaEnc.push(dado);
						}
						catch(Exception e1) {
							JOptionPane.showMessageDialog(null, "Operação inválida !", "ERRO", JOptionPane.ERROR_MESSAGE);	
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
				if(!pilhaEnc.vazia()) {
					int i = cont-1;
					JButton no = position.get(i);
					String removido = no.getText();
					try {
						/* Removendo o nó */
						no.setText("");
						no.setVisible(false);
						getContentPane().remove(no);
						/* Removendo a seta */
						setas[i-1].setVisible(false);
						getContentPane().remove(setas[i-1]);
						cont--;
						/* Desempilhando o dado da pilha */
						pilhaEnc.pop();
						JOptionPane.showMessageDialog(null, "Elemento desempilhado: " + removido, "POP!",
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
				if(!pilhaEnc.vazia()) {
					int top = pilhaEnc.top();
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
		
		
		int incrx = 140;
		int incry = 40;
		
		JButton pos0 = new JButton("");
		position.add(0, pos0);
		pos0.setBounds(433, 539, 131, 38);
		
		int x = pos0.getX();
		int y = pos0.getY();
		
		for(int i = 1; i < 10; i++) {
			JButton no = new JButton("");
			if(x == 13) {
				incrx = -140;
			}
			else if(y == 299) {
				incrx = 140;
			}
			
			no.setBounds((x - incrx), (y - incry), 131, 38);
			position.add(i, no);
			x = no.getX();
			y = no.getY();
		}
		
		memoriacheia = position.get(9).isShowing();
		
		setas[0] = new JButton("");
		setas[0].setForeground(new Color(102, 51, 51));
		setas[0].setBackground(new Color(102, 51, 51));
		setas[0].setIcon(new ImageIcon(PilhaEncGUI.class.getResource("/images/seta - r.png")));
		setas[0].setBounds(420, 499, 74, 38);
		
		setas[1] = new JButton("");
		setas[1].setIcon(new ImageIcon(PilhaEncGUI.class.getResource("/images/seta - r.png")));
		setas[1].setForeground(new Color(102, 51, 51));
		setas[1].setBackground(new Color(102, 51, 51));
		setas[1].setBounds(280, 459, 74, 38);
		
		setas[2] = new JButton("");
		setas[2].setIcon(new ImageIcon(PilhaEncGUI.class.getResource("/images/seta - r.png")));
		setas[2].setForeground(new Color(102, 51, 51));
		setas[2].setBackground(new Color(102, 51, 51));
		setas[2].setBounds(140, 419, 74, 38);
		
		setas[3] = new JButton("");
		setas[3].setIcon(new ImageIcon(PilhaEncGUI.class.getResource("/images/setainv - r.png")));
		setas[3].setForeground(new Color(102, 51, 51));
		setas[3].setBackground(new Color(102, 51, 51));
		setas[3].setBounds(83, 379, 74, 38);
		
		setas[4] = new JButton("");
		setas[4].setIcon(new ImageIcon(PilhaEncGUI.class.getResource("/images/setainv - r.png")));
		setas[4].setForeground(new Color(102, 51, 51));
		setas[4].setBackground(new Color(102, 51, 51));
		setas[4].setBounds(223, 339, 74, 38);
		
		setas[5] = new JButton("");
		setas[5].setIcon(new ImageIcon(PilhaEncGUI.class.getResource("/images/setainv - r.png")));
		setas[5].setForeground(new Color(102, 51, 51));
		setas[5].setBackground(new Color(102, 51, 51));
		setas[5].setBounds(363, 299, 74, 38);
		
		setas[6] = new JButton("");
		setas[6].setIcon(new ImageIcon(PilhaEncGUI.class.getResource("/images/seta - r.png")));
		setas[6].setForeground(new Color(102, 51, 51));
		setas[6].setBackground(new Color(102, 51, 51));
		setas[6].setBounds(420, 259, 74, 38);
		
		setas[7] = new JButton("");
		setas[7].setIcon(new ImageIcon(PilhaEncGUI.class.getResource("/images/seta - r.png")));
		setas[7].setForeground(new Color(102, 51, 51));
		setas[7].setBackground(new Color(102, 51, 51));
		setas[7].setBounds(280, 219, 74, 38);
		
		setas[8] = new JButton("");
		setas[8].setIcon(new ImageIcon(PilhaEncGUI.class.getResource("/images/seta - r.png")));
		setas[8].setForeground(new Color(102, 51, 51));
		setas[8].setBackground(new Color(102, 51, 51));
		setas[8].setBounds(140, 179, 74, 38);
		
	}
}