package src.view.menus;

import java.awt.EventQueue;

import javax.swing.JLabel;
import javax.swing.JTextField;

import src.model.StokTipiKart;
import src.view.baseViews.BaseMenuFrame;
import src.view.layouts.NavbarView;

public class StokTipKartMenuView extends BaseMenuFrame {
	public JTextField tipAdiField = new JTextField();
	public JTextField tipAciklamaField = new JTextField();
	public StokTipiKart kart = new StokTipiKart();
	public NavbarView navbar = super.navbarView;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StokTipKartMenuView frame = new StokTipKartMenuView();
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
	public StokTipKartMenuView() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);

		this.setResizable(false);
		this.setClosable(true);
		this.setDefaultCloseOperation(HIDE_ON_CLOSE);
		this.setTitle("STOK TIP KART MENU");

		JLabel stokTipiKodu = new JLabel("Stok Tip Kodu");
		stokTipiKodu.setBounds(40, 31, 90, 30);
		getContentPane().add(stokTipiKodu);

		JLabel stokTipAdi = new JLabel("Stok Tip Adı");
		stokTipAdi.setBounds(40, 93, 90, 30);
		getContentPane().add(stokTipAdi);

		JLabel stokTipAciklama = new JLabel("Açıklama");
		stokTipAciklama.setBounds(40, 156, 90, 30);
		getContentPane().add(stokTipAciklama);

		this.kod.setBounds(160, 32, 90, 30);
		getContentPane().add(super.kod);
		super.kod.setColumns(10);

		super.model = kart;

		navbar.setBounds(0, 0, this.getWidth(), 32);
		super.model = this.kart;
		getContentPane().add(navbar);

		tipAdiField.setColumns(10);
		tipAdiField.setBounds(160, 94, 90, 30);
		getContentPane().add(tipAdiField);

		tipAciklamaField.setColumns(10);
		tipAciklamaField.setBounds(160, 157, 90, 30);

		getContentPane().add(tipAciklamaField);

		super.getPopupMenu(true);


	}

}
