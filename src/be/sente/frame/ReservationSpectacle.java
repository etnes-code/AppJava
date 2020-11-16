package be.sente.frame;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import be.sente.pojo.PlanningSalle;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import java.awt.Font;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;

import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
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

public class ReservationSpectacle extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;

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
	public ReservationSpectacle() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 480);
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
		
		textField_10 = new JTextField();
		textField_10.setBounds(181, 96, 65, 20);
		panelDebout.add(textField_10);
		textField_10.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("Prix par place : ");
		lblNewLabel_8.setBounds(26, 99, 117, 14);
		panelDebout.add(lblNewLabel_8);
		
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
		
		textField_3 = new JTextField();
		textField_3.setBounds(175, 62, 54, 20);
		panelCirque.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(175, 85, 54, 20);
		panelCirque.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(175, 110, 54, 20);
		panelCirque.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(175, 135, 54, 20);
		panelCirque.add(textField_6);
		
		
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
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(177, 71, 54, 20);
		panelConcert.add(textField_7);
		
		JLabel lblNewLabel_7_1_2_2 = new JLabel("OR : 500");
		lblNewLabel_7_1_2_2.setBounds(24, 74, 92, 14);
		panelConcert.add(lblNewLabel_7_1_2_2);
		
		JLabel lblNewLabel_7_1_2_3 = new JLabel("Argent : 1500 ");
		lblNewLabel_7_1_2_3.setBounds(24, 103, 92, 14);
		panelConcert.add(lblNewLabel_7_1_2_3);
		
		JLabel lblNewLabel_7_1_2_4 = new JLabel("Bronze: 3000");
		lblNewLabel_7_1_2_4.setBounds(24, 128, 92, 14);
		panelConcert.add(lblNewLabel_7_1_2_4);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(177, 100, 54, 20);
		panelConcert.add(textField_8);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(177, 125, 54, 20);
		panelConcert.add(textField_9);
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(304, 167, 176, 28);
		contentPane.add(lblNewLabel);
		
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
		comboBoxConfig.setModel(new DefaultComboBoxModel(new String[] {"Debout", "Assis version concert", "Assis version cirque"}));
		comboBoxConfig.setBounds(20, 200, 176, 22);
		contentPane.add(comboBoxConfig);
		
		comboBoxConfig.addItemListener((ItemListener) new ItemListener(){
            public void itemStateChanged(ItemEvent e){

                if(e.getStateChange()==ItemEvent.SELECTED){

                     //Do what ever you want :))
                     if(e.getItem().toString().equals("Assis version cirque")) {
                    	 panelDebout.setVisible(false);
                    	 panelConcert.setVisible(false);
                    	 panelCirque.setVisible(true);                	 
                     }else if(e.getItem().toString().equals("Debout")) {
                    	 panelCirque.setVisible(false); 
                    	 panelConcert.setVisible(false);
                    	 panelDebout.setVisible(true);
                    	 
                     }else if(e.getItem().toString().equals("Assis version concert")) {
                    	 panelDebout.setVisible(false);
                    	 panelCirque.setVisible(false);
                    	 panelConcert.setVisible(true);
                     }
                }
            }});
		
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
		lblOuverture.setBounds(327, 185, 116, 22);
		contentPane.add(lblOuverture);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(433, 68, 125, 20);
		contentPane.add(dateChooser);
		
		textField = new JTextField();
		textField.setBounds(433, 106, 107, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(433, 142, 107, 20);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(433, 186, 107, 20);
		contentPane.add(textField_2);
		
		JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(1, 1, 4, 1));
		spinner.setBounds(166, 167, 30, 20);
		contentPane.add(spinner);
			
		
	}
}
