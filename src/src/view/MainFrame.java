package src.view;

import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import net.sf.jasperreports.view.JRViewer;
import src.model.StokKart;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;

public class MainFrame extends JFrame {

	public StokKart stokModel = new StokKart();
	public JMenu menu = new JMenu("Menu");
	public JMenuItem stokKartList = new JMenuItem("Stok Kart List");
	public JMenuItem stokKartMenu = new JMenuItem("Stok Kart Menu");
	public JMenuItem StokKartTip = new JMenuItem("Stok Tip Menu");
	public JMenuItem kdvTip = new JMenuItem("KDV Tip Menu");
	
	public JRViewer jrView = new JRViewer(null);

	public JMenuItem getStokKartList() {
		return this.stokKartList;
	}
	


	/**
	 * Create the application.
	 */
	public MainFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		this.setBounds(100, 100, 1920, 1080);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);

		this.getContentPane().setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		menuBar.add(menu);
		
		menu.add(stokKartList);
		menu.add(stokKartMenu);
		menu.add(StokKartTip);
		menu.add(kdvTip);
		
		this.setVisible(true);
	}
}
