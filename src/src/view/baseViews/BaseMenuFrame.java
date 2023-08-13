package src.view.baseViews;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JPopupMenu;
import javax.swing.JTextField;

import src.model.BaseModel;
import src.view.layouts.NavbarView;

public class BaseMenuFrame extends JInternalFrame {

	public NavbarView navbarView = new NavbarView();
	public JPopupMenu popupMenu;
	public JButton changeKodButton;
	public JTextField kod = new JTextField();

	public BaseModel model;

	public void getPopupMenu(boolean checks) {
		if (checks) {

			popupMenu = new JPopupMenu();
			changeKodButton = new JButton("Kod Değiştir");
			popupMenu.add(this.changeKodButton);
			this.setComponentPopupMenu(popupMenu);

		}
	}
}
