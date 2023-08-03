package src.view;

import javax.swing.JInternalFrame;
import javax.swing.JTextField;

import src.command.Navbar.NavbarCreateCommand;
import src.model.BaseModel;
import src.view.layouts.NavbarView;

public class BaseMenuFrame extends JInternalFrame {

	public NavbarView navbarView = new NavbarView();

	public BaseModel model;

	public JTextField kod = new JTextField();
	
	public BaseMenuFrame sendSuper() {
		return this;
	}
//	
//    private Shape shape;
//    public Super(Shape shape) { this.shape = shape; }
//    public Shape getShape() { return this.shape; }

}
