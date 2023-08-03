package src.view;

import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.util.Vector;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

import src.model.KdvTipKart;
import src.model.StokKart;
import src.model.StokTipiKart;
import src.view.layouts.NavbarView;

public class StokKartMenuView extends BaseMenuFrame {
	public NavbarView nView;
	public JTextField stokAdiField = new JTextField();
	public JTextField barkodField = new JTextField();
	public JComboBox stokTipiField = new JComboBox<>();
	public JComboBox<String> birimField = new JComboBox<>();
	public JComboBox kdvTipiField = new JComboBox<>();
	public JTextArea aciklamaField = new JTextArea();
	public JDateChooser olusTarihField = new JDateChooser();
	public StokKart stokKart = new StokKart();
	public KdvTipKart kdvTipiKart = new KdvTipKart();
	public StokTipiKart stokTipiKart = new StokTipiKart();
	Vector<String> birimArray = new Vector<>() {
		{
			this.add("1");
			this.add("2");
			this.add("3");
			this.add("4");
			this.add("5");
			this.add("6");

		}
	};

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StokKartMenuView frame = new StokKartMenuView();
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
	public StokKartMenuView() {
//		super(nView);
		setBounds(0, 0, 570, 500);
		getContentPane().setLayout(null);

		this.setResizable(true);
		this.setClosable(true);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setTitle("STOK KART MENU");

		super.kod.setBounds(100, 30, 120, 25);
		getContentPane().add(super.kod);
		super.kod.setColumns(10);

		super.navbarView.setSize(450, 32);
		getContentPane().add(super.navbarView);

		super.model = this.stokKart;

		stokAdiField = new JTextField();
		stokAdiField.setBounds(100, 70, 120, 25);
		getContentPane().add(stokAdiField);
		stokAdiField.setColumns(10);

		barkodField = new JTextField();
		barkodField.setBounds(100, 110, 120, 25);
		getContentPane().add(barkodField);
		barkodField.setColumns(10);

		stokTipiField.setBounds(400, 30, 120, 25);
		getContentPane().add(stokTipiField);
		stokTipiField.setRenderer(new DefaultListCellRenderer() {
			@Override
			public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected,
					boolean cellHasFocus) {
				super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
				if (value instanceof StokTipiKart) {
					StokTipiKart tipKart = (StokTipiKart) value;
					StringBuilder sb = new StringBuilder();
					sb.append(tipKart.getKodu());
					setText(sb.toString());
				}
				return this;
			}
		});

		birimField.setBounds(400, 90, 120, 25);
		getContentPane().add(birimField);
		for (String i : birimArray) {
			birimField.addItem(i);
		}

		kdvTipiField.setBounds(400, 150, 120, 25);
		kdvTipiField.setRenderer(new DefaultListCellRenderer() {
			@Override
			public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected,
					boolean cellHasFocus) {
				super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
				if (value instanceof KdvTipKart) {
					KdvTipKart kdvKart = (KdvTipKart) value;
					StringBuilder sb = new StringBuilder();
					sb.append(kdvKart.getOrani());
					setText(sb.toString());
				}
				return this;
			}
		});
		getContentPane().add(kdvTipiField);

		aciklamaField.setBounds(73, 190, 447, 81);
		getContentPane().add(aciklamaField);

		olusTarihField.setDateFormatString("yyyy-MM-dd ");
		olusTarihField.setBounds(100, 150, 120, 25);
		getContentPane().add(olusTarihField);

		JLabel lblNewLabel = new JLabel("Stok Kodu");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(5, 30, 70, 25);
		getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Stok Adı");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(5, 70, 70, 25);
		getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Barkodu");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(5, 110, 70, 25);
		getContentPane().add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Olş Tarih");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(5, 150, 70, 25);
		getContentPane().add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("Stok Tipi");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_4.setBounds(305, 30, 120, 25);
		getContentPane().add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("Birimi");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_5.setBounds(305, 90, 120, 25);
		getContentPane().add(lblNewLabel_5);

		JLabel lblNewLabel_6 = new JLabel("KDV Tipi");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_6.setBounds(305, 150, 120, 25);
		getContentPane().add(lblNewLabel_6);

		JLabel lblNewLabel_7 = new JLabel("Açıklama");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_7.setBounds(5, 190, 58, 81);
		getContentPane().add(lblNewLabel_7);

	}
}
