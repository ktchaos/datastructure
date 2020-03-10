package primeiraparte;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Window.Type;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Credits extends JDialog {

	private final JPanel contentPanel = new JPanel();

	public static void main(String[] args) {
		try {
			Credits dialog = new Credits();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Credits() {

		setType(Type.UTILITY);
		setModal(true);
		
		setBounds(100, 100, 800, 483);
		setLocation(250, 50);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(102, 51, 51));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblJjndfsdf = new JLabel("Desenvolvido e editado por Catarina Serrano durante os meses de Fevereiro e Mar\u00E7o.");
		lblJjndfsdf.setForeground(Color.WHITE);
		lblJjndfsdf.setFont(new Font("Impact", Font.PLAIN, 20));
		lblJjndfsdf.setBounds(34, 105, 722, 66);
		contentPanel.add(lblJjndfsdf);
		
		JLabel lblCredits = new JLabel("CR\u00C9DITOS");
		lblCredits.setForeground(Color.WHITE);
		lblCredits.setFont(new Font("Impact", Font.PLAIN, 26));
		lblCredits.setBounds(325, 11, 113, 66);
		contentPanel.add(lblCredits);
		
		JLabel lblGitGithubcomktchaos = new JLabel("Git: github.com/ktchaos");
		lblGitGithubcomktchaos.setForeground(Color.WHITE);
		lblGitGithubcomktchaos.setFont(new Font("Impact", Font.PLAIN, 20));
		lblGitGithubcomktchaos.setBounds(280, 190, 241, 46);
		contentPanel.add(lblGitGithubcomktchaos);
		
		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnOk.setForeground(Color.WHITE);
		btnOk.setBackground(Color.BLACK);
		btnOk.setFont(new Font("Impact", Font.PLAIN, 22));
		btnOk.setBounds(325, 353, 89, 30);
		contentPanel.add(btnOk);
	}

}
