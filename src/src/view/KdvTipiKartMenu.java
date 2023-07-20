package src.view;

import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Graphics;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import src.model.KdvTipKart;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class KdvTipiKartMenu extends JInternalFrame {
	public JTextField kdvKoduField = new JTextField();
	public JTextField kdvAdiField = new JTextField();
	public JTextField kdvOraniField = new JTextField();
	public JButton saveButton = new JButton("Save Button");
	public JButton backwardButton = new JButton(
			new ImageIcon("D:\\Workspace\\CaseStudy2\\src\\src\\icons\\left-arrow.png"));
	public JButton forwardButton = new JButton(
			new ImageIcon("D:\\Workspace\\CaseStudy2\\src\\src\\icons\\right-arrow.png"));
	public JButton firstButton = new JButton(
			new ImageIcon("D:\\Workspace\\CaseStudy2\\src\\src\\icons\\leftleftarrow.png"));
	public JButton lastButton = new JButton(
			new ImageIcon("D:\\Workspace\\CaseStudy2\\src\\src\\icons\\rightrightarrow.png"));
	public KdvTipKart tipKart = new KdvTipKart();
	public int limitLooker = 0;
	public int maxLimit = tipKart.getLastItemIndex();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					KdvTipiKartMenu frame = new KdvTipiKartMenu();
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
	public KdvTipiKartMenu() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);

		this.setResizable(true);
		this.setClosable(true);
		this.setDefaultCloseOperation(HIDE_ON_CLOSE);

		JLabel kdvTipiKodu = new JLabel("KDV Kodu");
		kdvTipiKodu.setBounds(40, 31, 90, 30);
		getContentPane().add(kdvTipiKodu);

		JLabel kdvAdi = new JLabel("KDV Adı");
		kdvAdi.setBounds(40, 93, 90, 30);
		getContentPane().add(kdvAdi);

		JLabel kdvOrani = new JLabel("Kdv Oranı");
		kdvOrani.setBounds(40, 156, 90, 30);
		getContentPane().add(kdvOrani);

		kdvKoduField.setBounds(160, 32, 90, 30);
		getContentPane().add(kdvKoduField);
		kdvKoduField.setColumns(10);

		kdvAdiField.setColumns(10);
		kdvAdiField.setBounds(160, 94, 90, 30);
		getContentPane().add(kdvAdiField);

		kdvOraniField.setColumns(10);
		kdvOraniField.setBounds(160, 157, 90, 30);
		getContentPane().add(kdvOraniField);

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

	}
}
