package be.sente.frame;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import be.sente.DAO.DAO;
import be.sente.DAO.FactoryDAO;
import be.sente.pojo.Categorie;
import be.sente.pojo.Configuration;
import be.sente.pojo.Organisateur;
import be.sente.pojo.Personne;
import be.sente.pojo.PlanningSalle;
import be.sente.pojo.Representation;
import be.sente.pojo.Reservation;
import be.sente.pojo.Spectacle;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import java.awt.Font;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;

import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JCalendar;
import com.toedter.components.JLocaleChooser;
import com.toedter.calendar.JDateChooser;
import javax.swing.JComboBox;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import com.toedter.components.JSpinField;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ReservationSpectacle extends JFrame {
	private JPanel contentPane;
	private JTextField textFieldHDebut;
	private JTextField textFieldHFin;
	private JTextField textFieldOuverture;
	private JTextField tfdiaPrixCir;
	private JTextField tfOrPrixCir;
	private JTextField tfArgPrixCir;
	private JTextField tfBronPrixCir;
	private JTextField tfOrPrixCo;
	private JTextField tfArgPrixCo;
	private JTextField tfBronPrixCo;
	private JTextField tfPrixDebout;
	private JTextField textFieldTitre;
	private JTextField textFieldArtiste;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReservationSpectacle frame = new ReservationSpectacle();
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
	public ReservationSpectacle(Organisateur user) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 720, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panelDebout = new JPanel();
		panelDebout.setBounds(231, 242, 327, 188);
		contentPane.add(panelDebout);
		panelDebout.setLayout(null);

		JLabel lblNewLabel_6 = new JLabel("8.0000 places non num\u00E9rot\u00E9");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_6.setBounds(52, 11, 238, 61);
		panelDebout.add(lblNewLabel_6);

		tfPrixDebout = new JTextField();
		tfPrixDebout.setBounds(181, 96, 65, 20);
		panelDebout.add(tfPrixDebout);
		tfPrixDebout.setColumns(10);

		JLabel lblNewLabel_8 = new JLabel("Prix par place : ");
		lblNewLabel_8.setBounds(26, 99, 117, 14);
		panelDebout.add(lblNewLabel_8);

		JPanel panelConcert = new JPanel();
		panelConcert.setBounds(231, 242, 327, 188);
		contentPane.add(panelConcert);
		panelConcert.setLayout(null);

		JLabel lblNewLabel_5_1 = new JLabel("Asssis Version Concert : 5000 places ");
		lblNewLabel_5_1.setBounds(59, 21, 220, 14);
		panelConcert.add(lblNewLabel_5_1);

		JLabel lblNewLabel_7_1_2 = new JLabel("cat\u00E9gorie/place");
		lblNewLabel_7_1_2.setBounds(24, 46, 92, 14);
		panelConcert.add(lblNewLabel_7_1_2);

		JLabel lblNewLabel_7_1_2_1 = new JLabel("Prix");
		lblNewLabel_7_1_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7_1_2_1.setBounds(153, 46, 92, 14);
		panelConcert.add(lblNewLabel_7_1_2_1);

		tfOrPrixCo = new JTextField();
		tfOrPrixCo.setColumns(10);
		tfOrPrixCo.setBounds(177, 71, 54, 20);
		panelConcert.add(tfOrPrixCo);

		JLabel lblNewLabel_7_1_2_2 = new JLabel("OR : 500");
		lblNewLabel_7_1_2_2.setBounds(24, 74, 92, 14);
		panelConcert.add(lblNewLabel_7_1_2_2);

		JLabel lblNewLabel_7_1_2_3 = new JLabel("Argent : 1500 ");
		lblNewLabel_7_1_2_3.setBounds(24, 103, 92, 14);
		panelConcert.add(lblNewLabel_7_1_2_3);

		JLabel lblNewLabel_7_1_2_4 = new JLabel("Bronze: 3000");
		lblNewLabel_7_1_2_4.setBounds(24, 128, 92, 14);
		panelConcert.add(lblNewLabel_7_1_2_4);

		tfArgPrixCo = new JTextField();
		tfArgPrixCo.setColumns(10);
		tfArgPrixCo.setBounds(177, 100, 54, 20);
		panelConcert.add(tfArgPrixCo);

		tfBronPrixCo = new JTextField();
		tfBronPrixCo.setColumns(10);
		tfBronPrixCo.setBounds(177, 125, 54, 20);
		panelConcert.add(tfBronPrixCo);

		JPanel panelCirque = new JPanel();
		panelCirque.setBounds(231, 242, 327, 188);
		contentPane.add(panelCirque);
		panelCirque.setLayout(null);

		JLabel lblNewLabel_5 = new JLabel("Asssis Version cirque : 6000 places ");
		lblNewLabel_5.setBounds(43, 11, 200, 14);
		panelCirque.add(lblNewLabel_5);

		JLabel lblNewLabel_7 = new JLabel("Diamand : 1000 ");
		lblNewLabel_7.setBounds(22, 65, 92, 14);
		panelCirque.add(lblNewLabel_7);

		JLabel lblNewLabel_7_1 = new JLabel("cat\u00E9gorie/place");
		lblNewLabel_7_1.setBounds(22, 36, 92, 14);
		panelCirque.add(lblNewLabel_7_1);

		JLabel lblNewLabel_7_1_1 = new JLabel("Prix");
		lblNewLabel_7_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7_1_1.setBounds(151, 36, 92, 14);
		panelCirque.add(lblNewLabel_7_1_1);

		JLabel lblNewLabel_7_2 = new JLabel("OR : 2000");
		lblNewLabel_7_2.setBounds(22, 88, 92, 14);
		panelCirque.add(lblNewLabel_7_2);

		JLabel lblNewLabel_7_3 = new JLabel("Argent : 1500");
		lblNewLabel_7_3.setBounds(22, 113, 92, 14);
		panelCirque.add(lblNewLabel_7_3);

		JLabel lblNewLabel_7_4 = new JLabel("Bronze: 1500");
		lblNewLabel_7_4.setBounds(22, 138, 92, 14);
		panelCirque.add(lblNewLabel_7_4);

		tfdiaPrixCir = new JTextField();
		tfdiaPrixCir.setBounds(175, 62, 54, 20);
		panelCirque.add(tfdiaPrixCir);
		tfdiaPrixCir.setColumns(10);

		tfOrPrixCir = new JTextField();
		tfOrPrixCir.setColumns(10);
		tfOrPrixCir.setBounds(175, 85, 54, 20);
		panelCirque.add(tfOrPrixCir);

		tfArgPrixCir = new JTextField();
		tfArgPrixCir.setColumns(10);
		tfArgPrixCir.setBounds(175, 110, 54, 20);
		panelCirque.add(tfArgPrixCir);

		tfBronPrixCir = new JTextField();
		tfBronPrixCir.setColumns(10);
		tfBronPrixCir.setBounds(175, 135, 54, 20);
		panelCirque.add(tfBronPrixCir);

		JLabel lblNewLabel_1 = new JLabel("Reservation de la salle");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(237, 11, 150, 28);
		contentPane.add(lblNewLabel_1);

		JLabel lblTitre = new JLabel("Titre");
		lblTitre.setBounds(20, 66, 82, 22);
		contentPane.add(lblTitre);

		JLabel lblArtiste = new JLabel("Artiste");
		lblArtiste.setBounds(20, 101, 82, 22);
		contentPane.add(lblArtiste);

		JLabel lblPlaceMaxParClient = new JLabel("nbr de place max/client");
		lblPlaceMaxParClient.setBounds(20, 167, 145, 22);
		contentPane.add(lblPlaceMaxParClient);

		JLabel lblNewLabel_2 = new JLabel("Information sur le spectacle");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_2.setBounds(10, 41, 195, 14);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Configuration de la salle");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_3.setBounds(10, 142, 155, 14);
		contentPane.add(lblNewLabel_3);

		JComboBox comboBoxConfig = new JComboBox();
		comboBoxConfig.setModel(
				new DefaultComboBoxModel(new String[] { "Debout", "Assis version concert", "Assis version cirque" }));
		comboBoxConfig.setBounds(20, 200, 176, 22);
		contentPane.add(comboBoxConfig);

		comboBoxConfig.addItemListener((ItemListener) new ItemListener() {
			public void itemStateChanged(ItemEvent e) {

				if (e.getStateChange() == ItemEvent.SELECTED) {

					// Do what ever you want :))
					if (e.getItem().toString().equals("Assis version cirque")) {
						panelDebout.setVisible(false);
						panelConcert.setVisible(false);
						panelCirque.setVisible(true);
					} else if (e.getItem().toString().equals("Debout")) {
						panelCirque.setVisible(false);
						panelConcert.setVisible(false);
						panelDebout.setVisible(true);

					} else if (e.getItem().toString().equals("Assis version concert")) {
						panelDebout.setVisible(false);
						panelCirque.setVisible(false);
						panelConcert.setVisible(true);
					}
				}
			}
		});

		JLabel lblNewLabel_4 = new JLabel("Information sur la repr\u00E9sentation");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_4.setBounds(327, 41, 231, 14);
		contentPane.add(lblNewLabel_4);

		JLabel lblDate = new JLabel("Date");
		lblDate.setBounds(327, 70, 82, 22);
		contentPane.add(lblDate);

		JLabel lblHeureDebut = new JLabel("Heure  de d\u00E9but");
		lblHeureDebut.setBounds(327, 105, 96, 22);
		contentPane.add(lblHeureDebut);

		JLabel lblHeureFin = new JLabel("Heure de fin");
		lblHeureFin.setBounds(327, 142, 82, 22);
		contentPane.add(lblHeureFin);

		JLabel lblOuverture = new JLabel("Ouverture des portes");
		lblOuverture.setBounds(286, 185, 134, 22);
		contentPane.add(lblOuverture);

		JLabel lblPrix = new JLabel("");
		lblPrix.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrix.setForeground(Color.RED);
		lblPrix.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 22));
		lblPrix.setBounds(20, 279, 165, 47);
		contentPane.add(lblPrix);
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(433, 68, 125, 20);
		contentPane.add(dateChooser);

		textFieldHDebut = new JTextField();
		textFieldHDebut.setBounds(433, 106, 107, 20);
		contentPane.add(textFieldHDebut);
		textFieldHDebut.setColumns(10);

		textFieldHFin = new JTextField();
		textFieldHFin.setColumns(10);
		textFieldHFin.setBounds(433, 142, 107, 20);
		contentPane.add(textFieldHFin);

		textFieldOuverture = new JTextField();
		textFieldOuverture.setColumns(10);
		textFieldOuverture.setBounds(433, 186, 107, 20);
		contentPane.add(textFieldOuverture);

		JSpinner spinnerMaxPlace = new JSpinner();
		spinnerMaxPlace.setModel(new SpinnerNumberModel(1, 1, 4, 1));
		spinnerMaxPlace.setBounds(166, 167, 30, 20);
		contentPane.add(spinnerMaxPlace);

		textFieldTitre = new JTextField();
		textFieldTitre.setColumns(10);
		textFieldTitre.setBounds(112, 67, 107, 20);
		contentPane.add(textFieldTitre);

		textFieldArtiste = new JTextField();
		textFieldArtiste.setColumns(10);
		textFieldArtiste.setBounds(112, 102, 107, 20);
		contentPane.add(textFieldArtiste);

		JLabel lblNewLabel = new JLabel("Prix ");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(20, 254, 96, 14);
		contentPane.add(lblNewLabel);

		JButton btnNewButton = new JButton("Valider la r\u00E9servation"); // creation d'une réservation
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Spectacle spectacle = new Spectacle(textFieldTitre.getText(), textFieldArtiste.getText(),
						(Integer) spinnerMaxPlace.getValue());
				spectacle.CreateSpetacle();
				Representation rep = new Representation(textFieldHDebut.getText(), textFieldHFin.getText(),
						textFieldOuverture.getText());
				rep.createRepresentation();
				Calendar d = Calendar.getInstance();
				d.setTime(dateChooser.getDate());
				int prix=0;
				if (d.get(Calendar.DAY_OF_WEEK) - 1 == 5 || d.get(Calendar.DAY_OF_WEEK) - 1 == 6
						|| d.get(Calendar.DAY_OF_WEEK) == 1) {
					prix = 4500;	
				}else {
					prix=3000;
				}
				String strDate1 = recupDateToString(d);
				d.add(Calendar.DATE, 1);
				String strDate2 = recupDateToString(d);
				PlanningSalle ps = new PlanningSalle(strDate1, strDate2);
				ps.createPlanning();
				Reservation reservation=new Reservation(prix,"Non payé",user.getId());
				user.setReservation(reservation);
				user.createReservation();
				
				Configuration config = new Configuration(comboBoxConfig.getSelectedItem().toString(),
						comboBoxConfig.getSelectedItem().toString());
				config.CreateConfig();
				if (comboBoxConfig.getSelectedItem().toString().equals("Assis version cirque")) {
					Categorie catd = new Categorie("Diamant", Integer.parseInt(tfdiaPrixCir.getText()), 1000);
					catd.createCat();
					Categorie cato = new Categorie("Or", Integer.parseInt(tfOrPrixCir.getText()), 2000);
					cato.createCat();
					Categorie cata = new Categorie("Argent", Integer.parseInt(tfArgPrixCir.getText()), 1500);
					cata.createCat();
					Categorie catb = new Categorie("Bronze", Integer.parseInt(tfBronPrixCir.getText()), 1500);
					catb.createCat();
				} else if (comboBoxConfig.getSelectedItem().toString().equals("Debout")) {
					Categorie cat = new Categorie("Place non numeroté", Integer.parseInt(tfPrixDebout.getText()), 8000);
				} else {
					Categorie catd = new Categorie("Diamant", Integer.parseInt(tfOrPrixCo.getText()), 500);
					catd.createCat();
					Categorie cata = new Categorie("Argent", Integer.parseInt(tfArgPrixCo.getText()), 1500);
					cata.createCat();
					Categorie catb = new Categorie("Bronze", Integer.parseInt(tfBronPrixCo.getText()), 3000);
					catb.createCat();
				}
			}
		});
		btnNewButton.setBounds(40, 384, 165, 23);
		contentPane.add(btnNewButton);

		JButton btnCalculer = new JButton("Calculer");
		btnCalculer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (dateChooser.getDate() == null) {
					lblPrix.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 12));
					lblPrix.setText("Veuillez choisir une date");
				} else {
					Calendar cal = Calendar.getInstance();
					cal.setTime(dateChooser.getDate());

					if (cal.get(Calendar.DAY_OF_WEEK) - 1 == 5 || cal.get(Calendar.DAY_OF_WEEK) - 1 == 6
							|| cal.get(Calendar.DAY_OF_WEEK) == 1) {
						lblPrix.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 22));
						lblPrix.setText("4500 euros");
					} else {
						lblPrix.setText("3000 euros");
					}
				}
			}
		});
		btnCalculer.setBounds(126, 252, 89, 23);
		contentPane.add(btnCalculer);
	}

	public static String recupDateToString(Calendar d) {
		DateFormat dateFormat = new SimpleDateFormat("EEEEEEE dd-MM-yyyy");
		String strDate = dateFormat.format(d.getTime());
		return strDate;
	}
}
