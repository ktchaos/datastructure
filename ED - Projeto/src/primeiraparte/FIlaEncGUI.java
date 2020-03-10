package primeiraparte;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Window.Type;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;

public class FIlaEncGUI extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private static FilaEncadeada fila = new FilaEncadeada();
	private JButton positions[] = new JButton[12];
	private JButton setas[] = new JButton[11];
	private int cont = 0;
	
	
	public static void main(String[] args) {
		try {
			FIlaEncGUI dialog = new FIlaEncGUI();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public FIlaEncGUI() {
		
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
		
		JLabel lblFilaSequencial = new JLabel("FILA ENCADEADA");
		lblFilaSequencial.setForeground(new Color(0, 0, 0));
		lblFilaSequencial.setFont(new Font("Impact", Font.PLAIN, 28));
		lblFilaSequencial.setBounds(308, 22, 205, 45);
		contentPanel.add(lblFilaSequencial);
		
		JButton btnInserir = new JButton("INSERIR");
		btnInserir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!positions[11].isShowing()) {
					JOptionPane input = new JOptionPane();
					String conteudo = input.showInputDialog("NOVO ELEMENTO:");
					if(conteudo != null && (conteudo.length()) > 0) {
						try {
							int valor = Integer.parseInt(conteudo);
							if(fila.insere(valor)) {
								if(cont >= 1) {
									contentPanel.add(setas[cont-1]);
									setas[cont-1].setVisible(true);
									setas[cont-1].doClick();
								}
								positions[cont].setText("" + valor);
								positions[cont].setFont(new Font("Impact", Font.PLAIN, 26));
								positions[cont].setForeground(Color.BLACK);
								contentPanel.add(positions[cont]);
								positions[cont].setVisible(true);
								positions[cont].doClick();
								cont++;
							}
							
						}
						catch(Exception e1) {
							JOptionPane.showMessageDialog(null, "Digite um elemento válido", "ERRO", JOptionPane.WARNING_MESSAGE);
						}
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "A memória está cheia !", "FULL", JOptionPane.ERROR_MESSAGE);
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
				if(!fila.vazia() && positions[0].isShowing()) {
					JButton no = positions[0];
					String removido = no.getText();
					try {
						for(int n = 0; n < cont; n++) {
							positions[n].setText("" + positions[n+1].getText());
						}
						positions[cont-1].setVisible(false);
						setas[cont-2].setVisible(false);
						cont--;

						fila.remove();
						JOptionPane.showMessageDialog(null, "Elemento removido: " + removido, "REMOVED!",
								JOptionPane.INFORMATION_MESSAGE);
					}
					catch(Exception e2) {
						JOptionPane.showMessageDialog(null, "Último elemento removido: " +
					removido , "EMPTY!", JOptionPane.WARNING_MESSAGE);
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
		
		JButton btnInicio = new JButton("CABEÇA");
		btnInicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!fila.vazia()) {
					int inicio = fila.getInicio();
					JOptionPane.showMessageDialog(null, "Início da fila: " + inicio, "FIRST", JOptionPane.INFORMATION_MESSAGE);
				}
				else {
					JOptionPane.showMessageDialog(null, "A fila está vazia", "EMPTY!", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnInicio.setForeground(new Color(204, 204, 204));
		btnInicio.setFont(new Font("Impact", Font.PLAIN, 18));
		btnInicio.setBackground(new Color(102, 0, 0));
		btnInicio.setBounds(294, 128, 95, 29);
		contentPanel.add(btnInicio);
		
		JButton btnFim = new JButton("CAUDA");
		btnFim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!fila.vazia()) {
					int fim = fila.getFim();
					JOptionPane.showMessageDialog(null, "Fim da fila: " + fim, "END", JOptionPane.INFORMATION_MESSAGE);
				}
				else {
					JOptionPane.showMessageDialog(null, "A fila está vazia", "NO ENDING!", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnFim.setForeground(new Color(204, 204, 204));
		btnFim.setFont(new Font("Impact", Font.PLAIN, 18));
		btnFim.setBackground(new Color(102, 0, 0));
		btnFim.setBounds(399, 128, 95, 29);
		contentPanel.add(btnFim);

		
		/* POSIÇÕES */
		
		positions[0] = new JButton("");
		positions[0].setBackground(Color.WHITE);
		positions[0].setBounds(44, 182, 81, 68);
		
		positions[1] = new JButton("");
		positions[1].setBackground(Color.WHITE);
		positions[1].setBounds(182, 182, 81, 68);
		
		positions[2] = new JButton("");
		positions[2].setBackground(Color.WHITE);
		positions[2].setBounds(320, 182, 81, 68);
		
		positions[3] = new JButton("");
		positions[3].setBackground(Color.WHITE);
		positions[3].setBounds(458, 182, 81, 68);
		
		positions[4] = new JButton("");
		positions[4].setBackground(Color.WHITE);
		positions[4].setBounds(596, 182, 81, 68);
		
		positions[5] = new JButton("");
		positions[5].setBackground(Color.WHITE);
		positions[5].setBounds(735, 182, 81, 68);
		
		positions[6] = new JButton("");
		positions[6].setBackground(Color.WHITE);
		positions[6].setBounds(735, 307, 81, 68);
		
		positions[7] = new JButton("");
		positions[7].setBackground(Color.WHITE);
		positions[7].setBounds(596, 307, 81, 68);
		
		positions[8] = new JButton("");
		positions[8].setBackground(Color.WHITE);
		positions[8].setBounds(458, 307, 81, 68);
		
		positions[9] = new JButton("");
		positions[9].setBackground(Color.WHITE);
		positions[9].setBounds(320, 307, 81, 68);
		
		positions[10] = new JButton("");
		positions[10].setBackground(Color.WHITE);
		positions[10].setBounds(182, 307, 81, 68);
		
		positions[11] = new JButton("");
		positions[11].setBackground(Color.WHITE);
		positions[11].setBounds(44, 307, 81, 68);
		
		
		/* SETAS */
		
		setas[0] = new JButton("");
		setas[0].setBackground(new Color(51, 102, 153));
		setas[0].setIcon(new ImageIcon(FIlaEncGUI.class.getResource("/images/setalista - r.png")));
		setas[0].setBounds(122, 201, 62, 36);
	
		setas[1] = new JButton("");
		setas[1].setIcon(new ImageIcon(FIlaEncGUI.class.getResource("/images/setalista - r.png")));
		setas[1].setBackground(new Color(51, 102, 153));
		setas[1].setBounds(260, 201, 62, 36);
		
		setas[2] = new JButton("");
		setas[2].setIcon(new ImageIcon(FIlaEncGUI.class.getResource("/images/setalista - r.png")));
		setas[2].setBackground(new Color(51, 102, 153));
		setas[2].setBounds(398, 201, 62, 36);
		
		setas[3] = new JButton("");
		setas[3].setIcon(new ImageIcon(FIlaEncGUI.class.getResource("/images/setalista - r.png")));
		setas[3].setBackground(new Color(51, 102, 153));
		setas[3].setBounds(536, 201, 62, 36);
		
		setas[4] = new JButton("");
		setas[4].setIcon(new ImageIcon(FIlaEncGUI.class.getResource("/images/setalista - r.png")));
		setas[4].setBackground(new Color(51, 102, 153));
		setas[4].setBounds(674, 201, 62, 36);
		
		setas[5] = new JButton("");
		setas[5].setIcon(new ImageIcon(FIlaEncGUI.class.getResource("/images/setalistaleft - r.png")));
		setas[5].setBackground(new Color(51, 102, 153));
		setas[5].setBounds(674, 325, 62, 36);
		
		setas[6] = new JButton("");
		setas[6].setIcon(new ImageIcon(FIlaEncGUI.class.getResource("/images/setalistaleft - r.png")));
		setas[6].setBackground(new Color(51, 102, 153));
		setas[6].setBounds(536, 325, 62, 36);
		
		setas[7] = new JButton("");
		setas[7].setIcon(new ImageIcon(FIlaEncGUI.class.getResource("/images/setalistaleft - r.png")));
		setas[7].setBackground(new Color(51, 102, 153));
		setas[7].setBounds(398, 325, 62, 36);
		
		setas[8] = new JButton("");
		setas[8].setIcon(new ImageIcon(FIlaEncGUI.class.getResource("/images/setalistaleft - r.png")));
		setas[8].setBackground(new Color(51, 102, 153));
		setas[8].setBounds(260, 325, 62, 36);
		
		setas[9] = new JButton("");
		setas[9].setIcon(new ImageIcon(FIlaEncGUI.class.getResource("/images/setalistaleft - r.png")));
		setas[9].setBackground(new Color(51, 102, 153));
		setas[9].setBounds(122, 325, 62, 36);
	
		setas[10] = new JButton("");
		setas[10].setIcon(new ImageIcon(FIlaEncGUI.class.getResource("/images/setalistadown - r.png")));
		setas[10].setBackground(new Color(51, 102, 153));
		setas[10].setBounds(759, 249, 36, 62);
	}
}