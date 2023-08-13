package src.controller;

import src.command.Navbar.NavbarCreateCommand;
import src.view.baseViews.BaseMenuFrame;

public class BaseMenuController {

	public BaseMenuFrame frame;

	public void navbarCreate(BaseMenuFrame frame) {
		new NavbarCreateCommand(frame).execute();
	}

}
