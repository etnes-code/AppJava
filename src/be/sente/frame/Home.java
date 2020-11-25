package be.sente.frame;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import be.sente.DAO.DAO;
import be.sente.DAO.FactoryDAO;
import be.sente.pojo.Organisateur;
import be.sente.pojo.Personne;
import be.sente.pojo.Spectacle;

import javax.swing.JList;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Home extends JFrame {

	private JPanel contentPane;
	private  Personne  user= new Personne();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home frame = new Home();
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
	public Home(int id) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100,640, 480);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panelClient = new JPanel();
		panelClient.setBounds(10, 82, 604, 348);
		contentPane.add(panelClient);
		panelClient.setLayout(null);
		
		panelClient.setVisible(false);
		user=user.getUser(id);
		if(user.getClass().getSimpleName().equals("Client")) {
			panelClient.setVisible(true);
		} 
			Organisateur orga=new Organisateur();
			orga=(Organisateur) user;
			
		
		
		
		JButton btnBuy = new JButton("Acheter");
		btnBuy.setBounds(29, 93, 99, 60);
		panelClient.add(btnBuy);
		
		JButton btnInformation = new JButton("Information");
		btnInformation.setBounds(170, 93, 99, 60);
		panelClient.add(btnInformation);
		
		JButton btnNewSpectacle_3 = new JButton("Nouveau");
		btnNewSpectacle_3.setBounds(29, 198, 99, 60);
		panelClient.add(btnNewSpectacle_3);
		
		JButton btnNewSpectacle_4 = new JButton("Nouveau");
		btnNewSpectacle_4.setBounds(170, 198, 99, 60);
		panelClient.add(btnNewSpectacle_4);
		
		JList listCommande = new JList();
		listCommande.setBounds(303, 36, 291, 312);
		panelClient.add(listCommande);
		
		JLabel titlelistbuy = new JLabel("Liste de vos achats");
		titlelistbuy.setBounds(303, 11, 266, 21);
		panelClient.add(titlelistbuy);
		
		JPanel panelOrga = new JPanel();
		panelOrga.setBounds(10, 82, 604, 348);
		contentPane.add(panelOrga);
		panelOrga.setLayout(null);
		

		JLabel lblTitleSpectacle = new JLabel("Liste de vos r\u00E9servation");
		lblTitleSpectacle.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		lblTitleSpectacle.setBounds(329, 82, 245, 25);
		contentPane.add(lblTitleSpectacle);
		
		
		
		JLabel lblTitle = new JLabel("Bienvenue "+user.getPrenom()+" "+user.getNom());
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
		lblTitle.setBounds(155, 29, 320, 25);
		contentPane.add(lblTitle);
		
		JList listSpectacle = new JList();
		listSpectacle.setBounds(313, 33, 291, 312);
		panelOrga.add(listSpectacle);
		for(var item : orga.getListReservation()) {
			int cpt=1;
			System.out.println(cpt+" "+item.getPlanning().getDateDebutR());
			cpt++;
		}
		JButton btnNewSpectacle = new JButton("Nouveau");
		btnNewSpectacle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ReservationSpectacle w=new ReservationSpectacle((Organisateur)user);
				Home ww=new Home(id);
				ww.setVisible(false);
				dispose();
				w.setVisible(true);				
			}
		});
		btnNewSpectacle.setBounds(29, 93, 99, 60);
		panelOrga.add(btnNewSpectacle);
		
		JButton btnInfo = new JButton("Information");
		btnInfo.setBounds(170, 93, 99, 60);
		panelOrga.add(btnInfo);
		
		JButton btnUpdate = new JButton("Modifier");
		btnUpdate.setBounds(29, 198, 99, 60);
		panelOrga.add(btnUpdate);
		
		JButton btnNewButton_3 = new JButton("New button");
		btnNewButton_3.setBounds(170, 198, 99, 60);
		panelOrga.add(btnNewButton_3);
		
		JButton btnDeco = new JButton("Deconnecter");
		btnDeco.setBackground(Color.RED);
		btnDeco.setForeground(Color.BLACK);
		btnDeco.setBounds(10, 52, 126, 23);
		contentPane.add(btnDeco);
		btnDeco.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserLogIn deco=new UserLogIn();
				Home ww=new Home(0);
				ww.setVisible(false);
				dispose();
				deco.setVisible(true);	
			}
		});
		
	
		
	}
}
