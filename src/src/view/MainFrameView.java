package src.view;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;


import net.sf.jasperreports.view.JRViewer;
import src.model.StokKart;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;

public class MainFrameView extends JFrame {

	public StokKart stokModel = new StokKart();
	public JMenu menu = new JMenu("Menu");
	public JMenuItem stokKartList = new JMenuItem("Stok Kart List");
	public JMenuItem stokKartMenu = new JMenuItem("Stok Kart Menu");
	public JMenuItem StokKartTip = new JMenuItem("Stok Tip Menu");
	public JMenuItem kdvList = new JMenuItem("KDV Tip List");
	public JMenuItem kdvTip = new JMenuItem("KDV Tip Menu");
	public JDesktopPane desktopPane = new JDesktopPane();
	
	public JRViewer jrView = new JRViewer(null);

	public JMenuItem getStokKartList() {
		return this.stokKartList;
	}
	


	/**
	 * Create the application.
	 */
	public MainFrameView() {
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
		this.setTitle("STUDY CASE");
		this.getContentPane().setLayout(null);
		
		desktopPane.setBounds(0, 0, 1920, 1080);
		getContentPane().add(desktopPane);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		menuBar.add(menu);
		
		menu.add(stokKartList);
		menu.add(stokKartMenu);
		menu.add(StokKartTip);
		menu.add(kdvTip);
		menu.add(kdvList);
		
		this.setVisible(true);
	}
}
