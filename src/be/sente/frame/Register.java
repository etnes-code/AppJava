package be.sente.frame;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class Register extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldEmail;
	private JTextField textFieldPassWord;
	private JTextField textFieldNom;
	private JTextField textFieldPrenom;
	private JTextField textFieldRue;
	private JTextField textFieldNum;
	private JTextField textFieldCp;
	private JTextField textFieldVille;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Register frame = new Register();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Register() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 300, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitle = new JLabel("Inscription");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTitle.setBounds(78, 11, 108, 25);
		contentPane.add(lblTitle);
		
		//Inscription
		
		JLabel lblEmail_1 = new JLabel("S'inscrire en tant que");
		lblEmail_1.setBounds(10, 39, 117, 25);
		contentPane.add(lblEmail_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Client", "Artiste", "Organisateur", "Gestionnaire"}));
		comboBox.setBounds(137, 40, 125, 25);
		contentPane.add(comboBox);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(10, 75, 61, 25);
		contentPane.add(lblEmail);
		
		JLabel lblPassWord = new JLabel("Mot de passe");
		lblPassWord.setBounds(10, 111, 84, 25);
		contentPane.add(lblPassWord);
		
		JLabel lblNom = new JLabel("Nom");
		lblNom.setBounds(10, 163, 48, 25);
		contentPane.add(lblNom);
		
		JLabel lblPrenom = new JLabel("Pr�nom");
		lblPrenom.setBounds(10, 199, 48, 25);
		contentPane.add(lblPrenom);
		
		JLabel lblRue = new JLabel("Rue");
		lblRue.setBounds(10, 260, 29, 25);
		contentPane.add(lblRue);
		
		JLabel lblNum = new JLabel("N");
		lblNum.setHorizontalAlignment(SwingConstants.CENTER);
		lblNum.setBounds(200, 260, 29, 25);
		contentPane.add(lblNum);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setBounds(112, 76, 142, 23);
		contentPane.add(textFieldEmail);
		textFieldEmail.setColumns(10);
		
		textFieldPassWord = new JTextField();
		textFieldPassWord.setColumns(10);
		textFieldPassWord.setBounds(112, 112, 142, 23);
		contentPane.add(textFieldPassWord);
		
		textFieldNom = new JTextField();
		textFieldNom.setColumns(10);
		textFieldNom.setBounds(112, 164, 142, 23);
		contentPane.add(textFieldNom);
		
		textFieldPrenom = new JTextField();
		textFieldPrenom.setColumns(10);
		textFieldPrenom.setBounds(112, 201, 142, 23);
		contentPane.add(textFieldPrenom);
		
		textFieldRue = new JTextField();
		textFieldRue.setColumns(10);
		textFieldRue.setBounds(44, 262, 142, 23);
		contentPane.add(textFieldRue);
		
		textFieldNum = new JTextField();
		textFieldNum.setBounds(240, 262, 34, 20);
		contentPane.add(textFieldNum);
		textFieldNum.setColumns(10);
		
		JLabel lblCp = new JLabel("Code postal");
		lblCp.setBounds(10, 296, 68, 25);
		contentPane.add(lblCp);
		
		JLabel lblVille = new JLabel("Ville");
		lblVille.setBounds(146, 296, 29, 25);
		contentPane.add(lblVille);
		
		textFieldCp = new JTextField();
		textFieldCp.setColumns(10);
		textFieldCp.setBounds(81, 296, 55, 23);
		contentPane.add(textFieldCp);
		
		textFieldVille = new JTextField();
		textFieldVille.setColumns(10);
		textFieldVille.setBounds(185, 296, 74, 23);
		contentPane.add(textFieldVille);
		
		JButton btnValider = new JButton("Valider");
		btnValider.setBounds(20, 356, 89, 23);
		contentPane.add(btnValider);
		
		JButton btnReset = new JButton("Reset");
		btnReset.setBounds(140, 356, 89, 23);
		contentPane.add(btnReset);
		
		
			
	}
}
