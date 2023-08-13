package src.view.layouts;

import javax.swing.JPanel;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.GridLayout;

public class NavbarView extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public JButton lastButton = new JButton(new ImageIcon("D:\\Workspace\\CaseStudy2\\src\\src\\icons\\rightrightarrow.png"));
	public JButton backwardButton =new JButton(new ImageIcon("D:\\Workspace\\CaseStudy2\\src\\src\\icons\\left-arrow.png"));
	public JButton forwardButton = new JButton(new ImageIcon("D:\\Workspace\\CaseStudy2\\src\\src\\icons\\right-arrow.png"));
	public JButton firstButton = new JButton(new ImageIcon("D:\\Workspace\\CaseStudy2\\src\\src\\icons\\leftleftarrow.png"));
	public JButton saveButton = new JButton(new ImageIcon("D:\\Workspace\\CaseStudy2\\src\\src\\icons\\savebutton.png"));
	public JButton deleteButton = new JButton(new ImageIcon("D:\\Workspace\\CaseStudy2\\src\\src\\icons\\deletebutton.png"));

	/**
	 * Create the panel.
	 */
	public NavbarView() {
		initialize();

	}

	private void initialize() {

		setBounds(0, 0, this.getWidth(), this.getHeight()/12);
		setLayout(new GridLayout(0, 6, 0, 0));

		add(lastButton);
		add(backwardButton);
		add(forwardButton);
		add(firstButton);
		add(saveButton);
		add(deleteButton);
	}

}
