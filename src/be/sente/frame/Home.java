package be.sente.frame;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import be.sente.pojo.Personne;

import javax.swing.JList;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
	public Home(Object obj) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100,640, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		user=(Personne)obj;
		
		
		JLabel lblTitleSpectacle = new JLabel("Liste de vos spectacles");
		lblTitleSpectacle.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		lblTitleSpectacle.setBounds(329, 82, 245, 25);
		contentPane.add(lblTitleSpectacle);
		
		JLabel lblTitle = new JLabel("Bienvenue "+user.getPrenom()+" "+user.getNom());
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
		lblTitle.setBounds(155, 29, 320, 25);
		contentPane.add(lblTitle);
		
		JList listSpectacle = new JList();
		listSpectacle.setBounds(323, 118, 291, 312);
		contentPane.add(listSpectacle);
		
		JButton btnNewSpectacle = new JButton("Nouveau");
		btnNewSpectacle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ReservationSpectacle w=new ReservationSpectacle();
				Home ww=new Home(user);
				ww.setVisible(false);
				dispose();
				w.setVisible(true);
				
			}
		});
		btnNewSpectacle.setBounds(30, 165, 99, 60);
		contentPane.add(btnNewSpectacle);
		
		JButton btnInfo = new JButton("Information");
		btnInfo.setBounds(177, 165, 104, 60);
		contentPane.add(btnInfo);
		
		JButton btnUpdate = new JButton("Modifier");
		btnUpdate.setBounds(30, 285, 99, 60);
		contentPane.add(btnUpdate);
		
		JButton btnNewButton_3 = new JButton("New button");
		btnNewButton_3.setBounds(177, 285, 104, 60);
		contentPane.add(btnNewButton_3);
		
	
		
	}
}
