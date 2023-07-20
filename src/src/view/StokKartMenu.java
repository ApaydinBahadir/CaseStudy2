package src.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

import src.model.KdvTipKart;
import src.model.StokKart;
import src.model.StokTipiKart;

public class StokKartMenu extends JInternalFrame {

	public JPanel dataPanel = new JPanel();
	public JButton deleteButton = new JButton("Delete");
	public JButton saveButton = new JButton("Save");
	public JButton refreshButton = new JButton("Refresh");

	public JTextField stokKoduField = new JTextField();
	public JTextField stokAdiField = new JTextField();
	public JTextField barkodField = new JTextField();
	public JComboBox stokTipiField = new JComboBox();
	public JComboBox birimField = new JComboBox();
	public JComboBox kdvTipiField = new JComboBox();
	public JTextArea aciklamaField = new JTextArea();
	public JDateChooser olusTarihField = new JDateChooser();
	public StokKart stokKart = new StokKart();
	public KdvTipKart kdvTipiKart = new KdvTipKart();
	public StokTipiKart stokTipiKart = new StokTipiKart();

	public JButton backwardButton = new JButton(
			new ImageIcon("D:\\Workspace\\CaseStudy2\\src\\src\\icons\\left-arrow.png"));
	public JButton forwardButton = new JButton(
			new ImageIcon("D:\\Workspace\\CaseStudy2\\src\\src\\icons\\right-arrow.png"));
	public JButton firstButton = new JButton(
			new ImageIcon("D:\\Workspace\\CaseStudy2\\src\\src\\icons\\leftleftarrow.png"));
	public JButton lastButton = new JButton(
			new ImageIcon("D:\\Workspace\\CaseStudy2\\src\\src\\icons\\rightrightarrow.png"));
	public KdvTipKart tipKart = new KdvTipKart();
	public int limitLooker = -1;
	public int maxLimit = stokKart.getLastItemIndex();

	Vector<String> birimArray = new Vector<>() {
		{
			add("1");
			add("2");
			add("3");
			add("4");
			add("5");
			add("6");

		}
	};

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StokKartMenu frame = new StokKartMenu();
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
	public StokKartMenu() {
		setBounds(0, 0, 570, 500);

		this.setResizable(true);
		this.setClosable(true);
		this.setDefaultCloseOperation(HIDE_ON_CLOSE);

		dataPanel.setBounds(960, 29, 800, 600);
		getContentPane().add(dataPanel);
		dataPanel.setLayout(null);

		stokKoduField = new JTextField();
		stokKoduField.setBounds(100, 30, 120, 25);
		dataPanel.add(stokKoduField);
		stokKoduField.setColumns(10);

		stokAdiField = new JTextField();
		stokAdiField.setBounds(100, 70, 120, 25);
		dataPanel.add(stokAdiField);
		stokAdiField.setColumns(10);

		barkodField = new JTextField();
		barkodField.setBounds(100, 110, 120, 25);
		dataPanel.add(barkodField);
		barkodField.setColumns(10);

		stokTipiField.setBounds(400, 30, 120, 25);
		dataPanel.add(stokTipiField);

		birimField.setBounds(400, 90, 120, 25);
		dataPanel.add(birimField);
		for (String i : birimArray) {
			birimField.addItem(i);
		}

		kdvTipiField.setBounds(400, 150, 120, 25);
		dataPanel.add(kdvTipiField);

		aciklamaField.setBounds(73, 190, 447, 81);
		dataPanel.add(aciklamaField);

//		JFormattedTextField olusTarihField = new JFormattedTextField();
//		olusTarihField.setBounds(100, 150, 120, 25);
//		dataPanel.add(olusTarihField);

		olusTarihField.setDateFormatString("yyyy-MM-dd ");
		olusTarihField.setBounds(100, 150, 120, 25);
		dataPanel.add(olusTarihField);

		JLabel lblNewLabel = new JLabel("Stok Kodu");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(5, 30, 70, 25);
		dataPanel.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Stok Adı");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(5, 70, 70, 25);
		dataPanel.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Barkodu");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(5, 110, 70, 25);
		dataPanel.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Olş Tarih");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(5, 150, 70, 25);
		dataPanel.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("Stok Tipi");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_4.setBounds(305, 30, 120, 25);
		dataPanel.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("Birimi");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_5.setBounds(305, 90, 120, 25);
		dataPanel.add(lblNewLabel_5);

		JLabel lblNewLabel_6 = new JLabel("KDV Tipi");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_6.setBounds(305, 150, 120, 25);
		dataPanel.add(lblNewLabel_6);

		JLabel lblNewLabel_7 = new JLabel("Açıklama");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_7.setBounds(5, 190, 58, 81);
		dataPanel.add(lblNewLabel_7);

		deleteButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		deleteButton.setBounds(105, 300, 100, 50);
		dataPanel.add(deleteButton);

		saveButton.setBounds(5, 300, 100, 50);
		dataPanel.add(saveButton);
		saveButton.setFont(new Font("Tahoma", Font.PLAIN, 20));

		refreshButton.setBounds(205, 300, 100, 50);
		dataPanel.add(refreshButton);
		refreshButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		firstButton.setBounds(320, 300, 32, 32);
		dataPanel.add(firstButton);
		backwardButton.setBounds(352, 300, 32, 32);
		dataPanel.add(backwardButton);
		forwardButton.setBounds(384, 300, 32, 32);
		dataPanel.add(forwardButton);
		lastButton.setBounds(416, 300, 32, 32);
		dataPanel.add(lastButton);
	}

}
