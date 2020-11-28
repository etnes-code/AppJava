package be.sente.frame;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.graalvm.compiler.lir.util.ValueSet;

import be.sente.DAO.DAO;
import be.sente.DAO.FactoryDAO;
import be.sente.pojo.Client;
import be.sente.pojo.Organisateur;
import be.sente.pojo.Personne;
import be.sente.pojo.Spectacle;

import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Home extends JFrame {

	private JPanel contentPane;
	private Personne user = new Personne();
	private JButton btnInfoSpec;

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
	@SuppressWarnings("unchecked")
	public Home(int id) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 480);
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

		JButton btnBuy = new JButton("Acheter");
		btnBuy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ReservationPlace w = new ReservationPlace();
				w.setVisible(true);
			}
		});
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

		JList listSpectacle = new JList();
		listSpectacle.setBounds(313, 33, 291, 312);
		panelOrga.add(listSpectacle);

		JButton btnNewSpectacle = new JButton("Nouveau");
		btnNewSpectacle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ReservationSpectacle w = new ReservationSpectacle((Organisateur) user);
				Home ww = new Home(id);
				ww.setVisible(false);
				dispose();
				w.setVisible(true);
			}
		});
		btnNewSpectacle.setBounds(29, 93, 99, 60);
		panelOrga.add(btnNewSpectacle);

		JButton btnInfo;

		JButton btnUpdate = new JButton("Modifier");
		btnUpdate.setBounds(29, 198, 99, 60);
		panelOrga.add(btnUpdate);

		JButton btnNewButton_3 = new JButton("New button");
		btnNewButton_3.setBounds(170, 198, 99, 60);
		panelOrga.add(btnNewButton_3);
		user = user.getUser(id);
		Client client= new Client();
		if (user.getClass().getSimpleName().equals("Client")) {
			panelClient.setVisible(true);		
			client= (Client)user;
		}
		Organisateur orga = new Organisateur();
		if (user.getClass().getSimpleName().equals("Organisateur")) {
			
			orga = (Organisateur) user;
		}
		

		ArrayList<Spectacle> listSpec = new ArrayList<Spectacle>();
		for (var item : orga.getListReservation()) {
			listSpec.add(item.getPlanning().getSpectacle());
		}
		listSpectacle.setModel(new AbstractListModel() {
			ArrayList<Spectacle> values = listSpec;

			public int getSize() {
				return values.size();
			}

			public Spectacle getElementAt(int index) {
				return values.get(index);
			}
		});

		JLabel TitleList = new JLabel("Liste de vos spectales");
		TitleList.setBounds(313, 11, 225, 14);
		panelOrga.add(TitleList);
		// panelnfoSpec.setVisible(false);

		JPanel panelnfoSpec = new JPanel();
		panelnfoSpec.setBounds(313, 33, 291, 312);
		panelOrga.add(panelnfoSpec);
		panelnfoSpec.setLayout(null);

		JLabel lblInfoTitre = new JLabel("");
		lblInfoTitre.setHorizontalAlignment(SwingConstants.CENTER);
		lblInfoTitre.setBounds(36, 49, 214, 23);
		panelnfoSpec.add(lblInfoTitre);

		JLabel lblInfoArtiste = new JLabel("");
		lblInfoArtiste.setHorizontalAlignment(SwingConstants.CENTER);
		lblInfoArtiste.setBounds(36, 96, 214, 23);
		panelnfoSpec.add(lblInfoArtiste);

		JLabel lblInfoConf = new JLabel("");
		lblInfoConf.setHorizontalAlignment(SwingConstants.CENTER);
		lblInfoConf.setBounds(36, 165, 214, 23);
		panelnfoSpec.add(lblInfoConf);

		JLabel lblNewLabel_1 = new JLabel("Titre");
		lblNewLabel_1.setBounds(36, 33, 98, 14);
		panelnfoSpec.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Artiste");
		lblNewLabel_2.setBounds(36, 83, 102, 14);
		panelnfoSpec.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Configuration");
		lblNewLabel_3.setBounds(35, 144, 113, 14);
		panelnfoSpec.add(lblNewLabel_3);
		btnInfoSpec = new JButton("Information");
		btnInfoSpec.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Spectacle spec = new Spectacle();
				listSpectacle.setVisible(false);
				TitleList.setText("Information sur le specatcle");
				spec = (Spectacle) listSpectacle.getSelectedValue();
				lblInfoTitre.setText(spec.getTitre());
				lblInfoArtiste.setText(spec.getArtiste());
				lblInfoConf.setText(spec.getConfig().getType());
			}
		});
		btnInfoSpec.setBounds(170, 93, 99, 60);
		panelOrga.add(btnInfoSpec);

		JLabel lblTitleSpectacle = new JLabel("Liste de vos r\u00E9servation");
		lblTitleSpectacle.setFont(new Font("Trebuchet MS", Font.PLAIN, 12));
		lblTitleSpectacle.setBounds(329, 82, 245, 25);
		contentPane.add(lblTitleSpectacle);

		JLabel lblTitle = new JLabel("Bienvenue " + user.getPrenom() + " " + user.getNom());
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
		lblTitle.setBounds(155, 29, 320, 25);
		contentPane.add(lblTitle);

		JButton btnDeco = new JButton("Deconnecter");
		btnDeco.setBackground(Color.RED);
		btnDeco.setForeground(Color.BLACK);
		btnDeco.setBounds(10, 52, 126, 23);
		contentPane.add(btnDeco);
		btnDeco.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserLogIn deco = new UserLogIn();
				Home ww = new Home(0);
				ww.setVisible(false);
				dispose();
				deco.setVisible(true);
			}
		});

	}
}
