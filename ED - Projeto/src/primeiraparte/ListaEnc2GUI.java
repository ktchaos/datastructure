package primeiraparte;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Window.Type;

import javax.swing.ImageIcon;
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

public class ListaEnc2GUI extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private static ListaEncadeada lista = new ListaEncadeada();
	private JButton positions[] = new JButton[15];
	private JButton setas[] = new JButton[14];
	private int cont = 0;

	public static void main(String[] args) {
		try {
			ListaEnc2GUI dialog = new ListaEnc2GUI();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ListaEnc2GUI() {
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
		setBounds(100, 100, 970, 580);
		setLocation(250, 50);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(0, 51, 51));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JButton btnInserir = new JButton("INSERIR");
		btnInserir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DialogLista input = new DialogLista();
				input.setVisible(true);
				
				int elemento = input.numero;
				int pos = input.position;
				
				int tamanho = lista.tamanho();
				
				if(lista.insere(pos, elemento) && !(positions[14].isShowing())) {
					
					/* INSERIR AS SETAS */
					if(cont >= 1) {
						contentPanel.add(setas[cont-1]);
						setas[cont-1].setVisible(true);
						setas[cont-1].doClick();
					}
					
					
					/* INSERÇÃO INICIAL */
					if(tamanho == 0) {
						contentPanel.add(positions[0]);
						positions[0].setText("" + elemento);
						positions[0].setVisible(true);
						positions[0].doClick();
						cont++;
					}
					/* INSERIR NO FINAL */
					else if(pos == tamanho+1) {
						contentPanel.add(positions[pos-1]);
						positions[pos-1].setText("" + elemento);
						positions[pos-1].setVisible(true);
						positions[pos-1].doClick();
						cont++;
					}
					/* INSERIR NO MEIO */
					else {
						
						JButton aloc = positions[tamanho];
						positions[tamanho].setText("" + positions[tamanho-1].getText());
						contentPanel.add(aloc);
						aloc.setVisible(true);
						aloc.doClick();
						
						for(int i = tamanho-1; i > pos-1; i--) {
							positions[i].setText("" + positions[i-1].getText());
						}
						
						positions[pos-1].setText("" + elemento);
						cont++;
					}
				}
				else if(positions[14].isShowing()){
					JOptionPane.showMessageDialog(null, "A memória está cheia", "ERRO", JOptionPane.ERROR_MESSAGE);
				}
				else {}
			}
		});
		btnInserir.setBackground(new Color(51, 51, 51));
		btnInserir.setForeground(new Color(255, 255, 204));
		btnInserir.setFont(new Font("Impact", Font.PLAIN, 20));
		btnInserir.setBounds(144, 77, 122, 36);
		contentPanel.add(btnInserir);
		
		JLabel lblListaEncadeada = new JLabel("LISTA ENCADEADA");
		lblListaEncadeada.setForeground(new Color(255, 255, 255));
		lblListaEncadeada.setFont(new Font("Impact", Font.PLAIN, 26));
		lblListaEncadeada.setBounds(394, 0, 199, 50);
		contentPanel.add(lblListaEncadeada);
		
		JButton btnRemover = new JButton("REMOVER");
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane input = new JOptionPane();
				String conteudo = input.showInputDialog("REMOVER ELEMENTO NA POSIÇÃO: ");
				
				try {
					int pos = Integer.parseInt(conteudo);
					int tamanho = lista.tamanho();
					if(pos <= 0 || pos > tamanho) {
						JOptionPane.showMessageDialog(null, "Posição inválida !", "ERRO", JOptionPane.ERROR_MESSAGE);
					}
					else if(lista.remove(pos) != -1) {
						String res = positions[pos-1].getText();
						if(pos == 1 &&tamanho == 1) {
							positions[0].setVisible(false);
							cont--;
						}
						else if(pos == tamanho) {
							positions[tamanho-1].setVisible(false);
							setas[tamanho-2].setVisible(false);
							cont--;
						}
						else {
							positions[tamanho-1].setVisible(false);
							setas[tamanho-2].setVisible(false);
							
							for(int i = pos-1; i < tamanho-1; i++) {
								positions[i].setText("" + positions[i+1].getText());
							}
							cont--;					
						}
						
						JOptionPane.showMessageDialog(null, "Elemento removido: " + res, "REMOVED", JOptionPane.INFORMATION_MESSAGE);
					}
				}
				catch(Exception e1) {}
			}
		});
		btnRemover.setBackground(new Color(51, 51, 51));
		btnRemover.setForeground(new Color(255, 255, 204));
		btnRemover.setFont(new Font("Impact", Font.PLAIN, 20));
		btnRemover.setBounds(308, 77, 122, 36);
		contentPanel.add(btnRemover);
		
		JButton btnHead = new JButton("CABE\u00C7A");
		btnHead.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(lista.tamanho() == 0) {
					JOptionPane.showMessageDialog(null, "A lista não tem cabeça! (vazia)", "HEAD", JOptionPane.WARNING_MESSAGE);
				}
				else {
					JOptionPane.showMessageDialog(null, "Cabeça da lista: " + positions[0].getText(), "HEAD", JOptionPane.INFORMATION_MESSAGE);
				}
				
			}
		});
		btnHead.setForeground(new Color(255, 255, 204));
		btnHead.setFont(new Font("Impact", Font.PLAIN, 20));
		btnHead.setBackground(new Color(153, 0, 0));
		btnHead.setBounds(50, 150, 122, 36);
		contentPanel.add(btnHead);
		
		JButton btnBuscarElemento = new JButton("BUSCAR ELEMENTO");
		btnBuscarElemento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!lista.vazia()) {
					try {
						JOptionPane input = new JOptionPane();
						String conteudo = input.showInputDialog("BUSCAR ELEMENTO: ");
						int elemento = Integer.parseInt(conteudo);
						int resultado = lista.posicao(elemento);
						
						if(resultado != -1) {
							JOptionPane.showMessageDialog(null, "Elemento está na posição: " + resultado, "RESULT", JOptionPane.INFORMATION_MESSAGE);
						}
						else {
							JOptionPane.showMessageDialog(null, "Posição inválida", "ERRO", JOptionPane.ERROR_MESSAGE);
						}
					}catch(Exception e2) {}
					
				}
				else {
					JOptionPane.showMessageDialog(null, "A lista está vazia", "ERRO", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnBuscarElemento.setForeground(new Color(255, 255, 204));
		btnBuscarElemento.setFont(new Font("Impact", Font.PLAIN, 20));
		btnBuscarElemento.setBackground(new Color(51, 51, 51));
		btnBuscarElemento.setBounds(472, 78, 179, 36);
		contentPanel.add(btnBuscarElemento);
		
		JButton btnBuscarPosio = new JButton("BUSCAR POSI\u00C7\u00C3O");
		btnBuscarPosio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!lista.vazia()) {
					try {
						JOptionPane input = new JOptionPane();
						String conteudo = input.showInputDialog("BUSCAR ELEMENTO: ");
						int pos = Integer.parseInt(conteudo);
						
						int resultado = lista.elemento(pos);
						if(resultado != -1) {
							JOptionPane.showMessageDialog(null, "O elemento ' " + resultado + " ' está na posição buscada", "RESULT", JOptionPane.INFORMATION_MESSAGE);
						}
						else {
							JOptionPane.showMessageDialog(null, "Elemento não encontrado !", "ERRO", JOptionPane.ERROR_MESSAGE);
						}
					}catch(Exception e1) {}
					
				}
				else {
					JOptionPane.showMessageDialog(null, "A lista está vazia", "ERRO", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnBuscarPosio.setForeground(new Color(255, 255, 204));
		btnBuscarPosio.setFont(new Font("Impact", Font.PLAIN, 20));
		btnBuscarPosio.setBackground(new Color(51, 51, 51));
		btnBuscarPosio.setBounds(690, 77, 179, 36);
		contentPanel.add(btnBuscarPosio);

		
		
		
		
		// DECLARAÇÕES DE VARIÁVEIS:
		
		/* POSIÇÕES DAS SETAS */
		setas[0] = new JButton("");
		setas[0].setForeground(new Color(0, 51, 51));
		setas[0].setBackground(new Color(0, 51, 51));
		setas[0].setIcon(new ImageIcon(ListaEnc2GUI.class.getResource("/images/setalista - r.png")));
		setas[0].setBounds(136, 208, 68, 38);
		
		setas[1] = new JButton("");
		setas[1].setForeground(new Color(0, 51, 51));
		setas[1].setBackground(new Color(0, 51, 51));
		setas[1].setIcon(new ImageIcon(ListaEnc2GUI.class.getResource("/images/setalista - r.png")));
		setas[1].setBounds(266, 208, 68, 38);
		
		setas[2] = new JButton("");
		setas[2].setForeground(new Color(0, 51, 51));
		setas[2].setBackground(new Color(0, 51, 51));
		setas[2].setIcon(new ImageIcon(ListaEnc2GUI.class.getResource("/images/setalista - r.png")));
		setas[2].setBounds(396, 208, 68, 38);
		
		setas[3] = new JButton("");
		setas[3].setForeground(new Color(0, 51, 51));
		setas[3].setBackground(new Color(0, 51, 51));
		setas[3].setIcon(new ImageIcon(ListaEnc2GUI.class.getResource("/images/setalista - r.png")));
		setas[3].setBounds(526, 208, 68, 38);
		
		setas[4] = new JButton("");
		setas[4].setForeground(new Color(0, 51, 51));
		setas[4].setBackground(new Color(0, 51, 51));
		setas[4].setIcon(new ImageIcon(ListaEnc2GUI.class.getResource("/images/setalista - r.png")));
		setas[4].setBounds(656, 208, 68, 38);
	
		setas[5] = new JButton("");
		setas[5].setForeground(new Color(0, 51, 51));
		setas[5].setBackground(new Color(0, 51, 51));
		setas[5].setIcon(new ImageIcon(ListaEnc2GUI.class.getResource("/images/setalista - r.png")));
		setas[5].setBounds(786, 208, 68, 38);
		
		setas[6] = new JButton("");
		setas[6].setForeground(new Color(0, 51, 51));
		setas[6].setBackground(new Color(0, 51, 51));
		setas[6].setIcon(new ImageIcon(ListaEnc2GUI.class.getResource("/images/setalistadown - r.png")));
		setas[6].setBounds(867, 255, 36, 60);
		
		setas[7] = new JButton("");
		setas[7].setForeground(new Color(0, 51, 51));
		setas[7].setBackground(new Color(0, 51, 51));
		setas[7].setIcon(new ImageIcon(ListaEnc2GUI.class.getResource("/images/setalistadown - r.png")));
		setas[7].setBounds(867, 378, 36, 60);
		
		setas[8] = new JButton("");
		setas[8].setForeground(new Color(0, 51, 51));
		setas[8].setBackground(new Color(0, 51, 51));
		setas[8].setIcon(new ImageIcon(ListaEnc2GUI.class.getResource("/images/setalistaleft - r.png")));
		setas[8].setBounds(786, 452, 68, 38);
		
		setas[9] = new JButton("");
		setas[9].setForeground(new Color(0, 51, 51));
		setas[9].setBackground(new Color(0, 51, 51));
		setas[9].setIcon(new ImageIcon(ListaEnc2GUI.class.getResource("/images/setalistaleft - r.png")));
		setas[9].setBounds(656, 452, 68, 38);
		
		setas[10] = new JButton("");
		setas[10].setForeground(new Color(0, 51, 51));
		setas[10].setBackground(new Color(0, 51, 51));
		setas[10].setIcon(new ImageIcon(ListaEnc2GUI.class.getResource("/images/setalistaleft - r.png")));
		setas[10].setBounds(526, 452, 68, 38);
		
		setas[11] = new JButton("");
		setas[11].setForeground(new Color(0, 51, 51));
		setas[11].setBackground(new Color(0, 51, 51));
		setas[11].setIcon(new ImageIcon(ListaEnc2GUI.class.getResource("/images/setalistaleft - r.png")));
		setas[11].setBounds(396, 452, 68, 38);
		
		setas[12] = new JButton("");
		setas[12].setForeground(new Color(0, 51, 51));
		setas[12].setBackground(new Color(0, 51, 51));
		setas[12].setIcon(new ImageIcon(ListaEnc2GUI.class.getResource("/images/setalistaleft - r.png")));
		setas[12].setBounds(266, 452, 68, 38);
		
		setas[13] = new JButton("");
		setas[13].setForeground(new Color(0, 51, 51));
		setas[13].setBackground(new Color(0, 51, 51));
		setas[13].setIcon(new ImageIcon(ListaEnc2GUI.class.getResource("/images/setalistaleft - r.png")));
		setas[13].setBounds(136, 452, 68, 38);
		
		
		/* POSIÇÕES DOS NÓS */
		
		positions[0] = new JButton("");
		positions[0].setBounds(70, 190, 70, 70);
		positions[0].setBackground(Color.WHITE);
		positions[0].setFont(new Font("Impact", Font.PLAIN, 24));
		
		positions[1] = new JButton("");
		positions[1].setBounds(200, 190, 70, 70);
		positions[1].setBackground(Color.WHITE);
		positions[1].setFont(new Font("Impact", Font.PLAIN, 24));
		
		positions[2] = new JButton("");
		positions[2].setBounds(330, 190, 70, 70);
		positions[2].setBackground(Color.WHITE);
		positions[2].setFont(new Font("Impact", Font.PLAIN, 24));
		
		positions[3] = new JButton("");
		positions[3].setBounds(460, 190, 70, 70);
		positions[3].setBackground(Color.WHITE);
		positions[3].setFont(new Font("Impact", Font.PLAIN, 24));
		
		positions[4] = new JButton("");
		positions[4].setBounds(590, 190, 70, 70);
		positions[4].setBackground(Color.WHITE);
		positions[4].setFont(new Font("Impact", Font.PLAIN, 24));
		
		positions[5] = new JButton("");
		positions[5].setBounds(720, 190, 70, 70);
		positions[5].setBackground(Color.WHITE);
		positions[5].setFont(new Font("Impact", Font.PLAIN, 24));
		
		positions[6] = new JButton("");
		positions[6].setBounds(850, 190, 70, 70);
		positions[6].setBackground(Color.WHITE);
		positions[6].setFont(new Font("Impact", Font.PLAIN, 24));
		
		positions[7] = new JButton("");
		positions[7].setBounds(850, 311, 70, 70);
		positions[7].setBackground(Color.WHITE);
		positions[7].setFont(new Font("Impact", Font.PLAIN, 24));
		
		positions[8] = new JButton("");
		positions[8].setBounds(850, 435, 70, 70);
		positions[8].setBackground(Color.WHITE);
		positions[8].setFont(new Font("Impact", Font.PLAIN, 24));
		
		positions[9] = new JButton("");
		positions[9].setBounds(720, 435, 70, 70);
		positions[9].setBackground(Color.WHITE);
		positions[9].setFont(new Font("Impact", Font.PLAIN, 24));
		
		positions[10] = new JButton("");
		positions[10].setBounds(590, 435, 70, 70);
		positions[10].setBackground(Color.WHITE);
		positions[10].setFont(new Font("Impact", Font.PLAIN, 24));
		
		positions[11] = new JButton("");
		positions[11].setBounds(460, 435, 70, 70);
		positions[11].setBackground(Color.WHITE);
		positions[11].setFont(new Font("Impact", Font.PLAIN, 24));
		
		positions[12] = new JButton("");
		positions[12].setBounds(330, 435, 70, 70);
		positions[12].setBackground(Color.WHITE);
		positions[12].setFont(new Font("Impact", Font.PLAIN, 24));
		
		positions[13] = new JButton("");
		positions[13].setBounds(200, 435, 70, 70);
		positions[13].setBackground(Color.WHITE);
		positions[13].setFont(new Font("Impact", Font.PLAIN, 24));
		
		positions[14] = new JButton("");
		positions[14].setBounds(70, 435, 70, 70);
		positions[14].setBackground(Color.WHITE);
		positions[14].setFont(new Font("Impact", Font.PLAIN, 24));
	}
}