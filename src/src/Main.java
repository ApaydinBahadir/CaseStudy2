package src;

import src.controller.MainFrameController;
import src.util.HibernateUtil;
import src.view.MainFrameView;

public class Main {

	public static void main(String[] args) {
		HibernateUtil.getSessionFactory();
		MainFrameController mainframe = new MainFrameController(new MainFrameView());
	}

}