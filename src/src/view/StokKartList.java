package src.view;

import java.awt.Component;
import java.awt.EventQueue;
import java.awt.PopupMenu;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import src.model.StokKart;

import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

import java.awt.BorderLayout;
import javax.swing.SpringLayout;
import javax.swing.JMenuBar;
import javax.swing.JMenu;

public class StokKartList extends JInternalFrame {

	public StokKart stokModel = new StokKart();
	public JTable stokKartTable = new JTable();
	public DefaultTableModel model = new DefaultTableModel();
	public JPopupMenu popupMenu = new JPopupMenu();

	public JButton excelButton = new JButton("Excel");
	public JButton pdfButton = new JButton("PDF");
	public JButton StokKartButton = new JButton("Stok Kart");
	public JButton mailButton = new JButton("Mail");

	public JScrollPane scrollPane = new JScrollPane();
	public JMenuBar menuBar = new JMenuBar();
	public JMenu mnMenu = new JMenu("Menu");
	public JMenuItem listele = new JMenuItem("Listele");

	public JMenuItem getListele() {
		return listele;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StokKartList frame = new StokKartList();
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
	public StokKartList() {

		setBounds(100, 100, 900, 600);
		getContentPane().setLayout(null);
		this.setResizable(true);
		this.setClosable(true);
		this.setDefaultCloseOperation(HIDE_ON_CLOSE);

		popupMenu.add(excelButton);
		popupMenu.add(pdfButton);
		popupMenu.add(mailButton);
		popupMenu.add(StokKartButton);
		

		scrollPane.setAlignmentY(Component.TOP_ALIGNMENT);
		scrollPane.setAlignmentX(Component.LEFT_ALIGNMENT);
		scrollPane.setBounds(0, 34, 900, 600);

		stokKartTable.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Stok Kodu", "Stok Adı", "Stok Tipi", "Stok Tipi Adı", "Stok Tipi Açıklama", "Birimi",
						"Barkodu", "KDV Tipi", "KDV Tipi Adı", "KDV Tipi Açıklama", "Açıklama", "Oluşturma Tarihi" }));
		scrollPane.add(stokKartTable);
		getContentPane().add(scrollPane);
		stokKartTable.setLayout(new BoxLayout(stokKartTable, BoxLayout.X_AXIS));

		scrollPane.setViewportView(stokKartTable);
		menuBar.setBounds(0, 0, 1540, 22);

		getContentPane().add(menuBar);

		menuBar.add(mnMenu);

		mnMenu.add(listele);

		stokKartTable.getColumnModel().getColumn(0).setPreferredWidth(this.getWidth() / 12);
		stokKartTable.getColumnModel().getColumn(1).setPreferredWidth(this.getWidth() / 12);
		stokKartTable.getColumnModel().getColumn(2).setPreferredWidth(this.getWidth() / 12);
		stokKartTable.getColumnModel().getColumn(3).setPreferredWidth(this.getWidth() / 12);
		stokKartTable.getColumnModel().getColumn(4).setPreferredWidth(this.getWidth() / 12);
		stokKartTable.getColumnModel().getColumn(5).setPreferredWidth(this.getWidth() / 12);
		stokKartTable.getColumnModel().getColumn(6).setPreferredWidth(this.getWidth() / 12);
		stokKartTable.getColumnModel().getColumn(7).setPreferredWidth(this.getWidth() / 12);
		stokKartTable.getColumnModel().getColumn(5).setPreferredWidth(this.getWidth() / 12);
		stokKartTable.getColumnModel().getColumn(6).setPreferredWidth(this.getWidth() / 12);
		stokKartTable.getColumnModel().getColumn(7).setPreferredWidth(this.getWidth() / 12);
		stokKartTable.getColumnModel().getColumn(5).setPreferredWidth(this.getWidth() / 12);
		stokKartTable.getColumnModel().getColumn(6).setPreferredWidth(this.getWidth() / 12);
		stokKartTable.getColumnModel().getColumn(7).setPreferredWidth(this.getWidth() / 12);
		stokKartTable.getColumnModel().getColumn(5).setPreferredWidth(this.getWidth() / 12);
		stokKartTable.getColumnModel().getColumn(6).setPreferredWidth(this.getWidth() / 12);
		stokKartTable.getColumnModel().getColumn(7).setPreferredWidth(this.getWidth() / 12);

	}
}
