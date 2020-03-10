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

public class ListaSeqGUI extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JButton[] position = new JButton[10];
	private static ListaSequencial lista = new ListaSequencial();
	
	public static void main(String[] args) {
		try {
			ListaSeqGUI dialog = new ListaSeqGUI();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ListaSeqGUI() {
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
		
		JLabel lblListaSequencial = new JLabel("LISTA SEQUENCIAL");
		lblListaSequencial.setForeground(new Color(255, 255, 255));
		lblListaSequencial.setFont(new Font("Impact", Font.PLAIN, 26));
		lblListaSequencial.setBounds(389, 11, 199, 58);
		contentPanel.add(lblListaSequencial);
		
		/* BOTÕES DE INSERIR E REMOVER */
		
		JButton btnInserir = new JButton("INSERIR");
		btnInserir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DialogLista input = new DialogLista();
				input.setVisible(true);
				int elemento = input.numero;
				int pos = input.position;
				int tamanho = lista.getTamanhoAtual();
				
				if(lista.inserir(pos, elemento)) {
					for(int i = tamanho; i >= pos; i--) {
						String a = position[i-1].getText();
						position[i].setText(a);
					}
					position[pos-1].setText("" + elemento);
				}
				else if(position[9].isShowing()){
					JOptionPane.showMessageDialog(null, "ERROR: operação inválida", "ERRO", JOptionPane.ERROR_MESSAGE);
				}
				else {
				}
			}
		});
		btnInserir.setBackground(new Color(0, 0, 0));
		btnInserir.setForeground(new Color(204, 204, 204));
		btnInserir.setFont(new Font("Impact", Font.PLAIN, 18));
		btnInserir.setBounds(354, 93, 104, 30);
		contentPanel.add(btnInserir);
		
		JButton btnRemover = new JButton("REMOVER");
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(!lista.vazia()) {
						JOptionPane input = new JOptionPane();
						String conteudo = input.showInputDialog("REMOVER ELEMENTO NA POSIÇÃO: ");
						
						boolean vazia = lista.vazia();
						int pos = Integer.parseInt(conteudo);
						int tamanho = lista.getTamanhoAtual();
						int res = lista.remove(pos);
						
						
						if(res == -1) {
							JOptionPane.showMessageDialog(null, "Posição inválida !", "ERRO", JOptionPane.ERROR_MESSAGE);
						}
						else {
							for(int i = (pos-1); i < tamanho; i++) {
								String b = position[i+1].getText();
								position[i].setText(b);
								position[i+1].setText("");
							}
							JOptionPane.showMessageDialog(null, "Elemento removido: " + res, "REMOVED", JOptionPane.INFORMATION_MESSAGE);
						
						}
					}
					else {
						JOptionPane.showMessageDialog(null, "A lista está vazia !", "ERRO", JOptionPane.ERROR_MESSAGE);
					}
				} 
				catch(Exception ex) {}
		}
		});
		btnRemover.setBackground(new Color(0, 0, 0));
		btnRemover.setForeground(new Color(204, 204, 204));
		btnRemover.setFont(new Font("Impact", Font.PLAIN, 18));
		btnRemover.setBounds(512, 93, 104, 30);
		contentPanel.add(btnRemover);
		
		JButton btnBuscarElemento = new JButton("BUSCAR ELEMENTO");
		btnBuscarElemento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!lista.vazia()) {
					JOptionPane input = new JOptionPane();
					String conteudo = input.showInputDialog("BUSCAR ELEMENTO: ");
					int elemento = Integer.parseInt(conteudo);
					int resultado = lista.getPosicao(elemento);
					
					if(resultado != -1) {
						JOptionPane.showMessageDialog(null, "Elemento está na posição: " + resultado, "RESULT", JOptionPane.INFORMATION_MESSAGE);
					}
					else {
						JOptionPane.showMessageDialog(null, "Elemento não encontrado !", "ERRO", JOptionPane.ERROR_MESSAGE);
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "A lista está vazia", "ERRO", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnBuscarElemento.setForeground(new Color(204, 204, 204));
		btnBuscarElemento.setFont(new Font("Impact", Font.PLAIN, 18));
		btnBuscarElemento.setBackground(Color.BLACK);
		btnBuscarElemento.setBounds(276, 144, 184, 30);
		contentPanel.add(btnBuscarElemento);
		
		JButton btnBuscarPosio = new JButton("BUSCAR POSI\u00C7\u00C3O");
		btnBuscarPosio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!lista.vazia()) {
					JOptionPane input = new JOptionPane();
					String conteudo = input.showInputDialog("BUSCAR NA POSIÇÃO: ");
					int pos = Integer.parseInt(conteudo);
					
					if(pos > 0 && pos < lista.getTamanhoAtual()) {
						int res = lista.getElemento(pos);
						if(res != -1) {
							JOptionPane.showMessageDialog(null, "O elemento ' " + res + " ' está na posição buscada", "RESULT", JOptionPane.INFORMATION_MESSAGE);
						}
						else {
							JOptionPane.showMessageDialog(null, "Elemento não encontrado !", "ERRO", JOptionPane.ERROR_MESSAGE);
						}
					}
					else {
						JOptionPane.showMessageDialog(null, "Posição inválida !", "ERRO", JOptionPane.ERROR_MESSAGE);
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "A lista está vazia", "ERRO", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnBuscarPosio.setForeground(new Color(204, 204, 204));
		btnBuscarPosio.setFont(new Font("Impact", Font.PLAIN, 18));
		btnBuscarPosio.setBackground(Color.BLACK);
		btnBuscarPosio.setBounds(513, 144, 184, 30);
		contentPanel.add(btnBuscarPosio);
		
		/* POSIÇÕES DA LISTA */
		
		position[0] = new JButton("");
		position[0].setBackground(Color.WHITE);
		position[0].setFont(new Font("Impact", Font.PLAIN, 22));
		position[0].setBounds(117, 300, 73, 72);
		contentPanel.add(position[0]);
		
		position[1] = new JButton("");
		position[1].setBackground(Color.WHITE);
		position[1].setFont(new Font("Impact", Font.PLAIN, 22));
		position[1].setBounds(190, 300, 73, 72);
		contentPanel.add(position[1]);
		
		position[2] = new JButton("");
		position[2].setBackground(Color.WHITE);
		position[2].setFont(new Font("Impact", Font.PLAIN, 22));
		position[2].setBounds(263, 300, 73, 72);
		contentPanel.add(position[2]);
		
		position[3] = new JButton("");
		position[3].setBackground(Color.WHITE);
		position[3].setFont(new Font("Impact", Font.PLAIN, 22));
		position[3].setBounds(336, 300, 73, 72);
		contentPanel.add(position[3]);
		
		position[4] = new JButton("");
		position[4].setBackground(Color.WHITE);
		position[4].setFont(new Font("Impact", Font.PLAIN, 22));
		position[4].setBounds(409, 300, 73, 72);
		contentPanel.add(position[4]);
		
		position[5] = new JButton("");
		position[5].setBackground(Color.WHITE);
		position[5].setFont(new Font("Impact", Font.PLAIN, 22));
		position[5].setBounds(482, 300, 73, 72);
		contentPanel.add(position[5]);
		
		position[6] = new JButton("");
		position[6].setBackground(Color.WHITE);
		position[6].setFont(new Font("Impact", Font.PLAIN, 22));
		position[6].setBounds(555, 300, 73, 72);
		contentPanel.add(position[6]);
		
		position[7] = new JButton("");
		position[7].setBackground(Color.WHITE);
		position[7].setFont(new Font("Impact", Font.PLAIN, 22));
		position[7].setBounds(628, 300, 73, 72);
		contentPanel.add(position[7]);
		
		position[8] = new JButton("");
		position[8].setBackground(Color.WHITE);
		position[8].setFont(new Font("Impact", Font.PLAIN, 22));
		position[8].setBounds(701, 300, 73, 72);
		contentPanel.add(position[8]);
		
		position[9] = new JButton("");
		position[9].setBackground(Color.WHITE);
		position[9].setFont(new Font("Impact", Font.PLAIN, 22));
		position[9].setBounds(774, 300, 73, 72);
		contentPanel.add(position[9]);
		
	}
}
