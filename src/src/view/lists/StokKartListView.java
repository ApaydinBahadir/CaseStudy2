package src.view.lists;

import java.awt.Component;
import java.awt.EventQueue;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import src.model.StokKart;
import src.view.baseViews.BaseListFrame;
import src.view.tableModels.StokKartListTableModel;

import javax.swing.JPopupMenu;

public class StokKartListView extends BaseListFrame {
	public StokKartListTableModel model = new StokKartListTableModel();
	public JPopupMenu popupMenu = new JPopupMenu();

	public JButton searchButton = new JButton("Search");
	public JTextField searchField = new JTextField();

	public JButton excelButton = new JButton("Excel");
	public JButton pdfButton = new JButton("PDF");
	public JButton StokKartButton = new JButton("Stok Kart");
	public JButton mailButton = new JButton("Mail");

	public JScrollPane scrollPane = new JScrollPane();
	public JButton listele = new JButton("Listele");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StokKartListView frame = new StokKartListView();
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
	public StokKartListView() {
		this.table = new JTable();
		this.baseModel = new StokKart();
		this.tableModel = new StokKartListTableModel();
		
		setBounds(100, 100, 900, 600);
		getContentPane().setLayout(null);
		this.setResizable(false);
		this.setClosable(true);
		this.setDefaultCloseOperation(HIDE_ON_CLOSE);
		listele.setLocation(10, 0);
		listele.setSize(101, 35);

		getContentPane().add(listele);
		searchButton.setSize(101, 35);
		searchButton.setLocation(765, 0);
		getContentPane().add(searchButton);
		searchField.setSize(166, 35);
		searchField.setLocation(589, 0);
		getContentPane().add(searchField);

		popupMenu.add(excelButton);
		popupMenu.add(pdfButton);
		popupMenu.add(mailButton);
		popupMenu.add(StokKartButton);

		scrollPane.setAlignmentY(Component.TOP_ALIGNMENT);
		scrollPane.setAlignmentX(Component.LEFT_ALIGNMENT);
		scrollPane.setBounds(10, 35, 868, 526);

		this.table.setModel(this.tableModel);
		scrollPane.add(this.table);
		getContentPane().add(scrollPane);
		this.table.setLayout(new BoxLayout(this.table, BoxLayout.X_AXIS));

		scrollPane.setViewportView(this.table);

		this.table.getColumnModel().getColumn(0).setPreferredWidth(this.getWidth() / 12);
		this.table.getColumnModel().getColumn(1).setPreferredWidth(this.getWidth() / 12);
		this.table.getColumnModel().getColumn(2).setPreferredWidth(this.getWidth() / 12);
		this.table.getColumnModel().getColumn(3).setPreferredWidth(this.getWidth() / 12);
		this.table.getColumnModel().getColumn(4).setPreferredWidth(this.getWidth() / 12);
		this.table.getColumnModel().getColumn(5).setPreferredWidth(this.getWidth() / 12);
		this.table.getColumnModel().getColumn(6).setPreferredWidth(this.getWidth() / 12);
		this.table.getColumnModel().getColumn(7).setPreferredWidth(this.getWidth() / 12);
		this.table.getColumnModel().getColumn(8).setPreferredWidth(this.getWidth() / 12);
		this.table.getColumnModel().getColumn(9).setPreferredWidth(this.getWidth() / 12);
		this.table.getColumnModel().getColumn(10).setPreferredWidth(this.getWidth() / 12);
		this.table.getColumnModel().getColumn(11).setPreferredWidth(this.getWidth() / 12);
	}
}