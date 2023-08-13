package src.view.menus;

import java.awt.EventQueue;
import javax.swing.JLabel;
import javax.swing.JTextField;
import src.model.KdvTipKart;
import src.view.baseViews.BaseMenuFrame;

public class KdvTipiKartMenuView extends BaseMenuFrame {
	public JTextField kdvAdiField = new JTextField();
	public JTextField kdvOraniField = new JTextField();
	public KdvTipKart tipKart = new KdvTipKart();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					KdvTipiKartMenuView frame = new KdvTipiKartMenuView();
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
	public KdvTipiKartMenuView() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);

		super.navbarView.setSize(this.getWidth(), 32);
		this.model = tipKart;

		getContentPane().add(super.navbarView);

		this.setTitle("KDV TİP KART MENU");
		this.setResizable(false);
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

		super.kod.setBounds(160, 32, 90, 30);
		getContentPane().add(super.kod);
		super.kod.setColumns(10);

		kdvAdiField.setColumns(10);
		kdvAdiField.setBounds(160, 94, 90, 30);
		getContentPane().add(kdvAdiField);

		kdvOraniField.setColumns(10);
		kdvOraniField.setBounds(160, 157, 90, 30);
		getContentPane().add(kdvOraniField);

		super.getPopupMenu(false);

	}
}
