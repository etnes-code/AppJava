package be.sente.frame;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import be.sente.DAO.DAO;
import be.sente.DAO.FactoryDAO;
import be.sente.pojo.Categorie;
import be.sente.pojo.Client;
import be.sente.pojo.Commande;
import be.sente.pojo.Place;
import be.sente.pojo.PlanningSalle;
import be.sente.pojo.Spectacle;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.swing.SwingConstants;
import javax.swing.AbstractListModel;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import javax.swing.SpinnerModel;

import java.util.Date;
import java.util.Calendar;
import javax.swing.SpinnerNumberModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class ReservationPlace extends JFrame {

	private JPanel contentPane;
	private final ButtonGroup buttonGroupCat = new ButtonGroup();
	private final ButtonGroup buttonGroupLivraison = new ButtonGroup();
	private final ButtonGroup buttonGroupPayement = new ButtonGroup();
	private Spectacle specChoose;
	private Spectacle specInfo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReservationPlace frame = new ReservationPlace();
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
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public ReservationPlace(int idUser) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panelInfo = new JPanel();
		panelInfo.setBounds(308, 124, 306, 306);
		contentPane.add(panelInfo);
		panelInfo.setLayout(null);
		panelInfo.setVisible(false);

		JLabel lblInfoTitre = new JLabel("New label");
		lblInfoTitre.setForeground(Color.RED);
		lblInfoTitre.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblInfoTitre.setHorizontalAlignment(SwingConstants.CENTER);
		lblInfoTitre.setBounds(40, 11, 199, 45);
		panelInfo.add(lblInfoTitre);

		JLabel lblNewLabel_1 = new JLabel("Configuration : ");
		lblNewLabel_1.setBounds(10, 85, 101, 14);
		panelInfo.add(lblNewLabel_1);

		JLabel lblInfoConfig = new JLabel("New label");
		lblInfoConfig.setBounds(132, 85, 122, 14);
		panelInfo.add(lblInfoConfig);

		JLabel lblNewLabel_1_1 = new JLabel("Artiste");
		lblNewLabel_1_1.setBounds(10, 127, 101, 14);
		panelInfo.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_1_1 = new JLabel("Date ");
		lblNewLabel_1_1_1.setBounds(10, 56, 70, 14);
		panelInfo.add(lblNewLabel_1_1_1);

		JLabel lblNewLabel_1_1_2 = new JLabel("Heure de d\u00E9but : ");
		lblNewLabel_1_1_2.setBounds(10, 163, 112, 14);
		panelInfo.add(lblNewLabel_1_1_2);

		JLabel lblNewLabel_1_1_2_1 = new JLabel("Heure de fin : ");
		lblNewLabel_1_1_2_1.setBounds(10, 203, 112, 14);
		panelInfo.add(lblNewLabel_1_1_2_1);

		JLabel lblInfoArtiste = new JLabel("New label");
		lblInfoArtiste.setBounds(117, 127, 122, 14);
		panelInfo.add(lblInfoArtiste);

		JLabel lblInfoHeureD = new JLabel("New label");
		lblInfoHeureD.setBounds(132, 163, 122, 14);
		panelInfo.add(lblInfoHeureD);

		JLabel lblInfoHeureF = new JLabel("New label");
		lblInfoHeureF.setBounds(132, 203, 122, 14);
		panelInfo.add(lblInfoHeureF);

		JLabel lblInfoDate = new JLabel("");
		lblInfoDate.setBounds(100, 56, 196, 14);
		panelInfo.add(lblInfoDate);

		JList list = new JList();
		list.setBounds(308, 124, 306, 306);
		contentPane.add(list);

		FactoryDAO adf = new FactoryDAO();
		DAO<Spectacle> spectacledao = adf.getSpectacleDAO();
		DAO<PlanningSalle> planningdao = adf.getPlanningSalleDAO();
		ArrayList<PlanningSalle> listPlanningSalle = planningdao.getALL();
		ArrayList<Spectacle> listSpectacle = spectacledao.getALL();

		list.setModel(new AbstractListModel() {
			ArrayList<Spectacle> values = listSpectacle;

			public int getSize() {
				return values.size();
			}

			public Spectacle getElementAt(int index) {
				return values.get(index);
			}
		});

		JLabel lblNewLabel = new JLabel("Liste des spectacles disponibles");
		lblNewLabel.setBounds(308, 99, 211, 14);
		contentPane.add(lblNewLabel);

		JLabel lblchoose = new JLabel("Veuillez choisir une spectacle");
		lblchoose.setHorizontalAlignment(SwingConstants.CENTER);
		lblchoose.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblchoose.setBounds(23, 203, 237, 123);
		contentPane.add(lblchoose);

		JButton btnInfo = new JButton("Information"); // voir les informations sur spectacle sélectionné
		btnInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				specInfo = (Spectacle) list.getSelectedValue();
				panelInfo.setVisible(true);
				list.setVisible(false);
				lblInfoTitre.setText(specInfo.getTitre());
				lblInfoArtiste.setText(specInfo.getArtiste());
				lblInfoConfig.setText(specInfo.getConfig().getType());
				lblInfoHeureD.setText(specInfo.getRepresentation().getHeureDebut());
				lblInfoHeureF.setText(specInfo.getRepresentation().getHeureFin());
				for (var item : listPlanningSalle) {
					if (item.getIdSpectacle() == specInfo.getId()) {
						lblInfoDate.setText(item.getDateDebutR());
					}
				}

			}
		});
		btnInfo.setBounds(485, 95, 108, 23);
		contentPane.add(btnInfo);

		JButton btnReturn = new JButton("retour \u00E0 la liste"); // revenir à la liste des spectacles
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelInfo.setVisible(false);
				list.setVisible(true);

			}
		});
		btnReturn.setBounds(64, 256, 175, 23);
		panelInfo.add(btnReturn);

		JPanel panelCommande = new JPanel();
		panelCommande.setBounds(10, 11, 288, 419);
		contentPane.add(panelCommande);
		panelCommande.setLayout(null);
		panelCommande.setVisible(false);

		JLabel lblNewLabel_2 = new JLabel("Configuration : ");
		lblNewLabel_2.setBounds(10, 11, 92, 14);
		panelCommande.add(lblNewLabel_2);

		JLabel lblConfig = new JLabel("");
		lblConfig.setBounds(134, 11, 144, 14);
		panelCommande.add(lblConfig);

		JLabel lblNewLabel_2_1 = new JLabel("Cat\u00E9gorie :");
		lblNewLabel_2_1.setBounds(10, 62, 92, 14);
		panelCommande.add(lblNewLabel_2_1);

		JRadioButton rdbtnDiamant = new JRadioButton("Diamant");
		rdbtnDiamant.setSelected(true);
		buttonGroupCat.add(rdbtnDiamant);
		rdbtnDiamant.setBounds(10, 83, 109, 23);
		panelCommande.add(rdbtnDiamant);

		JRadioButton rdbtnOr = new JRadioButton("Or");
		rdbtnOr.setSelected(true);
		buttonGroupCat.add(rdbtnOr);
		rdbtnOr.setBounds(134, 83, 109, 23);
		panelCommande.add(rdbtnOr);

		JRadioButton rdbtnArgent = new JRadioButton("Argent");
		rdbtnArgent.setSelected(true);
		buttonGroupCat.add(rdbtnArgent);
		rdbtnArgent.setBounds(10, 124, 109, 23);
		panelCommande.add(rdbtnArgent);

		JRadioButton rdbtnBronze = new JRadioButton("Bronze");
		rdbtnBronze.setSelected(true);
		buttonGroupCat.add(rdbtnBronze);
		rdbtnBronze.setBounds(134, 124, 109, 23);
		panelCommande.add(rdbtnBronze);

		rdbtnDiamant.setActionCommand("Diamant");
		rdbtnArgent.setActionCommand("Argent");
		rdbtnOr.setActionCommand("Or");
		rdbtnBronze.setActionCommand("Bronze");

		JLabel lblNewLabel_2_1_1 = new JLabel("Mode de livraison : ");
		lblNewLabel_2_1_1.setBounds(10, 168, 109, 14);
		panelCommande.add(lblNewLabel_2_1_1);

		JRadioButton rdbtnSurPlace = new JRadioButton("Sur place");
		buttonGroupLivraison.add(rdbtnSurPlace);
		rdbtnSurPlace.setBounds(10, 189, 109, 23);
		panelCommande.add(rdbtnSurPlace);

		JRadioButton rdbtnLivraisonPrior = new JRadioButton("prior");
		buttonGroupLivraison.add(rdbtnLivraisonPrior);
		rdbtnLivraisonPrior.setBounds(134, 189, 144, 23);
		panelCommande.add(rdbtnLivraisonPrior);

		JRadioButton rdbtnRecommand = new JRadioButton("recommandee");
		buttonGroupLivraison.add(rdbtnRecommand);
		rdbtnRecommand.setBounds(10, 215, 214, 23);
		panelCommande.add(rdbtnRecommand);

		rdbtnSurPlace.setActionCommand("Sur place");
		rdbtnLivraisonPrior.setActionCommand("prior");
		rdbtnRecommand.setActionCommand("recommandee");
		JLabel lblNewLabel_2_1_1_1 = new JLabel("Payement :");
		lblNewLabel_2_1_1_1.setBounds(10, 243, 109, 14);
		panelCommande.add(lblNewLabel_2_1_1_1);

		JRadioButton rdbtnPaypal = new JRadioButton("Paypal");
		buttonGroupPayement.add(rdbtnPaypal);
		rdbtnPaypal.setBounds(10, 264, 109, 23);
		panelCommande.add(rdbtnPaypal);

		JRadioButton rdbtnVisa = new JRadioButton("Visa");
		buttonGroupPayement.add(rdbtnVisa);
		rdbtnVisa.setBounds(134, 264, 109, 23);
		panelCommande.add(rdbtnVisa);

		JRadioButton rdbtnSepa = new JRadioButton("Virement Sepa");
		buttonGroupPayement.add(rdbtnSepa);
		rdbtnSepa.setBounds(10, 301, 109, 23);
		panelCommande.add(rdbtnSepa);

		rdbtnPaypal.setActionCommand("Paypal");
		rdbtnVisa.setActionCommand("Visa");
		rdbtnSepa.setActionCommand("Virement Sepa");

		JLabel lblNewLabel_3 = new JLabel("Prix :");
		lblNewLabel_3.setBounds(10, 331, 75, 14);
		panelCommande.add(lblNewLabel_3);

		JLabel lblPrix = new JLabel("");
		lblPrix.setForeground(Color.RED);
		lblPrix.setBounds(116, 331, 66, 14);
		panelCommande.add(lblPrix);

		JLabel lblNewLabel_2_2 = new JLabel("Nombre de places");
		lblNewLabel_2_2.setBounds(10, 36, 114, 14);
		panelCommande.add(lblNewLabel_2_2);

		JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(1, 1, 4, 1));
		spinner.setBounds(159, 36, 48, 20);
		panelCommande.add(spinner);

		JLabel lblDebout = new JLabel("");
		lblDebout.setForeground(Color.RED);
		lblDebout.setBounds(84, 62, 123, 14);
		panelCommande.add(lblDebout);

		JButton btnReserver = new JButton("R\u00E9server place");
		btnReserver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				specChoose = (Spectacle) list.getSelectedValue();
				panelCommande.setVisible(true);
				lblchoose.setVisible(false);
				btnReserver.setVisible(false);
				lblPrix.setText("");
				spinner.setModel(new SpinnerNumberModel(1, 1, specChoose.getNbrPlaceParClient(), 1)); // limiter le //
																										// nombre de //
																										// place
				// set les catégories selon la configuration du spectacle choisi
				if (specChoose.getConfig().getType().equals("Assis version concert")) {
					lblDebout.setText("");
					rdbtnDiamant.setVisible(false);
				} else if (specChoose.getConfig().getType().equals("Debout")) {
					rdbtnDiamant.setVisible(false);
					rdbtnOr.setVisible(false);
					rdbtnArgent.setVisible(false);
					rdbtnBronze.setVisible(false);
					lblDebout.setText("Place non numéroté");
				} else {
					lblDebout.setText("");
					rdbtnDiamant.setVisible(true);
					rdbtnOr.setVisible(true);
					rdbtnArgent.setVisible(true);
					rdbtnBronze.setVisible(true);

				}
			}
		});
		btnReserver.setBounds(59, 357, 175, 23);
		contentPane.add(btnReserver);
		JButton btncalculer = new JButton("Calculer");
		btncalculer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				float somme = 0;
				for (var item : specChoose.getConfig().getListCat()) {
					if (item.getType().equals(buttonGroupCat.getSelection().getActionCommand())) {
						somme = item.getPrix();
					}
					if (item.getType().equals("Place non numeroté")) {
						somme=item.getPrix();
					}
				}
				switch (buttonGroupLivraison.getSelection().getActionCommand().toString()) {
				case "Sur place":
					break;
				case "prior":
					somme += 1.21;
					break;
				case "recommandee":
					somme += 10;
					break;
				}
				somme = somme * (Integer) spinner.getValue();
				lblPrix.setText(String.valueOf(somme) + " €");

			}
		});
		btncalculer.setBounds(189, 327, 89, 23);
		panelCommande.add(btncalculer);

		JButton btnCancel = new JButton("Annuler");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelCommande.setVisible(false);
				lblchoose.setVisible(true);
				btnReserver.setVisible(true);
			}
		});
		btnCancel.setBounds(154, 370, 89, 23);
		panelCommande.add(btnCancel);

		JButton btnValider = new JButton("Valider");// injection sql
		btnValider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				float somme = 0;
				for (var item : specChoose.getConfig().getListCat()) {
					if (item.getType().equals(buttonGroupCat.getSelection().getActionCommand())) {
						somme = item.getPrix();
					}
					if (item.getType().equals("Place non numeroté")) {
						somme=item.getPrix();
					}
				}
				switch (buttonGroupLivraison.getSelection().getActionCommand().toString()) {
				case "Sur place":
					break;
				case "prior":
					somme += 1.21;
					break;
				case "recommandee":
					somme += 10;
					break;
				}
				somme = somme * (Integer) spinner.getValue();
				Commande commande = new Commande(buttonGroupLivraison.getSelection().getActionCommand().toString(),
						buttonGroupPayement.getSelection().getActionCommand().toString(), somme, idUser);
				commande.createCommande();
				Place place = new Place(buttonGroupCat.getSelection().getActionCommand().toString(),somme,(Integer) spinner.getValue(),specChoose.getRepresentation().getId());
				place.CreatePlace(place);
				Categorie cat= new Categorie();
				for (var item : specChoose.getConfig().getListCat()) {
					if(item.getType().equals(buttonGroupCat.getSelection().getActionCommand())){
						 cat= new Categorie(item.getNbrPlaceRestante()-(Integer) spinner.getValue(),item.getIdConfig());					
					}							
				}
				cat.UpdateCatPlace();
				JOptionPane.showMessageDialog(null, "Procéder aux payement "+buttonGroupPayement.getSelection().getActionCommand().toString());
				Home h= new Home(idUser);
				h.setVisible(true);
				dispose();
			}
		});
		btnValider.setBounds(13, 370, 89, 23);
		panelCommande.add(btnValider);

	}
}
