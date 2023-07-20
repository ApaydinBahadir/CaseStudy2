package src.view;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import src.model.StokTipiKart;

public class StokTipKartMenu extends JInternalFrame {
	public JTextField tipKodField = new JTextField();
	public JTextField tipAdiField = new JTextField();
	public JTextField tipAciklamaField = new JTextField();
	public JButton saveButton = new JButton("Save Button");
	public JButton backwardButton = new JButton(new ImageIcon("D:\\Workspace\\CaseStudy2\\src\\src\\icons\\left-arrow.png"));
	public JButton forwardButton = new JButton(new ImageIcon("D:\\Workspace\\CaseStudy2\\src\\src\\icons\\right-arrow.png"));
	public JButton firstButton = new JButton(new ImageIcon("D:\\Workspace\\CaseStudy2\\src\\src\\icons\\leftleftarrow.png"));
	public JButton lastButton = new JButton(new ImageIcon("D:\\Workspace\\CaseStudy2\\src\\src\\icons\\rightrightarrow.png"));
	public StokTipiKart kart = new StokTipiKart();

	public int limitLooker = 0;
	public int maxLimit = kart.getLastItemIndex();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StokTipKartMenu frame = new StokTipKartMenu();
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
	public StokTipKartMenu() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		this.setResizable(true);
		this.setClosable(true);
		this.setDefaultCloseOperation(HIDE_ON_CLOSE);

		JLabel stokTipiKodu = new JLabel("Stok Tip Kodu");
		stokTipiKodu.setBounds(40, 31, 90, 30);
		getContentPane().add(stokTipiKodu);

		JLabel stokTipAdi = new JLabel("Stok Tip Adı");
		stokTipAdi.setBounds(40, 93, 90, 30);
		getContentPane().add(stokTipAdi);

		JLabel stokTipAciklama = new JLabel("Açıklama");
		stokTipAciklama.setBounds(40, 156, 90, 30);
		getContentPane().add(stokTipAciklama);

		tipKodField.setBounds(160, 32, 90, 30);
		getContentPane().add(tipKodField);
		tipKodField.setColumns(10);

		tipAdiField.setColumns(10);
		tipAdiField.setBounds(160, 94, 90, 30);
		getContentPane().add(tipAdiField);

		tipAciklamaField.setColumns(10);
		tipAciklamaField.setBounds(160, 157, 90, 30);

		saveButton.setBounds(40, 218, 85, 21);
		getContentPane().add(saveButton);

		firstButton.setBounds(150, 218, 32, 32);
		getContentPane().add(firstButton);
		backwardButton.setBounds(190, 218, 32, 32);
		getContentPane().add(backwardButton);
		forwardButton.setBounds(230, 218, 32, 32);
		getContentPane().add(forwardButton);
		lastButton.setBounds(270, 218, 32, 32);
		getContentPane().add(lastButton);
		
		getContentPane().add(tipAciklamaField);

	}

}
