package src.view.lists;

import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import src.model.KdvTipKart;
import src.view.baseViews.BaseListFrame;
import src.view.tableModels.KdvTipTableModel;

public class KdvListView extends BaseListFrame {

	public KdvTipTableModel model = new KdvTipTableModel();
	public JPopupMenu popupMenu = new JPopupMenu();
	public JButton excelButton = new JButton("Excel");

	public JScrollPane scrollPane = new JScrollPane();
	public JButton listele = new JButton("Listele");

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					KdvListView frame = new KdvListView();
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
	public KdvListView() {

		this.baseModel = new KdvTipKart();
		this.table = new JTable();
		this.tableModel = new KdvTipTableModel();

		setBounds(100, 100, 900, 600);
		getContentPane().setLayout(null);
		this.setResizable(false);
		this.setClosable(true);
		this.setDefaultCloseOperation(HIDE_ON_CLOSE);
		listele.setLocation(0, 0);
		listele.setSize(100, 35);

		popupMenu.add(excelButton);
		table.setComponentPopupMenu(popupMenu);

		getContentPane().add(listele);

		scrollPane.setAlignmentY(Component.TOP_ALIGNMENT);
		scrollPane.setAlignmentX(Component.LEFT_ALIGNMENT);
		scrollPane.setBounds(10, 35, 868, 526);

		this.table.setModel(this.tableModel);
		scrollPane.add(this.table);
		getContentPane().add(scrollPane);
		this.table.setLayout(new BoxLayout(this.table, BoxLayout.X_AXIS));

		scrollPane.setViewportView(this.table);

		this.table.getColumnModel().getColumn(0).setPreferredWidth(200);
		this.table.getColumnModel().getColumn(1).setPreferredWidth(200);
		this.table.getColumnModel().getColumn(2).setPreferredWidth(200);

	}

}
