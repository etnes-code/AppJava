package be.sente.frame;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import be.sente.DAO.BosquetConnection;
import be.sente.DAO.DAO;
import be.sente.DAO.FactoryDAO;
import be.sente.DAO.PersonneDAO;
import be.sente.pojo.*;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UserLogIn extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldEmail;
	private JTextField textFieldPassWord;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserLogIn frame = new UserLogIn();
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
	public UserLogIn() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitle = new JLabel("Bienvenue sur le Bosquet Wallon");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTitle.setBounds(77, 11, 268, 43);
		contentPane.add(lblTitle);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmail.setBounds(10, 101, 66, 22);
		contentPane.add(lblEmail);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setBounds(75, 103, 118, 20);
		contentPane.add(textFieldEmail);
		textFieldEmail.setColumns(10);
		
		JLabel lblPassWord = new JLabel("Mot de passe");
		lblPassWord.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPassWord.setBounds(213, 102, 83, 20);
		contentPane.add(lblPassWord);
		
		textFieldPassWord = new JTextField();
		textFieldPassWord.setBounds(295, 103, 107, 20);
		contentPane.add(textFieldPassWord);
		textFieldPassWord.setColumns(10);
		
		JButton btnConnexion = new JButton("Se connecter");
		btnConnexion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//vérifier si les champs sont vides
				FactoryDAO adf=new FactoryDAO();
				DAO<Personne> personnedao=adf.getPersonneDAO();	
				//DAO<Personne> personnedao=new PersonneDAO(BosquetConnection.getInstance());
				Personne user=new Personne();
				user=personnedao.findUser(textFieldEmail.getText(),textFieldPassWord.getText());
				if(user.getClass().getSimpleName().equals("Personne")) {
					JOptionPane.showMessageDialog(null, "Email ou mot de passe incorrecte");
				}else {
					Home h= new Home(user);
					UserLogIn w=new UserLogIn();
					
					h.setVisible(true);
					w.dispose();					
				}
				
			}
		});
		btnConnexion.setBounds(295, 141, 129, 23);
		contentPane.add(btnConnexion);
		
		JLabel lblInscription = new JLabel("Pas encore inscrit ?");
		lblInscription.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblInscription.setBounds(29, 200, 118, 22);
		contentPane.add(lblInscription);
		
		JButton btnInscription = new JButton("Clique-ici !");
		btnInscription.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Register windowRegister= new Register();
				windowRegister.setVisible(true);
			}
		});
		btnInscription.setBounds(157, 201, 118, 23);
		contentPane.add(btnInscription);
	}
}
