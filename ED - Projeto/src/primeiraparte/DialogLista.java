package primeiraparte;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

import java.awt.Window.Type;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DialogLista extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtElement;
	private JTextField txtPos;
	protected int numero;
	protected int position;

	public static void main(String[] args) {
		try {
			DialogLista dialog = new DialogLista();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	public DialogLista() {
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
		
		setType(Type.UTILITY);
		setTitle("INSERIR!");
		setModal(true);
		setBounds(100, 100, 450, 234);
		setLocation(500, 200);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(51, 51, 51));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblElemento = new JLabel("ELEMENTO :");
			lblElemento.setForeground(new Color(255, 255, 255));
			lblElemento.setFont(new Font("Impact", Font.PLAIN, 18));
			lblElemento.setBounds(90, 11, 88, 29);
			contentPanel.add(lblElemento);
		}
		{
			JLabel lblPosio = new JLabel("POSI\u00C7\u00C3O :");
			lblPosio.setForeground(new Color(255, 255, 255));
			lblPosio.setFont(new Font("Impact", Font.PLAIN, 18));
			lblPosio.setBounds(260, 11, 88, 29);
			contentPanel.add(lblPosio);
		}
		
		txtElement = new JTextField();
		txtElement.setForeground(new Color(0, 0, 0));
		txtElement.setFont(new Font("Impact", Font.PLAIN, 34));
		txtElement.setBounds(82, 51, 96, 68);
		contentPanel.add(txtElement);
		txtElement.setColumns(10);
		
		txtPos = new JTextField();
		txtPos.setForeground(new Color(0, 0, 0));
		txtPos.setFont(new Font("Impact", Font.PLAIN, 34));
		txtPos.setColumns(10);
		txtPos.setBounds(248, 51, 96, 68);
		contentPanel.add(txtPos);
		
		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					String el = txtElement.getText();
					String p = txtPos.getText();
					// CONVERSÃO:
					try {
					if(el != null && p != null) {
						numero = Integer.parseInt(el);
						position = Integer.parseInt(p);
						if(position == 0) {
							JOptionPane.showMessageDialog(null, "Digite uma posição válida", "ERRO", JOptionPane.WARNING_MESSAGE);
						}
						else {
							dispose();
						}
					}
					} catch(Exception e1) {
						JOptionPane.showMessageDialog(null, "Digite um elemento válido", "ERRO", JOptionPane.WARNING_MESSAGE);
					}
			}
		});
		btnOk.setBackground(new Color(255, 255, 204));
		btnOk.setFont(new Font("Impact", Font.PLAIN, 18));
		btnOk.setBounds(319, 155, 89, 29);
		contentPanel.add(btnOk);
	}
}
